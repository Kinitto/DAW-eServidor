package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Usuario;

public interface UsuarioServiceI {

	public Usuario save(Usuario e);

	public Usuario findById(long id);

	public List<Usuario> findAll();

}
