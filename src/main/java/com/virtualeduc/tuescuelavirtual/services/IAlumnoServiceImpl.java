/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.services;

import com.virtualeduc.tuescuelavirtual.models.Alumno;



import com.virtualeduc.tuescuelavirtual.repo.IAlumnoRepo;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Personal
 */
@Service
public class IAlumnoServiceImpl implements IAlumnoService {
    
    @Autowired
    IAlumnoRepo alumnorepo;
    



    @Override
    @Transactional
    public void guardaAlumno(Alumno alumno) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
          alumnorepo.save(alumno);
    }

    /**
     *
     * @return
     */
    @Override
    @Transactional(readOnly=true)
    public Optional<Alumno> consultarAlumnos() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        return alumnorepo.findListAlumnos();
      
    
    }

    @Override
    public Alumno consultaAlumno(Long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Alumno alumno = null;
        
        return alumno;
    }

  

   

   

 
    
}
