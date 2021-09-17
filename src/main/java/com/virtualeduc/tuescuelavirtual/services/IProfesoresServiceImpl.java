package com.virtualeduc.tuescuelavirtual.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualeduc.tuescuelavirtual.models.Profesor;
import com.virtualeduc.tuescuelavirtual.repo.IProfesorRepo;

@Service
public class IProfesoresServiceImpl implements IProfesoresService {
	
	@Autowired
	IProfesorRepo profesoresRepo;

	@Override
	public List<Profesor> consultarProfesores() {
		// TODO Auto-generated method stub
		return profesoresRepo.findListProfesores();
	}

}
