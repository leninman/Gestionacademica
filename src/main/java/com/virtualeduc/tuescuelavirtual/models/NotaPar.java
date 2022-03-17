package com.virtualeduc.tuescuelavirtual.models;

import com.virtualeduc.tuescuelavirtual.models.DTOS.NotaParDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the notas_par database table.
 *
 */
@Entity
@Table(name = "notas_par")
public class NotaPar implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_NOTA_PAR")
    private Long idNotaPar;

    @Column(name = "ID_ALUMNO")
    private Long idAlumno;
//    @JoinColumn(name = "ID_ALUMNO", referencedColumnName = "ID_AL")
//    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Alumno alumno;

    @Column(name = "ID_CURSO")
    private Long idCurso;
//    @JoinColumn(name = "ID_CURSO", referencedColumnName = "ID_CURSO")
//    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Curso curso;

    @Column(name = "ID_LAPSO")
    private Long idLapso;
//    @JoinColumn(name = "ID_LAPSO", referencedColumnName = "ID_LAPSO")
//    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Lapso lapso;

    @Column(name = "ID_MAT")
    private Long idMat;
//    @JoinColumn(name = "ID_MAT", referencedColumnName = "ID_MAT")
//    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Materia materia;

    @Column(name = "ID_PRF")
    private Long idPrf;
//     @JoinColumn(name = "ID_PRF", referencedColumnName = "ID_PRF")
//    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Profesor profesor;

    private Float nota;

    public NotaPar() {
    }

    public static NotaParDTO toNotaParDTO(NotaPar notaPar) {

        NotaParDTO notaParDTO = new NotaParDTO();

        notaParDTO.setIdAlumno(notaPar.getIdAlumno());

        notaParDTO.setIdCurso(notaPar.getIdCurso());

        notaParDTO.setIdLapso(notaPar.getIdLapso());

        notaParDTO.setIdMat(notaPar.getIdMat());

        notaParDTO.setIdPrf(notaPar.getIdPrf());

        notaParDTO.setIdNotaPar(notaPar.getIdNotaPar());

        return notaParDTO;

    }

    public List<NotaParDTO> getListNotasParDTO(List<NotaPar> notasPar) {

        List<NotaParDTO> notasPardto = new ArrayList<>();

        for (NotaPar notapar : notasPar) {
            notasPardto.add(NotaPar.toNotaParDTO(notapar));
        }

        return notasPardto;

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

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /* public Long getIdAlumno() {
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
    }*/
}
