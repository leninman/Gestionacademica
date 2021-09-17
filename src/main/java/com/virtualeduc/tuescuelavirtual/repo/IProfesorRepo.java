package com.virtualeduc.tuescuelavirtual.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.virtualeduc.tuescuelavirtual.models.Profesor;

public interface IProfesorRepo extends JpaRepository<Profesor, Long>{
	
	@Query(value="SELECT * from profesores a "
            + "WHERE a.STATUS='A'",nativeQuery = true)
public List<Profesor> findListProfesores();
}
