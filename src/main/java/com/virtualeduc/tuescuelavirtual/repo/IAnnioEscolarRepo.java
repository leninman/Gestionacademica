/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.repo;
import com.virtualeduc.tuescuelavirtual.models.AnnioEscolar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Lenin
 */
public interface IAnnioEscolarRepo extends JpaRepository<AnnioEscolar, Long> {

    @Query(value="SELECT * from annio_escolar a where a.status='A'",nativeQuery = true)
    public AnnioEscolar consultarAnnioEscolarVigente();
}
