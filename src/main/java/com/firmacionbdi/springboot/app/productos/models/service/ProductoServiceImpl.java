package com.firmacionbdi.springboot.app.productos.models.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firmacionbdi.springboot.app.productos.models.dao.ProductoDao;
import com.firmacionbdi.springboot.app.commons.models.entity.Producto;


@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	ProductoDao productoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	public Producto findById(Long idProducto) {
		return productoDao.findById(idProducto).orElse(null);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	@Transactional
	public void deleteById(Long idProducto) {
		productoDao.deleteById(idProducto);
	}

}
