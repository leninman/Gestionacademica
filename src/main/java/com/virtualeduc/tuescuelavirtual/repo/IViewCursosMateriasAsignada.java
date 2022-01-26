package com.virtualeduc.tuescuelavirtual.repo;

import com.virtualeduc.tuescuelavirtual.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualeduc.tuescuelavirtual.models.ViewCursosMateriasAsignada;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface IViewCursosMateriasAsignada extends JpaRepository<ViewCursosMateriasAsignada,String> {
    
     @Query(value="SELECT * FROM view_cursos_materias_asignadas a"
            + " where a.id_prf=?1",nativeQuery = true)
    public List<ViewCursosMateriasAsignada> consultarMateriasPorCursoProfesor(Long idprofesor);

}
