package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PedidoProducto;
import com.example.demo.model.Producto;
import com.example.demo.model.dto.interfaces.PedidoProductoDTOI;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	@Query(value = ""
			+ "SELECT "
			+ "	tp.nombre as nombre, "
			+ "	pp.cantidad  as cantidad, "
			+ "	tp.precio as precio "
			+ "FROM "
			+ "	t_pedido_producto pp, "
			+ "	t_producto tp  "
			+ "WHERE "
			+ "	pp.id_producto = tp.id_producto "
			+ "	AND pp.id_pedido = ?1" , nativeQuery = true)
	List<PedidoProductoDTOI> findProductFromOrder(Long id);

	
	@Query(value = ""
			+ "SELECT "
			+ "* "
			+ "FROM "
			+ "t_producto " , nativeQuery = true)
	List<Producto> findProducts(long id);

}
