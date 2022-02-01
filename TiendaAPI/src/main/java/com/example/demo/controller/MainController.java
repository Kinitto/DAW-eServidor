package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pedido;
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


	@PostMapping("/pedido")
	public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedidoDTO) {
		
		Pedido pedido = servicioPedido.crearPedido(pedidoDTO);
		
		return ResponseEntity.ok(pedido);
	}
	
	@GetMapping("/pedido")
	public List<Pedido> getPedidos() {
		
		return servicioPedido.findAll();

	}
	@GetMapping("/pedido/{id}")
	public Pedido getPedidosByID(@PathVariable Long id) {
		
		return servicioPedido.findById(id);

	}

	
}
