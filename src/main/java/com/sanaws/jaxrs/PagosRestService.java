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

@Path("/Pago")
public class PagosRestService {
	

    @GET
    @Path("/nocobrar")
    @Produces(MediaType.APPLICATION_JSON)
    @Secured("ROLE_ADMIN")
	public Mensajes guarda(
			@QueryParam("idCliente") String idCliente,
			@QueryParam("latitud") String latitud,
			@QueryParam("longitud") String longitud,
			@QueryParam("motivo") String motivo,
			@QueryParam("evidencia") String evidencia
			
			) throws SQLException
	{
    	
    	Mensajes mensaje = null;    	
    	
    	String queryCliente="Insert into lugares_cobro values(0,"
    			+ idCliente + ","                       //int
    			+ latitud + ","              //int
    			+ longitud + ",'"              //int
    			+ motivo + "',1,CURTIME(),CURDATE(),null,null,null,0,null,'"                         //char(1)
    			+ evidencia + "')";
    	        
    			
    	
    	DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
		Connection c;
		
		
		c = ds.getConnection();
		
		int idPago = 0;
		try {
		 			
			Statement stmt = c.createStatement();
			
			stmt.execute(queryCliente, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				idPago = rs.getInt(1);	
				Mensajes R=new Mensajes(0,idPago,"Se guardó correctamente la información");
			    mensaje = R;
			}else{
				Mensajes R=new Mensajes(1,0,"Ocurrió un error registrar la información");
			    mensaje = R;
			}
			rs.close();			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Mensajes R=new Mensajes(2,0,"Ocurrió un error al registrar la información");
		    mensaje = R;
			e.printStackTrace();
		}    	
    	
		c.close();
		return mensaje;
	}



}