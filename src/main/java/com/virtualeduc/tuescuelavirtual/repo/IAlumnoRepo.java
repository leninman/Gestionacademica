/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.repo;

import com.virtualeduc.tuescuelavirtual.models.Alumno;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Personal
 */
public interface IAlumnoRepo extends JpaRepository<Alumno, Long> {

    @Query(value="SELECT * from alumnos a "
                    + "LEFT JOIN cursos b ON a.ID_CURSO=b.ID_CURSO "
                    + "LEFT JOIN annios c ON b.ID_ANNIO=c.ID_ANNIO "
                    + "LEFT JOIN secciones d ON b.ID_SEC=d.ID_SEC "
                    + "LEFT JOIN annio_escolar e ON b.ID_ANNIO_ESC=e.ID_ANNIO_ESC "
                    + "LEFT JOIN representantes f ON a.ID_RPR1=f.ID_RPR "
                    + "WHERE a.STATUS='ACTIVO'",nativeQuery = true)
    public List<Alumno> findListAlumnos();
    
    
    public Alumno findAlumnoByTipoDocAlAndNumDocAl(String tipoDocAl, String numDocAl);
    
    
    @Query(value="SELECT a.ID_AL FROM alumnos a "
    		+ "LEFT JOIN cursos b ON a.ID_CURSO=b.ID_CURSO "
    		+ "WHERE a.STATUS='ACTIVO' and a.ID_CURSO=?1",nativeQuery = true)
    public Long[] findAlumnoByIdCurso(Long idcurso);
    
    /*@Modifying
    @Query(value="UPDATE alumnos a "
    		+ "SET a.STATUS='RETIRADO' "
    		+ "WHERE idAl=?1",nativeQuery=true)
    public void DelAlumno(Long idAl);*/
    
}
