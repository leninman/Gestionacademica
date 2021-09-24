package com.virtualeduc.tuescuelavirtual.services;

import java.util.List;

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
	public List<Profesor> consultarProfesores() {
		// TODO Auto-generated method stub
		return profesoresRepo.findListProfesores();
	}

	@Override
	public Responses guardarProfesor(ProfesorDTO profesorDTO, boolean guardar) {
		// TODO Auto-generated method stub

		Responses resp = new Responses();

		try {

			Profesor profesor = new Profesor(profesorDTO);

			String tipoDocPrf = profesorDTO.getTipoDocPrf();

			String numDocPrf = profesorDTO.getNumDocPrf();

			Profesor profesorGuardado = profesoresRepo.consultarProfesorPorCedula(tipoDocPrf, numDocPrf);

			if (guardar) {
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
				if (profesorGuardado != null) {
					Profesor profesorAguardar=new Profesor(profesorDTO);
					Long id = profesorGuardado.getIdPrf();
					profesorAguardar.setIdPrf(id);
					profesorGuardado=profesoresRepo.save(profesorAguardar);
					ProfesorDTO profesorGuardadodTO=new ProfesorDTO(profesorGuardado);
					resp.setResponseCode(Constantes.PROFESOR_MODIFICADO_CODE);
					resp.setResponseDescription(Constantes.PROFESOR_MODIFICADO_DESC);
					resp.setProfesor(profesorGuardadodTO);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
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
