package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pedido;
import com.example.demo.model.PedidoProducto;
import com.example.demo.repository.PedidoProductoRepository;
import com.example.demo.service.PedidoProductoServiceI;
/**
 * servicio de pedidoProducto / lineaPedido
 * @author joaquin
 *
 */
@Primary
@Service("PedidoProductoServiceImpl")
public class PedidoProductoServiceImpl implements PedidoProductoServiceI {

	@Autowired
	private PedidoProductoRepository PedidoProductoRepository;
	
	/**
	 * guarda el pedido
	 */
	@Override
	public PedidoProducto save(PedidoProducto PedidoProducto) {
		// TODO Auto-generated method stub
		return PedidoProductoRepository.save(PedidoProducto);
	}

	/**
	 * busca por id
	 */
	@Override
	public PedidoProducto findById(long id) {

		return PedidoProductoRepository.findById(id).orElse(null);

	}

	/**
	 * borra una linea de pedido
	 */
	@Override
	public void borrarLineas(Pedido pedido, Long idLinea) {

		PedidoProducto linea = PedidoProductoRepository.findByPedidoAndIdLinea(pedido, idLinea);
		PedidoProductoRepository.delete(linea);
	}
	
	/**
	 * edita lineas de pedido, enviamos al metodo 
	 * una linea de pedido con la id de su pedido y su id propia
	 */
	@Override
	public PedidoProducto editarLinea(PedidoProducto lineaPedidoDTO, Long idLinea, Pedido pedido) {
		
		lineaPedidoDTO.setId(idLinea);
		lineaPedidoDTO.setPedido(pedido);
		PedidoProductoRepository.save(lineaPedidoDTO);
		return lineaPedidoDTO;
	}

}
