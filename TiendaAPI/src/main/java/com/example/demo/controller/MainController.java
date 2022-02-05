package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.error.ApiError;
import com.example.demo.error.LineaNotFoundException;
import com.example.demo.error.PedidoNotFoundException;
import com.example.demo.error.ProductoNotFoundException;
import com.example.demo.error.UsuarioNotFoundException;
import com.example.demo.model.Pedido;
import com.example.demo.model.PedidoProducto;
import com.example.demo.model.Producto;
import com.example.demo.model.Usuario;
import com.example.demo.service.PedidoProductoServiceI;
import com.example.demo.service.PedidoServiceI;
import com.example.demo.service.ProductoServiceI;
import com.example.demo.service.UsuarioServiceI;
/**
 * Controlador de la API tienda
 * @author joaquin
 *
 */
@RestController
public class MainController {

	@Autowired
	private UsuarioServiceI servicioUsuario;

	@Autowired
	private ProductoServiceI servicioProducto;

	@Autowired
	private PedidoServiceI servicioPedido;

	@Autowired
	private PedidoProductoServiceI servicioLineas;

	/**
	 * ver todos los usuarios
	 * @return lista usuarios
	 */
	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios() {
		return servicioUsuario.findAll();
	}
	
	/**
	 * ver un usuario por su id
	 * @param id
	 * @return usuario
	 */
	@GetMapping("/usuarios/{id}")
	public Usuario getUsuariosById(@PathVariable Long id) {
		
		Usuario usuario = servicioUsuario.findById(id);
		if(usuario == null) {
			throw new UsuarioNotFoundException(id);
		}
		else {
			return usuario;
		}
	}
	
	/**
	 * ver todos los productos
	 * @return lista de productos
	 */
	@GetMapping("/productos")
	public List<Producto> getProductos() {
		return servicioProducto.findAll();
	}
	
	/**
	 * ver producto por su id
	 * @param id
	 * @return producto
	 */
	@GetMapping("/productos/{id}")
	public Producto getProductosById(@PathVariable Long id) {

		Producto producto = servicioProducto.findById(id);
		
		if (producto == null) {
			throw new ProductoNotFoundException(id);
		}
		else {
			return producto;
		}
	}

	/**
	 * crear un pedido
	 * @param pedidoDTO
	 * @return pedido
	 */

	@PostMapping("/pedidos")
	public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedidoDTO) {
		
		Pedido pedido = servicioPedido.crearPedido(pedidoDTO);
		
		return ResponseEntity.ok(pedido);
	}
	
	/**
	 * ver todos los pedidos
	 * @return lista de pedidos
	 */
	@GetMapping("/pedidos")
	public List<Pedido> getPedidos() {
		
		return servicioPedido.findAll();

	}
	/**
	 * ver pedido por su id
	 * @param id
	 * @return pedido
	 */
	@GetMapping("/pedidos/{id}")
	public Pedido getPedidosByID(@PathVariable Long id) {
		
		Pedido pedido = servicioPedido.findById(id);
		if(pedido == null) {
			throw new PedidoNotFoundException(id);
		}
		else {
			return pedido;
		}

	}
	/**
	 * editar un pedido
	 * @param id
	 * @param pedidoDTO
	 * @return pedido
	 */
	@PutMapping("/pedidos/{id}")
	public ResponseEntity<Pedido> editarPedido(@PathVariable Long id, @RequestBody Pedido pedidoDTO) {
		
		Pedido pedido = servicioPedido.findById(id);
		if(pedido == null) {
			throw new PedidoNotFoundException(id);
		}
		else {
			servicioPedido.editPedido(id, pedidoDTO);
			return ResponseEntity.ok(pedido);
		}


	}
	
	/**
	 * Eliminar un pedido
	 * @param id
	 * @return codigo de respuesta http
	 */
	
	@DeleteMapping("/pedidos/{id}")
	public ResponseEntity<Pedido> borrarPedido(@PathVariable Long id) {
		
		Pedido pedido = servicioPedido.findById(id);
		if(pedido == null) {
			throw new PedidoNotFoundException(id);
		}
		else {
			servicioPedido.delete(id);
			return ResponseEntity.noContent().build();
		}
	
	}
	
	/**
	 * crear linea de pedido
	 * @param lineaPedidoDTO
	 * @param id
	 * @return linea de pedido
	 */

	@PostMapping("/pedidos/{id}/lineapedido")
	public PedidoProducto crearLinea(@RequestBody PedidoProducto lineaPedidoDTO, @PathVariable Long id) {
		
		return servicioPedido.crearLinea(lineaPedidoDTO, id);
	}
	
	/**
	 * ver todas las lineas de pedido de un pedido.
	 * @param id
	 * @return lista de lineas de pedido
	 */
	@GetMapping("/pedidos/{id}/lineapedido")
	public List<PedidoProducto> getLineas(@PathVariable Long id) {
		
		Pedido pedido = servicioPedido.findById(id);
		if(pedido == null) {
			throw new PedidoNotFoundException(id);
		}
		else {
			List<PedidoProducto> listaLineas = servicioPedido.getListaLineas(id);
			return listaLineas;
		}
	}
	/**
	 * eliminar linea de pedido por su id
	 * @param id
	 * @param idLinea
	 * @return codigo de respuesta http
	 */
	
	@DeleteMapping("/pedidos/{id}/lineapedido/{idLinea}")
	public ResponseEntity<PedidoProducto> borrarLineas(@PathVariable Long id,@PathVariable Long idLinea) {
		
		Pedido pedido = servicioPedido.findById(id);
		PedidoProducto lineaPedido = servicioLineas.findById(idLinea);
		
		if (lineaPedido == null) {
			throw new LineaNotFoundException(id);
		}
		else {
			servicioPedido.restarPrecio(lineaPedido);
			servicioLineas.borrarLineas(pedido, idLinea);
			return ResponseEntity.noContent().build();
		}
		
	}
	/**
	 * Editar linea de pedido por id
	 * @param lineaPedidoDTO
	 * @param id
	 * @param idLinea
	 * @return linea de pedido
	 */
	
	@PutMapping("/pedidos/{id}/lineapedido/{idLinea}")
	public PedidoProducto editarLinea(@RequestBody PedidoProducto lineaPedidoDTO, @PathVariable Long id,
			@PathVariable Long idLinea) {
		PedidoProducto linea = servicioLineas.findById(idLinea);
		if(linea == null) {
			throw new LineaNotFoundException(id);
		}
		else {
			Pedido pedido = servicioPedido.findById(id);
			PedidoProducto lineaPedido = servicioLineas.editarLinea(lineaPedidoDTO, idLinea, pedido);
			servicioPedido.setTotalPrecio(lineaPedido);
			return lineaPedido;
		}
	}
	
	/**
	 * excepcion not found producto
	 * @param ex
	 * @return exception
	 */
	
	@ExceptionHandler(ProductoNotFoundException.class)
	public ResponseEntity<ApiError> handleProductoNoEncontrado(ProductoNotFoundException ex) {
		ApiError apiError = new ApiError();
		apiError.setEstado(HttpStatus.NOT_FOUND);
		apiError.setFecha(LocalDateTime.now());
		apiError.setMensaje(ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
	/**
	 * excepcion not found usuario
	 * @param ex
	 * @return exception
	 */
	
	@ExceptionHandler(UsuarioNotFoundException.class)
	public ResponseEntity<ApiError> handleUsuarioNoEncontrado(UsuarioNotFoundException ex) {
		ApiError apiError = new ApiError();
		apiError.setEstado(HttpStatus.NOT_FOUND);
		apiError.setFecha(LocalDateTime.now());
		apiError.setMensaje(ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
	/**
	 * excepcion not found pedido
	 * @param ex
	 * @return exception
	 */
	
	@ExceptionHandler(PedidoNotFoundException.class)
	public ResponseEntity<ApiError> handlePedidoNoEncontrado(PedidoNotFoundException ex) {
		ApiError apiError = new ApiError();
		apiError.setEstado(HttpStatus.NOT_FOUND);
		apiError.setFecha(LocalDateTime.now());
		apiError.setMensaje(ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
	/**
	 * excepcion not found linea
	 * @param ex
	 * @return exception
	 */
	
	@ExceptionHandler(LineaNotFoundException.class)
	public ResponseEntity<ApiError> handleLineaNoEncontrado(LineaNotFoundException ex) {
		ApiError apiError = new ApiError();
		apiError.setEstado(HttpStatus.NOT_FOUND);
		apiError.setFecha(LocalDateTime.now());
		apiError.setMensaje(ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}

}
