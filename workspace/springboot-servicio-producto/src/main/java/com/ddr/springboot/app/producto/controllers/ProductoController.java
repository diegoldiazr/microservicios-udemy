package com.ddr.springboot.app.producto.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public Producto detalle(@PathVariable Long id) throws Exception {
		Producto producto = productoService.findById(id);
		producto.setPort(port);
		
		/*try {
			Thread.sleep(2000L);
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		return producto;
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crear(@RequestBody Producto producto) {		
		return productoService.save(producto);
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editar(@PathVariable Long id, @RequestBody Producto producto) {		
		return productoService.editar(id, producto);
	}
	
	@DeleteMapping("/borrar/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void borrar(@PathVariable Long id) {		
		productoService.deleteById(id);
	}
	
	
}
