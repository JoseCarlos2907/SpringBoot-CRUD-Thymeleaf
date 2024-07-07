package com.app.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entity.Estudiante;
import com.app.web.repository.EstudianteRepository;

@Service
public class EstudianteImplService implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository; 

    @Override
    public List<Estudiante> listarTodosLosEstudiantes() {
        return this.estudianteRepository.findAll();
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return this.estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante obtenerEstudiantePorId(Long id) {
        return this.estudianteRepository.findById(id).get();
    }

    @Override
    public Estudiante actualizarEstudiante(Estudiante estudiante) {
        return this.estudianteRepository.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        this.estudianteRepository.deleteById(id);
    }

    


}
