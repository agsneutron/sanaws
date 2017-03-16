
package com.sanaws.jaxrs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.codec.binary.Base64;
import org.springframework.security.access.annotation.Secured;

import com.sanaws.model.Mensajes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/* 
 * author: Alex
 * */

@Path("/file")
public class SubeArchivoRestServide {
	
    @GET
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @Secured("ROLE_ADMIN")
    
	public Mensajes getFile(@QueryParam("filename") String nombre,@QueryParam("image") String imagen)
	{    	
		return convertStringtoImage(imagen,nombre);
    	//return validadatos(imagen,nombre);
		
	}


// 
	public Mensajes convertStringtoImage(String encodedImageStr,String fileName) {
		Mensajes mensaje = null;
		try {
			// Decode String using Base64 Class
			byte[] imageByteArray = Base64.decodeBase64(encodedImageStr); 

			// Write Image into File system - Make sure you update the path
			FileOutputStream imageOutFile = new FileOutputStream("/home/sanatf/imagenes/" + fileName);
			//FileOutputStream imageOutFile = new FileOutputStream("C:/ags/UploadedImages/" + fileName);
			imageOutFile.write(imageByteArray);
			
			Mensajes R=new Mensajes(0,1,"Se guardó correctamente la imágen");
		    mensaje = R;
			
			imageOutFile.close();

			System.out.println("Image Successfully Stored");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Image Path not found" + fnfe);
			Mensajes R=new Mensajes(1,0,"el directorio no existe");
		    mensaje = R;
		} catch (IOException ioe) {
			Mensajes R=new Mensajes(2,0,"Excepción al convertir la imágen" + ioe);
		    mensaje = R;
			System.out.println("Exception while converting the Image " + ioe);
		}
		return mensaje;
	}

	
	public Mensajes validadatos(String encodedImageStr,String fileName) {
		Mensajes mensaje = null;
					
			Mensajes R=new Mensajes(100,100,"nombre de la imágen es: " + fileName);
		    mensaje = R;			
		
		return mensaje;
	}
	
}