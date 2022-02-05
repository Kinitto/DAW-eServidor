package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Pedido;
import com.example.demo.model.Usuario;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Query(value = ""
			+ "SELECT "
			+ "	* "
			+ "FROM "
			+ "	t_pedido tpe, "
			+ "	t_usuario tu "
			+ "WHERE "
			+ "	tpe.user_id = tu.id_usuario "
			+ "	AND tu.id_usuario = ?1" , nativeQuery = true)
	List<Pedido> findOrdersFromUser(Long id);
	
}
