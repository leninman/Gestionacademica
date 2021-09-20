package com.virtualeduc.tuescuelavirtual.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualeduc.tuescuelavirtual.models.Profesion;
import com.virtualeduc.tuescuelavirtual.repo.IProfesionRepo;

@Service
public class IVariosServiceImpl implements IVariosService {
    @Autowired
    IProfesionRepo profesionesRepo;
    
    @Override
	public List<Profesion> consultarProfesiones() {
		// TODO Auto-generated method stub
		return profesionesRepo.findAll();
	}

}
