package com.virtualeduc.tuescuelavirtual.services;

import com.virtualeduc.tuescuelavirtual.models.Alumno;
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
import com.virtualeduc.tuescuelavirtual.repo.ICursoRepo;
import com.virtualeduc.tuescuelavirtual.repo.ILapsoRepo;
import com.virtualeduc.tuescuelavirtual.repo.IMateriaRepo;
import com.virtualeduc.tuescuelavirtual.repo.INotasParRepo;
import com.virtualeduc.tuescuelavirtual.repo.IProfesorRepo;
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
    
    @Override
    public Responses guardarNotasParciales(List<NotaParDTO> notasParDTO) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Responses response = new Responses();
        
        List<NotaParDTO> notasGuardadas = new ArrayList<>();

        //  List<NotasPar> notaspar=NotasParDTO.getListNotasPar(notasDTO);
        for (NotaParDTO notaParDTO : notasParDTO) {
            
            NotaParDTO notaGuardada = guardarNotaParcial(NotaParDTO.toNotaPar(notaParDTO));
            
            notasGuardadas.add(notaGuardada);

//            Alumno alumno = alumnoRepo.findById(notaParDTO.getIdAlumno()).orElse(null);
//
//            Curso curso = cursoRepo.findById(notaParDTO.getIdCurso()).orElse(null);
//
//            Lapso lapso = lapsoRepo.findById(notaParDTO.getIdLapso()).orElse(null);
//
//            Materia materia = materiaRepo.findById(notaParDTO.getIdMat()).orElse(null);
//
//            Profesor profesor = profesorRepo.findById(notaParDTO.getIdPrf()).orElse(null);
//
//            NotaPar nota = new NotaPar();
//            
//            nota.setAlumno(alumno);
//            
//            nota.setCurso(curso);
//            
//            nota.setLapso(lapso);
//            
//            nota.setMateria(materia);
//            
//            nota.setProfesor(profesor);
//            nota.setNota(notaParDTO.getNota());
        }
        
        response.setNotasParciales(notasGuardadas);
        return response;
        
    }
    
    @Override
    public NotaParDTO guardarNotaParcial(NotaPar notaPar) {
        
        NotaPar nota = notasRepo.save(notaPar);
        
        NotaParDTO notaParDto = NotaPar.toNotaParDTO(nota);
        
        return notaParDto;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Notawrapper> consultarNotasPorCedula(String tipoDoc, String numDoc) {
        
        List<NotaPar> notas = new ArrayList<>();
        
        List<Notawrapper> notaswrapper = new ArrayList<>();
        
        notas = notasRepo.consultarNotasPorAlumno(tipoDoc, numDoc);
        
        CursoDTO curso;
        
        MateriaDTO materia;
        
        Profesor profesor;
        
        Lapso lapso;
        
        Alumno alumno = alumnoservice.consultarAlumnoPorId(notas.get(0).getIdAlumno());
        
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
            
            notaswrapper.add(notawrapper);
            
        }
        
        return notaswrapper;
    }
    
}
