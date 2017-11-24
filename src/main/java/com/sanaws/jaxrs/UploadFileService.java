package com.sanaws.jaxrs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sanaws.model.Mensajes;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/imagen")
public class UploadFileService {

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Mensajes uploadFile(
	        @FormDataParam("file") InputStream uploadedInputStream,
	        @FormDataParam("file") FormDataContentDisposition fileDetail) {
	
	
	    // Path format //10.217.14.97/Installables/uploaded/
		//String path = "C:/ags/UploadedImages/";
		String path = "/home/sanatf/imagenes/";
		//String path = "/Users/ariaocho/RESPALDOS/";
		
	    System.out.println("path::"+path);
	    String uploadedFileLocation = path
	            + fileDetail.getFileName();
	
	    // save it
	    writeToFile(uploadedInputStream, uploadedFileLocation);
	
	    String output = "File uploaded to : " + uploadedFileLocation;
	     
	    Mensajes R=new Mensajes(0,1,"Se guardó correctamente la imágen");
	    return R;
	    //return Response.status(200).entity(output).build();
	
	}
	
	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
	        String uploadedFileLocation) {
	
	    try {
	        OutputStream out = new FileOutputStream(new File(
	                uploadedFileLocation));
	        int read = 0;
	        byte[] bytes = new byte[1024];
	
	        out = new FileOutputStream(new File(uploadedFileLocation));
	        while ((read = uploadedInputStream.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        
	        out.flush();
	        out.close();
	        
	    } catch (IOException e) {
	
	        e.printStackTrace();
	    }
	
	 }

   }