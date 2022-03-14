package com.virtualeduc.tuescuelavirtual.models.DTOS;

import com.virtualeduc.tuescuelavirtual.models.Alumno;
import com.virtualeduc.tuescuelavirtual.models.Curso;
import com.virtualeduc.tuescuelavirtual.models.Lapso;
import com.virtualeduc.tuescuelavirtual.models.Materia;
import com.virtualeduc.tuescuelavirtual.models.NotasPar;
import com.virtualeduc.tuescuelavirtual.models.Profesor;
import com.virtualeduc.tuescuelavirtual.repo.IAlumnoRepo;
import com.virtualeduc.tuescuelavirtual.repo.ICursoRepo;
import com.virtualeduc.tuescuelavirtual.repo.ILapsoRepo;
import com.virtualeduc.tuescuelavirtual.repo.IMateriaRepo;
import com.virtualeduc.tuescuelavirtual.repo.IProfesorRepo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;

public class NotasParDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long idNotaPar;

    private Long idAlumno;

    private Long idCurso;

    private Long idLapso;

    private Long idMat;

    private Long idPrf;

    private String tipoDeCarga;

    private Float nota;

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
    
    
    

    public NotasParDTO() {

    }

    public static NotasPar toNotasPar(NotasParDTO notaParDTO) {

        NotasPar notaPar = new NotasPar();

     //  Alumno alumno = alumnoRepo.find

       // notaPar.setAlumno(alumno);

//        Curso curso = cursoRepo.findById(notaParDTO.getIdCurso()).orElse(null);

//        notaPar.setCurso(curso);

//        Lapso lapso = lapsoRepo.findById(notaParDTO.getIdLapso()).orElse(null);
        
//        notaPar.setLapso(lapso);
//
//        Materia materia =materiaRepo.findById(notaParDTO.getIdMat()).orElse(null);
//        
//        notaPar.setMateria(materia);
//        
//        Profesor profesor=profesorRepo.findById(notaParDTO.getIdPrf()).orElse(null);
//        
//        notaPar.setProfesor(profesor);
        
       
        return notaPar;

    }
    
   

    /*public NotasPar toNotasPar(NotasParDTO notasParDTO) {

        NotasPar notasPar = new NotasPar();

        notasPar.setIdAlumno(notasParDTO.getIdAlumno());

        notasPar.setIdCurso(notasParDTO.getIdCurso());

        notasPar.setIdLapso(notasParDTO.getIdLapso());

        notasPar.setIdMat(notasParDTO.getIdMat());

        notasPar.setIdPrf(notasParDTO.getIdPrf());

        return notasPar;
    }*/
//    public static NotasParDTO fromNotasPar(NotasPar notasPar) {
//
//        /*NotasParDTO notasParDTO = new NotasParDTO();
//        
//        notasParDTO.setIdAlumno(notasPar.getIdAlumno());
//
//        notasParDTO.setIdCurso(notasPar.getIdCurso());
//
//        notasParDTO.setIdLapso(notasPar.getIdLapso());
//
//        notasParDTO.setIdMat(notasPar.getIdMat());
//
//        notasParDTO.setIdPrf(notasPar.getIdPrf());
//        
//        return notasParDTO;*/
//        ModelMapper modelMapper = new ModelMapper();
//
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//
//        return modelMapper.map(notasPar, NotasParDTO.class);
//
//    }

//    public static NotasPar fromNotasParDTO(NotasParDTO notasParDTO) {
//
//        ModelMapper modelMapper = new ModelMapper();
//
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//
//        return modelMapper.map(notasParDTO, NotasPar.class);
//    }

//    public NotasPar toNotasPar() {
//
//        ModelMapper modelMapper = new ModelMapper();
//
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//
//        return modelMapper.map(this, NotasPar.class);
//    }

   

    public static List<NotasPar> getListNotasPar(List<NotasParDTO> notasParDTO) {
        //return notasParDTO.stream().map(NotasParDTO::fromNotasParDTO).collect(Collectors.toList());
        List<NotasPar> notasPar=new ArrayList<>();
        
        for(NotasParDTO nota:notasParDTO){
            NotasPar notaPar=nota.toNotasPar(nota);
            notasPar.add(notaPar);
        }
        
        
        return notasPar;
    }

    public Long getIdNotaPar() {
        return idNotaPar;
    }

    public void setIdNotaPar(Long idNotaPar) {
        this.idNotaPar = idNotaPar;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public Long getIdLapso() {
        return idLapso;
    }

    public void setIdLapso(Long idLapso) {
        this.idLapso = idLapso;
    }

    public Long getIdMat() {
        return idMat;
    }

    public void setIdMat(Long idMat) {
        this.idMat = idMat;
    }

    public Long getIdPrf() {
        return idPrf;
    }

    public void setIdPrf(Long idPrf) {
        this.idPrf = idPrf;
    }

    public String getTipoDeCarga() {
        return tipoDeCarga;
    }

    public void setTipoDeCarga(String tipoDeCarga) {
        this.tipoDeCarga = tipoDeCarga;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

}
