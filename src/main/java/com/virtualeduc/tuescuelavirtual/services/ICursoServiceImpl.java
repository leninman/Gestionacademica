/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.services;

import com.virtualeduc.tuescuelavirtual.models.Annio;
import com.virtualeduc.tuescuelavirtual.models.AnnioEscolar;
import com.virtualeduc.tuescuelavirtual.models.Curso;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioEscolarDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.SeccionDTO;
import com.virtualeduc.tuescuelavirtual.models.Seccion;
import com.virtualeduc.tuescuelavirtual.repo.IAnnioEscolarRepo;
import com.virtualeduc.tuescuelavirtual.repo.IAnnioRepo;
import com.virtualeduc.tuescuelavirtual.repo.ICursoRepo;
import com.virtualeduc.tuescuelavirtual.repo.ISeccionRepo;
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
    ICursoRepo cursorepo;

    @Override
    public AnnioDTO consultarAnnioPorAnnio(String annio) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        Annio an = anniorepo.consultarAnnioByAnnio(annio);

        AnnioDTO annioDTO = new AnnioDTO(an);

        return annioDTO;

    }

    @Override
    public AnnioEscolarDTO consultarAnnioEscolarPorAnnioEscolar(String annioEscolar) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        AnnioEscolar annioescolar = annioescolarrepo.consultarAnnioEscolarByAnnio(annioEscolar);

        AnnioEscolarDTO annioescolarDTO = new AnnioEscolarDTO(annioescolar);

        return annioescolarDTO;

    }

    @Override
    public SeccionDTO consultarSeccionPorSeccion(Character seccion) {
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
        
        List<Curso> cursos = cursorepo.findAll();
        
        
        List<CursoDTO> cursosDTO = new ArrayList<CursoDTO>();


        for (int i = 0; i < cursos.size(); i++) {

            Curso curso = new Curso();

            curso = cursos.get(i);

            CursoDTO cur = new CursoDTO(curso);

            cursosDTO.add(cur);

        }

        return cursosDTO;

    }

    @Override
    public CursoDTO consultarcursoporparametros(Long idannio, Long idannioesc, Long idseccion) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        Curso curso = cursorepo.consultarCursoByParametros(idannio, idannioesc, idseccion);

        CursoDTO cursoDTO = new CursoDTO(curso);

        return cursoDTO;
    }

}
