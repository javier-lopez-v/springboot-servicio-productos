package com.firmacionbdi.springboot.app.productos.controllers;



import com.twilio.Twilio; 
import com.twilio.rest.api.v2010.account.Message; 

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.firmacionbdi.springboot.app.commons.models.entity.Producto;
import com.firmacionbdi.springboot.app.productos.models.service.IProductoService;

@RestController
public class ProductoController {
	
//	@Autowired
//	private Environment env;
	
    public static final String ACCOUNT_SID = "AC9cd27e5fee2f7d93d5374874ddf88964";
    public static final String AUTH_TOKEN = "3396fcf706ae84654b8f6c435bda0ac9";
	
	@Value("${server.port}")
	private Integer port;

	@Autowired
	public IProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> productos(){
		System.out.println("---------------------------------------------------------------------------------------->>>");

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
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crearProducto(@RequestBody Producto producto) {
		return productoService.save(producto);
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editarProducto(@RequestBody Producto producto, @PathVariable(value = "id") Long idProducto) {
		
		Producto productoDb = productoService.findById(idProducto);
		
		productoDb.setNombre(producto.getNombre());
		productoDb.setPrecio(producto.getPrecio());
	
		return productoService.save(productoDb);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarProducto(@PathVariable(value ="id" ) Long idProducto) {
		productoService.deleteById(idProducto);
	}
	
	@GetMapping("/enviarWhatapp")
	public void enviarWhatApp() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        
       // Message.cre
        
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+5217122253943"), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"), 
                "¡¡¡¡Hola Jorge…!!!!")
                .create();
        Message message2 = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+5217122253943"), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"), 
                "Como estas Jorge")
                .create();
        Message message3 = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+5217122253943"), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"), 
                "jajajajajaja")
                .create();
        Message message4 = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+5217122253943"), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"), 
                "estas dormido ?")
                .create();
        Message message5 = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+5217122253943"), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"), 
                "creo que si ")
                .create();
        Message message6 = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+5217122253943"), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"), 
                "hatas Mañana")
                .create();
        Message message7 = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+5217122253943"), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"), 
                "Jorge…!")
                .create();
        Message message8 = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+5217122253943"), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"), 
                "jajajajajaja")
                .create();
        System.out.println(message.getSid());
        System.out.println(message2.getSid());
        System.out.println(message3.getSid());
        System.out.println(message4.getSid());
        System.out.println(message5.getSid());
        System.out.println(message6.getSid());
        System.out.println(message7.getSid());
        System.out.println(message8.getSid());

	}
}
