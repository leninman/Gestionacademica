package com.virtualeduc.tuescuelavirtual.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	static String valorDelPeriodo;
	
	
	public static String extraePeriodoEscolar(Date fechaI,Date fechaF) {
		
	    
		SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
		
		String AnnioInicial = getYearFormat.format(fechaI);
		
		String AnnioFinal = getYearFormat.format(fechaF);
	    
	   valorDelPeriodo=AnnioInicial.concat("-").concat(AnnioFinal);
		
		return valorDelPeriodo;
	}

}
