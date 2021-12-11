/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.repo;


import com.virtualeduc.tuescuelavirtual.models.Representante;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Lenin
 */
public interface IRepresentanteRepo extends CrudRepository<Representante,Long> {
    
    @Query(value="SELECT * from representantes a"
            + " WHERE a.TIPO_DOC_RPR=?1 AND a.NUM_DOC_RPR=?2",nativeQuery = true)
    Representante findRepresentanteByTipoDocRprAndNumDocRpr(String tipoDocRpr,String numDocRpr);
}
