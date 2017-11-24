
package com.sanaws.jaxrs;


import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.rpc.ServiceException;

import org.springframework.security.access.annotation.Secured;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sanaws.model.ApplicationContextProvider;
import com.sanaws.model.CobroConsulta;
import com.sanaws.model.CobroRealiza;
/* 
 * author: Arpit Mandliya
 * */
import com.sanaws.model.Mensajes;

import safisrv.ws.schemas.ConsultaSaldoCreditoRequest;
import safisrv.ws.schemas.ConsultaSaldoCreditoResponse;
import safisrv.ws.schemas.PagoCreditoRequest;
import safisrv.ws.schemas.PagoCreditoResponse;
import safisrv.ws.schemas.SAFIServicios;
import safisrv.ws.schemas.SAFIServiciosServiceLocator;



@Path("/cobro")
public class CobrosRestService {
	
    @GET
    @Path("/consultaAnterior")
    @Produces(MediaType.APPLICATION_JSON)
    @Secured("ROLE_ADMIN")
	public CobroConsulta getCountries(@QueryParam("claveUsuario") String claveUsuario,
			@QueryParam("creditoId") String creditoId,
			@QueryParam("Dispositivo") String Dispositivo,
			@QueryParam("Folio") String Folio) 
	{
    	
    	SAFIServiciosServiceLocator locator = new SAFIServiciosServiceLocator();
		SAFIServicios servicio;
		try {
			servicio = locator.getSAFIServiciosSoap11();
			ConsultaSaldoCreditoRequest req = new ConsultaSaldoCreditoRequest();
			
			req.setClaveUsuario(claveUsuario);
			req.setCreditoID(creditoId);
			req.setDispositivo(Dispositivo);
			req.setFolio(Folio);
			
			
				ConsultaSaldoCreditoResponse res;
				try {
					res = servicio.consultaSaldoCredito(req);
					/*CobroConsulta cobro = new CobroConsulta(res.getSaldoTotal(),res.getSaldoExigibleDia(),res.getProyeccion()
							,res.getCodigoRespuesta(),res.getMensajeRespuesta());
					
					return cobro;*/
					return null;
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
				
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}			
		
    

    
    
		
		@GET
		@Path("/envia")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Secured("ROLE_ADMIN")
		public CobroRealiza setCobro(@QueryParam("claveUsuario") String claveUsuario,
				@QueryParam("creditoId") String creditoId,
				@QueryParam("Dispositivo") String Dispositivo,
				@QueryParam("Folio") String Folio,
				@QueryParam("monto") String monto,
				@QueryParam("montoGL") String montoGL)
		{
	    	
	    	SAFIServiciosServiceLocator locator = new SAFIServiciosServiceLocator();
			SAFIServicios servicio;
			try {
				servicio = locator.getSAFIServiciosSoap11();
				PagoCreditoRequest req = new PagoCreditoRequest();
				
				req.setClaveUsuario(claveUsuario);
				req.setCreditoID(creditoId);
				req.setDispositivo(Dispositivo);
				req.setFolio(Folio);
				req.setMonto(monto);
				req.setMontoGL(montoGL);
				
				
				
					PagoCreditoResponse res;
					try {
						res = servicio.pagoCredito(req);
						CobroRealiza cobro = new CobroRealiza(res.getCreditoID(),res.getNumTransaccion(),res.getSaldoExigible(),
								res.getSaldoTotalActual(),res.getCodigoRespuesta(),res.getMensajeRespuesta());
						
						return cobro;
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
					}
					
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}
		
		
		
		@GET
	    @Path("/consulta")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Secured("ROLE_ADMIN")
		public CobroConsulta getConsulta(@QueryParam("claveUsuario") String claveUsuario,
				@QueryParam("creditoId") String creditoId,
				@QueryParam("Dispositivo") String Dispositivo,
				@QueryParam("Folio") String Folio) 
		{
	    	
			CobroConsulta resultado=null; 
			
			SAFIServiciosServiceLocator locator = new SAFIServiciosServiceLocator();
			SAFIServicios servicio;
			String saldo = "0.00";
			try {
				servicio = locator.getSAFIServiciosSoap11();
				ConsultaSaldoCreditoRequest req = new ConsultaSaldoCreditoRequest();
				
				req.setClaveUsuario(claveUsuario);
				req.setCreditoID(creditoId);
				req.setDispositivo(Dispositivo);
				req.setFolio(Folio);
				
				
				ConsultaSaldoCreditoResponse res;
				try {
						res = servicio.consultaSaldoCredito(req);
						//saldo = res.getSaldoFinalPlazo();
						saldo=res.getSaldoExigibleDia();
						saldo=res.getSaldoTotal();
				} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
					
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String query="SELECT (SaldoCapVigent + SaldoCapAtrasad + SaldoCapVencido + SaldCapVenNoExi) Capital,"
					+ " (SaldoInterProvi + SaldoInterAtras + SaldoInterVenc + SaldoIntNoConta) interes,"
					+ " SaldoMoratorios moratorios,"
					+ " MontototalExi subtotal, round((MontototalExi*0.16),2) iva, round((MontototalExi*1.16),2) total,"
					+ " (SELECT CONCAT(idSucursal,' ',sucursal) FROM dbsanatf.sanaubicacion) sucursal,"
					+ " (SELECT plaza FROM dbsanatf.sanaubicacion) plaza, CreditoID,"
					+ " ClienteID,NombreCompleto,User.nombre cajero,curtime() hora,"
					+ " DATE_FORMAT(CURDATE(), '%d-%m-%Y') fecha,"
					+ " DATE_FORMAT(ADDDATE(FechaExigible, INTERVAL 7 DAY), '%d-%m-%Y') fechaproxima"
					+ " FROM bachtable, solicitudes,User"
					+ " where CreditoID = " + creditoId
					+ " and bachtable.SolicitudCreditoID = solicitudes.SolicitudCreditoSafi"
					+ " and solicitudes.User_id = User.User_Id";     

			
			DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
			Connection c;
			try {
				c = ds.getConnection();
				Statement stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				if (rs.next()) {
					CobroConsulta cobro = new CobroConsulta(rs.getString("Capital"),rs.getString("interes"),rs.getString("moratorios"),
							rs.getString("subtotal"),rs.getString("iva"),rs.getString("total"),saldo,
							rs.getString("cajero"),rs.getString("sucursal"),rs.getString("plaza"),rs.getString("NombreCompleto"),
							rs.getString("ClienteID"),rs.getString("CreditoID"),rs.getString("total"),rs.getString("fecha"),
							rs.getString("hora"),rs.getString("fechaproxima"),"0","EXITO");
					resultado = cobro;
				}else{
					CobroConsulta cobro = new CobroConsulta("","","",
							"","","","",
							"","","","",
							"","","","","","","1","No existe información para el crédito: " + creditoId);
					resultado = cobro;
				}
				rs.close();				
				c.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				CobroConsulta cobro = new CobroConsulta("","","",
						"","","","",
						"","","","",
						"","","","","","","2","Ocurrió un error en la consulta.");
				resultado = cobro;
			} 		
			
			return resultado;
		}	
		
	
		@GET
		@Path("/enviapago")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Secured("ROLE_ADMIN")
		public Mensajes setPago(@QueryParam("claveUsuario") String claveUsuario,
				@QueryParam("creditoId") String creditoId,
				@QueryParam("Dispositivo") String Dispositivo,
				@QueryParam("Folio") String Folio,
				@QueryParam("monto") String monto,
				@QueryParam("montoGL") String montoGL) throws SQLException
		{
			Mensajes mensaje = null;
	    	String queryCliente="Insert into lugares_cobro values(0,"
	    			+ "(SELECT A.idCliente FROM dbsanatf.solicitudes A"
	    			+ " where A.folioSolicitud ='" + Folio + "'),"                       //int
	    			
	    			+ "(SELECT A.negocioLatitud FROM dbsanatf.solicitudes A"
	    			+ " where A.folioSolicitud ='" + Folio + "')," 
	    			
					+ "(SELECT A.negocioLongitud FROM dbsanatf.solicitudes A"
	    			+ " where  A.folioSolicitud ='" + Folio + "')" 
	    			+ ",'',1,null,(SELECT curdate()),0,(SELECT round((MontototalExi*1.16),2)  FROM dbsanatf.bachtable where CreditoId = '" + creditoId + "')," + monto + ",1,(SELECT current_timestamp()),null,null,null"				 //char(1)
	    			+ ",0," + creditoId + ",'"+ Folio +"','"+Dispositivo+"')";						 //string
	    			
	    				    	
	    	   	
	    	
	    	DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
			Connection c;
			
			
			c = ds.getConnection();
			
			int idRegistro = 0;
			try {
			 			
				Statement stmt = c.createStatement();
				
				stmt.execute(queryCliente, Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					idRegistro = rs.getInt(1);
					Mensajes R=new Mensajes(0,idRegistro,"Se guardó correctamente el registro");
					mensaje = R;
				}else{
					Mensajes R=new Mensajes(1,0,"Ocurrió un error en el registro");
				    mensaje = R;
				}
				rs.close();
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Mensajes R=new Mensajes(2,0,"Ocurrió un error al generar el registro");
			    mensaje = R;
				e.printStackTrace();
			}    	
	    	
			c.close();
			return mensaje;
	    	
		}
		
		
		
		@GET
	    @Path("/noCobro")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Secured("ROLE_ADMIN")
		public Mensajes guarda(
				@QueryParam("idCliente") String idCliente,
				@QueryParam("idCredito") String idCredito,
				@QueryParam("latitud") String latitud,
				@QueryParam("longitud") String longitud,
				@QueryParam("lugarVisitado") String lugarVisitado, // 0=no visitado, 1= visitado
				@QueryParam("horaVisita") String horaVisita,
				@QueryParam("fechaVisita") String fechaVisita,
				@QueryParam("motivo") String motivo,
				@QueryParam("fechaDeRegreso") String fechaDeRegreso,
				@QueryParam("horaDeRegreso") String horaDeRegreso,
				@QueryParam("foto") String foto
				
				) throws SQLException
		{
	    	
	    	Mensajes mensaje = null;
	    	String queryCliente="Insert into lugares_cobro values(0,"
	    			+ idCliente + ","                       //int
	    			+ latitud + ","              //double
	    			+ longitud + ",'"              //double
	    			+ motivo + "',"              //string
	    			+ lugarVisitado + ",'"                         //char(1) 
	    			+ horaVisita + "','"				 //string
	    			+ fechaVisita + "',0,(SELECT MontoTotalExigible FROM dbsanatf.bachtable where CreditoId = '" + idCredito + "'),(SELECT MontoTotalExigible FROM dbsanatf.bachtable where CreditoId = '" + idCredito + "'),0,null,'"				 //char(1)
	    			+ fechaDeRegreso + "','"			 //string
	    			+ horaDeRegreso + "','"				 //string
	    			+ foto + "',0," + idCredito + ",null,null)";						 //string
	    			
	    				    	
	    	   	
	    	
	    	DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
			Connection c;
			
			
			c = ds.getConnection();
			
			int idRegistro = 0;
			try {
			 			
				Statement stmt = c.createStatement();
				
				stmt.execute(queryCliente, Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					idRegistro = rs.getInt(1);
					Mensajes R=new Mensajes(0,idRegistro,"Se guardó correctamente el registro");
				}else{
					Mensajes R=new Mensajes(1,0,"Ocurrió un error en el registro");
				    mensaje = R;
				}
				rs.close();
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Mensajes R=new Mensajes(2,0,"Ocurrió un error al generar el registro");
			    mensaje = R;
				e.printStackTrace();
			}    	
	    	
			c.close();
			return mensaje;
		}	

}