package com.ddr.springboot.app.producto.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ddr.springboot.app.producto.models.dao.IProductoDao;
import com.ddr.springboot.app.producto.models.entity.Producto;

@Service
public class ProductoService implements IProductoService {
	
	@Autowired
	private IProductoDao productoDao;

	@Override
	@Transactional(readOnly=true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional()
	public Producto save(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	@Transactional()
	public void deleteById(Long id) {
		productoDao.deleteById(id);
		
	}

	@Override
	public Producto editar(Long id, Producto producto) {
		Producto original = findById(id);
		original.setNombre(producto.getNombre());
		original.setPrecio(producto.getPrecio());
		original.setPort(producto.getPort());
		return save(original);
	}

}
