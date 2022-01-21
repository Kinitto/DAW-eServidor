package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pedido;
import com.example.demo.model.PedidoProducto;
import com.example.demo.model.Producto;
import com.example.demo.model.Usuario;
import com.example.demo.model.dto.PedidoProductoDTO;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.service.PedidoProductoServiceI;
import com.example.demo.service.PedidoServiceI;
import com.example.demo.service.ProductoServiceI;

@Primary
@Service("PedidoServiceImpl")
public class PedidoServiceImpl implements PedidoServiceI {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProductoServiceI productoService;
	
	@Autowired
	private PedidoProductoServiceI pedidoProductoService;
	
	@Override
	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@Override
	public Pedido findById(long id) {
		return pedidoRepository.findById(id).orElse(null);
	}

	@Override
	public Pedido crearPedido(Usuario usuario, List<Integer> cantidades) {
		// si la cantidad que introduces es mayor de 0 se añade el producto.
			Pedido pedido = new Pedido();
	
			pedido.setUsuario(usuario);
			pedido.setFechaCompra(LocalDate.now());
			pedido.setCodPedido(UUID.randomUUID().toString());
			pedido.setDireccion(usuario.getDireccion());
			pedido.setEmail(usuario.getEmail());
			pedido.setTelefono(usuario.getTelefono());
			
			pedidoRepository.save(pedido);
			
			for(int i = 0;i<cantidades.size();i++){
				
				if(cantidades.get(i)>0) {
					Producto producto = productoService.findById(i+1);
					PedidoProducto pedidoProducto = new PedidoProducto(null, pedido, producto, cantidades.get(i));
					pedidoProductoService.save(pedidoProducto);
				}
			}
			return pedido;
	}
	
	@Override
	public List<Pedido> findProductsFromUser(Long id) {

		return pedidoRepository.findProductsFromUser(id);
	}

	@Override
	public double calcularTotal(List<PedidoProductoDTO> productos) {
		
		double total = 0;
		for(int i = 0;i<productos.size();i++){
			
			total = productos.get(i).getCantidad() * productos.get(i).getPrecio() + total;
		}
		
		return total;
	}

	@Override
	public void setTotal(Pedido pedidoActual, double total) {

		pedidoActual.setTotalPrecio(total);
		pedidoRepository.save(pedidoActual);

	}

	@Override
	public void delete(Pedido pedidoActual) {
		
		pedidoActual.setBorrado(true);
		pedidoRepository.save(pedidoActual);
	}

	@Override
	public void edit(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

	

	

	

}
