package com.sanaws.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.Random;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import javax.sql.DataSource;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.LatLng;
import com.google.gson.JsonObject;
import com.sanaws.model.ApplicationContextProvider;



@Controller
public class AjaxController {
	@RequestMapping(value = "/consultaGeneral", method = RequestMethod.GET)
    public @ResponseBody
    String getReporteGeneral(HttpServletRequest request,HttpServletResponse response,Map<String, Object> map) {
		String fechaInicio = request.getParameter("fechaInicio");
		String fechaFinal = request.getParameter("fechaFinal");
        Random rand = new Random();
        float r = rand.nextFloat() * 100;
        String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
        System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller.." + new Date().toString());
        //response.setContentType("application/json");
        map.put("fechas", "fechas");
		return reporte(fechaInicio,fechaFinal);
		
        
    }
	
	@RequestMapping(value = "/consultaCobradores", method = RequestMethod.GET)
    public @ResponseBody
    String getReporteCobradores(HttpServletRequest request,HttpServletResponse response,Map<String, Object> map) {
		String fechaInicio = request.getParameter("fechaInicio");
		String fechaFinal = request.getParameter("fechaFinal");
		return reporteCobradores(fechaInicio,fechaFinal);
		
        
    }
	
	
	public String reporte(String fechaInicio, String fechaFinal){			
		String json = "" ;
		String query="select visitados,totalVisitar-visitados as porVisitar,cobranzaTotal, " 
		+ "cobranzaTotal-cobrado as porCobrar,cobrado "
		+ "from "
		+ "(SELECT count(*) visitados FROM dbsanatf.lugares_cobro "
		+ "where lugarVisitado=1 and fechaVisita between '" + fechaInicio + "' and '" + fechaFinal + "') A, "
		+ "(SELECT count(*) totalVisitar FROM dbsanatf.programacion_cobros where fechaCobro between '" + fechaInicio + "' and '" + fechaFinal + "') B, "
		+ "(SELECT sum(pagoCuota) cobranzaTotal FROM dbsanatf.lugares_cobro "
		+ "where fechaVisita between '" + fechaInicio + "' and '" + fechaFinal + "') C, "
		+ "(SELECT sum(pagoCuota) cobrado FROM dbsanatf.lugares_cobro "
		+ "where lugarVisitado=1 and fechaVisita between '" + fechaInicio + "' and '" + fechaFinal + "') D";
		
		DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
    	Connection c;	    	
		try {
			c = ds.getConnection();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				JsonObject object = new JsonObject();
				object.addProperty("visitados", rs.getDouble("visitados"));
				object.addProperty("porVisitar", rs.getDouble("porVisitar"));
				object.addProperty("cobranzaTotal", rs.getDouble("cobranzaTotal"));
				object.addProperty("porCobrar", rs.getDouble("porCobrar"));
				object.addProperty("cobrado", rs.getDouble("cobrado"));
				object.addProperty("rangoFechas", "de " + fechaInicio + " a " + fechaFinal);
				 
				json = object.toString();
				System.out.println(json);
			}
			rs.close();				
			c.close();
			
			if(json==""){
				JsonObject object = new JsonObject();
				object.addProperty("visitados", 0);
				object.addProperty("porVisitar", 0);
				object.addProperty("cobranzaTotal", 0);
				object.addProperty("porCobrar", 0);
				object.addProperty("cobrado", 0);
				object.addProperty("rangoFechas", "de " + fechaInicio + " a " + fechaFinal);
				 
				json = object.toString();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
		return json;
		
	}
	
	public String reporteCobradores(String fechaInicio, String fechaFinal){			
		String json = "" ;
		
		
		String query="Select * From "
		+" (SELECT C.user_id,C.nombre,Sum(pagoCuota) Meta,count(A.idCliente) Visitar"
		+" FROM dbsanatf.lugares_cobro A, dbsanatf.solicitudes B, dbsanatf.user C"
		+" where A.idCliente = B.idCliente";
		if (fechaInicio==null){
			query +=" and fechaVisita = CURDATE()";
		}else{
			query +=" and fechaVisita between '" + fechaInicio + "' and '" + fechaFinal + "'";
		}    
		query +=" and B.User_id=C.User_id"
		+" group by C.user_id,C.nombre) AA,"

        +" (SELECT B.user_id,Sum(pagoCuota) cobro,count(A.idCliente) Visitado"
        +" FROM dbsanatf.lugares_cobro A, dbsanatf.solicitudes B"
        +" where A.idCliente = B.idCliente"
        +" and lugarVisitado=1 ";
		if (fechaInicio==null){
			query +=" and fechaVisita = CURDATE()";
		}else{
			query +=" and fechaVisita between '" + fechaInicio + "' and '" + fechaFinal + "'";
		}    
		query +=" group by B.user_id) BB"
        +" where AA.user_id = BB.user_id";
		
		double distancia = calcularDistanciaEntre(0,0);
		
		double[][] matriz = new double[5][5];
		matriz[0][0]=0;
		matriz[0][1]=290;
		matriz[0][2]=192;
		matriz[0][3]=185;
		matriz[0][4]=63;
		matriz[1][0]=290;
		matriz[1][1]=0;
		matriz[1][2]=115;
		matriz[1][3]=294;
		matriz[1][4]=143;
		matriz[2][0]=192;
		matriz[2][1]=115;
		matriz[2][2]=0;
		matriz[2][3]=170;
		matriz[2][4]=115;
		matriz[3][0]=185;
		matriz[3][1]=294;
		matriz[3][2]=170;
		matriz[3][3]=0;
		matriz[3][4]=70;
		matriz[4][0]=63;
		matriz[4][1]=143;
		matriz[4][2]=117;
		matriz[4][3]=70;
		matriz[4][4]=0;
		String ruta = ruta_optima(5,matriz);

		DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
    	Connection c;	    	
		try {
			c = ds.getConnection();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				JsonObject object = new JsonObject();
				object.addProperty("Nombre", rs.getString("nombre"));
				object.addProperty("Meta", rs.getDouble("Meta"));
				object.addProperty("porVisitar", rs.getDouble("Visitar"));
				object.addProperty("cobrado", rs.getDouble("cobro"));
				object.addProperty("Visitados", rs.getDouble("Visitado"));
				object.addProperty("User_id", rs.getDouble("user_id"));
				 
				json = object.toString();
				System.out.println(json);
			}
			rs.close();				
			c.close();
			
			if(json==""){
				JsonObject object = new JsonObject();
				object.addProperty("Nombre", "S/N");
				object.addProperty("Meta", 0);
				object.addProperty("porVisitar", 0);
				object.addProperty("cobrado", 0);
				object.addProperty("Visitados", 0);
				object.addProperty("User_id", 0);
				 
				json = object.toString();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
		return json;
		
	}

	public String lugaresRuta(String fechaInicio, String fechaFinal,String userId){			
		String json = "" ;
		
		
		String query="SELECT C.nombre as usuario, CONCAT(D.nombre,' ',D.apellidoPaterno,' ',D.apellidoMaterno) as cliente,"
				+ " B.negocioHorario as horario,A.pagoCuota,A.pagoCobroRealizado,A.pagoMontoCobrado,A.descripcion"
				+ " B.negocioLatitud,B.negocioLongitud"
				+ " FROM dbsanatf.lugares_cobro A, dbsanatf.solicitudes B, dbsanatf.user C,dbsanatf.clientes D"
				+ " where A.idCliente = B.idCliente and B.user_id = " + userId;
				if (fechaInicio==null){
					query +=" and fechaVisita = CURDATE()";
				}else{
					query +=" and fechaVisita between '" + fechaInicio + "' and '" + fechaFinal + "'";
				}    
				query += " and B.User_id=C.User_id"
				+ " and A.idCliente = D.idCliente";
		
		
		DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
    	Connection c;	    	
		try {
			c = ds.getConnection();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				JsonObject object = new JsonObject();
				object.addProperty("usuario", rs.getString("usuario"));
				object.addProperty("cliente", rs.getDouble("cliente"));
				object.addProperty("horario", rs.getDouble("negocioHorario"));
				object.addProperty("cuota", rs.getDouble("pagoCuota"));
				object.addProperty("cobroRealizado", rs.getDouble("pagoCobroRealizado"));
				object.addProperty("montoCobrado", rs.getDouble("pagoMontoCobrado"));
				object.addProperty("razon", rs.getDouble("descripcion"));
				object.addProperty("latitud", rs.getDouble("negocioLatitud"));
				object.addProperty("longitud", rs.getDouble("negocioLatitud"));
				object.addProperty("User_id", rs.getDouble("user_id"));
				 
				json = object.toString();
				System.out.println(json);
			}
			rs.close();				
			c.close();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
		return json;
		
	}
	
	
	public String ruta_optima(int numero_nodos,double[][] d)
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
	}

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
	
	
	
	public double calcularDistanciaEntre(double iniPos, double endPos) {
        
	    LatLng latlngInicial = new LatLng(0,0);
	    LatLng latlngFinal = new LatLng(0,0);
	    double distancia=0;
	    
	    
	    
	    latlngInicial.lat=19.2799481;
	    latlngInicial.lng=-99.669227;
	    
	    latlngFinal.lat=19.290219;
	    latlngFinal.lng=-99.659703;
	   
	    
	    DirectionsLeg dms = new DirectionsLeg();
	    dms.startLocation=latlngInicial;
	    dms.endLocation=latlngFinal;

	    
	    distancia = dms.distance.inMeters;
	    
        return distancia;


	}
	
}





