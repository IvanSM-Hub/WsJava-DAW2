package unir.familias.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import unir.familias.modelo.dao.ProductoDao;
import unir.familias.modelo.entity.Producto;

@RestController
public class ProductoRestController {
	
	@Autowired
	private ProductoDao pdao;

	@GetMapping("/todos")
	public List<Producto> todos(){
		return pdao.todos();
	}
	
	@GetMapping("/unProducto/{idProducto}")
	public Producto unProducto(@PathVariable int idProducto) {
		return pdao.buscarUno(idProducto);
	}
	
	@GetMapping("/porFamilia/{idFamilia}")
	public List<Producto> porFamilia(@PathVariable int idFamilia) {
		return pdao.buscarProductosPorFamilia(idFamilia);
	}
	
	@PostMapping("/alta")
	public Producto alta(@RequestBody Producto producto) {
		return pdao.insertOne(producto);
	}
	
}
