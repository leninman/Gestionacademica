package com.virtualeduc.tuescuelavirtual.services;

import java.util.ArrayList;
import java.util.List;

import com.virtualeduc.tuescuelavirtual.models.CursoProf;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoProfDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualeduc.tuescuelavirtual.models.Profesor;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import com.virtualeduc.tuescuelavirtual.models.DTOS.ProfesorDTO;
import com.virtualeduc.tuescuelavirtual.repo.IProfesorRepo;
import com.virtualeduc.tuescuelavirtual.utils.Constantes;

@Service
public class IProfesoresServiceImpl implements IProfesoresService {

	@Autowired
	IProfesorRepo profesoresRepo;

	@Override
	public List<ProfesorDTO> consultarProfesores() {
		// TODO Auto-generated method stub
		List<ProfesorDTO> profesoresdto=new ArrayList<>();
		
		List<Profesor> profesores=new ArrayList<>();
		
		 profesores=profesoresRepo.findListProfesores();
		 
		 for(Profesor profesor:profesores) {
			 ProfesorDTO profesordto=new ProfesorDTO(profesor);
			 
			 profesoresdto.add(profesordto);
		 }
		 
		 return profesoresdto;
	}

	@Override
	public Responses guardarProfesor(ProfesorDTO profesorDTO, boolean guardar) {
		// TODO Auto-generated method stub

		Responses resp = new Responses();

		try {

			

			if (guardar) {
				
				Profesor profesor = new Profesor(profesorDTO);

				String tipoDocPrf = profesorDTO.getTipoDocPrf();

				String numDocPrf = profesorDTO.getNumDocPrf();

				Profesor profesorGuardado = profesoresRepo.consultarProfesorPorCedula(tipoDocPrf, numDocPrf);
				
				if (profesorGuardado == null) {
					profesorGuardado = profesoresRepo.save(profesor);
					ProfesorDTO profesorGuardadoDto = new ProfesorDTO(profesorGuardado);
					resp.setResponseCode(Constantes.PROFESOR_REGISTRADO_CODE);
					resp.setResponseDescription(Constantes.PROFESOR_REGISTRADO_DESC);
					resp.setProfesor(profesorGuardadoDto);
				} else {
					resp.setResponseCode(Constantes.PROFESOR_EXISTE_CODE);
					resp.setResponseDescription(Constantes.PROFESOR_EXISTE_DESC);
					resp.setProfesor(profesorDTO);
				}

			} else {
			
					Profesor profesorAguardar=new Profesor(profesorDTO);
					Profesor profesorGuardado=profesoresRepo.save(profesorAguardar);
					ProfesorDTO profesorGuardadodto=new ProfesorDTO(profesorGuardado);
					resp.setResponseCode(Constantes.PROFESOR_MODIFICADO_CODE);
					resp.setResponseDescription(Constantes.PROFESOR_MODIFICADO_DESC);
					resp.setProfesor(profesorGuardadodto);

				

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	@Override
	public Long[] consultarProfesoresPorIdCurso(Long idCurso) {
		Long[] cursosProfs = profesoresRepo.findIdProfesoresByIdCurso(idCurso);
		//List<CursoProfDTO> cursosProfsDTO = CursoProfDTO.cursosProfsDTO(cursosProfs);
		return cursosProfs;

	}

	@Override
	public Profesor consultarProfesorPorId(Long idProfesor) {
		// TODO Auto-generated method stub
		return profesoresRepo.findById(idProfesor).orElseThrow(null);
	}

	@Override
	public Profesor consultarProfesorPorCedula(String tipoDocPrf, String numDocPrf) {
		// TODO Auto-generated method stub
		return profesoresRepo.consultarProfesorPorCedula(tipoDocPrf, numDocPrf);
	}

}
