package com.ddr.springboot.app.producto.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ddr.springboot.app.producto.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{
	
	

}
