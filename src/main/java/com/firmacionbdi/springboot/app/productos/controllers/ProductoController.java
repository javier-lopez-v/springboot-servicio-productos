package com.firmacionbdi.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.firmacionbdi.springboot.app.productos.models.entity.Producto;
import com.firmacionbdi.springboot.app.productos.models.service.IProductoService;

@RestController
public class ProductoController {
	
//	@Autowired
//	private Environment env;
	
	@Value("${server.port}")
	private Integer port;

	@Autowired
	public IProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> productos(){
		return productoService.findAll().stream().map(producto ->{
			//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			producto.setPort(port);

			return producto;
		}).collect(Collectors.toList());
	}
	@GetMapping("/producto/{id}")
	public Producto producto(@PathVariable(value = "id")Long idProducto)  {
		Producto producto = productoService.findById(idProducto);
		//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		producto.setPort(port);
		
//		try {
//			Thread.sleep(2000L);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		/* 
		 * ejemplo de github
		 * generando commit desde eclipse
		 * */
		

		/* 
		 *hola 
		 *ejemplo de github
		 * generando commit desde github
		 * */
		
//		boolean ok = false;
//		if(!ok) {
//			throw new Exception("no se pudo iniciar el servicio ");
//		}
		return producto;
	}
}
