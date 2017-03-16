package com.sanaws.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	@RequestMapping({"/home","/"})
	public String doLogin(HttpSession session,Map<String, Object> map,HttpServletRequest request){
		boolean rolAdministrador = request.isUserInRole("Administrador");
		String regresa="login";
        
		if (rolAdministrador){
			regresa = "home";
		}
		return regresa;
	}
	
}

