package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Pedido;
import com.example.demo.model.Usuario;
import com.example.demo.model.dto.PedidoProductoDTO;
import com.example.demo.service.PedidoServiceI;
import com.example.demo.service.ProductoServiceI;
import com.example.demo.service.UsuarioServiceI;

@RestController
public class MainController {

	@Autowired
	private UsuarioServiceI servicioUsuario;

	@Autowired
	private ProductoServiceI servicioProducto;

	@Autowired
	private PedidoServiceI servicioPedido;

	@Autowired
	private HttpSession sesion;



	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario usuarioDTO) {

		Usuario usuario = servicioUsuario.findUser(usuarioDTO);

		if (usuario != null) {
			sesion.setAttribute("usuario", usuario);
			return ResponseEntity.ok(usuario);
		} else {
			return ResponseEntity.notFound().build();

		}
	}

	
	@PostMapping("/nuevopedido")
	public String nuevopedidoSubmit(@RequestParam("cantidades") List<Integer> cantidades) {

		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		
		Pedido pedido = servicioPedido.crearPedido(usuario, cantidades);
		sesion.setAttribute("idPedido", pedido.getId());

		return "redirect:/resumen";
	}

	
	@GetMapping("/resumen")
	public String resumen(Model model) {
		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
		Long id = (Long) sesion.getAttribute("idPedido");

		List<PedidoProductoDTO> productos = servicioProducto.findProductFromOrder(id);

		int productoSize = productos.size();

		Pedido pedidoActual = servicioPedido.findById(id);

		double total = servicioPedido.calcularTotal(productos);

		servicioPedido.setTotal(pedidoActual, total);
		
		model.addAttribute("total", total);
		model.addAttribute("hayproducto", productoSize);
		model.addAttribute("productos", productos);
		
		return "resumen";
	}

	

	@PostMapping("/resumen/submit")
	public String resumenSubmit(@RequestParam String envio, Model model) {

		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
		Long id = (Long) sesion.getAttribute("idPedido");

		Pedido pedidoActual = servicioPedido.findById(id);

			servicioPedido.addEnvio(pedidoActual,envio);
		
		return "redirect:/listapedidos";
	}

	
	
	@GetMapping("/listapedidos")
	public String listapedido(Model model) {
		
		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		

		List<Pedido> listaPedidos = servicioPedido.findOrdersFromUser(usuario.getId());
		int pedidosize = listaPedidos.size();
		
		model.addAttribute("hayproducto", pedidosize);
		model.addAttribute("listaPedidos", listaPedidos);
		
		return "listapedidos";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editarpedido(@PathVariable long id, Model model) {
		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
		
		Pedido pedido = servicioPedido.findById(id);

		model.addAttribute("pedido", pedido);


	
		return "editarpedido";
	}

	
	@PostMapping("/edit/submit")
	public String editarpedidosubmit(@RequestParam long id,@ModelAttribute("pedido") Pedido pedidoModificado) {
		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		} else {
			
			Pedido pedidoActual = servicioPedido.findById(id);
			
			servicioPedido.edit(pedidoModificado, pedidoActual);
			
			
			List<PedidoProductoDTO> productos = servicioProducto.findProductFromOrder(id);

			double total = servicioPedido.calcularTotal(productos);

			servicioPedido.setTotal(pedidoActual, total);

			
			return "redirect:/listapedidos";
		}
	}

	
	
	@GetMapping("/delete/{id}")
	public String deletepedido(@PathVariable long id, Model model) {
		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		} else {
			Pedido pedido = servicioPedido.findById(id);
			servicioPedido.delete(pedido);
			return "redirect:/listapedidos";
		}
	}
}
