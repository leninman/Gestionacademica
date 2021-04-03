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
    
    @Query(value="SELECT * from cursos a "
                    + "WHERE a.ID_ANNIO=?1 and a.ID_ANNIO_ESC=?2 and a.ID_SEC=?3",nativeQuery = true)
    public Curso consultarCursoByParametros(Long idannio,Long idannioesc,Long idseccion);
    
    
    @Query(value="Select a.id_curso,a.id_annio,a.id_sec,a.id_annio_esc,a.id_turno,b.nivel,b.especialidad "
                    + "from cursos a left join annios b "
                    + "on a.id_annio=b.id_annio "
                    + "where a.id_annio_esc=?1",nativeQuery = true)
    public List<Curso> consultarCursosByPeriodo(Long idannioesc);
    
    

    
}
