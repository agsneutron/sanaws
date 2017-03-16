package com.sanaws.jaxrs;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
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


import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.sanaws.model.RutaOptima;
import com.sanaws.model.DistanceMatrixAplicacion;
import com.sanaws.model.Lugares;
import com.sanaws.model.ApplicationContextProvider;


@Path("/rutas")
public class RutasRestService {
	
	private GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyCh3BwQ9kuSt5lb2hoRd5Y7pLk0IhN8src");
	private String[] vectorLatLng = new String[]{};
	private int[] vectorOrden = new int[]{};
	private double[] vectorMetros = new double[]{};

	 @GET
	 @Path("/rutaOptima")
	 @Produces(MediaType.APPLICATION_JSON)
	 @Secured("ROLE_ADMIN")
	 public List<RutaOptima> getRutaOptima(@QueryParam("idUser") String idUser,
				@QueryParam("fechaInicio") String fechaInicio,
				@QueryParam("fechaFinal") String fechaFinal) {
			
			
			List<RutaOptima> rutas = new LinkedList<RutaOptima>();
			
			int m=0,i=0;
			double Latitud=0;
			double Longitud=0;
			String nombreCliente = "";
			int lugarVisitado=0;
			
			String[] vectorRutas = new String[]{};
		
			String rutaSS=ruta_optima(recorreLista(lugaresCobradoresConsola(idUser,fechaInicio,fechaFinal)));
			
			for(m=0;m<=vectorOrden.length-1;m++){
				i=0;
				for (String retval: vectorLatLng[vectorOrden[m]-1].split(",")){
					
					if (i==0){Latitud= Double.parseDouble(retval);}
					else{
						if (i==1){
							Longitud= Double.parseDouble(retval);
						}else{
							if (i==2){
								nombreCliente=retval;
							}else{
								lugarVisitado=Integer.parseInt(retval);
							}	
						}	
					}
			         System.out.println(retval);
			        i +=1; 
			    }

				RutaOptima R = new RutaOptima(Latitud,Longitud,nombreCliente,m+1,lugarVisitado); 
				rutas.add(R);	
			}
			
			return rutas;
			
	        
	    }
	
	 
	 
	 
	 
	 public String ruta_optima(double[][] d)
		{
		  /*ALGORITMO DE OPTIMIZACION DE RUTA EN JAVASCRIPT 
		  ///José Enrique González Cornejo, 01/05/2009
		  ///http://www.docirs.cl/ruta_optima.htm
		  ///http://www.docirs.cl/simulacion_aleatoria_ruta_optima.asp
		  ///La función devuelve una cadena con un recorrido óptimo,
		  ///desde el punto de vista, del Método Por Tramos DocIRS 
		  ///con la siguiente sintaxis: a1-->d[a1][a2]-->....,an-->d[an][1]-->a1
		  ///Se asume que vienen parámetros globales: numero_nodos, la matriz d[i][j]    cargada con sus correspondientes valores
		*/
			

		 int numero_nodos = d.length;
		 int[] ruta = new int[numero_nodos+1]; /// se guardará el orden de recorrido de la ruta
		 double[] metros = new double[numero_nodos]; /// se guardará el orden de recorrido de la ruta en metros
		 
		 int[] donde=new int[numero_nodos]; /// Almacena el punto donde estamos situados
		 double[] minimo=new double[numero_nodos]; /// Almacena el valor mínimo d[i][j] seleccionado
		 int[] v=new int[numero_nodos+1]; /// Rotulación de los nodos. Por simplicacion del algoritmo v(j)=j
		 int kkk=0; //Contador
		 double MMM=0;   //Comienza numero gande, se Almacena Mínimo
		 String restriccion=","; //Cadena donde se van guardando los nodos ya seleccionados.
		 int m; //iterador local
		 int i; //iterador local
		 int j; //iterador local
		 String nodo_doble;  //variable auxiliar para limpiar la duplicacion de rotulos en los tramos
		 String ss; //cadena resultante que contiene la serie de la ruta óptima ,a1,a2,a3,.....,an,a1
		 
		 int punto1=0;
		 int punto2=0;
		 String tt;
		 //'=============================
		 donde[0] = 0;
		 v[0]=1;
		 for(j=1;j<numero_nodos;j++){
			 v[j]=j+1;
		 }
		 v[numero_nodos]=1;
		//'=============================

		 do{
			MMM = Math.pow(10,20);
			i = donde[kkk];
			kkk = kkk + 1;
			restriccion = restriccion + donde[kkk - 1] + ",";

		    for(j=1;j<numero_nodos;j++){
		    	if(i!= j){
		    		if(d[i][j] < MMM){
		    			tt="," + j + ",";
		                if(InStr(restriccion, tt)==0){
		                	MMM = d[i][j];
		                    donde[kkk] = j;
		                }
		    		}
		    	}
		    }
		                 
		    if(MMM == Math.pow(10,20)){
		    	minimo[kkk] = 0;
		    }else{
		    	minimo[kkk] = MMM;
		    }               
		}while (kkk<numero_nodos-1);
		/////////////////////////////
		ss = "";
		for(m = 0;m<=numero_nodos - 2;m++){
			punto1 = v[donde[m]];
			punto2 = v[donde[m + 1]];
			ss = ss + punto1 + "-->[" + d[punto1-1][punto2-1] + "]-->" + punto2 + "-->";
			if (m==0) {ruta[m]=punto1;}
			ruta[m+1]=punto2;
			metros[m]=d[punto1-1][punto2-1];
		}
		
		ruta[m+1]=1;
		metros[m]=d[punto2-1][0];
		vectorOrden = ruta;
		vectorMetros=metros;

		for(m=1;m<=numero_nodos;m++){
			nodo_doble = "-->" + m + "-->" + m + "-->";
			ss = ss.replace(nodo_doble, "-->" + m + "-->");
		}

		ss = ss + "["+d[punto2-1][0]+"]-->1";

		return ss; 
		}

		
		//public int InStr(String n, String s1, String s2){
		public int InStr(String n, String s1){
			//int numargs=InStr.arguments.length;
			//if(numargs<3){
				return n.indexOf(s1)+1;
			//}else{
			//	return s1.indexOf(s2, n)+1;
			//}
		}
		
		
		
		
		public ArrayList lugaresCobradoresConsola(String userId,String fechaInicio, String fechaFinal){	
			ArrayList lista=new ArrayList();
			
			String query= " SELECT 0 idCliente,'SANA' cliente,'09:00' horaDesde,'21:00' horaHasta,latitud negocioLatitud,longitud negocioLongitud,nombre negocioNombre,1 lugarVisitado FROM dbsanatf.sanaubicacion"
					+ " UNION SELECT D.idCliente, CONCAT(D.nombre,' ',D.apellidoPaterno,' ',D.apellidoMaterno) as cliente,"
					+ " concat(B.horaDesde) as horaDesde,concat(B.horaHasta) horaHasta,"
					+ " B.negocioLatitud,B.negocioLongitud,"
					+ " B.negocioNombre, A.lugarVisitado"
					+ " FROM dbsanatf.lugares_cobro A, dbsanatf.solicitudes B, dbsanatf.User C,dbsanatf.clientes D,dbsanatf.bachtable E"
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
					Lugares R=new Lugares(rs.getInt("idCliente"),rs.getString("cliente"),rs.getString("horaDesde"),rs.getString("horaHasta"),rs.getDouble("negocioLatitud"),rs.getDouble("negociolongitud"),
							rs.getString("negocioNombre"),rs.getInt("lugarVisitado"));
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
		
		public double[][] recorreLista(ArrayList lista){
			int i=0;
			int j=0;
			// Declaramos el Iterador e imprimimos los Elementos del ArrayList
			ArrayList copia = new ArrayList();
			copia = lista;
			Iterator<Lugares> listaIterator = lista.iterator();
			double[][] matriz = new double[lista.size()][lista.size()];
			String[] vectorLocal = new String[lista.size()];
			
			
			DistanceMatrixAplicacion distancia = new DistanceMatrixAplicacion(context);
			DistanceMatrix matrix=null;
			
			while(listaIterator.hasNext()){
				Lugares ruta = listaIterator.next();
				Iterator<Lugares> copiaIterator = copia.iterator();
				while(copiaIterator.hasNext()){
					Lugares rutaCopia = copiaIterator.next();
					if (j>=i) {	
						try {
							
								matrix = distancia.obtenDistancias(ruta.getLatitud() + "," + ruta.getLongitud(),rutaCopia.getLatitud() + "," + rutaCopia.getLongitud());
								matriz[i][j]=matrix.rows[0].elements[0].distance.inMeters;
								matriz[j][i]=matrix.rows[0].elements[0].distance.inMeters;
								
								if(i==0){
									vectorLocal[j] = rutaCopia.getLatitud() + "," + rutaCopia.getLongitud() + "," + rutaCopia.getCliente() + "," + rutaCopia.getLugarVisitado();
								}
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}	
					
					j+=1;
				}
				j=0;
				i+=1;
				
			}
			
			System.out.println(matriz.toString());
			vectorLatLng = vectorLocal;
			return matriz;
			
		}
	
	
}
