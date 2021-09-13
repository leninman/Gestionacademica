/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.repo;

import com.virtualeduc.tuescuelavirtual.models.Annio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Lenin
 */
public interface IAnnioRepo extends JpaRepository<Annio, Long>{
    
    @Query(value="SELECT * from annios a "
                    + "WHERE a.ANNIO=?1 and a.NIVEL=?2",nativeQuery = true)
    public Annio consultarAnnioByAnnioAndNivel(String annio,String nivel); 
    
    @Query(value="SELECT * from annios a "
            + "WHERE a.ANNIO=?1 and a.NIVEL=?2 and a.ESPECIALIDAD=?3",nativeQuery = true)
public Annio consultarAnnioByAnnioAndNivelAndEspecialidad(String annio,String nivel, String especialidad); 
}
