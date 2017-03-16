package com.sanaws.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	@RequestMapping("/login")
	public String doLogin(HttpSession session,Map<String, Object> map){
		String pathimg =session.getServletContext().getRealPath("/resources/bootstrap/img/logo_small.png");
    	try {
			imageByte(pathimg,"logo_small",map);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "login";
	}
	
	
	private void imageByte(String ruta,String imageName,Map<String, Object> map) throws FileNotFoundException{
		File file = new File(ruta);
		FileInputStream fis=new FileInputStream(file);
		
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		int b;
		byte[] buffer = new byte[1024];
		try {
			while((b=fis.read(buffer))!=-1){
			   bos.write(buffer,0,b);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] fileBytes=bos.toByteArray();
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		byte[] encoded=Base64.encodeBase64(fileBytes);
		String encodedString = new String(encoded);

		//ModelMap map = new ModelMap();
		map.put(imageName, encodedString);		
		
	}
	
	
}

