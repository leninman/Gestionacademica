/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.repo;


import com.virtualeduc.tuescuelavirtual.models.Representante;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Lenin
 */
public interface IRepresentanteRepo extends CrudRepository<Representante,Long> {
    
//    @Query("SELECT * from Representante u"
//            + " WHERE u.tipoDocRpr=tipoDoc AND u.numDocRpr=numDoc"
//    )
    
    Representante findRepresentanteByTipoDocRprAndNumDocRpr(String tipoDocRpr,String numDocRpr);
}
