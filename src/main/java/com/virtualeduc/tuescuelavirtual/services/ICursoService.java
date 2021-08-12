/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.services;


import com.virtualeduc.tuescuelavirtual.models.Curso;
import com.virtualeduc.tuescuelavirtual.models.Responses;
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
      
      public AnnioEscolarDTO consultarAnnioEscolar();
      
      public SeccionDTO consultarSeccionPorSeccion(String seccion);
      
      public TurnoDTO consultarTurnoPorTurno(String turno);
      
      public CursoDTO consultarCursoPorId(Long idcurso);
      
      public Responses  guardarCurso(CursoDTO curso,boolean guardarCurso);
      
      public Curso cursoporcurso(CursoDTO curso);
      
      public Responses eliminarCurso(Long idcurso);
      
      
      
      
      
      
      
}
