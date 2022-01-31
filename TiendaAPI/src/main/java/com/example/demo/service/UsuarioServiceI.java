package com.example.demo.service;

import com.example.demo.model.Usuario;

public interface UsuarioServiceI {

	public Usuario save(Usuario e);

	public Usuario findById(long id);

	public Usuario findUser(Usuario usuario);

}
