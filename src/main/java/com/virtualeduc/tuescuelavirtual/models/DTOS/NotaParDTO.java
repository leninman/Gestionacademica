package com.virtualeduc.tuescuelavirtual.models.DTOS;

import com.virtualeduc.tuescuelavirtual.models.Alumno;
import com.virtualeduc.tuescuelavirtual.models.Curso;
import com.virtualeduc.tuescuelavirtual.models.Lapso;
import com.virtualeduc.tuescuelavirtual.models.Materia;
import com.virtualeduc.tuescuelavirtual.models.NotaPar;
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

public class NotaParDTO implements Serializable {

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
    
    private Float porcentaje;

    @Autowired
    static IAlumnoRepo alumnoRepo;

    @Autowired
    static ICursoRepo cursoRepo;

    @Autowired
    static ILapsoRepo lapsoRepo;

    @Autowired
    static IMateriaRepo materiaRepo;

    @Autowired
    static IProfesorRepo profesorRepo;

    public NotaParDTO() {

    }

    public static NotaPar toNotaPar(NotaParDTO notaParDTO) {

        NotaPar notaPar = new NotaPar();

        notaPar.setIdAlumno(notaParDTO.getIdAlumno());

        notaPar.setIdCurso(notaParDTO.getIdCurso());

        notaPar.setIdMat(notaParDTO.getIdMat());

        notaPar.setIdPrf(notaParDTO.getIdPrf());

        notaPar.setIdLapso(notaParDTO.getIdLapso());

        notaPar.setNota(notaParDTO.getNota());

      return notaPar;

    }

    public static List<NotaPar> getListNotasPar(List<NotaParDTO> notasParDTO) {
        List<NotaPar> notasPar = new ArrayList<>();

        for (NotaParDTO notaparDTO : notasParDTO) {
            notasPar.add(NotaParDTO.toNotaPar(notaparDTO));
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
    
    
    public Float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Float porcentaje) {
        this.porcentaje = porcentaje;
    }
}
