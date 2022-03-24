package com.virtualeduc.tuescuelavirtual.services;

import com.virtualeduc.tuescuelavirtual.models.Alumno;
import com.virtualeduc.tuescuelavirtual.models.AnnioEscolar;
import com.virtualeduc.tuescuelavirtual.models.Curso;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.MateriaDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.NotaParDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.Notawrapper;
import com.virtualeduc.tuescuelavirtual.models.Lapso;
import com.virtualeduc.tuescuelavirtual.models.Materia;
import com.virtualeduc.tuescuelavirtual.models.NotaPar;
import com.virtualeduc.tuescuelavirtual.models.Profesor;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import com.virtualeduc.tuescuelavirtual.repo.IAlumnoRepo;
import com.virtualeduc.tuescuelavirtual.repo.IAnnioEscolarRepo;
import com.virtualeduc.tuescuelavirtual.repo.ICursoRepo;
import com.virtualeduc.tuescuelavirtual.repo.ILapsoRepo;
import com.virtualeduc.tuescuelavirtual.repo.IMateriaRepo;
import com.virtualeduc.tuescuelavirtual.repo.INotasParRepo;
import com.virtualeduc.tuescuelavirtual.repo.IProfesorRepo;
import com.virtualeduc.tuescuelavirtual.utils.Constantes;
import com.virtualeduc.tuescuelavirtual.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class INotasServiceImpl implements INotasService {
    
    @Autowired
    INotasParRepo notasRepo;
    
    @Autowired
    IAlumnoRepo alumnoRepo;
    
    @Autowired
     ICursoRepo cursoRepo;
    
    @Autowired
     ILapsoRepo lapsoRepo;
    
    @Autowired
     IMateriaRepo materiaRepo;
    
    @Autowired
     IProfesorRepo profesorRepo;
    
    @Autowired
     IAlumnoService alumnoservice;
    
    @Autowired
     ICursoService cursoservice;
    
    @Autowired
     IMateriaService materiaservice;
    
    @Autowired
     IProfesoresService profesoresservice;
    
    @Autowired
     ILapsoRepo lapsorepo;
    
     @Autowired
     IAnnioEscolarRepo annioescolarRepo;
     
    static CursoDTO curso;
        
    static   MateriaDTO materia;
        
    static   Profesor profesor;
        
    static   Lapso lapso;
        
    static   AnnioEscolar periodoescolar;
     
    static Alumno alumno;
    
    @Override
    public Responses guardarNotasParciales(List<NotaParDTO> notasParDTO) {
      
        Responses response = new Responses();
        
        List<NotaParDTO> notasGuardadas = new ArrayList<>();

 
        for (NotaParDTO notaParDTO : notasParDTO) {
            
            
            
            NotaParDTO notaGuardada = guardarNotaParcial(NotaParDTO.toNotaPar(notaParDTO));
            
            notasGuardadas.add(notaGuardada);

        }
        
        response.setNotasParciales(notasGuardadas);
        
        response.setResponseCode(Constantes.NOTAS_REGISTRADAS);
        
        response.setResponseDescription(Constantes.NOTAS_REGISTRADAS_DESC);
        
        return response;
        
    }
    
    @Override
    public NotaParDTO guardarNotaParcial(NotaPar notaPar) {
        
        lapso = lapsorepo.getById(notaPar.getIdLapso());
        
        Float rate=lapso.getPorcentaje();
        
        Float porcentaje=Utils.calcularPorcentajeNota(notaPar.getNota(), rate);
        
        notaPar.setPorcentaje(porcentaje);
        
        NotaPar nota = notasRepo.save(notaPar);
        
        NotaParDTO notaParDto = NotaPar.toNotaParDTO(nota);
        
        return notaParDto;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Notawrapper> consultarNotasPorCedula(String tipoDoc, String numDoc) {
        
        List<NotaPar> notas = new ArrayList<>();
        
        notas = notasRepo.consultarNotasPorAlumno(tipoDoc, numDoc);
        
        List<Notawrapper> notaswrapper = new ArrayList<>();
        
        notaswrapper=obtenerNotas(notas);
        
        return notaswrapper;
       
    }

    @Override
    public List<AnnioEscolar> consultarPeriodos() {
        
        List<AnnioEscolar> anniosescolares=new ArrayList<>();
        
        anniosescolares=annioescolarRepo.consultarPeriodosEscolares();
        
        return anniosescolares;
    }

    @Override
    public List<Lapso> consultarLapsos() {
       return lapsorepo.findAll();
    }

    @Override
    public List<Notawrapper> consultarNotasPorCedulaYperiodo(String tipoDoc, String numDoc, String periodo) {
        
        List<NotaPar> notas = new ArrayList<>();
        
        notas = notasRepo.consultarNotasPorAlumnoPeriodo(tipoDoc, numDoc, periodo);
        
        List<Notawrapper> notaswrapper = new ArrayList<>();
        
        notaswrapper=obtenerNotas(notas);
        
        return notaswrapper;
    }

    @Override
    public List<Notawrapper> consultarNotasPorCedulaPeriodoYlapso(String tipoDoc, String numDoc, String periodo, String lapso) {
       
         List<NotaPar> notas = new ArrayList<>();
        
        notas = notasRepo.consultarNotasPorAlumnoPeriodoLapso(tipoDoc, numDoc, periodo, lapso);
        
        List<Notawrapper> notaswrapper = new ArrayList<>();
        
        if(!notas.isEmpty()){
             notaswrapper=obtenerNotas(notas);
        }
        
       
        
        return notaswrapper;
        
    }
    
    public  List<Notawrapper> obtenerNotas(List<NotaPar> notas){
    
        List<Notawrapper> notaswrapper = new ArrayList<>();
        
        alumno = alumnoservice.consultarAlumnoPorId(notas.get(0).getIdAlumno());
        
        for (NotaPar notaPar : notas) {
            
            Notawrapper notawrapper = new Notawrapper();
            
            notawrapper.setIdAl(alumno.getIdAl());
            
            notawrapper.setTipoDocAl(alumno.getTipoDocAl());
            
            notawrapper.setNumDocAl(alumno.getNumDocAl());
            
            notawrapper.setPrimNombAl(alumno.getPrimNombAl());
            
            notawrapper.setPrimApellAl(alumno.getPrimApellAl());
            
            notawrapper.setSegNombAl(alumno.getSegNombAl());
            
            notawrapper.setSegApellAl(alumno.getSegApellAl());
            
            curso = cursoservice.consultarCursoPorId(notaPar.getIdCurso());
            
            periodoescolar=cursoservice.obtenerAnnioEscolarPorId(curso.getIdAnnio());
            
            notawrapper.setIdCurso(curso.getIdCurso());
            
            notawrapper.setAnnio(curso.getAnnio());
            
            notawrapper.setSeccion(curso.getSeccion());
            
            notawrapper.setIntAnnioEsc(curso.getIntAnnioEsc());
            
            notawrapper.setTurno(curso.getTurno());
            
            notawrapper.setNivel(curso.getNivel());
            
            notawrapper.setEspecialidad(curso.getEspecialidad());
            
            materia = materiaservice.consultarMateriaPorId(notaPar.getIdMat());
            
            notawrapper.setIdMateria(materia.getIdMat());
            
            notawrapper.setCodigoMat(materia.getCodigoMat());
            
            notawrapper.setNombreMat(materia.getNombreMat());
            
            profesor = profesoresservice.consultarProfesorPorId(notaPar.getIdPrf());
            
            notawrapper.setIdPrf(profesor.getIdPrf());
            
             notawrapper.setTipoDocPrf(profesor.getTipoDocPrf());
             
             notawrapper.setNumDocPrf(profesor.getNumDocPrf());
             
            
            notawrapper.setPrimNombPrf(profesor.getPrimNombPrf());
            
            notawrapper.setSegNombPrf(profesor.getSegNombPrf());
            
            notawrapper.setPrimApellPrf(profesor.getPrimApellPrf());
            
            notawrapper.setSegApellPrf(profesor.getSegApellPrf());
            
            lapso = lapsorepo.getById(notaPar.getIdLapso());
            
            notawrapper.setPeriodo(lapso.getPeriodo());
            
            notawrapper.setIdLapso(lapso.getIdLapso());
            
            notawrapper.setLapsodescripcion(lapso.getDescripcion());
            
            notawrapper.setNota(notaPar.getNota());
            
            notawrapper.setPorcentaje(notaPar.getPorcentaje());
            
            notaswrapper.add(notawrapper);
            
        }
        
        return notaswrapper;
    
    }

    @Override
    public List<Lapso> consultarLapsosHabilitados(Long idMat,Long idCurso) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          return lapsorepo.consultarLapsosDisponibles(idMat, idCurso);
    }
    
  
}


