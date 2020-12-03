package com.ddr.springboot.app.item.service;

import java.util.List;

import com.ddr.springboot.app.item.model.Item;

public interface IItemService {
	
	public List<Item> findAll();
	public Item getById(Long id, Integer cantidad);

}
