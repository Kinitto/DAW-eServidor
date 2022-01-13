package com.example.demo.service.impl;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioServiceI;

@Primary
@Service("UsuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioServiceI {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario findById(long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	@Override
	public Usuario findUser(Usuario usuario) {
		return usuarioRepository.findByNombreAndPassword(usuario.getNombre(), usuario.getPassword());
	}
	
	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@PostConstruct
	public void init() {
		usuarioRepository.saveAll(Arrays.asList(
				new Usuario(1, "Admin", "1234", "admin@gmail.com", "666666666", "secret"),
				new Usuario(2, "Maria", "1234", "maria.sanchez@dominio.es", "656111222", "Calle Pajarito N28"),
				new Usuario(3, "Juan", "1234", "juanito@dominio.es", "656434767", "Calle Rey N14")));
	}

}
