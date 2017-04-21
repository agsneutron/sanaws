package com.sanaws.jaxrs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.security.access.annotation.Secured;

import com.sanaws.model.ApplicationContextProvider;
import com.sanaws.model.Mensajes;
import com.sanaws.model.TablaClientes;

@Path("/solicitudgrupal")
public class SolicitudGrupalRestService {

	@GET
    @Path("/guardaGrupo")
    @Produces(MediaType.APPLICATION_JSON)
    @Secured("ROLE_ADMIN")
	public Mensajes guarda(
			@QueryParam("nombre") String nombre,
			@QueryParam("User_id") String User_id
			) throws SQLException
	{
    	
    	Mensajes mensaje = null;    	
    	
    	String queryGrupo="Insert into grupos values(0,"
    			+ " (select User_Id from User where Usuario='" + User_id + "'),'"						 //int
    			+ nombre + "',current_timestamp())"; //string, datetime 			
    			
    	DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
		Connection c;
				
		c = ds.getConnection();
				
		try {
		 			
			Statement stmt = c.createStatement();
			int autoIncKeyFromApi = -1;
			stmt.execute(queryGrupo, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {				
				autoIncKeyFromApi = rs.getInt(1);
			    Mensajes R=new Mensajes(0,autoIncKeyFromApi,"Se guardó correctamente la solicitud");
			    mensaje = R;
			}else{
				Mensajes R=new Mensajes(1,0,"Ocurrió un error registrar el grupo");
			    mensaje = R;
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Mensajes R=new Mensajes(2,0,"Ocurrió una excepción al registrar el grupo");
		    mensaje = R;
			e.printStackTrace();
		}    	
    	
		c.close();
		return mensaje;
	}
	
	
	
	@GET
    @Path("/guardaSolicitudGrupal")
    @Produces(MediaType.APPLICATION_JSON)
    @Secured("ROLE_ADMIN")
	public Mensajes guarda(			
			@QueryParam("nombre") String nombre,
			@QueryParam("apellidoPaterno") String apellidoPaterno,
			@QueryParam("apellidoMaterno") String apellidoMaterno,
			@QueryParam("sexo") String sexo,
			@QueryParam("fechaNacimiento") String fechaNacimiento,
			@QueryParam("nacionalidad") String nacionalidad,
			@QueryParam("edad") String edad,
			@QueryParam("paisNacimiento") String paisNacimiento,
			@QueryParam("entidadFederativaNacimiento") String entidadFederativaNacimiento,
			@QueryParam("curp") String curp,
			@QueryParam("rfc") String rfc,
			@QueryParam("telefonolParticular") String telefonolParticular,
			@QueryParam("telefonoCelular") String telefonoCelular,
			@QueryParam("mail") String mail,
			@QueryParam("calle") String calle,
			@QueryParam("numeroExterior") String numeroExterior,
			@QueryParam("numeroInterior") String numeroInterior,
			@QueryParam("idColonia") String idColonia,
			@QueryParam("cp") String cp,
			@QueryParam("idMunicipio") String idMunicipio,
			@QueryParam("entidadFederativaDomicilio") String entidadFederativaDomicilio,
			
			@QueryParam("User_id") String User_id,			
			@QueryParam("negocioCalle") String negocioCalle, // vacio
			@QueryParam("negocioNoExt") String negocioNoExt, // vacio
			@QueryParam("negocioNoInt") String negocioNoInt, // vacio
			@QueryParam("negocioIdColonia") String negocioIdColonia, // vacio
			@QueryParam("negocioIdMunicipio") String negocioIdMunicipio, // vacio
			@QueryParam("negocioIdEntidadFederativa") String negocioIdEntidadFederativa, // vacio
			@QueryParam("negocioEntreCalles") String negocioEntreCalles, // vacio
			@QueryParam("negocioTelefono") String negocioTelefono, // vacio
			@QueryParam("negocioReferencia") String negocioReferencia, // vacio
			@QueryParam("negocioIdGiro") String negocioIdGiro, // vacio
			@QueryParam("negocioAntiguedad") String negocioAntiguedad, // vacio
			@QueryParam("referenciaNombre1") String referenciaNombre1,
			@QueryParam("referenciaParentesco1") String referenciaParentesco1,
			@QueryParam("referenciaTelefono1") String referenciaTelefono1,
			@QueryParam("referenciaDomicilio1") String referenciaDomicilio1,
			@QueryParam("referenciaNombre2") String referenciaNombre2,
			@QueryParam("referenciaParentesco2") String referenciaParentesco2,
			@QueryParam("referenciaTelefono2") String referenciaTelefono2,
			@QueryParam("referenciaDomicilio2") String referenciaDomicilio2,
			@QueryParam("creditoMonto") String creditoMonto,
			@QueryParam("creditoFrecuenciaPago") String creditoFrecuenciaPago,
			@QueryParam("creditoPlazo") String creditoPlazo,
			@QueryParam("creditoMedidaPlazo") String creditoMedidaPlazo,
			@QueryParam("creditoIdUsoRecursos") String creditoIdUsoRecursos,
			@QueryParam("creditoOtro") String creditoOtro,
			@QueryParam("creditoIdRenovacionAumento") String creditoIdRenovacionAumento,
			@QueryParam("creditoIdTipoCredito") String creditoIdTipoCredito,
			@QueryParam("comentarios") String comentarios, // anotarán proyecto: para qué van a usar el crédito
			@QueryParam("autorizacionUsoDatos") String autorizacionUsoDatos,
			@QueryParam("otroGiro") String otroGiro, 
			@QueryParam("otroUsoRecursos") String otroUsoRecursos,
			@QueryParam("fechaRegistro") String fechaRegistro,
			@QueryParam("fechaEmision") String fechaEmision,
			@QueryParam("negocioLatitud") String negocioLatitud,
			@QueryParam("negocioLongitud") String negocioLongitud,
			@QueryParam("negocioNombre") String negocioNombre, // vacio
			@QueryParam("horaDesde") String horaDesde,
			@QueryParam("horaHasta") String horaHasta,
			@QueryParam("negocioCP") String negocioCP,// vacio
			@QueryParam("fotoIdentificacion") String fotoIdentificacion, // vacio
			@QueryParam("fotoComprobanteDomicilio") String fotoComprobanteDomicilio, // vacio
			@QueryParam("fotoComprobantePropiedad") String fotoComprobantePropiedad, // vacio
			@QueryParam("fotoSolicitudBuro") String fotoSolicitudBuro, // vacio
			@QueryParam("idgrupo") String idgrupo,
			@QueryParam("idtipointegrante") String idtipointegrante
			
			) throws SQLException
	{
    	
    	Mensajes mensaje = null;
    	int idCliente = -1;
    	
    	String queryCliente="Insert into clientes values(0,'"
    			+ nombre + "','"                       //string
    			+ apellidoPaterno + "','"              //string
    			+ apellidoMaterno + "','"              //string
    			+ sexo + "','"                         //char(1) 
    			+ fechaNacimiento + "','"				 //string
    			+ nacionalidad + "',"				 //char(1)
    			+ edad + ","						 //int
    			+ paisNacimiento + ","				 //int
    			+ entidadFederativaNacimiento + ",'"  //int
    			+ curp + "','"						 //string
    			+ rfc + "','"							 //string
    			+ telefonolParticular + "','"			 //string
    			+ telefonoCelular + "','"				 //string
    			+ mail + "','"						 //string
    			+ calle + "','"						 //string
    			+ numeroExterior + "','"				 //string
    			+ numeroInterior + "',"				 //string
    			+ idColonia + ",'"					 //int
    			+ cp + "',"							 //string
    			+ idMunicipio + ","			 		 //int
    			+ entidadFederativaDomicilio + "," //int
    			+ "0,NULL,NULL,NULL,0,NULL,0," + idgrupo + "," + idtipointegrante + ")";
    	        
    			/*idClienteSANA int(11) 
    			titulo varchar(7) 
    			direccionOficial char(1) 
    			numeroIdentificacion varchar(20) 
    			idTipoIdentificacion int(11) 
    			identificacionOficial char(1) 
    			idTipoDireccion int(11)*/
    	
    	   	
    	
    	DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
		Connection c;
		
		
		c = ds.getConnection();
		
		int idSolicitud = 0;
		try {
		 			
			Statement stmt = c.createStatement();
			
			stmt.execute(queryCliente, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
			    idCliente = rs.getInt(1);			    
			}else{
				Mensajes R=new Mensajes(1,0,"Ocurrió un error registrar el cliente");
			    mensaje = R;
			}
			rs.close();
			
			
			//insertar solicitud
			if (idCliente != -1){
				String folioSolicitud="SG201703"+ idCliente;
				//String query="Insert into solicitudes values(0,(select User_Id from User where Usuario='"
	    		//		+ User_id + "'),"
				String query="Insert into solicitudes values(0,0,"
	    	    		+ idCliente + ",'"
	    	    		+ folioSolicitud + "','s/d','s/d','s/d',1,1,15,'s/d','s/d','s/d',1,'s/d','"
	    	    		/*+ negocioCalle + "','"
	    	    		+ negocioNoExt + "','"
	    	    		+ negocioNoInt + "',"
	    	    		+ negocioIdColonia + ","
	    	    		+ negocioIdMunicipio + ","
	    	    		+ negocioIdEntidadFederativa + ",'"
	    	    		+ negocioEntreCalles + "','"
	    	    		+ negocioTelefono + "','"
	    	    		+ negocioReferencia + "',"
	    	    		+ negocioIdGiro + ",'"
	    	    		+ negocioAntiguedad + "','"*/
	    	    		+ referenciaNombre1 + "','"
	    	    		+ referenciaParentesco1 + "','"
	    	    		+ referenciaTelefono1 + "','"
	    	    		+ referenciaDomicilio1 + "','"
	    	    		+ referenciaNombre2 + "','"
	    	    		+ referenciaParentesco2 + "','"
	    	    		+ referenciaTelefono2 + "','"
	    	    		+ referenciaDomicilio2 + "',"
	    	    		+ creditoMonto + ","
	    	    		+ creditoFrecuenciaPago + ","
	    	    		+ creditoPlazo + ",'"
	    	    		+ creditoMedidaPlazo + "',"
	    	    		+ creditoIdUsoRecursos + ",'"
	    	    		+ creditoOtro + "',"
	    	    		+ creditoIdRenovacionAumento + ","
	    	    		+ creditoIdTipoCredito + ",'"
	    	    		+ comentarios + "','"
	    	    		+ autorizacionUsoDatos + "','"
	    	    		+ otroGiro + "',"
	    	    		+ otroUsoRecursos + ",current_timestamp(),NULL,"
	    	    		//+ fechaEmision + ","
	    	    		+ negocioLatitud + ","
	    	    		+ negocioLongitud + ",NULL,'"
	    	    		//+ negocioNombre + "','"
	    	    		+ horaDesde + "','"
	    	    		+ horaHasta + "',0," + negocioCP + ",NULL,NULL,NULL,NULL,"+ idgrupo + ",NULL)";
	    	    		/*+ horaHasta + "',0," + negocioCP + ",'"
	    	    		+ fotoIdentificacion + "','" 
	    	    		+ fotoComprobanteDomicilio + "','" 
	    	    		+ fotoComprobantePropiedad + "','" 
	    	    		+ fotoSolicitudBuro + "')";*/
	    	    		
								
				stmt.execute(query, Statement.RETURN_GENERATED_KEYS);
				ResultSet rss = stmt.getGeneratedKeys();
				int autoIncKeyFromApi = -1;
				if (rss.next()) {
				    autoIncKeyFromApi = rss.getInt(1);
				    Mensajes R=new Mensajes(0,autoIncKeyFromApi,"Se guardó correctamente la solicitud");
				    mensaje = R;
				}else{
					Mensajes R=new Mensajes(1,0,"Ocurrió un error al generar la clave de la solicitud");
				    mensaje = R;
				}
				rss.close();
			}
				
										
					
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Mensajes R=new Mensajes(2,0,"Ocurrió una excepción al registrar la solicitud");
		    mensaje = R;
			e.printStackTrace();
		}    	
    	
		c.close();
		return mensaje;
	}
	
	@GET
    @Path("/listaGrupo")
    @Produces(MediaType.APPLICATION_JSON)
    @Secured("ROLE_ADMIN")
	public List<TablaClientes> listado(
			@QueryParam("grupo") String grupo,
			@QueryParam("idgrupo") String idgrupo,
			@QueryParam("nombrePersona") String nombrePersona
			) throws SQLException
	{
    	
		List<TablaClientes> listOfClientes = new ArrayList<TablaClientes>();
		listOfClientes=createClientList(nombrePersona,idgrupo,grupo);
		return listOfClientes;
	}
	
	
	public List<TablaClientes> createClientList(String nombrePersona,String idgrupo, String grupo)
	{
	
		List<TablaClientes> lista=new ArrayList<TablaClientes>();
		String cobro ="";

		String queryGrupo="select C.nombre grupo,A.idCliente,"
				+ "D.nombreintegrante,"
				+ "if (concat(A.fotoComprobanteDomicilio,A.fotoComprobantePropiedad,A.fotoIdentificacion,A.fotoSolicitudBuro) is null,0,1) estatus,"
				+ "A.idSolicitud,concat(B.nombre,' ',B.apellidoPaterno,' ',B.apellidoMaterno) nombreCliente,"
				+" concat(B.calle,' # ',B.numeroExterior,' CP: ',B.cp,' Col. ',"
				+" (select nombre from colonias AA where AA.ColoniaID=B.idColonia and AA.estado_id=B.entidadFederativaDomicilio and AA.MunicipioID=B.idMunicipio)"
				+" ,' ,',(select nombre from municipios AA where AA.estado_id=B.entidadFederativaDomicilio and AA.MunicipioID=B.idMunicipio)) direccion"
				+" from solicitudes A, clientes B, grupos C, integrantes D"
				+" where A.idCliente = B.idCliente"
				+" and B.idtipointegrante = D.idtipointegrante"
				+" and A.idgrupo = B.idgrupo"
				+" and A.idgrupo = C.idgrupo";
	    	
	    	if (nombrePersona.compareTo("")!=0){
	    		queryGrupo+=" and B.nombre like '%" + nombrePersona + "%'";
	    	}
	    	if (idgrupo.compareTo("")!=0){
	    		queryGrupo+=" and C.idgrupo = " + idgrupo; //string, datetime
	    	}
	    	if (grupo.compareTo("")!=0){
	    		queryGrupo+=" and C.nombre like '%"+grupo+"%'";
	    	}
				
				
		
		DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
		Connection c;
		Time hora = null;
		try {
			c = ds.getConnection();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(queryGrupo);
			while (rs.next()) {		
				TablaClientes R=new TablaClientes(rs.getString("grupo"),rs.getInt("idCliente"),rs.getString("nombreCliente"),rs.getString("direccion"),rs.getInt("idSolicitud"),rs.getString("nombreintegrante"),rs.getInt("estatus"));
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
	
	
	@GET
    @Path("/guardaFotosSolicitudGrupal")
    @Produces(MediaType.APPLICATION_JSON)
    @Secured("ROLE_ADMIN")
	public Mensajes guarda(	
			@QueryParam("idsolicitud") String idsolicitud,
			@QueryParam("fotoIdentificacion") String fotoIdentificacion, // vacio
			@QueryParam("fotoComprobanteDomicilio") String fotoComprobanteDomicilio, // vacio
			@QueryParam("fotoComprobantePropiedad") String fotoComprobantePropiedad, // vacio
			@QueryParam("fotoSolicitudBuro") String fotoSolicitudBuro // vacio
			
			) throws SQLException
	{
    	
    	Mensajes mensaje = null;
    	
    	String queryCliente="update solicitudes set fotoIdentificacion = '" + fotoIdentificacion + "',"
    			+ "fotoComprobanteDomicilio='" + fotoComprobanteDomicilio + "',"                       //string
    			+ "fotoComprobantePropiedad='" + fotoComprobantePropiedad + "',"              //string
    			+ "fotoSolicitudBuro='" + fotoSolicitudBuro + "'"              //string
    			+ " where idSolicitud = " + idsolicitud;
    	        
    	   	
    	
    	DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
		Connection c;	    	
		try {
			c = ds.getConnection();
			Statement stmt = c.createStatement();
			stmt.execute(queryCliente);

			Mensajes R=new Mensajes(0,Integer.parseInt(idsolicitud) ,"Se guardó correctamente la información en la solicitud: " + idsolicitud);
			mensaje = R;
			c.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			Mensajes R=new Mensajes(1,0 ,"Ocurrió un error : Código de error =" + e.getErrorCode() + " Mensaje: " + e.getMessage());
			mensaje = R;
			e.printStackTrace();
		} 	
    	
		
		return mensaje;
	}
	
}
