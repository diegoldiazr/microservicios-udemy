package com.ddr.springboot.app.item.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ddr.springboot.app.item.model.Item;
import com.ddr.springboot.app.item.model.Producto;

@Service
public class ItemService implements IItemService {
	
	@Autowired
	private RestTemplate clienteRest;
	
	private String URL_LISTAR = "http://localhost:8001/listar";
	private String URL_VER = "http://localhost:8001/ver/{id}";

	@Override
	public List<Item> findAll() {
		List<Producto> productos = Arrays.asList(clienteRest.getForObject(URL_LISTAR,Producto[].class));
		return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item getById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Producto producto = clienteRest.getForObject(URL_VER, Producto.class, pathVariables);
		return new Item(producto, cantidad);
	}

}
