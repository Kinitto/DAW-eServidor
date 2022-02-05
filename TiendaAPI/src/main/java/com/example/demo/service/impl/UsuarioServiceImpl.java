package com.example.demo.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioServiceI;
/**
 * servicio de usuario
 * @author joaquin
 *
 */
@Primary
@Service("UsuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioServiceI {

	@Autowired
	private UsuarioRepository usuarioRepository;

	/**
	 * busca un usuario por id
	 */
	@Override
	public Usuario findById(long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	/**
	 * busca todos los usuarios
	 */
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	/**
	 * guarda todos los usuarios
	 */
	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	/**
	 * crea usuarios al iniciar la aplicacion
	 */
	@PostConstruct
	public void init() {
		usuarioRepository.saveAll(Arrays.asList(
				new Usuario(null, "Admin", "1234", "admin@gmail.com", "666666666", "secret"),
				new Usuario(null, "Maria", "1234", "maria.sanchez@dominio.es", "656111222", "Calle Pajarito N28"),
				new Usuario(null, "Juan", "1234", "juanito@dominio.es", "656434767", "Calle Rey N14")));
	}

}
