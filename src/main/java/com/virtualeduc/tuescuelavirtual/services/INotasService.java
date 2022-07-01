package com.virtualeduc.tuescuelavirtual.services;

import com.virtualeduc.tuescuelavirtual.models.AnnioEscolar;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.NotaParDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.Notawrapper;
import com.virtualeduc.tuescuelavirtual.models.DTOS.Notawrapperporlapso;
import com.virtualeduc.tuescuelavirtual.models.Lapso;
import com.virtualeduc.tuescuelavirtual.models.NotaPar;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import java.util.List;

public interface INotasService {
	
	public Responses guardarNotasParciales(List<NotaParDTO> notas);

    public Responses actualizarNotasParciales(Long idAlumno,Long idMateria,Long idCurso,Float notaLapso1,Float notaLapso2,Float notaLapso3);
        
        public NotaParDTO guardarNotaParcial(NotaPar notaPar);
        
        public List<Notawrapper> consultarNotasPorCedula(String tipoDoc,String numDoc);
        
        public List<Notawrapper> consultarNotasPorCedulaYperiodo(String tipoDoc,String numDoc,String periodo);
        
        public List<Notawrapper> consultarNotasPorCedulaPeriodoYlapso(String tipoDoc,String numDoc,String periodo,String lapso);
        
        public List<AnnioEscolar>  consultarPeriodos();
        
        public List<Lapso>  consultarLapsos();
        
        public List<Lapso>  consultarLapsosHabilitados(Long idMat,Long idCurso);
        
        public List<Notawrapperporlapso> consultarNotasPorCursoMateria(List<AlumnoDTO> alumnos,Long idMat,Long idCurso);


        public Long[] consultarNotasPorIdCurso(Long idCurso);

        

}
