package com.virtualeduc.tuescuelavirtual.services;

import java.util.List;

import com.virtualeduc.tuescuelavirtual.models.Materia;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import com.virtualeduc.tuescuelavirtual.models.DTOS.MateriaDTO;

public interface IMateriaService {
	
	public Responses guardarMateria(Materia materia,boolean guardar);
	
    public List<MateriaDTO> listaMaterias();
    
    public MateriaDTO consultarMateriaPorId(Long idMateria);
    
    public MateriaDTO consultarMateriaPorCodigo(String codigoMateria);
    
    public Responses desactivarMateria(Long idMat);
    
    public List<String> nombresmaterias();
    
    public Long consultarIdMaterias(String materia,String annio,String nivel,String especialidad);
    
    
    
    

}
