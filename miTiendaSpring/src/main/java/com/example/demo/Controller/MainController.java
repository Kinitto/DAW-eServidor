package com.example.demo.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.PathVariable;
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
		model.addAttribute("usuario", new ModelUsuario());

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
	public String nuevoUsuarioSubmit(@Valid ModelUsuario usuarioDTO, BindingResult bindingResult, Model model) {

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
	
	/**
	 * comprueba que el usuario existe y muestra la pagina de crear pedido
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
	 * El submit de nuestro pedido, recogemos los datos de cantidad que ha seleccionado
	 * el usuario y  creamos el objeto pedido al completo.
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

		Date date = new Date();
		int pedidosize = servicioPedido.cantidad() + 1;
		int id = 0;

		// si la cantidad que introduces es mayor de 0 se añade el producto.
		if (camisetacantidad > 0) {
			servicioProducto.add(new ModelProducto(pedidosize, "Camiseta", camisetacantidad, 15));
		}
		if (pantaloncantidad > 0) {
			servicioProducto.add(new ModelProducto(pedidosize, "Pantalon", pantaloncantidad, 25));
		}
		if (abrigocantidad > 0) {
			servicioProducto.add(new ModelProducto(pedidosize, "Abrigo", abrigocantidad, 65));
		}

		if (camisetacantidad > 0 || pantaloncantidad > 0 || abrigocantidad > 0) {

			// Creo el pedido con todos los datos
			List<ModelProducto> producto = servicioProducto.findProducto(pedidosize);

			ModelUsuario usuario = (ModelUsuario) sesion.getAttribute("usuario");
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

			if (id < pedidosize) {
				servicioPedido.add(new ModelPedido(pedidosize, producto, usuario.getEmail(), usuario.getTelefono(),
						usuario.getDireccion(), formatter.format(date)));

			}
		}

		return "redirect:/resumen";
	}

	/**
	 * obtenemos el resumen del pedido con su precio y seleccionamos el tipo de envio
	 * @param model
	 * @return
	 */
	@GetMapping("/resumen")
	public String resumen(Model model) {
		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
		// Crear y enviar las variables para saber que metodo de envio se selecciona.
		String domicilio = "";
		String correo = "";
		String tienda = "";

		model.addAttribute("domicilio", domicilio);
		model.addAttribute("correo", correo);
		model.addAttribute("tienda", tienda);
		int pedidosize = servicioPedido.cantidad();
		model.addAttribute("hayproducto", pedidosize);
		model.addAttribute("listaProducto", servicioProducto.findProducto(servicioPedido.cantidad()));
		return "resumen";
	}

	/**
	 * comprobamos que existe usuario y enviamos a lista de pedidos.
	 * @param model
	 * @return
	 */
	@PostMapping("/resumen/submit")
	public String resumenSubmit(@RequestParam String envio,Model model) {
		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
		sesion.setAttribute("envio", envio);
		return "redirect:/listapedidos";
	}

	/**
	 * comprobamos que hay usuario y mostramos en una tabla todos los pedidos 
	 * que hemos realizado
	 * @param model
	 * @return
	 */
	@GetMapping("/listapedidos")
	public String listapedido(Model model) {
		model.addAttribute("listaPedido", servicioPedido.findAll());
		int pedidosize = servicioPedido.cantidad();
		String envio = (String) sesion.getAttribute("envio");
		model.addAttribute("hayproducto", pedidosize);
		model.addAttribute("envio",envio);
		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
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

		ModelPedido pedido = servicioPedido.findById(id);

		model.addAttribute("pedido", pedido);

		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
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
	public String editarpedidosubmit(@Valid @ModelAttribute("pedido") ModelPedido pedido, BindingResult bindingResult) {
		if (sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		} else {
			servicioPedido.edit(pedido);
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
			servicioPedido.delete(id);
			return "redirect:/listapedidos";
		}
	}

}
