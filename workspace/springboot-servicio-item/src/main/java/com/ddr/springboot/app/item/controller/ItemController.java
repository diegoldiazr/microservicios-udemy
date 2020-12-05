package com.ddr.springboot.app.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ddr.springboot.app.item.model.Item;
import com.ddr.springboot.app.item.model.Producto;
import com.ddr.springboot.app.item.service.IItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class ItemController {

	@Autowired
	@Qualifier("ItemServiceFeign")
	private IItemService itemService;
	
	@GetMapping("/listar")
	public List<Item>  findAll(){
		return itemService.findAll();
	}
	
	@HystrixCommand(fallbackMethod = "metodo_alternativo")
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.getById(id, cantidad);
	}
	
	public Item metodo_alternativo(@PathVariable Long id, @PathVariable Integer cantidad) {
		Item item = new Item();
		item.setCantidad(cantidad);
		Producto producto = new Producto();
		producto.setId(id);
		producto.setNombre("Producto alternativo");
		producto.setPrecio(1.0);
		item.setProducto(producto);
		return item;
	}
	
}
