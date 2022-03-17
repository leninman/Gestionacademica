package com.virtualeduc.tuescuelavirtual.services;

import com.virtualeduc.tuescuelavirtual.models.DTOS.NotaParDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.Notawrapper;
import com.virtualeduc.tuescuelavirtual.models.NotaPar;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import java.util.List;

public interface INotasService {
	
	public Responses guardarNotasParciales(List<NotaParDTO> notas);
        
        public NotaParDTO guardarNotaParcial(NotaPar notaPar);
        
        public List<Notawrapper> consultarNotasPorCedula(String tipoDoc,String numDoc);
        
        
        
        
        

}
