package com.sanaws.jaxrs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import javax.sql.DataSource;

import com.sanaws.model.ApplicationContextProvider;
import com.sanaws.model.Solicitudes;
import com.sanaws.model.TablaRuta;
import com.sanaws.model.Mensajes;
import com.sanaws.service.SolicitudesService;


/* 
 * author: Alex
 * */

@Path("/solicitudes")
public class SolicitudRestService {
	

    @GET
    @Path("/guardar")
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
			@QueryParam("negocioCalle") String negocioCalle,
			@QueryParam("negocioNoExt") String negocioNoExt,
			@QueryParam("negocioNoInt") String negocioNoInt,
			@QueryParam("negocioIdColonia") String negocioIdColonia,
			@QueryParam("negocioIdMunicipio") String negocioIdMunicipio,
			@QueryParam("negocioIdEntidadFederativa") String negocioIdEntidadFederativa,
			@QueryParam("negocioEntreCalles") String negocioEntreCalles,
			@QueryParam("negocioTelefono") String negocioTelefono,
			@QueryParam("negocioReferencia") String negocioReferencia,
			@QueryParam("negocioIdGiro") String negocioIdGiro,
			@QueryParam("negocioAntiguedad") String negocioAntiguedad,
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
			@QueryParam("comentarios") String comentarios,
			@QueryParam("autorizacionUsoDatos") String autorizacionUsoDatos,
			@QueryParam("otroGiro") String otroGiro,
			@QueryParam("otroUsoRecursos") String otroUsoRecursos,
			@QueryParam("fechaRegistro") String fechaRegistro,
			@QueryParam("fechaEmision") String fechaEmision,
			@QueryParam("negocioLatitud") String negocioLatitud,
			@QueryParam("negocioLongitud") String negocioLongitud,
			@QueryParam("negocioNombre") String negocioNombre,
			@QueryParam("horaDesde") String horaDesde,
			@QueryParam("horaHasta") String horaHasta,
			@QueryParam("negocioCP") String negocioCP,
			@QueryParam("fotoIdentificacion") String fotoIdentificacion,
			@QueryParam("fotoIdentificacion2") String fotoIdentificacion2,
			@QueryParam("fotoComprobanteDomicilio") String fotoComprobanteDomicilio,
			@QueryParam("fotoComprobantePropiedad") String fotoComprobantePropiedad,
			@QueryParam("fotoSolicitudBuro") String fotoSolicitudBuro
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
    			+ "0,NULL,NULL,NULL,0,NULL,0,NULL,NULL)";
    	        
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
				String folioSolicitud="-" + idCliente;
				//String query="Insert into solicitudes values(0,(select User_Id from User where Usuario='"
	    		//		+ User_id + "'),"
				
				String query="Insert into solicitudes values(0,0,"
	    	    		+ idCliente + ","
	    	    		+ "concat('SI',DATE_FORMAT(current_timestamp(),'%Y'),DATE_FORMAT(current_timestamp(),'%m'),'" + folioSolicitud + "'),'"
	    	    		+ negocioCalle + "','"
	    	    		+ negocioNoExt + "','"
	    	    		+ negocioNoInt + "',"
	    	    		+ negocioIdColonia + ","
	    	    		+ negocioIdMunicipio + ","
	    	    		+ negocioIdEntidadFederativa + ",'"
	    	    		+ negocioEntreCalles + "','"
	    	    		+ negocioTelefono + "','"
	    	    		+ negocioReferencia + "',"
	    	    		+ negocioIdGiro + ",'"
	    	    		+ negocioAntiguedad + "','"
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
	    	    		+ negocioLongitud + ",'"
	    	    		+ negocioNombre + "','"
	    	    		+ horaDesde + "','"
	    	    		+ horaHasta + "',0," + negocioCP + ",'"
	    	    		+ fotoIdentificacion + "','" 
	    	    		+ fotoIdentificacion2 + "','" 
	    	    		+ fotoComprobanteDomicilio + "','" 
	    	    		+ fotoComprobantePropiedad + "','" 
	    	    		+ fotoSolicitudBuro + "',0,NULL,0)";
	    	    		
								
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
			Mensajes R=new Mensajes(2,0,"Ocurrió un error al registrar la solicitud");
		    mensaje = R;
			e.printStackTrace();
		}    	
    	
		c.close();
		return mensaje;
	}



}
