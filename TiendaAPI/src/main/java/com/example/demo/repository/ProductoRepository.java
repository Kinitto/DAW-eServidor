package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	@Query(value = ""
			+ "SELECT "
			+ "* "
			+ "FROM "
			+ "t_producto " , nativeQuery = true)
	List<Producto> findProducts(long id);

}
