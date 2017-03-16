package com.sanaws.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.axis.AxisFault;
import org.apache.commons.io.output.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.stereotype.Service;



import javax.persistence.Entity;

import com.sanaws.model.ApplicationContextProvider;
import com.sanaws.model.ClientesAsignados;
import com.sanaws.model.Usuarios;
import com.sanaws.model.UsuariosStatus;
import com.sanaws.service.UsuariosService;

import safisrv.ws.schemas.ConsultaSaldoCreditoRequest;
import safisrv.ws.schemas.ConsultaSaldoCreditoResponse;
import safisrv.ws.schemas.SAFIServiciosSoap11Stub;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import java.util.List;
import safisrv.ws.schemas.*;

@Controller

public class ListaUsuariosController {
	
	@Autowired
	private UsuariosService usuariosService;
	@RequestMapping(value = "/lista", method = RequestMethod.GET, headers="Accept:application/json")
	//@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody ArrayList clientesAsignados(HttpSession session,Map<String, Object> map,HttpServletRequest request,HttpServletResponse response){	
		ArrayList lista=new ArrayList();
		String userId = request.getParameter("user");

		String query="SELECT CONCAT(D.nombre,' ',D.apellidoPaterno,' ',D.apellidoMaterno) as cliente,"
				+ " B.negocioLatitud,B.negocioLongitud"
				+ " FROM dbsanatf.lugares_cobro A, dbsanatf.solicitudes B, dbsanatf.user C,dbsanatf.clientes D"
				+ " where A.idCliente = B.idCliente and B.user_id = " + userId
				+ " and B.User_id=C.User_id"
				+ " and A.idCliente = D.idCliente";
				
		response.setContentType("application/json");
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
