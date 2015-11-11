package com.sanaTF.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanaTF.dao.UserDao;
import com.sanaTF.model.Role;
import com.sanaTF.model.User;
import com.sanaTF.model.UserStatus;
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String Usuario)
			throws UsernameNotFoundException {
		User user = userDao.findUserByName(Usuario); //our own User model class
		
		if(user!=null){
			String Contrasena = user.getPassword();
			//additional information on the security object
			boolean enabled = user.getStatus().equals(UserStatus.S);
			boolean accountNonExpired = user.getStatus().equals(UserStatus.S);
			boolean credentialsNonExpired = user.getStatus().equals(UserStatus.S);
			boolean accountNonLocked = user.getStatus().equals(UserStatus.S);
			
			//Let's populate user roles
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for(Role role : user.getRoles()){
				authorities.add(new GrantedAuthorityImpl(role.getRoleName()));
			}
			
			//Now let's create Spring Security User object
			org.springframework.security.core.userdetails.User securityUser = new 
					org.springframework.security.core.userdetails.User(Usuario, Contrasena, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
			return securityUser;
		}else{
			throw new UsernameNotFoundException("Usuario no encontrado!!!");
		}
	}

}
