package com.virtualeduc.tuescuelavirtual.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.virtualeduc.tuescuelavirtual.models.Profesor;

public interface IProfesorRepo extends JpaRepository<Profesor, Long>{
	
	@Query(value="SELECT * from profesores a "
            + "WHERE a.STATUS='ACTIVO'",nativeQuery = true)
public List<Profesor> findListProfesores();
	
	@Query(value="SELECT * from profesores a "
            + "WHERE a.TIPO_DOC_PRF=?1 and a.NUM_DOC_PRF=?2 and a.STATUS='ACTIVO'",nativeQuery = true)
public Profesor consultarProfesorPorCedula(String tipoDocPrf,String numDocPrf);
}
