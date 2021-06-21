/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.services;


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
      
      public List<CursoDTO> consultarcursos();
      
      public CursoDTO consultarcursoporparametros(Long idannio,Long idannioesc,Long idseccion);
      
       public List<CursoDTO> consultarcursosporperiodo(Long idannioesc);
     
      public AnnioDTO consultarAnnioPorAnnio(String annio);
      
      public AnnioEscolarDTO consultarAnnioEscolarPorAnnioEscolar();
      
      public SeccionDTO consultarSeccionPorSeccion(String seccion);
      
      public TurnoDTO consultarTurnoPorTurno(String turno);
      
      
      
}
