package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Pedido;
import com.example.demo.model.PedidoProducto;
import com.example.demo.model.Producto;
import com.example.demo.model.Usuario;
import com.example.demo.model.dto.PedidoProductoDTO;
import com.example.demo.service.PedidoProductoServiceI;
import com.example.demo.service.PedidoServiceI;
import com.example.demo.service.ProductoServiceI;
import com.example.demo.service.UsuarioServiceI;

@Controller
public class MainController {

	@Autowired
	private UsuarioServiceI servicioUsuario;

	@Autowired
	private ProductoServiceI servicioProducto;

	@Autowired
	private PedidoServiceI servicioPedido;

	@Autowired
	private PedidoProductoServiceI servicioPedidoProducto;

	@Autowired
	private HttpSession sesion;

	/**
	 * Invalida la sesión y redirecciona a login
	 * 
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
	 * 
	 * @param model
	 * @return
	 */

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());

		return "login";
	}

	/**
	 * Recogemos los datos del usuario que hemos rellenado en el formulario se lo
	 * enviamos al servicio para que identifique todos los datos de ese usuario,
	 * comprobamos que el usuario no es nulo y lo mandamos a la seleccion si el
	 * usuario es nulo te devuelve de nuevo a login
	 * 
	 * @param usuarioDTO
	 * @param bindingResult
	 * @param model
	 * @return
	 */

	@PostMapping("/login/submit")
	public String nuevoUsuarioSubmit(Usuario usuarioDTO, Model model, RedirectAttributes redirectAtributos) {

		Usuario usuario = servicioUsuario.findUser(usuarioDTO);

		if (usuario != null) {
			sesion.setAttribute("usuario", usuario);
			return "redirect:/seleccion";
		} else {
			redirectAtributos.addFlashAttribute("error", true);
			return "redirect:/login";

		}
	}

	/**
	 * comprobamos que el usuario existe y se lo mandamos a la vista
	 * 
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

	/**
	 * comprueba que el usuario existe y muestra la pagina de crear pedido
	 * 
	 * @param model
	 * @param request
	 * @return
	 */

	@GetMapping("/nuevopedido")
	public String nuevopedido(Model model) {

		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}

		return "nuevopedido";
	}

	/**
	 * El submit de nuestro pedido, recogemos los datos de cantidad que ha
	 * seleccionado el usuario y creamos el objeto pedido al completo.
	 * 
	 * @param camisetacantidad
	 * @param pantaloncantidad
	 * @param abrigocantidad
	 * @param model
	 * @return
	 */
	@PostMapping("/nuevopedido/submit")
	public String nuevopedidoSubmit(@RequestParam("cantidades") List<Integer> cantidades, Model model) {

		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		
		Pedido pedido = servicioPedido.crearPedido(usuario, cantidades);
		sesion.setAttribute("idPedido", pedido.getId());

		return "redirect:/resumen";
	}

	/**
	 * obtenemos el resumen del pedido con su precio y seleccionamos el tipo de
	 * envio
	 * 
	 * @param model1
	 * @return
	 */
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

	/**
	 * comprobamos que existe usuario y enviamos a lista de pedidos.
	 * 
	 * @param model
	 * @return
	 */

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

	/**
	 * comprobamos que hay usuario y mostramos en una tabla todos los pedidos que
	 * hemos realizado
	 * 
	 * @param model
	 * @return
	 */
	
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
	
	/**
	 * recogemos el id y buscamos el pedido por id y se lo enviamos a la vista
	 * para poder editar el pedido en especifico que queremos
	 * @param id
	 * @param model
	 * @return
	 */
	
	@GetMapping("/edit/{id}")
	public String editarpedido(@PathVariable long id, Model model) {
		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
		
		Pedido pedido = servicioPedido.findById(id);

		model.addAttribute("pedido", pedido);


	
		return "editarpedido";
	}

	/**
	 * recogemos el pedido que hemos editado y lo enviamos al servicio a la funcion
	 * de edit.
	 * @param pedido
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/edit/submit")
	public String editarpedidosubmit(@RequestParam long id,@ModelAttribute("pedido") Pedido pedidoModificado, BindingResult bindingResult) {
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

	
	
	/**
	 * recogemos la id del pedido que queremos eliminar y se la mandamos al 
	 * servicio a la funcion delete.
	 * @param id
	 * @param model
	 * @return
	 */
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
