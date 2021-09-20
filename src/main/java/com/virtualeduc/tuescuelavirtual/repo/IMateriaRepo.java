package com.virtualeduc.tuescuelavirtual.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.virtualeduc.tuescuelavirtual.models.Materia;

public interface IMateriaRepo extends JpaRepository<Materia,Long> {
	
	@Query(value="Select a.ID_MAT,a.CODIGO_MAT,a.NOMBRE_MAT,a.DESCRIPCION_MAT,a.ID_ANNIO,a.STATUS "
	 		+ "from Materias a "
	 		+ "where a.STATUS='A'",nativeQuery = true)
	 public List<Materia> listarMateriasActivas();
	
	
	
	@Query(value="Select a.ID_MAT,a.CODIGO_MAT,a.NOMBRE_MAT,a.DESCRIPCION_MAT,a.ID_ANNIO "
	 		+ "from Materias a "
	 		+ "where a.CODIGO_MAT=?1",nativeQuery = true)
	 public Materia buscarMateriaPorCodigo(String codigoMateria);
	
	
	@Query(value="Select distinct(a.NOMBRE_MAT) "
	 		+ "from Materias a",nativeQuery = true)
	 public List<String> nombresMaterias();
}
