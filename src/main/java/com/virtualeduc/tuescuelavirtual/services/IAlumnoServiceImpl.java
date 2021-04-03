/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.services;

import com.virtualeduc.tuescuelavirtual.models.Alumno;

import com.virtualeduc.tuescuelavirtual.models.Representante;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoCursoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;
import com.virtualeduc.tuescuelavirtual.repo.IAlumnoRepo;
import com.virtualeduc.tuescuelavirtual.utils.Constantes;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Personal
 */
@Service
public class IAlumnoServiceImpl implements IAlumnoService {

    @Autowired
    IAlumnoRepo alumnorepo;

    @Autowired
    IRepresentanteService representanteservice;
    
    @Autowired
    ICursoService cursoservice;

    Alumno alumno;
    
    AlumnoDTO alumnoDTO;

    @Override
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public Responses guardaAlumno(Alumno alumno) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String tipoDocAl = alumno.getTipoDocAl();
        String numDocAl = alumno.getNumDocAl();
        Responses resp = new Responses();

        //CONSULTA SI EL ALUMNO YA EXISTE, SI EXISTE RETORNA EL ALUMNO, SI NO LO GUARDA
        this.alumno = consultarAlumnoPorCedula(tipoDocAl, numDocAl);
        if (this.alumno == null) {
           
            this.alumno = alumnorepo.save(alumno);
            if (this.alumno != null) {
                resp.setResponseCode(Constantes.ALUMNO_REGISTRADO_CODE);
                resp.setResponseDescription(Constantes.ALUMNO_REGISTRADO_DESC);
               // alumnoDTO=new AlumnoDTO(this.alumno);
//                resp.setAlumno(this.alumnoDTO);
            }

        } else {

            resp.setResponseCode(Constantes.ALUMNO_EXISTE_CODE);
            resp.setResponseDescription(Constantes.ALUMNO_EXISTE_DESC);
            alumno.setIdAl(this.alumno.getIdAl());

        }

        return resp;
    }

    /**
     *
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<AlumnoCursoDTO> consultarAlumnos() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        List<Alumno> alumnos = alumnorepo.findListAlumnos();

        List<AlumnoCursoDTO> alumnosCursoDTO = new ArrayList<AlumnoCursoDTO>();

        for (int i = 0; i < alumnos.size(); i++) {

            Alumno al = new Alumno();

            al = alumnos.get(i);

            AlumnoCursoDTO al1 = new AlumnoCursoDTO(al);

            alumnosCursoDTO.add(al1);

        }

        return alumnosCursoDTO;

    }

    @Override
    @Transactional(readOnly = true)
    public Alumno consultarAlumnoPorId(Long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return alumnorepo.findById(id).orElse(null);
    }

    @Override
    public Alumno consultarAlumnoPorCedula(String tipoDoc, String numDoc) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return alumnorepo.findAlumnoByTipoDocAlAndNumDocAl(tipoDoc, numDoc);
    }

    @Override
    public List<AlumnoDTO> consultarTodosLosAlumnos() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          List<AlumnoDTO> alumnosDTO=new ArrayList<AlumnoDTO>();
          
          List<Alumno> alumnos=alumnorepo.findAll();
          
           for (int i = 0; i < alumnos.size(); i++) {

            Alumno al = new Alumno();

            al = alumnos.get(i);

            AlumnoDTO al1 = new AlumnoDTO(al);

            alumnosDTO.add(al1);

        }
          
          
          return alumnosDTO;
    }

}
