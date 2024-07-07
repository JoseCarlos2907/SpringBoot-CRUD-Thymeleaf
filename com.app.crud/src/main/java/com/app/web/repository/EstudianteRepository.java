package com.app.web.repository;

import org.springframework.stereotype.Repository;

import com.app.web.entity.Estudiante;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{
    
}
