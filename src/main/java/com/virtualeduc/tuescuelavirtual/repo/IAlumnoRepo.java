/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.repo;

import com.virtualeduc.tuescuelavirtual.models.Alumno;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Personal
 */
public interface IAlumnoRepo extends CrudRepository<Alumno,Long> {
    
    //public Alumnos findByalumnosPK(alumnosPK Alumno);
    //@Query()
     @Query("SELECT a.idAl,"
             + "a.tipoDocAl,"
             + "a.numDocAl,"
             + "a.primNombAl,"
             + "a.segNombAl,"
             + "a.primApellAl,"
             + "a.segApellAl,"
             + "c.annio,"
             + "d.seccion,"
             + "e.intAnnioEsc,"
             + "f.idRpr "
             + "from Alumno a "
             + "LEFT JOIN Curso b ON a.curso.idCurso=b.idCurso "
             + "LEFT JOIN Annio c ON b.annio.idAnnio=c.idAnnio "
             + "LEFT JOIN Seccion d ON b.seccion.idSec=d.idSec "
             + "LEFT JOIN AnnioEscolar e ON b.annioEscolar.intAnnioEsc=e.intAnnioEsc "
             + "LEFT JOIN Representante f ON a.representante.idRpr=f.idRpr")
    Optional<Alumno> findListAlumnos();
    
    
    
    
    
//         @Query("SELECT a from Alumnos a")
//    List<Alumnos> findListAlumnos();
    
}
