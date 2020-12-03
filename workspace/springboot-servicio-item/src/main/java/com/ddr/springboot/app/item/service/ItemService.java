package com.ddr.springboot.app.item.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ddr.springboot.app.item.model.Item;

@Service
public class ItemService implements IItemService {
	
	@Autowired
	private RestTemplate clienteRest;

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getById(Long id, Integer cantidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
