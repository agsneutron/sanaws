
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

import javax.sql.DataSource;

import com.sanaws.model.ApplicationContextProvider;
import com.sanaws.model.Paises;
import com.sanaws.model.Plazos;
import com.sanaws.model.Renovacion;
import com.sanaws.model.TipoCredito;
import com.sanaws.model.EntidadFederativa;
import com.sanaws.model.FrecuenciaPago;
import com.sanaws.model.Giro;
import com.sanaws.model.Municipios;
import com.sanaws.model.Colonias;
/* 
 * author: Alex
 * */

@Path("/catalogos")
public class CatalogosRestService {
	
    @GET
    @Path("/paises")
    @Produces(MediaType.APPLICATION_JSON)
    @Secured("ROLE_ADMIN")
	public List<Paises> getPaises()
	{
		List<Paises> listOfPaises = new ArrayList<Paises>();
		listOfPaises=creaListaPaises();
		return listOfPaises;
	}


// Utiliy method to create country list.
	public List<Paises> creaListaPaises()
	{
	
		List<Paises> lista=new ArrayList<Paises>();
		String cobro ="";

		String query="SELECT idpais,nombre,codigo from Paises";
				
		
		DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
		Connection c;	    	
		try {
			c = ds.getConnection();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {				
				Paises R=new Paises(rs.getInt("idpais"),rs.getString("nombre"),rs.getString("codigo"));
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
    @Path("/estados")
    @Produces(MediaType.APPLICATION_JSON)
    @Secured("ROLE_ADMIN")
	public List<EntidadFederativa> getEstados(@QueryParam("idPais") String idPais)
	{
		List<EntidadFederativa> lista = new ArrayList<EntidadFederativa>();
		lista =creaListaEstados(idPais);
		return lista;
	}


// Utiliy method to create country list.
	public List<EntidadFederativa> creaListaEstados(String idPais)
	{
	
		List<EntidadFederativa> lista=new ArrayList<EntidadFederativa>();

		String query="SELECT idEntidadFederativa,nombreEntidadFederativa,idPais from entidad_federativa";
		
		if (Integer.parseInt(idPais) != 0){
			query += " where idPais = " + idPais;
		}else{
			query += " where idPais = 146";
		}		
				
		
		DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
		Connection c;	    	
		try {
			c = ds.getConnection();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {				
				EntidadFederativa R=new EntidadFederativa(rs.getInt("idEntidadFederativa"),rs.getString("nombreEntidadFederativa"),rs.getInt("idPais"));
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
    @Path("/municipios")
    @Produces(MediaType.APPLICATION_JSON)
    @Secured("ROLE_ADMIN")
	public List<Municipios> getMunicipios(@QueryParam("idEstado") String idEstado)
	{
		List<Municipios> lista = new ArrayList<Municipios>();
		lista =creaListaMunicipios(idEstado);
		return lista;
	}


// Utiliy method to create country list.
	public List<Municipios> creaListaMunicipios(String idEstado)
	{
	
		List<Municipios> lista=new ArrayList<Municipios>();

		String query="SELECT id,estado_id,MunicipioID,nombre,localidad from municipios"
				+ " where estado_id = " + idEstado;
				
		
		DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
		Connection c;	    	
		try {
			c = ds.getConnection();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {				
				Municipios R=new Municipios(rs.getInt("id"),rs.getInt("estado_id"),rs.getInt("MunicipioID"),rs.getString("nombre"),rs.getInt("localidad"));
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
    @Path("/colonias")
    @Produces(MediaType.APPLICATION_JSON)
    @Secured("ROLE_ADMIN")
	public List<Colonias> getColonias(@QueryParam("idEstado") String idEstado,
			@QueryParam("idMunicipio") String idMunicipio)
	{
		List<Colonias> lista = new ArrayList<Colonias>();
		lista =creaListaColonias(idEstado,idMunicipio);
		return lista;
	}


// Utiliy method to create country list.
	public List<Colonias> creaListaColonias(String idEstado, String idMunicipio)
	{
	
		List<Colonias> lista=new ArrayList<Colonias>();

		String query="SELECT id,estado_id,municipio_id,tipoAsentamiento,nombre,codigoPostal from colonias"
				+ " where estado_id = " + idEstado
				+ " and municipio_id = " + idMunicipio
				+ " order by nombre";
				
		
		DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
		Connection c;	    	
		try {
			c = ds.getConnection();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {				
				Colonias R=new Colonias(rs.getInt("id"),rs.getInt("estado_id"),rs.getInt("municipio_id"),rs.getString("tipoAsentamiento"),rs.getString("nombre"),rs.getInt("codigoPostal"));
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
    @Path("/giros")
    @Produces(MediaType.APPLICATION_JSON)
    @Secured("ROLE_ADMIN")
	public List<Giro> getGiros()
	{
		List<Giro> lista = new ArrayList<Giro>();
		lista =creaListaGiros();
		return lista;
	}
	
	// Utiliy method to create country list.
		public List<Giro> creaListaGiros()
		{
		
			List<Giro> lista=new ArrayList<Giro>();

			String query="SELECT idGiro,idActividadBMX,idActividadINEGI,nombre from giro";
					
					
			
			DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
			Connection c;	    	
			try {
				c = ds.getConnection();
				Statement stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {				
					Giro R=new Giro(rs.getInt("idGiro"),rs.getDouble("idActividadBMX"),rs.getInt("idActividadINEGI"),rs.getString("nombre"));
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
	    @Path("/frecuencia")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Secured("ROLE_ADMIN")
		public List<FrecuenciaPago> getFrecuenciaPagos()
		{
			List<FrecuenciaPago> lista = new ArrayList<FrecuenciaPago>();
			lista =creaListaFrecuenciaPagos();
			return lista;
		}
		
		// Utiliy method to create country list.
			public List<FrecuenciaPago> creaListaFrecuenciaPagos()
			{
			
				List<FrecuenciaPago> lista=new ArrayList<FrecuenciaPago>();

				String query="SELECT idFrecuenciaPago,descripcion FROM frecuencia_pago";
						
						
				
				DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
				Connection c;	    	
				try {
					c = ds.getConnection();
					Statement stmt = c.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {				
						FrecuenciaPago R=new FrecuenciaPago(rs.getInt("idFrecuenciaPago"),rs.getString("descripcion"));
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
		    @Path("/tipocredito")
		    @Produces(MediaType.APPLICATION_JSON)
		    @Secured("ROLE_ADMIN")
			public List<TipoCredito> getTipoCredito()
			{
				List<TipoCredito> lista = new ArrayList<TipoCredito>();
				lista =creaListaTipoCredito();
				return lista;
			}
			
			// Utiliy method to create country list.
				public List<TipoCredito> creaListaTipoCredito()
				{
				
					List<TipoCredito> lista=new ArrayList<TipoCredito>();

					String query="SELECT idTipoCredito,nombre,descripcion FROM tipo_credito";
							
							
					
					DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
					Connection c;	    	
					try {
						c = ds.getConnection();
						Statement stmt = c.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						while (rs.next()) {				
							TipoCredito R=new TipoCredito(rs.getInt("idTipoCredito"),rs.getString("nombre"),rs.getString("descripcion"));
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
			    @Path("/plazos")
			    @Produces(MediaType.APPLICATION_JSON)
			    @Secured("ROLE_ADMIN")
				public List<Plazos> getPlazos(@QueryParam("idTipoCredito") String idTipoCredito)
				{
					List<Plazos> lista = new ArrayList<Plazos>();
					lista =creaListaPlazos(idTipoCredito);
					return lista;
				}


			// Utiliy method to create country list.
				public List<Plazos> creaListaPlazos(String idTipoCredito)
				{
				
					List<Plazos> lista=new ArrayList<Plazos>();

					String query="Select A.idPlazo,descripcion,numero,unidad from plazos A,tipo_credito_plazo B" 
							+ " where A.idPlazo = B.idPlazo"
							+ " and idTipoCredito=" + idTipoCredito;
							
							
					
					DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
					Connection c;	    	
					try {
						c = ds.getConnection();
						Statement stmt = c.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						while (rs.next()) {				
							Plazos R=new Plazos(rs.getInt("idPlazo"),rs.getString("descripcion"),rs.getInt("numero"),rs.getString("unidad"));
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
			    @Path("/renovacion")
			    @Produces(MediaType.APPLICATION_JSON)
			    @Secured("ROLE_ADMIN")
				public List<Renovacion> getRenovacion()
				{
					List<Renovacion> lista = new ArrayList<Renovacion>();
					lista =creaListaRenovacion();
					return lista;
				}
				
				// Utiliy method to create country list.
					public List<Renovacion> creaListaRenovacion()
					{
					
						List<Renovacion> lista=new ArrayList<Renovacion>();

						String query="SELECT idRenovacionAumento,nombre FROM renovacion_aumento";
								
								
						
						DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
						Connection c;	    	
						try {
							c = ds.getConnection();
							Statement stmt = c.createStatement();
							ResultSet rs = stmt.executeQuery(query);
							while (rs.next()) {				
								Renovacion R=new Renovacion(rs.getInt("idRenovacionAumento"),rs.getString("nombre"));
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
