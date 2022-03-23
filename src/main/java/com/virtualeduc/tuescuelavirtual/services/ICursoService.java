/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.services;


import com.virtualeduc.tuescuelavirtual.models.AnnioEscolar;
import com.virtualeduc.tuescuelavirtual.models.Curso;
import com.virtualeduc.tuescuelavirtual.models.CursoProf;
import com.virtualeduc.tuescuelavirtual.models.MateriaProf;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import com.virtualeduc.tuescuelavirtual.models.ViewCursosMateriasAsignada;
import com.virtualeduc.tuescuelavirtual.models.ViewCursosMateriasSinAsignar;
import com.virtualeduc.tuescuelavirtual.models.ViewMateriasPorCurso;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioEscolarDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.SeccionDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.TurnoDTO;
import java.util.List;

/**
 *
 * @author Lenin
 */
public interface ICursoService {
    
    
      public List<AnnioDTO> consultarannios(); 
      
      public List<AnnioEscolarDTO> consultaranniosesc();
      
      public List<SeccionDTO> consultarsecciones();
      
      public List<TurnoDTO>  consultarturnos();
      
      public List<CursoDTO> consultarcursos();
      
      public CursoDTO consultarcursoporparametros(Long idannio,Long idannioesc,Long idseccion);
      
      public List<CursoDTO> consultarcursosporperiodo(Long idannioesc);
     
      public AnnioDTO consultarAnnioPorAnnioYnivel(String annio,String nivel);
      
      public AnnioDTO consultarAnnioPorAnnioYnivelYespecialidad(String annio,String nivel,String especialidad);
      
      public AnnioEscolarDTO consultarAnnioEscolar();
      
      public List<AnnioEscolarDTO> consultarPeriodos();
      
      public AnnioEscolarDTO consultarAnnioEscolarPorId(Long idAnnioEscolar);
      
      public AnnioEscolar obtenerAnnioEscolarPorId(Long idAnnioEscolar);
      
      public Responses eliminarPeriodo(Long idAnnioEsc);
      
      public SeccionDTO consultarSeccionPorSeccion(String seccion);
      
      public TurnoDTO consultarTurnoPorTurno(String turno);
      
      public CursoDTO consultarCursoPorId(Long idcurso);
      
      public Responses  guardarCurso(CursoDTO curso,boolean guardarCurso);
      
      public Curso cursoporcurso(CursoDTO curso);
      
      public Responses eliminarCurso(Long idcurso);
      
      public Responses  guardarPeriodo(AnnioEscolarDTO annioescolar,boolean guardarPeriodo);
      
      public void DesactivarPeriodoVigente();
      
      public Curso consultarCursoPorIdCurso(Long idCurso);
      
      public List<String> annios();
      
      public List<String> niveles();
      
      public List<String> especialidades();
      
      public List<ViewCursosMateriasAsignada> consultarMateriasAsignadas();
      
      public List<ViewCursosMateriasSinAsignar> consultarMateriasSinAsignar();
      
      public List<ViewMateriasPorCurso> consultarMateriaPorCurso();
      
      public List<CursoProf> consultarCursosPorProfesor(Long idProfesor);
      
      public Responses asignarCursosMaterias(List<CursoProf> cursosprof);
      
      public Responses asignarMaterias(List<MateriaProf> materiasprof);
      
      public Responses eliminarCursosMateria(Long idPrf,Long idCurso,Long idMat);
      
      public List<ViewCursosMateriasAsignada> consultarcursomateriaprofesor(Long idprofesor);
      
      
      
}
