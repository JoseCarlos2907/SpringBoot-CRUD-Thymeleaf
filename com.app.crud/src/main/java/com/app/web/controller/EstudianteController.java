package com.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entity.Estudiante;
import com.app.web.service.EstudianteService;


import org.springframework.ui.Model;

@Controller
public class EstudianteController {
    
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping({"/estudiantes", "/"})
    public String listarEstudiantes(Model modelo){
        modelo.addAttribute("estudiantes", estudianteService.listarTodosLosEstudiantes());
        return "estudiantes";
    }

    @GetMapping("/estudiantes/nuevo")
    public String mostrarFormularioRegistroEstudiante(Model model){
        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante", estudiante);
        return "crear_estudiante";
    }

    @PostMapping("/estudiantes")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante){
        estudianteService.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/editar/{id}")
    public String mostrarFormularioEditarEstudiante(@PathVariable Long id, Model modelo){
        modelo.addAttribute("estudiante", this.estudianteService.obtenerEstudiantePorId(id));
        return "editar_estudiante";
    }

    @PostMapping("/estudiantes/{id}")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante, @PathVariable Long id, Model modelo){
        Estudiante estudianteExistente = this.estudianteService.obtenerEstudiantePorId(id);

        estudianteExistente.setIdEstudiante(id);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEmail(estudiante.getEmail());

        estudianteService.actualizarEstudiante(estudiante);

        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/{id}")
    public String eliminarEstudiante(@PathVariable Long id, Model modelo){
        this.estudianteService.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
}
