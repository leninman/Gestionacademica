package com.virtualeduc.tuescuelavirtual.services;

import java.util.List;

import com.virtualeduc.tuescuelavirtual.models.Profesor;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import com.virtualeduc.tuescuelavirtual.models.DTOS.ProfesorDTO;

public interface IProfesoresService {
	
	public List<ProfesorDTO> consultarProfesores();
	
	public Profesor consultarProfesorPorId(Long idProfesor);
	
	public Profesor consultarProfesorPorCedula(String tipoDocPrf,String numDocPrf);
	
	public Responses guardarProfesor(ProfesorDTO profesorDTO,boolean guardar);

}
