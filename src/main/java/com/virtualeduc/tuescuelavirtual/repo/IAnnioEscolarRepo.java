/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.repo;
import com.virtualeduc.tuescuelavirtual.models.AnnioEscolar;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Lenin
 */
public interface IAnnioEscolarRepo extends JpaRepository<AnnioEscolar, Long> {

    @Query(value="SELECT * from annio_escolar a where a.status='A'",nativeQuery = true)
    public AnnioEscolar consultarAnnioEscolarVigente();
    
    @Query(value="Select a.ID_ANNIO_ESC,a.INT_ANNIO_ESC,a.FECHA_I,a.FECHA_F,a.STATUS"
       		+ " from annio_escolar a",nativeQuery=true)
       public List<AnnioEscolar> consultarPeriodosEscolares();
}
