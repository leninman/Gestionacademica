package com.virtualeduc.tuescuelavirtual.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.virtualeduc.tuescuelavirtual.models.Materia;

public interface IMateriaRepo extends JpaRepository<Materia,Long> {
	
	@Query(value="Select a.ID_MAT,a.CODIGO_MAT,a.NOMBRE_MAT,a.DESCRIPCION_MAT,a.ID_ANNIO,a.STATUS "
	 		+ "from materias a "
	 		+ "where a.STATUS='A'",nativeQuery = true)
	 public List<Materia> listarMateriasActivas();
	
	
	
	@Query(value="Select a.ID_MAT,a.CODIGO_MAT,a.NOMBRE_MAT,a.DESCRIPCION_MAT,a.ID_ANNIO "
	 		+ "from materias a "
	 		+ "where a.CODIGO_MAT=?1",nativeQuery = true)
	 public Materia buscarMateriaPorCodigo(String codigoMateria);
	
	
	@Query(value="Select distinct(a.NOMBRE_MAT) "
	 		+ "from materias a",nativeQuery = true)
	 public List<String> nombresMaterias();
	
	
	@Query(value="SELECT a.ID_MAT "
			+ "FROM materias a INNER JOIN annios b "
	 		+ "ON a.ID_ANNIO=b.ID_ANNIO "
	 		+ "WHERE a.NOMBRE_MAT=?1 "
	 		+ "and b.ANNIO=?2 "
	 		+ "and b.NIVEL=?3 "
	 		+ "and b.ESPECIALIDAD=?4",nativeQuery = true)
	 public Long consultarIdMaterias(String materia,String annio,String nivel,String especialidad);
}
