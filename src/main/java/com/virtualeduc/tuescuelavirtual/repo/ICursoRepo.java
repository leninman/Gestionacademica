/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.repo;

import com.virtualeduc.tuescuelavirtual.models.Curso;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Lenin
 */
public interface ICursoRepo extends JpaRepository<Curso, Long> {
    
    @Query(nativeQuery = true)
    public Curso consultarCursoByParametros(Long idannio,Long idseccion,Long idannioesc);
    

    
}
