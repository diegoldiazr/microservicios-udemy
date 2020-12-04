package com.ddr.springboot.app.producto.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ddr.springboot.app.producto.models.entity.Producto;
import com.ddr.springboot.app.producto.services.IProductoService;

@RestController
public class ProductoController {
	
	//para traer el port
	@Autowired
	private Environment env;

	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> findAll(){
		return productoService.findAll().stream().map(producto -> {
			producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return producto;
			}).collect(Collectors.toList());
		
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return producto;
	}
}
