package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.pedidoProducto;


@Repository
public interface pedidoProductoRepository extends JpaRepository<pedidoProducto,Long>{

}
