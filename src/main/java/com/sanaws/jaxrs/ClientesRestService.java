package com.sanaws.jaxrs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.security.access.annotation.Secured;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import javax.sql.DataSource;

import com.sanaws.model.ApplicationContextProvider;
import com.sanaws.model.TablaRuta;
/* 
 * author: Alex
 * */

@Path("/clientes")
public class ClientesRestService {
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Path("{idUser: \\d+}")
    @Secured("ROLE_ADMIN")
	public List<TablaRuta> getCountries(@QueryParam("idUser") String idUser,
			@QueryParam("fechaInicio") String fechaInicio,
			@QueryParam("fechaFinal") String fechaFinal)
	{
		List<TablaRuta> listOfClientes = new ArrayList<TablaRuta>();
		listOfClientes=createClientList(idUser,fechaInicio,fechaFinal);
		return listOfClientes;
	}

	@GET
    //@Path("{idUser: \\d+},{idCliente: \\d+}")
	@Path("/cliente")
    @Produces(MediaType.APPLICATION_JSON)
	public TablaRuta getCountryById(@QueryParam("idUser") String idUser,@QueryParam("idCliente") int idCliente,
			@QueryParam("fechaInicio") String fechaInicio,
			@QueryParam("fechaFinal") String fechaFinal)
	{
		List<TablaRuta> listOfClientes = new ArrayList<TablaRuta>();
		listOfClientes=createClientList(idUser,fechaInicio,fechaFinal);

		for (TablaRuta clientes: listOfClientes) {
			if(clientes.getIdCliente()==idCliente)
				return clientes;
		}
		
		return null;
	}

// Utiliy method to create country list.
	public List<TablaRuta> createClientList(String userId,String fechaInicio, String fechaFinal)
	{
	
		List<TablaRuta> lista=new ArrayList<TablaRuta>();
		String cobro ="";

		String query="SELECT C.nombre as usuario,C.usuario claveUsuario,D.idCliente, CONCAT(D.nombre,' ',D.apellidoPaterno,' ',D.apellidoMaterno) as cliente,"
				+ " concat(B.horaDesde) as horaDesde,concat(B.horaHasta) horaHasta,A.pagoCuota,A.pagoCobroRealizado,A.pagoMontoCobrado,A.descripcion,"
				+ " B.negocioLatitud,B.negocioLongitud,"
				+ " CONCAT(B.negocioCalle,' ',B.negocioNoExt,' ',(select nombre From colonias col where col.id = B.negocioIdColonia and col.estado_id = B.negocioIdEntidadFederativa ),"
				+ " ' ',(Select nombre from municipios M where M.estado_id = B.negocioIdEntidadFederativa and M.id = B.negocioIdMunicipio)) direccion,"
				+ " B.negocioNombre,A.CreditoId,folioSolicitud"
				+ " FROM dbsanatf.lugares_cobro A, dbsanatf.solicitudes B, dbsanatf.User C,dbsanatf.clientes D,dbsanatf.bachtable E"
				+ " where A.idCliente = B.idCliente and C.Usuario = '" + userId + "'"
				+ " and fechaVisita between '" + fechaInicio + "' and '" + fechaFinal + "'"
				+ " and B.User_id=C.User_id"
				+ " and A.idCliente = D.idCliente"
				+ " and A.idCliente = E.ClienteId";
				
				
		
		DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
		Connection c;
		Time hora = null;
		try {
			c = ds.getConnection();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {		
				TablaRuta R=new TablaRuta(rs.getInt("idCliente"),rs.getString("cliente"),rs.getString("horaDesde"),rs.getString("horaHasta"),rs.getDouble("pagoCuota"),cobro,rs.getDouble("pagoMontoCobrado"),rs.getString("descripcion"),rs.getString("pagoCobroRealizado"),rs.getDouble("negocioLatitud"),rs.getDouble("negociolongitud"),
						rs.getString("direccion"),rs.getString("negocioNombre"),rs.getString("CreditoId"),rs.getString("folioSolicitud"),rs.getString("claveUsuario"));
				lista.add(R);
			}
			rs.close();				
			c.close();
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
		return lista;
		
		
		
		
	}
}
