/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.repo;

import com.virtualeduc.tuescuelavirtual.models.Alumno;

import java.util.List;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Personal
 */
public interface IAlumnoRepo extends JpaRepository<Alumno, Long> {

    @Query(nativeQuery = true)
    List<Alumno> findListAlumnos();
    
    Alumno findAlumnoByTipoDocAlAndNumDocAl(String tipoDocAl, String numDocAl);
    
//    @Query(nativeQuery = true)
//    Alumno findByTipoDocAlAndNumDocAl(String tipoDocAl,String numDocAl);
    
    
            
//     @Query(value="SELECT a.idAl,"
//             + "a.tipoDocAl," 
//             + "a.numDocAl,"
//             + "a.primNombAl,"
//             + "a.segNombAl,"
//             + "a.primApellAl,"
//             + "a.segApellAl,"
//             + "c.annio,"
//             + "d.seccion,"
//             + "e.intAnnioEsc,"
//             + "f.idRpr "
//             + "from alumnos a "
//             + "LEFT JOIN cursos b ON a.idCurso.idCurso=b.idCurso "
//             + "LEFT JOIN annios c ON b.idAnnio.idAnnio=c.idAnnio "
//             + "LEFT JOIN secciones d ON b.idSec.idSec=d.idSec "
//             + "LEFT JOIN annio_escolar e ON b.idAnnioEsc.idAnnioEsc=e.idAnnioEsc "
//             + "LEFT JOIN representantes f ON a.idRpr1.idRpr=f.idRpr",nativeQuery = true)
//            
//     @Query("select a from Alumno a inner join fetch a.idCurso b ON a.idCurso.idCurso=b.idCurso")     

//    Optional<List<Alumno>> findListAlumnos();
//      List<Alumno> findListAlumnos();     
    

}
