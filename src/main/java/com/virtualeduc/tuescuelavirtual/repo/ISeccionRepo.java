/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.repo;


import com.virtualeduc.tuescuelavirtual.models.AnnioEscolar;
import com.virtualeduc.tuescuelavirtual.models.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Lenin
 */
public interface ISeccionRepo extends JpaRepository<Seccion, Long> {
    
    
    @Query(value="SELECT * from secciones a "
                    + "WHERE a.SECCION=:seccion",nativeQuery = true)
    public Seccion consultarSeccionBySeccion(String seccion);
    
   
}
