package com.virtualeduc.tuescuelavirtual.repo;

import com.virtualeduc.tuescuelavirtual.models.NotaPar;
import com.virtualeduc.tuescuelavirtual.models.Numerosdelista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface INumerodelistaRepo extends JpaRepository<Numerosdelista,Long> {

    @Query(value="SELECT "
            + "a.ID_CURSO,a.ID_ALUMNO,a.NROLISTA "
            + "from numerosdelista a "
            + "WHERE a.ID_ALUMNO=?1 AND a.ID_CURSO=?2"
            ,nativeQuery = true)
    public Numerosdelista consultarNumeroListaAlumno(Long idAlumno,Long idCurso);


    @Query(value="SELECT "
            + "MAX(NROLISTA) "
            + "from numerosdelista a "
            + "WHERE a.ID_CURSO=?1"
            ,nativeQuery = true)
    public Long consultarNumeroListaMayor(Long idCurso);



}
