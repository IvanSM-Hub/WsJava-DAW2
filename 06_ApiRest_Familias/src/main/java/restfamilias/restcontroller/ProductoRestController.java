package restfamilias.restcontroller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restfamilias.modelo.dto.ProductoDto;
import restfamilias.modelo.entities.Producto;
import restfamilias.service.FamiliaService;
import restfamilias.service.ProductoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest/productos")
public class ProductoRestController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private FamiliaService familiaService;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping({"/",""})
	public List<Producto> todos() {
		return productoService.findAll();
	}
	
	@GetMapping("/{idProducto}")
	public Producto una(@PathVariable int idProducto) {
		return productoService.findOne(idProducto);
	}
	
	@GetMapping("/color-y-marca/{color}/{marca}")
	public List<Producto> todosColorMarca(
			@PathVariable String color,
			@PathVariable String marca
	){
		return productoService.findByColorMarca(color,marca);
	}
	
	@GetMapping("/por-familia/{idFamilia}")
	public List<Producto> todosFamilia(@PathVariable int idFamilia) {
		return productoService.findByFamilia(idFamilia);
	}
	
	@PostMapping("/")
	public Producto alta(@RequestBody ProductoDto productoDto) {
		Producto producto = new Producto();
		modelMapper.map(productoDto, producto);
//		producto.setColor(productoDto.getColor());
//		producto.setMarca(productoDto.getMarca());
//		producto.setDescripcion(productoDto.getDescripcion());
//		producto.setPrecioUnitario(productoDto.getPrecioUnitario());
		producto.setFamilia(familiaService.findOne(productoDto.getCodigoFamilia()));
		return productoService.insertOne(producto);
	}
	
	@PutMapping("/")
	public Producto modificar(@RequestBody Producto producto) {
		return productoService.updateOne(producto);
	}
	
	@DeleteMapping("/{idProducto}")
	public String eliminar(@PathVariable int idProducto) {
		if (productoService.deleteOne(idProducto))
			return "Producto eliminado correctamente";
		else
			return "Producto no se ha podido eliminar";
	}

}
