package com.virtualeduc.tuescuelavirtual.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualeduc.tuescuelavirtual.models.NotaPar;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface INotasParRepo extends JpaRepository<NotaPar,Long> {
    
    
//      @Query("SELECT * from NotaPar u "
//              + "INNER JOIN Alumno v "
//              + "on u.alumno=v "
//              + "INNER JOIN Curso e "
//              + "on u.curso=e "
//              + "WHERE v.tipoDocAl=?1 AND v.numDocAl=?2",nativeQuery=true)
//  List<NotaPar> consultarNotasPorAlumno(String tipoDocAl,String numDocAl);
//}
    
    @Query(value="SELECT "
                + "a.ID_NOTA_PAR,a.ID_ALUMNO,a.ID_MAT,a.ID_CURSO,a.ID_PRF,a.ID_LAPSO,a.NOTA,a.PORCENTAJE "
	 	+ "from notas_par a "
                + "LEFT JOIN alumnos b ON a.ID_ALUMNO =b.ID_AL "
                + "WHERE b.TIPO_DOC_AL=?1 AND b.NUM_DOC_AL=?2"
         ,nativeQuery = true)
	 public List<NotaPar> consultarNotasPorAlumno(String tipoDocAl,String numDocAl);

    @Query(value="SELECT "
                + "a.ID_NOTA_PAR,a.ID_ALUMNO,a.ID_MAT,a.ID_CURSO,a.ID_PRF,a.ID_LAPSO,a.NOTA,a.PORCENTAJE,d.INT_ANNIO_ESC "
	 	+ "from notas_par a "
                + "LEFT JOIN alumnos b ON a.ID_ALUMNO =b.ID_AL "
                + "left join cursos c on b.ID_CURSO =c.ID_CURSO "
                + "left join annio_escolar d on c.ID_ANNIO_ESC =d.ID_ANNIO_ESC "
                + "WHERE b.TIPO_DOC_AL=?1 AND b.NUM_DOC_AL=?2 AND d.INT_ANNIO_ESC=?3"
                
         ,nativeQuery = true)
	 public List<NotaPar> consultarNotasPorAlumnoPeriodo(String tipoDocAl,String numDocAl,String periodo);


    @Query(value="SELECT "
                + "a.ID_NOTA_PAR,a.ID_ALUMNO,a.ID_MAT,a.ID_CURSO,a.ID_PRF,a.ID_LAPSO,a.NOTA,a.PORCENTAJE,d.INT_ANNIO_ESC "
	 	+ "from notas_par a "
                + "LEFT JOIN alumnos b ON a.ID_ALUMNO =b.ID_AL "
                + "left join cursos c on b.ID_CURSO =c.ID_CURSO "
                + "left join annio_escolar d on c.ID_ANNIO_ESC =d.ID_ANNIO_ESC "
                + "LEFT JOIN lapsos e on a.ID_LAPSO =e.ID_LAPSO "
                + "WHERE b.TIPO_DOC_AL=?1 AND b.NUM_DOC_AL=?2 AND d.INT_ANNIO_ESC=?3 AND e.DESCRIPCION=?4"
                
         ,nativeQuery = true)
	 public List<NotaPar> consultarNotasPorAlumnoPeriodoLapso(String tipoDocAl,String numDocAl,String periodo,String lapso);


    @Query(value="SELECT "
                + "a.ID_NOTA_PAR,a.ID_ALUMNO,a.ID_MAT,a.ID_CURSO,a.ID_PRF,a.ID_LAPSO,a.NOTA,a.PORCENTAJE,d.INT_ANNIO_ESC "
	 	+ "from notas_par a "
                + "LEFT JOIN alumnos b ON a.ID_ALUMNO =b.ID_AL "
                + "left join cursos c on b.ID_CURSO =c.ID_CURSO "
                + "left join annio_escolar d on c.ID_ANNIO_ESC =d.ID_ANNIO_ESC "
                + "LEFT JOIN lapsos e on a.ID_LAPSO =e.ID_LAPSO "
                + "left join materias m on a.ID_MAT = m.ID_MAT  "
                + "WHERE a.ID_CURSO =?1 AND a.ID_MAT =?2 AND a.ID_ALUMNO=?3"
                
         ,nativeQuery = true)
	 public List<NotaPar> consultarNotasPorCursoMateriaYAlumno(Long idCurso,Long idMat,Long idAlumno);


	@Query(value = "SELECT " +
			"a.ID_NOTA_PAR," +
			"a.ID_ALUMNO," +
			"a.ID_MAT," +
			"a.ID_CURSO," +
			"a.ID_PRF," +
			"a.ID_LAPSO," +
			"a.NOTA," +
			"a.PROCENTAJE " +
			"WHERE a.ID_ALUMNO=?1 and a.ID_MAT=?2 and a.ID_CURSO=?3"
			,nativeQuery = true)
	public List<NotaPar> consultarNotasPorCursoMateriaYAlumno2(Long idAlumno,Long idMat,Long idCurso);





}



