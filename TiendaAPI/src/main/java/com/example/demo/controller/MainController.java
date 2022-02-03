package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pedido;
import com.example.demo.model.PedidoProducto;
import com.example.demo.model.Producto;
import com.example.demo.model.Usuario;
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
	


	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios() {
		return servicioUsuario.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario getUsuariosById(@PathVariable Long id) {
		return servicioUsuario.findById(id);
	}
	
	
	@GetMapping("/productos")
	public List<Producto> getProductos() {
		return servicioProducto.findAll();
	}
	
	@GetMapping("/productos/{id}")
	public Producto getProductosById(@PathVariable Long id) {
		return servicioProducto.findById(id);
	}


	@PostMapping("/pedidos")
	public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedidoDTO) {
		
		Pedido pedido = servicioPedido.crearPedido(pedidoDTO);
		
		return ResponseEntity.ok(pedido);
	}
	
	@GetMapping("/pedidos")
	public List<Pedido> getPedidos() {
		
		return servicioPedido.findAll();

	}
	@GetMapping("/pedidos/{id}")
	public Pedido getPedidosByID(@PathVariable Long id) {
		
		return servicioPedido.findById(id);

	}
	@PutMapping("/pedidos/{id}")
	public ResponseEntity<Pedido> editPedido(@PathVariable Long id, @RequestBody Pedido pedidoDTO) {
		
		//excepcion si el id es null
		Pedido pedido = servicioPedido.editPedido(id, pedidoDTO);
		return ResponseEntity.ok(pedido);


	}
	
	@DeleteMapping("/pedidos/{id}")
	public Pedido deletePedido(@PathVariable Long id) {
		
		//excepcion si el id es null
		Pedido pedido = this.servicioPedido.delete(id);
		
		return pedido;

	}

	
}
