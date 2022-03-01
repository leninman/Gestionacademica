package com.virtualeduc.tuescuelavirtual.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.virtualeduc.tuescuelavirtual.models.Alumno;
import com.virtualeduc.tuescuelavirtual.models.Cursos_prof;

public interface ICursoProfRepo extends JpaRepository<Cursos_prof,Long> {
	
	@Query(value="Select * from cursos_prof a"
			+ " where a.ID_CURSO=?1 and a.ID_MAT=?2 and a.ID_PROF=?3",nativeQuery = true)
public Cursos_prof findCursoProf(Long idcurso,Long idmateria,Long idprofesor);


@Query(value="Select * from cursos_prof a"
			+ " where a.ID_PROF=?1",nativeQuery = true)
public List<Cursos_prof> findCursosPorProf(Long idprofesor);

}
