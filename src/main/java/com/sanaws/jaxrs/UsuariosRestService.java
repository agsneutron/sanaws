
package com.sanaws.jaxrs;


import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

import com.sanaws.dao.UserDao;
import com.sanaws.model.Role;
import com.sanaws.model.Usuarios;
import com.sanaws.model.UserStatus;
import com.sanaws.service.UsuariosService;
import com.sanaws.model.User;

/* 
 * author:
 * 
 * */
@Path("/usuarios")
@Secured("ROLE_USER")
@Controller
public class UsuariosRestService {
	
	@Autowired
	private SessionFactory session;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public int getUsuarioId(@QueryParam("userName") String userName)
	{
    	
    	int idUser=0;
    	
    	
    	Criteria criteria = session.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("Usuario", userName));		
		User user = (User)criteria.uniqueResult();
    		
    		if(user!=null){
    			idUser = user.getId();
    			
    		}else{
    			throw new UsernameNotFoundException("Usuario no encontrado!!!");
    		}
		return idUser;
	}
}
