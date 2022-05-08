package com.virtualeduc.tuescuelavirtual.utils;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class Utils {
	
	static String valorDelPeriodo;
	
	
	public static String extraePeriodoEscolar(Date fechaI,Date fechaF) {
		
	    
		SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
		
		String AnnioInicial = getYearFormat.format(fechaI);
		
		String AnnioFinal = getYearFormat.format(fechaF);
	    
	   valorDelPeriodo=AnnioInicial.concat("-").concat(AnnioFinal);
		
		return valorDelPeriodo;
	}
        
        public static boolean hasRole(String role) {

		SecurityContext context = SecurityContextHolder.getContext();

		if (context == null) {
			return false;
		}

		Authentication auth = context.getAuthentication();

		if (auth == null) {
			return false;
		}

		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

		return authorities.contains(new SimpleGrantedAuthority(role));

		/*
		 * for(GrantedAuthority authority:authorities) {
		 * 
		 * if(role.equals(authority.getAuthority())) {
		 * logger.info("Hola usuario ".concat(auth.getName()).concat(" tu role es: ").
		 * concat(authority.getAuthority())); return true; }
		 * 
		 * } return false;
		 */ 
	}
        
        public static Float calcularPorcentajeNota(Float nota,Float rate){
        
           return nota*rate/100;
        
        }


}
