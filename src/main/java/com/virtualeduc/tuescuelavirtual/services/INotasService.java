package com.virtualeduc.tuescuelavirtual.services;

import com.virtualeduc.tuescuelavirtual.models.DTOS.NotasParDTO;
import com.virtualeduc.tuescuelavirtual.models.NotasPar;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import java.util.List;

public interface INotasService {
	
	public Responses guardarNotasParciales(List<NotasParDTO> notas);
        
        public NotasParDTO guardarNotaParcial(NotasPar notaPar);

}
