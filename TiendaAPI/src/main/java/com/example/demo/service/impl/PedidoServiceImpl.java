package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pedido;
import com.example.demo.model.PedidoProducto;
import com.example.demo.model.Producto;
import com.example.demo.repository.PedidoProductoRepository;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.service.PedidoServiceI;
import com.example.demo.service.ProductoServiceI;
/**
 * servicio de Pedido
 * @author joaquin
 *
 */
@Primary
@Service("PedidoServiceImpl")
public class PedidoServiceImpl implements PedidoServiceI {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProductoServiceI productoService;
	
	
	@Autowired
	private PedidoProductoRepository pedidoProductoRepo;
	
	/**
	 * guarda un pedido
	 */
	@Override
	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	/**
	 * busca un pedido por id
	 */
	@Override
	public Pedido findById(long id) {
		return pedidoRepository.findById(id).orElse(null);
	}

	/**
	 * crea un pedido
	 */
	@Override
	public Pedido crearPedido(Pedido pedidoDTO) {

	
			pedidoRepository.save(pedidoDTO);
			
			return pedidoDTO;
	}
	/**
	 * busca todos los pedidos
	 */
	@Override
	public List<Pedido> findAll() {
		// TODO Auto-generated method stub
		return 	pedidoRepository.findAll();

	}
	/**
	 * edita un pedido
	 */
	@Override
	public Pedido editPedido(Long id, Pedido pedidoDTO) {

		
			pedidoDTO.setId(id);
			pedidoRepository.save(pedidoDTO);
		
		return pedidoDTO;
	}
	
	/**
	 * elimina un pedido
	 */
	@Override
	public Pedido delete(Long id) {
		// TODO Auto-generated method stub
		Pedido pedido = this.findById(id);
		pedidoRepository.deleteById(id);
		
		return pedido;
	}


	/**
	 * busca las lineas de pedido de un pedido
	 */
	@Override
	public List<PedidoProducto> getListaLineas(Long id) {
		
		Pedido pedido = this.findById(id);
		List<PedidoProducto> listaLineas = pedido.getProductos();
		return listaLineas;
	}
	/**
	 * crea una linea de pedido
	 */
	
	@Override
	public PedidoProducto crearLinea(PedidoProducto lineaPedidoDTO, Long id) {

		PedidoProducto lineaPedido = lineaPedidoDTO;

		Pedido pedido = this.findById(id);
		
		if(pedido==null) {
			lineaPedido = null;
		}
		else {
			lineaPedido.setProducto(lineaPedidoDTO.getProducto());
			lineaPedido.setPedido(pedido);
			lineaPedido.setCantidad(lineaPedidoDTO.getCantidad());
			this.setTotalPrecio(lineaPedidoDTO);
			pedidoProductoRepo.save(lineaPedido);
		}
		
		
		return lineaPedido;
	}

	/**
	 * establece el precio del pedido
	 */
	@Override
	public void setTotalPrecio(PedidoProducto lineaPedidoDTO) {
		Pedido pedido = findById(lineaPedidoDTO.getPedido().getId());
		Producto producto = productoService.findById(lineaPedidoDTO.getProducto().getId());
		
		double total = producto.getPrecio()*lineaPedidoDTO.getCantidad();
		
		if(pedido.getTotalPrecio()==null) {
			pedido.setTotalPrecio(total);

		}
		else {
			pedido.setTotalPrecio(pedido.getTotalPrecio()+total);
		}
		
		pedidoRepository.save(pedido);

	}
	
	/**
	 * resta el precio de pedido
	 * se usa para cuando eliminamos una linea de pedido
	 */
	@Override
	public void restarPrecio(PedidoProducto lineaPedidoDTO) {
		
		Pedido pedido = findById(lineaPedidoDTO.getPedido().getId());
		Producto producto = productoService.findById(lineaPedidoDTO.getProducto().getId());
		
		double total = producto.getPrecio()*lineaPedidoDTO.getCantidad();
		
		if(pedido.getTotalPrecio()==null) {
			pedido.setTotalPrecio(total);

		}
		else {
			pedido.setTotalPrecio(pedido.getTotalPrecio()-total);
		}
		
		pedidoRepository.save(pedido);
		
	}



	
	
	
	
	

	

	

	

}
