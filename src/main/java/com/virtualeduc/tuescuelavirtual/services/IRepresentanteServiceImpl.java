/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.services;
import com.virtualeduc.tuescuelavirtual.models.DTOS.RepresentanteDTO;
import com.virtualeduc.tuescuelavirtual.models.Representante;
import com.virtualeduc.tuescuelavirtual.repo.IRepresentanteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenin
 */
@Service
public class IRepresentanteServiceImpl implements IRepresentanteService {

     @Autowired
     IRepresentanteRepo representanteRepo;
     
     Representante rep;
    
    @Override
    public Representante consultarepresentanteporid(Long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return representanteRepo.findById(id).orElse(null);
    }
    
    
    @Override
    public Representante consultarepresentanteporcedula(String tipodocumento, String numerodocumento) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          return representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(tipodocumento, numerodocumento);
    }

    @Override
    public Representante guardarRepresentante(Representante representante) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        rep=new Representante();
        return representanteRepo.save(representante);
//        return rep;
    }

    @Override
    public RepresentanteDTO obtenerRepresentantePorCedula(String tipodocumento, String numerodocumento) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Representante rep=representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(tipodocumento, numerodocumento);
         
         RepresentanteDTO repdto=new RepresentanteDTO(rep);
         
         return repdto;
    }

    
    
}
