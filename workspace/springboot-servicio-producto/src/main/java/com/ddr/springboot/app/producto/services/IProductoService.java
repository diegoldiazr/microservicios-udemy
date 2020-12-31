package com.ddr.springboot.app.producto.services;

import java.util.List;

import com.ddr.springboot.app.producto.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	
	public Producto findById(Long id);
	
	public Producto save(Producto producto);
	
	public void deleteById(Long id);

	public Producto editar(Long id, Producto producto);
}
