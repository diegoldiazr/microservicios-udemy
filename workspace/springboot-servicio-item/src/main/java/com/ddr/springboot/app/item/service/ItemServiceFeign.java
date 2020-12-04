package com.ddr.springboot.app.item.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddr.springboot.app.item.clientes.IProductoClienteRest;
import com.ddr.springboot.app.item.model.Item;

@Service("ItemServiceFeign")
public class ItemServiceFeign implements IItemService {
	
	@Autowired
	private IProductoClienteRest clienteFeign;

	@Override
	public List<Item> findAll() {
		return clienteFeign.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item getById(Long id, Integer cantidad) {
		return new Item(clienteFeign.detalle(id), cantidad);
	}

}
