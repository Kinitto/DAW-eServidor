package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;
import com.example.demo.model.Usuario;
import com.example.demo.model.pedidoProducto;
import com.example.demo.service.PedidoServiceI;
import com.example.demo.service.ProductoServiceI;
import com.example.demo.service.UsuarioServiceI;
import com.example.demo.service.pedidoProductoServiceI;

@Controller
public class MainController {

	@Autowired
	private UsuarioServiceI servicioUsuario;
	@Autowired
	private ProductoServiceI servicioProducto;
	@Autowired
	private PedidoServiceI servicioPedido;
	@Autowired
	private pedidoProductoServiceI servicioPedidoProducto;
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
	public String nuevopedidoSubmit(@RequestParam("camisetacantidad") int camisetacantidad,
			@RequestParam("pantaloncantidad") int pantaloncantidad, @RequestParam("abrigocantidad") int abrigocantidad,
			Model model) {

		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		// si la cantidad que introduces es mayor de 0 se añade el producto.
		if (camisetacantidad > 0 || pantaloncantidad > 0 || abrigocantidad > 0) {

			Pedido pedido = new Pedido(usuario.getEmail(), usuario.getTelefono(), usuario.getDireccion(),
					formatter.format(date));
			servicioPedido.save(pedido);

			if (camisetacantidad > 0) {
				Producto producto = servicioProducto.findById(1);
				pedidoProducto pedidoProducto = new pedidoProducto(pedido, producto, camisetacantidad);
				servicioPedidoProducto.save(pedidoProducto);
			}
		}

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
		// Crear y enviar las variables para saber que metodo de envio se selecciona.
		//String domicilio = "";
		////String tienda = "";

		// model.addAttribute("domicilio", domicilio);
		// model.addAttribute("correo", correo);
		// model.addAttribute("tienda", tienda);
		// int pedidosize = servicioPedido.cantidad();
		// model.addAttribute("hayproducto", pedidosize);
		// model.addAttribute("listaProducto",
		// servicioProducto.findProducto(servicioPedido.cantidad()));
		return "resumen";
	}

	/**
	 * comprobamos que existe usuario y enviamos a lista de pedidos.
	 * 
	 * @param model
	 * @return
	 */

}
