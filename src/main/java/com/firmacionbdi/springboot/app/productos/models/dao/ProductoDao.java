package com.firmacionbdi.springboot.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.firmacionbdi.springboot.app.commons.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{

}
