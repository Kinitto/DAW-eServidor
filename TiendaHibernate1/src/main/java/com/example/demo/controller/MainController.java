package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioServiceI;


@Controller
public class MainController {
	
	@Autowired
	private UsuarioServiceI servicioUsuario;
	@Autowired
	private HttpSession sesion;
	
	/**
	 * Invalida la sesión y redirecciona a login
	 * @param model
	 * @return
	 */

	@GetMapping("")
	public String redirectLogin(Model model) {
		sesion.invalidate();
		return "redirect:/login";
	}
	
	/**
	 * carga la pagina de login y enviamos a la vista el usuario
	 * @param model
	 * @return
	 */

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());

		return "login";
	}
	
	/**
	 * Recogemos los datos del usuario que hemos rellenado en el formulario y 
	 * se lo enviamos al servicio para que identifique todos los datos de ese usuario, comprobamos que el usuario no
	 * es nulo y lo mandamos a la seleccion
	 * si el usuario es nulo te devuelve de nuevo a login
	 * @param usuarioDTO
	 * @param bindingResult
	 * @param model
	 * @return
	 */

	@PostMapping("/login/submit")
	public String nuevoUsuarioSubmit(Usuario usuarioDTO, Model model) {

		Usuario usuario = servicioUsuario.findUser(usuarioDTO);

		if (usuario != null) {
		sesion.setAttribute("usuario", usuario);
			return "redirect:/seleccion";
		} else {
		model.addAttribute("error", true);
		return "redirect:/login";

	}
	}

	/**
	 * comprobamos que el usuario existe y se lo mandamos a la vista
	 * @param model
	 * @return
	 */
	@GetMapping("/seleccion")
	public String seleccion(Model model) {
		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
		model.addAttribute("usuario", sesion.getAttribute("usuario"));
		return "seleccion";
	}
	
}
