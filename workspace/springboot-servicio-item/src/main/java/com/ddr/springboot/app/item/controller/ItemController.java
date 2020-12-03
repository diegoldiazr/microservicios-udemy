package com.ddr.springboot.app.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ddr.springboot.app.item.model.Item;
import com.ddr.springboot.app.item.service.IItemService;


@RestController
public class ItemController {

	@Autowired
	private IItemService itemService;
	
	@GetMapping("/listar")
	public List<Item>  findAll(){
		return itemService.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.getById(id, cantidad);
	}
}
