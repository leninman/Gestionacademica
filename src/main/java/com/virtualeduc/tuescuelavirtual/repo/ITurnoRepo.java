/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.repo;
import com.virtualeduc.tuescuelavirtual.models.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Lenin
 */
public interface ITurnoRepo extends JpaRepository<Turno, Long> {
    
    @Query(value="SELECT * from turnos a "
                    + "WHERE a.TURNO=:turno",nativeQuery = true)
    public Turno consultarTurnoByTurno(String turno);
}
