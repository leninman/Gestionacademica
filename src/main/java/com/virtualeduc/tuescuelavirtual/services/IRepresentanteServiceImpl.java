/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.services;

import com.virtualeduc.tuescuelavirtual.models.Representante;
import com.virtualeduc.tuescuelavirtual.repo.IRepresentanteRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Lenin
 */
public class IRepresentanteServiceImpl implements IRepresentanteService {

     @Autowired
     IRepresentanteRepo representanteRepo;
    
    
    
    @Override
    public Representante Consultarepresentante(Long id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         return representanteRepo.findById(id).orElse(null);
    }
    
}
