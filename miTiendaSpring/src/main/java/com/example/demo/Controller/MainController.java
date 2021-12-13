package com.example.demo.Controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.ModelPedido;
import com.example.demo.Model.ModelProducto;
import com.example.demo.Model.ModelUsuario;
import com.example.demo.Service.ServicePedido;
import com.example.demo.Service.ServiceProducto;
import com.example.demo.Service.ServiceUsuario;

@Controller
public class MainController {

	@Autowired
	private ServiceUsuario servicioUsuario;
	@Autowired
	private ServiceProducto servicioProducto;
	@Autowired
	private ServicePedido servicioPedido;
	@Autowired
	private HttpSession sesion;

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
			BindingResult bindingResult, Model model) {


		ModelUsuario usuario = servicioUsuario.findUser(usuarioDTO);

		if (usuario != null) {
			// terminar que funcione meter en sesion
			sesion.setAttribute("usuario", usuario);
			return "redirect:/seleccion";
		} else {
			model.addAttribute("error", true);
			return "redirect:/login";
		}
	}

	@GetMapping("/seleccion")
	public String seleccion(Model model) {
		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
		model.addAttribute("usuario", sesion.getAttribute("usuario"));
		return "seleccion";
	}

	@GetMapping("/nuevopedido")
	public String nuevopedido(Model model, HttpServletRequest request) {
		HttpSession sesion = request.getSession();

		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
		return "nuevopedido";
	}

	@PostMapping("/nuevopedido/submit")
	public String nuevopedidoSubmit(@RequestParam("camisetacantidad") int camisetacantidad,
			@RequestParam("pantaloncantidad") int pantaloncantidad, @RequestParam("abrigocantidad") int abrigocantidad,
			Model model) {

		// si la cantidad que introduces es mayor de 0 se añade el producto.
		if (camisetacantidad > 0) {
			servicioProducto.add(new ModelProducto("Camiseta", camisetacantidad, 15));
		}
		if (pantaloncantidad > 0) {
			servicioProducto.add(new ModelProducto("Pantalon", pantaloncantidad, 25));
		}
		if (abrigocantidad > 0) {
			servicioProducto.add(new ModelProducto("Abrigo", abrigocantidad, 65));
		}
		List<ModelProducto> product = servicioProducto.findAll();

		sesion.setAttribute("productos", product);

		// Creo el pedido con todos los datos
		ModelUsuario usuario = (ModelUsuario) sesion.getAttribute("usuario");
		servicioPedido.add(new ModelPedido(1,product, usuario.getEmail(), usuario.getTelefono(), usuario.getDireccion()));

		return "redirect:/resumen";
	}

	@GetMapping("/resumen")
	public String resumen(Model model) {
		
		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
		//Crear y enviar las variables para saber que metodo de envio se selecciona.
		String domicilio = "";
		String correo = "";
		String tienda = "";

		model.addAttribute("domicilio", domicilio);
		model.addAttribute("correo", correo);
		model.addAttribute("tienda", tienda);

		model.addAttribute("listaProducto", servicioProducto.findAll());
		return "resumen";
	}

	@PostMapping("/resumen/submit")
	public String resumenSubmit(@RequestParam String envio, Model model) {
		sesion.setAttribute("envio", envio);
		return "redirect:/listapedidos";
	}
	
	@GetMapping("/listapedidos")
	public String listapedido(Model model) {
		model.addAttribute("listaPedido", servicioPedido.findAll());
		model.addAttribute("listaProducto", servicioProducto.findAll());
		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
		System.out.println(servicioPedido.findAll());
		return "listapedidos";
	}	

}
