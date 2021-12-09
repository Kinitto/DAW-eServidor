package com.example.demo.Controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Model.ModelUsuario;
import com.example.demo.Service.ServiceUsuario;

@Controller
public class MainController {

	@Autowired
	private ServiceUsuario servicioUsuario;

	@GetMapping("")
	public String redirectLogin(Model model) {
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("listausuarios", servicioUsuario.findAll());
		model.addAttribute("usuario", new ModelUsuario());
		return "login";
	}

	@PostMapping("/login/submit")
	public String nuevoUsuarioSubmit(@Valid @ModelAttribute("usuario") ModelUsuario usuarioDTO,
			BindingResult bindingResult, Model model, HttpServletRequest request) {

		HttpSession sesion = request.getSession();

		ModelUsuario usuario = servicioUsuario.findUser(usuarioDTO);

		if (usuario != null) {
			//terminar que funcione meter en sesion
			sesion.setAttribute("usuario", usuario);
			return "redirect:/seleccion";
		} else {
			return "redirect:/login";
		}
	}
	

	@GetMapping("/seleccion")
	public String seleccion(Model model) {
		model.addAttribute("listausuarios", servicioUsuario.findAll());
		model.addAttribute("usuario", new ModelUsuario());
		return "seleccion";
	}

}
