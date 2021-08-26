/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.services;

import com.virtualeduc.tuescuelavirtual.models.Annio;
import com.virtualeduc.tuescuelavirtual.models.AnnioEscolar;
import com.virtualeduc.tuescuelavirtual.models.Curso;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioEscolarDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.SeccionDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.TurnoDTO;
import com.virtualeduc.tuescuelavirtual.models.Seccion;
import com.virtualeduc.tuescuelavirtual.models.Turno;
import com.virtualeduc.tuescuelavirtual.repo.IAnnioEscolarRepo;
import com.virtualeduc.tuescuelavirtual.repo.IAnnioRepo;
import com.virtualeduc.tuescuelavirtual.repo.ICursoRepo;
import com.virtualeduc.tuescuelavirtual.repo.ISeccionRepo;
import com.virtualeduc.tuescuelavirtual.repo.ITurnoRepo;
import com.virtualeduc.tuescuelavirtual.utils.Constantes;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenin
 */
@Service
public class ICursoServiceImpl implements ICursoService {

	@Autowired
	IAnnioRepo anniorepo;

	@Autowired
	ISeccionRepo seccionrepo;

	@Autowired
	IAnnioEscolarRepo annioescolarrepo;

	@Autowired
	ITurnoRepo turnorepo;

	@Autowired
	ICursoRepo cursorepo;

	private CursoDTO cursoaguardar;

	private Curso cursoguardado;

	@Override
	public AnnioDTO consultarAnnioPorAnnioYnivel(String annio, String nivel) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

		Annio an = anniorepo.consultarAnnioByAnnioAndNivel(annio, nivel);

		AnnioDTO annioDTO = new AnnioDTO(an);

		return annioDTO;

	}

	@Override
	public AnnioEscolarDTO consultarAnnioEscolar() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		AnnioEscolar annioescolar = annioescolarrepo.consultarAnnioEscolarVigente();

		AnnioEscolarDTO annioescolarDTO = new AnnioEscolarDTO(annioescolar);

		return annioescolarDTO;

	}

	@Override
	public SeccionDTO consultarSeccionPorSeccion(String seccion) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

		Seccion sec = seccionrepo.consultarSeccionBySeccion(seccion);

		SeccionDTO seccionDTO = new SeccionDTO(sec);

		return seccionDTO;
	}

	@Override
	public List<AnnioDTO> consultarannios() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

		List<Annio> annios = anniorepo.findAll();

		List<AnnioDTO> anniosDTO = new ArrayList<AnnioDTO>();

		for (int i = 0; i < annios.size(); i++) {
			Annio annio = new Annio();

			annio = annios.get(i);

			AnnioDTO an = new AnnioDTO(annio);

			anniosDTO.add(an);
		}

		return anniosDTO;
	}

	@Override
	public List<AnnioEscolarDTO> consultaranniosesc() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

		List<AnnioEscolar> anniosescolares = annioescolarrepo.findAll();

		List<AnnioEscolarDTO> anniosescolaresDTO = new ArrayList<AnnioEscolarDTO>();

		for (int i = 0; i < anniosescolares.size(); i++) {
			AnnioEscolar annioescolar = new AnnioEscolar();

			annioescolar = anniosescolares.get(i);

			AnnioEscolarDTO anesc = new AnnioEscolarDTO(annioescolar);

			anniosescolaresDTO.add(anesc);
		}

		return anniosescolaresDTO;
	}

	@Override
	public List<SeccionDTO> consultarsecciones() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

		List<Seccion> secciones = seccionrepo.findAll();

		List<SeccionDTO> seccionDTO = new ArrayList<SeccionDTO>();

		for (int i = 0; i < secciones.size(); i++) {
			Seccion seccion = new Seccion();

			seccion = secciones.get(i);

			SeccionDTO sec = new SeccionDTO(seccion);

			seccionDTO.add(sec);
		}

		return seccionDTO;
	}

	@Override
	public List<CursoDTO> consultarcursos() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

		// Annio an = new Annio();

		// AnnioEscolar anesc = new AnnioEscolar();

		// Seccion sec = new Seccion();

		// Turno tur = new Turno();

		List<Curso> cursos = cursorepo.findAll();

		List<CursoDTO> cursosDTO = new ArrayList<CursoDTO>();

		for (int i = 0; i < cursos.size(); i++) {

			Curso curso = new Curso();

			curso = cursos.get(i);

			/*
			 * an = this.anniorepo.consultarAnnioByAnnio(curso.getIdAnnio().getAnnio());
			 * 
			 * anesc = this.annioescolarrepo.consultarAnnioEscolarVigente();
			 * 
			 * sec =
			 * this.seccionrepo.consultarSeccionBySeccion(curso.getIdSec().getSeccion());
			 * 
			 * tur = this.turnorepo.consultarTurnoByTurno(curso.getIdTurno().getTurno());
			 */

			CursoDTO cur = new CursoDTO(curso);

			cursosDTO.add(cur);

		}

		return cursosDTO;

	}

	@Override
	public CursoDTO consultarcursoporparametros(Long idannio, Long idannioesc, Long idseccion) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

		CursoDTO cursoDTO = null;

		// Annio an = new Annio();

		// AnnioEscolar anesc = new AnnioEscolar();

		// Seccion sec = new Seccion();

		// Turno tur = new Turno();

		Curso curso = cursorepo.consultarCursoByParametros(idannio, idannioesc, idseccion);

		if (curso != null) {

			/*
			 * an = this.anniorepo.consultarAnnioByAnnio(curso.getIdAnnio().getAnnio());
			 * 
			 * anesc = this.annioescolarrepo.consultarAnnioEscolarVigente();
			 * 
			 * sec =
			 * this.seccionrepo.consultarSeccionBySeccion(curso.getIdSec().getSeccion());
			 * 
			 * tur = this.turnorepo.consultarTurnoByTurno(curso.getIdTurno().getTurno());
			 */

			cursoDTO = new CursoDTO(curso);

		}
		return cursoDTO;
	}

	@Override
	public List<CursoDTO> consultarcursosporperiodo(Long idannioesc) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
//        CursoDTO curDTO = null;

//        Curso cur = new Curso();
		// Annio an = new Annio();

		// AnnioEscolar anesc = new AnnioEscolar();

		// Seccion sec = new Seccion();

		// Turno tur = new Turno();

		List<Curso> cur = new ArrayList<>();

		List<CursoDTO> curDTO = new ArrayList<>();

		cur = this.cursorepo.consultarCursosByPeriodo(idannioesc);

		if (cur != null) {
			for (int i = 0; i < cur.size(); i++) {

				Curso curso = new Curso();

				curso = cur.get(i);

				/*
				 * an = this.anniorepo.consultarAnnioByAnnio(curso.getIdAnnio().getAnnio());
				 * 
				 * anesc = this.annioescolarrepo.consultarAnnioEscolarVigente();
				 * 
				 * sec =
				 * this.seccionrepo.consultarSeccionBySeccion(curso.getIdSec().getSeccion());
				 * 
				 * tur = this.turnorepo.consultarTurnoByTurno(curso.getIdTurno().getTurno());
				 */

				CursoDTO curs = new CursoDTO(curso);

				curDTO.add(curs);

			}
		}

		return curDTO;
	}

	@Override
	public TurnoDTO consultarTurnoPorTurno(String turno) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

		Turno tur = this.turnorepo.consultarTurnoByTurno(turno);

		TurnoDTO turnoDTO = new TurnoDTO(tur);

		return turnoDTO;
	}

	@Override
	public CursoDTO consultarCursoPorId(Long idcurso) {
		// TODO Auto-generated method stub
		CursoDTO cursoDTO;
		cursoDTO = new CursoDTO(cursorepo.consultarCursoById(idcurso));
		return cursoDTO;
	}

	@Override
	public List<TurnoDTO> consultarturnos() {
		// TODO Auto-generated method stub
		List<TurnoDTO> turnosDTO = new ArrayList<>();
		List<Turno> turnos = new ArrayList();
		TurnoDTO turnoDTO;
		Turno turno;
		turnos = turnorepo.findAll();

		for (int i = 0; i < turnos.size(); i++) {
			turno = new Turno();
			turno = turnos.get(i);
			turnoDTO = new TurnoDTO(turno);
			turnosDTO.add(turnoDTO);
		}
		return turnosDTO;
	}

	@Override
	public Responses guardarCurso(CursoDTO curso, boolean guardarCurso) {
		// TODO Auto-generated method stub
		Responses resp = null;

		Annio annio = anniorepo.consultarAnnioByAnnioAndNivel(curso.getAnnio(), curso.getNivel());

		// Long idAnnio=annio.getIdAnnio();

		Seccion seccion = seccionrepo.consultarSeccionBySeccion(curso.getSeccion());

		// Long idSeccion=seccion.getIdSec();

		Turno turno = turnorepo.consultarTurnoByTurno(curso.getTurno());

		// Long idTurno=turno.getIdTurno();

		AnnioEscolar annioEscolar = annioescolarrepo.consultarAnnioEscolarVigente();

		// Long idAnnioescolar=annioEscolar.getIdAnnioEsc();

		Curso cursoaguardar = new Curso(annio, annioEscolar, seccion, turno);

		if (!guardarCurso) {
			cursoguardado = cursorepo.consultarCursoById(curso.getIdCurso());
			cursoaguardar.setIdCurso(cursoguardado.getIdCurso());
		}

		Curso cursoguardado = cursorepo.save(cursoaguardar);

		CursoDTO cursoguardadodto = new CursoDTO(cursoguardado);

		resp = new Responses();

		resp.setCurso(cursoguardadodto);

		if (guardarCurso) {
			resp.setResponseCode(Constantes.CURSO_REGISTRADO_CODE);

			resp.setResponseDescription(Constantes.CURSO_REGISTRADO_DESC);
		} else {
			resp.setResponseCode(Constantes.CURSO_MODIFICADO_CODE);

			resp.setResponseDescription(Constantes.CURSO_MODIFICADO_DESC);
		}

		/*
		 * cursoaguardardto.setIdAnnio(idAnnio);
		 * 
		 * cursoaguardardto.setIdSec(idSeccion);
		 * 
		 * cursoaguardardto.setIdAnnioEsc(idAnnioescolar);
		 * 
		 * cursoaguardardto.setIdTurno(idTurno);
		 * 
		 * cursoaguardardto.setAnnio(annio.getAnnio());
		 * 
		 * cursoaguardardto.setIntAnnioEsc(annioEscolar.getIntAnnioEsc());
		 * 
		 * cursoaguardardto.setSeccion(seccion.getSeccion());
		 * 
		 * cursoaguardardto.setTurno(turno.getTurno());
		 * 
		 * cursoaguardardto.setNivel(annio.getNivel());
		 * 
		 * cursoaguardardto.setEspecialidad(annio.getEspecialidad());
		 */

		return resp;

	}

	@Override
	public Curso cursoporcurso(CursoDTO curso) {
		// TODO Auto-generated method stub
		Annio annio = anniorepo.consultarAnnioByAnnioAndNivel(curso.getAnnio(), curso.getNivel());

		Seccion seccion = seccionrepo.consultarSeccionBySeccion(curso.getSeccion());

		Turno turno = turnorepo.consultarTurnoByTurno(curso.getTurno());

		AnnioEscolar annioescolar = annioescolarrepo.consultarAnnioEscolarVigente();

		Curso cursoconsultado = new Curso();

		cursoconsultado = cursorepo.consultarCursoPorParametros(annio.getIdAnnio(), annioescolar.getIdAnnioEsc(),
				seccion.getIdSec(), turno.getIdTurno());

		return cursoconsultado;
	}

	@Override
	public Responses eliminarCurso(Long idcurso) {
		// TODO Auto-generated method stub
		Responses resp = new Responses();

		cursorepo.deleteById(idcurso);

		resp.setResponseCode(Constantes.CURSO_ELIMINADO_CODE);
		resp.setResponseDescription(Constantes.CURSO_ELIMINADO_DESC);

		return resp;
	}

	@Override
	public List<AnnioEscolarDTO> consultarPeriodos() {
		// TODO Auto-generated method stub

		List<AnnioEscolarDTO> periodosDTO = new ArrayList<>();

		List<AnnioEscolar> periodos = new ArrayList<>();

		AnnioEscolarDTO annioescolar;

		periodos = annioescolarrepo.consultarPeriodosEscolares();

		for (int j = 0; j < periodos.size(); j++) {
			annioescolar = new AnnioEscolarDTO(periodos.get(j));
			periodosDTO.add(annioescolar);
		}

		return periodosDTO;
	}

	@Override
	public Responses guardarPeriodo(AnnioEscolarDTO annioescolarDTO, boolean guardarPeriodo) {
		// TODO Auto-generated method stub
		Responses resp = new Responses();

		if (guardarPeriodo) {
			
			DesactivarPeriodoVigente();

			AnnioEscolar annioEscolarAguardar = new AnnioEscolar(annioescolarDTO);
			
		
			AnnioEscolar annioEscolarGuardado=new AnnioEscolar();
			
			
			annioEscolarGuardado=this.annioescolarrepo.save(annioEscolarAguardar);
			

			resp.setAnnioescolar(new AnnioEscolarDTO(annioEscolarGuardado));
			
			resp.setResponseCode(Constantes.ANNIO_ESCOLAR_REGISTRADO_CODE);

			resp.setResponseDescription(Constantes.ANNIO_ESCOLAR_REGISTRADO_DESC);
		}

		return resp;
	}

	@Override
	public void DesactivarPeriodoVigente() {
		// TODO Auto-generated method stub

		// Consulta el periodo vigente
		Long IdPeriodoVigente;

		AnnioEscolarDTO periodovigente = new AnnioEscolarDTO(annioescolarrepo.consultarAnnioEscolarVigente());

		if (periodovigente != null) {

			IdPeriodoVigente = periodovigente.getIdAnnioEsc();

			periodovigente.setStatus("I");

			AnnioEscolar periodo = new AnnioEscolar(periodovigente);

			periodo.setIdAnnioEsc(IdPeriodoVigente);

			this.annioescolarrepo.save(periodo);
		}

	}

	@Override
	public Curso consultarCursoPorIdCurso(Long idCurso) {
		// TODO Auto-generated method stub
		return cursorepo.findById(idCurso).orElse(null);
	}

}
