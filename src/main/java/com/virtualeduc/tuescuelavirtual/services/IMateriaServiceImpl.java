package com.virtualeduc.tuescuelavirtual.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualeduc.tuescuelavirtual.models.Materia;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import com.virtualeduc.tuescuelavirtual.models.DTOS.MateriaDTO;
import com.virtualeduc.tuescuelavirtual.repo.IMateriaRepo;
import com.virtualeduc.tuescuelavirtual.utils.Constantes;

@Service
public class IMateriaServiceImpl implements IMateriaService{
	
	@Autowired
	IMateriaRepo materiaRepo;

	@Override
	public Responses guardarMateria(Materia materia,boolean Guardar) {
		// TODO Auto-generated method stub
		Responses resp=new Responses();
		
		if(Guardar) {
			//Para guardar
			String codigo=materia.getCodigoMat();
			
			Materia materiaGuardada=materiaRepo.buscarMateriaPorCodigo(codigo);
			
			
			if(materiaGuardada==null) {
				
				materiaGuardada=materiaRepo.save(materia);
				
				MateriaDTO materiaGuardadadto=new MateriaDTO(materiaGuardada);
				
				resp.setResponseCode(Constantes.MATERIA_REGISTRADA_CODE);
				
				resp.setResponseDescription(Constantes.MATERIA_REGSTRADA_DESC);
				
				resp.setMateria(materiaGuardadadto);
			}else {
				
				MateriaDTO materiaGuardadadto=new MateriaDTO(materiaGuardada);
				
				resp.setResponseCode(Constantes.MATERIA_EXISTE_CODE);
				
				resp.setResponseDescription(Constantes.MATERIA_EXISTE_DESC);
				
				resp.setMateria(materiaGuardadadto);
			}
			
		}else {
			//Para actualizar
			//Long idMat=materiaDTO.getIdMat();
			
			//Materia materiaGuardada=materiaRepo.findById(idMat).orElse(null);
			
			//Materia materiaAguardar=new Materia(materiaDTO);
			
			//materiaAguardar.setIdMat(idMat);
			
			Materia materiaGuardada=materiaRepo.save(materia);
			
			MateriaDTO materiaGuardadadto=new MateriaDTO(materiaGuardada);
			
			resp.setMateria(materiaGuardadadto);
			
			resp.setResponseCode(Constantes.MATERIA_MODIFICADA_CODE);
			
			resp.setResponseDescription(Constantes.MATERIA_MODIFICADA_DESC);
			
		}
		
	
		
		
		return resp;
	}

	@Override
	public List<MateriaDTO> listaMaterias() {
		// TODO Auto-generated method stub
		List<MateriaDTO> materiasDTO=new ArrayList<>();
		
		List<Materia> materias=new ArrayList<>();
		
		materias= materiaRepo.listarMateriasActivas();
		
		for(Materia materia:materias) {
			
			MateriaDTO materiaDTO=new MateriaDTO(materia);
			
			materiasDTO.add(materiaDTO);
		}
		
		return materiasDTO;
	}

	@Override
	public MateriaDTO consultarMateriaPorId(Long idMateria) {
		// TODO Auto-generated method stub
		Materia materia=materiaRepo.findById(idMateria).orElse(null);
		
		MateriaDTO materiaDTO=new MateriaDTO(materia);
		
		return materiaDTO;
	}

	@Override
	public MateriaDTO consultarMateriaPorCodigo(String codigoMateria) {
		// TODO Auto-generated method stub
		Materia materia=materiaRepo.buscarMateriaPorCodigo(codigoMateria);
		
		MateriaDTO materiaDTO=new MateriaDTO(materia);
		
		return materiaDTO;
	}

	@Override
	public Responses desactivarMateria(Long idMat) {
		// TODO Auto-generated method stub
		
		Responses resp=new Responses();
		
		Materia materia;
		
		Materia materiaAguardar=new Materia(); 
		
		Materia materiaGuardada=materiaRepo.findById(idMat).orElse(null);
		
		materiaAguardar=materiaGuardada;
		
		materiaAguardar.setStatus("I");
		
		materia=materiaRepo.save(materiaAguardar);
		
		resp.setResponseCode(Constantes.MATERIA_DESACTIVADA_CODE);
		
		resp.setResponseDescription(Constantes.MATERIA_DESACTIVADA_DESC);
		
		return resp;
	}

}
