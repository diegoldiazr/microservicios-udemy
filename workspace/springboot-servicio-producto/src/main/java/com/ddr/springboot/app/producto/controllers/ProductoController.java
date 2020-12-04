package com.ddr.springboot.app.producto.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ddr.springboot.app.producto.models.entity.Producto;
import com.ddr.springboot.app.producto.services.IProductoService;

@RestController
public class ProductoController {
	
	//traer el port de forma mas sencilla
	@Value("${server.port}")
	private Integer port;
	

	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> findAll(){
		return productoService.findAll().stream().map(producto -> {
			producto.setPort(port);
			return producto;
			}).collect(Collectors.toList());
		
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		producto.setPort(port);
		return producto;
	}
}
