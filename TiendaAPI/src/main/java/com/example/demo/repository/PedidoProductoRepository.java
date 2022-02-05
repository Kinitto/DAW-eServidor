package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Pedido;
import com.example.demo.model.PedidoProducto;
import com.example.demo.model.Usuario;

@Repository
public interface PedidoProductoRepository extends JpaRepository<PedidoProducto, Long> {

	PedidoProducto findByPedidoAndIdLinea(Pedido pedido, Long idLinea);

}
