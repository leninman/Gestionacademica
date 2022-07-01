/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models.DTOS;

/**
 *
 * @author Lenin
 */

import com.virtualeduc.tuescuelavirtual.models.Alumno;
import com.virtualeduc.tuescuelavirtual.models.CursoProf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenin
 */

public class CursoProfDTO implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long IdCursoProf;

    private Long idCurso;

    private Long idMat;

    private Long idProf;







    public CursoProfDTO() {
    }

    public CursoProfDTO(CursoProf cursoProf) {
        this.IdCursoProf = cursoProf.getIdCursoProf();
        this.idCurso = cursoProf.getIdCurso();
        this.idMat = cursoProf.getIdMat();
        this.idProf = cursoProf.getIdProf();


    }

    public static List<CursoProfDTO > cursosProfsDTO(List<CursoProf> cursosProf){
        List<CursoProfDTO> cursosProfsDTO=new ArrayList<>();
        for(CursoProf cursoProf:cursosProf){
            CursoProfDTO cursoProfDTO=new CursoProfDTO(cursoProf);
            cursosProfsDTO.add(cursoProfDTO);
        }
        return cursosProfsDTO;
    }



    public CursoProfDTO(Long idCursoProf, Long idCurso, Long idMat, Long idProf) {
        IdCursoProf = idCursoProf;
        this.idCurso = idCurso;
        this.idMat = idMat;
        this.idProf = idProf;
    }

    public Long getIdCursoProf() {
        return IdCursoProf;
    }

    public void setIdCursoProf(Long idCursoProf) {
        IdCursoProf = idCursoProf;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public Long getIdMat() {
        return idMat;
    }

    public void setIdMat(Long idMat) {
        this.idMat = idMat;
    }

    public Long getIdProf() {
        return idProf;
    }

    public void setIdProf(Long idProf) {
        this.idProf = idProf;
    }


}
