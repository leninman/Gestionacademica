package com.virtualeduc.tuescuelavirtual.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualeduc.tuescuelavirtual.models.NotasPar;
import org.springframework.data.jpa.repository.Query;

public interface INotasParRepo extends JpaRepository<NotasPar,Long> {
    
    /*@Query(value="SELECT "
                + "b.TIPO_DOC_AL,b.NUM_DOC_AL,b.PRIM_NOMB_AL,b.PRIM_APELL_AL,"
                + "b.SEG_APELL_AL,b.SEG_NOMB_AL,a.NOTA,c.NOMBRE_MAT,e.ANNIO,"
                + "f.SECCION,g.INT_ANNIO_ESC,h.TURNO,i.DESCRIPCION "
	 	+ "from notas_par a "
                + "LEFT JOIN alumnos b ON a.ID_ALUMNO =b.ID_AL "
                + "LEFT JOIN materias c  on a.ID_MAT =c.ID_MAT "
                + "LEFT JOIN cursos d on a.ID_CURSO =d.ID_CURSO "
                + "INNER JOIN annios e on d.ID_ANNIO =e.ID_ANNIO "
                + "INNER JOIN secciones f on d.ID_SEC =f.ID_SEC "
                + "INNER JOIN annio_escolar g on d.ID_ANNIO_ESC = g.ID_ANNIO_ESC "
                + "INNER JOIN turnos h on d.ID_TURNO =h.ID_TURNO "
                + "INNER JOIN lapsos i on a.ID_LAPSO = i.ID_LAPSO "
	 	+ "where b.TIPO_DOC_AL =?1 AND b.NUM_DOC_AL =?2",nativeQuery = true)
	 public List<Materia> listarMateriasActivas();*/

}
