package com.virtualeduc.tuescuelavirtual.services;

import com.virtualeduc.tuescuelavirtual.models.Alumno;
import com.virtualeduc.tuescuelavirtual.models.Curso;
import com.virtualeduc.tuescuelavirtual.models.DTOS.NotasParDTO;
import com.virtualeduc.tuescuelavirtual.models.Lapso;
import com.virtualeduc.tuescuelavirtual.models.Materia;
import com.virtualeduc.tuescuelavirtual.models.NotasPar;
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

    @Override
    public Responses guardarNotasParciales(List<NotasParDTO> notasParDTO) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Responses response = new Responses();

        List<NotasParDTO> notasGuardadas = new ArrayList<>();

        //  List<NotasPar> notaspar=NotasParDTO.getListNotasPar(notasDTO);
        for (NotasParDTO notaParDTO : notasParDTO) {

            Alumno alumno = alumnoRepo.findById(notaParDTO.getIdAlumno()).orElse(null);

            Curso curso = cursoRepo.findById(notaParDTO.getIdCurso()).orElse(null);

            Lapso lapso = lapsoRepo.findById(notaParDTO.getIdLapso()).orElse(null);

            Materia materia = materiaRepo.findById(notaParDTO.getIdMat()).orElse(null);

            Profesor profesor = profesorRepo.findById(notaParDTO.getIdPrf()).orElse(null);

            NotasPar nota = new NotasPar();
            
            nota.setAlumno(alumno);
            
            nota.setCurso(curso);
            
            nota.setLapso(lapso);
            
            nota.setMateria(materia);
            
            nota.setProfesor(profesor);
            
            nota.setNota(notaParDTO.getNota());
            
            

            NotasParDTO notaGuardada = guardarNotaParcial(nota);

             notasGuardadas.add(notaGuardada);
        }

         response.setNotasParciales(notasGuardadas);
        return response;

    }

    @Override
    public NotasParDTO guardarNotaParcial(NotasPar notaPar) {
      
        NotasPar nota = notasRepo.save(notaPar);

        NotasParDTO notaParDto = NotasPar.toNotasParDTO(nota);

        return notaParDto;
    }

}
