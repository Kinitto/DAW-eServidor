package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PedidoProducto;

@Repository
public interface PedidoProductoRepository extends JpaRepository<PedidoProducto, Long> {

}
