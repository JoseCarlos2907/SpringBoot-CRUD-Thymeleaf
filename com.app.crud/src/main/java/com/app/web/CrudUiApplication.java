package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.web.entity.Estudiante;
import com.app.web.repository.EstudianteRepository;

@SpringBootApplication
public class CrudUiApplication implements CommandLineRunner{

	@Autowired
	private EstudianteRepository estudianteRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudUiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
