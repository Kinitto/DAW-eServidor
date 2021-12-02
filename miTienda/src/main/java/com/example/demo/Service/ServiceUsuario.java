package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.demo.Model.ModelUsuario;

@Service
public class ServiceUsuario {
	
	private List<ModelUsuario> listaUsuarios = new ArrayList<>();

	public List<ModelUsuario> findAll() {
		return listaUsuarios;
	}

	@PostConstruct
	public void init() {
		
		listaUsuarios.addAll(
				Arrays.asList(new ModelUsuario(1, "Admin","1234", "admin@gmail.com", "666666666","secret"),
						new ModelUsuario(2, "Maria","1234","maria.sanchez@dominio.es", "656111222","Calle Pajarito N28"),
						new ModelUsuario(3, "Juan","1234","juanito@dominio.es", "656434767","Calle Rey N14")
						)
				);
	}
}
