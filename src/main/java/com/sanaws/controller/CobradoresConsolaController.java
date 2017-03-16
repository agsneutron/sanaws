package com.sanaws.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.sanaws.model.ApplicationContextProvider;
import com.sanaws.model.ClientesAsignados;
import com.sanaws.model.TablaRuta;


@Controller
public class CobradoresConsolaController {
	@RequestMapping({"/cobradores_consola","/"})
	public String doLogin(HttpSession session,Map<String, Object> map,HttpServletRequest request){
		
		boolean rolAdministrador = request.isUserInRole("Administrador");
		String regresa="login";
		ArrayList lista=new ArrayList();
		if (rolAdministrador){
			String fechaInicio = request.getParameter("fechaInicio");
			String fechaFinal = request.getParameter("fechaFinal");
			String userId = request.getParameter("user");
			lista=reporteCobradoresConsola(userId,fechaInicio,fechaFinal,map);
			
			map.put("listaClientes", lista);
			map.put("clientesAsignados", clientesAsignados(userId));
			regresa = "cobradores_consola";
		}
		return regresa;
	}
	
	public ArrayList reporteCobradoresConsola(String userId,String fechaInicio, String fechaFinal,Map<String, Object> map){	
		ArrayList lista=new ArrayList();
		String cobro ="";
		String circulo ="glyphicon-remove-circle cobro-no";

		String query="SELECT C.nombre as usuario,c.usuario claveUsuario,D.idCliente, CONCAT(D.nombre,' ',D.apellidoPaterno,' ',D.apellidoMaterno) as cliente,"
				+ " B.horaDesde as horaDesde,B.horaHasta horaHasta,A.pagoCuota,A.pagoCobroRealizado,A.pagoMontoCobrado,A.descripcion,"
				+ " B.negocioLatitud,B.negocioLongitud,"
				+ " CONCAT(B.negocioCalle,' ',B.negocioNoExt,' ',(select nombre From colonias col where col.id = B.negocioIdColonia and col.estado_id = B.negocioIdEntidadFederativa ),"
				+ " ' ',(Select nombre from municipios M where M.estado_id = B.negocioIdEntidadFederativa and M.id = B.negocioIdMunicipio)) direccion,"
				+ " B.negocioNombre,CreditoId,folioSolicitud"
				+ " FROM dbsanatf.lugares_cobro A, dbsanatf.solicitudes B, dbsanatf.user C,dbsanatf.clientes D,dbsanatf.bachtable E"
				+ " where A.idCliente = B.idCliente and C.Usuario = '" + userId + "'"
				+ " and fechaVisita between '" + fechaInicio + "' and '" + fechaFinal + "'"
				+ " and B.User_id=C.User_id"
				+ " and A.idCliente = D.idCliente"
				+ " and A.idCliente = E.ClienteId";
				
		
		DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
		Connection c;	    	
		try {
			c = ds.getConnection();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				cobro = rs.getString("pagoCobroRealizado");
				if (cobro.compareTo("1")==0){
					circulo="glyphicon-ok-circle cobro-ok";
				}else{
					circulo ="glyphicon-remove-circle cobro-no";
				}
				TablaRuta R=new TablaRuta(rs.getInt("idCliente"),rs.getString("cliente"),rs.getTime("horaDesde").toString(),rs.getTime("horaHasta").toString(),rs.getDouble("pagoCuota"),cobro,rs.getDouble("pagoMontoCobrado"),rs.getString("descripcion"),circulo,rs.getDouble("latitud"),rs.getDouble("longitud")
						,rs.getString("direccion"),rs.getString("negocioNombre"),rs.getString("CreditoId"),rs.getString("folioSolicitud"),rs.getString("claveUsuario"));
				lista.add(R);
				map.put("usuario", rs.getString("usuario"));
			}
			rs.close();				
			c.close();
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
		return lista;
		
	}
	
	
	public ArrayList clientesAsignados(String userId){	
		ArrayList lista=new ArrayList();

		String query="SELECT CONCAT(D.nombre,' ',D.apellidoPaterno,' ',D.apellidoMaterno) as cliente,"
				+ " B.negocioLatitud,B.negocioLongitud"
				+ " FROM dbsanatf.lugares_cobro A, dbsanatf.solicitudes B, dbsanatf.user C,dbsanatf.clientes D"
				+ " where A.idCliente = B.idCliente and B.user_id = " + userId
				+ " and B.User_id=C.User_id"
				+ " and A.idCliente = D.idCliente";
				
		
		DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
		Connection c;	    	
		try {
			c = ds.getConnection();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {				
				ClientesAsignados R=new ClientesAsignados(rs.getString("cliente"),rs.getString("negocioLatitud"),rs.getString("negocioLongitud"));
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




