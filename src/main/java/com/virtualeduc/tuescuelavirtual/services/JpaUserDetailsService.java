package com.virtualeduc.tuescuelavirtual.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtualeduc.tuescuelavirtual.models.Role;
import com.virtualeduc.tuescuelavirtual.models.Usuario;
import com.virtualeduc.tuescuelavirtual.repo.IUsuarioRepo;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {
	
	@Autowired
	IUsuarioRepo usuariorepo;
	
    private Logger logger=LoggerFactory.getLogger(JpaUserDetailsService.class);
    		
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario=usuariorepo.findByUsername(username);
		
		if(usuario==null) {
			logger.error("Error en el login: no existe el usuario '" + username + "'");
			throw new UsernameNotFoundException("Username " + username + " no existe en el sistema");
			
		}
		
		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		
		
	
		
		for(Role role:usuario.getRoles()) {
			logger.info(role.getAuthority());
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		
		
		if(authorities.isEmpty()) {
			logger.error("Error en el login: usuario '" + username + "' no tiene roles asignados!");
			throw new UsernameNotFoundException("Error en el login: usuario '" + username + "' no tiene roles asignados!");
		}
		
		return new User(usuario.getUsername(),usuario.getPassword(),true,true, true, true,authorities);
	}

}
