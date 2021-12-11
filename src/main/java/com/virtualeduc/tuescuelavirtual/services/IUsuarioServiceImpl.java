package com.virtualeduc.tuescuelavirtual.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualeduc.tuescuelavirtual.models.Alumno;
import com.virtualeduc.tuescuelavirtual.models.Profesor;
import com.virtualeduc.tuescuelavirtual.models.Representante;
import com.virtualeduc.tuescuelavirtual.models.Usuario;
import com.virtualeduc.tuescuelavirtual.models.DTOS.PersonaDTO;
import com.virtualeduc.tuescuelavirtual.repo.IAlumnoRepo;
import com.virtualeduc.tuescuelavirtual.repo.IProfesorRepo;
import com.virtualeduc.tuescuelavirtual.repo.IRepresentanteRepo;

@Service
public class IUsuarioServiceImpl implements IUsuarioService {

	@Autowired
	IAlumnoRepo alumnoRepo;

	@Autowired
	IProfesorRepo profesorRepo;

	@Autowired
	IRepresentanteRepo representanteRepo;

	@Override
	public Usuario findUsuarioByCedulaAndTipoUsuario(String tipodoc, String numdoc, String tipousuario) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public PersonaDTO findPersonaByCedulaAndTipoUsuario(String tipodoc, String numdoc, String tipoUsuario) {
		// TODO Auto-generated method stub
		PersonaDTO persona = new PersonaDTO();

		try {

			switch (tipoUsuario) {

			case "Alumno":

				Alumno alumno = alumnoRepo.findAlumnoByTipoDocAlAndNumDocAl(tipodoc, numdoc);

				if (alumno != null) {
					persona.setTipoDocumento(alumno.getTipoDocAl());
					persona.setNumeroDocumento(alumno.getNumDocAl());
					persona.setPrimerNombre(alumno.getPrimNombAl());
					persona.setSegundoNombre(alumno.getSegNombAl());
					persona.setPrimerApellido(alumno.getPrimApellAl());
					persona.setSegundoApellido(alumno.getSegApellAl());
					
				}

				break;

			case "Profesor":

				Profesor profesor = profesorRepo.consultarProfesorPorCedula(tipodoc, numdoc);

				if (profesor != null) {
					persona.setTipoDocumento(profesor.getTipoDocPrf());
					persona.setNumeroDocumento(profesor.getNumDocPrf());
					persona.setPrimerNombre(profesor.getPrimNombPrf());
					persona.setSegundoNombre(profesor.getSegNombPrf());
					persona.setPrimerApellido(profesor.getPrimApellPrf());
					persona.setSegundoApellido(profesor.getSegApellPrf());
					
				}

				break;

			case "Representante":
				
				Representante representante=representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(tipodoc,numdoc);
				
				if (representante != null) {
					persona.setTipoDocumento(representante.getTipoDocRpr());
					persona.setNumeroDocumento(representante.getNumDocRpr());
					persona.setPrimerNombre(representante.getPrimNombRpr());
					persona.setSegundoNombre(representante.getSegNombRpr());
					persona.setPrimerApellido(representante.getPrimApellRpr());
					persona.setSegundoApellido(representante.getSegApellRpr());
					
				}


				break;

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return persona;
	}

}
