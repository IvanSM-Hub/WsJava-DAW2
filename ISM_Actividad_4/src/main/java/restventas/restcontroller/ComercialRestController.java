package restventas.restcontroller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restventas.modelo.entity.Comercial;

@RestController
@RequestMapping("/comercial")
public class ComercialRestController extends AutowiredController {
	
	@GetMapping("/uno/{idComercial}")
	public Comercial unComercial(@PathVariable int idComercial) {
		return comercialService.findOne(idComercial);
	}
	
	@PostMapping("/alta")
	public Comercial altaComercial(@RequestBody Comercial comercial) {
		return comercialService.insert(comercial);
	}
	
	@DeleteMapping("/eliminar/{idComercial}")
	public String eliminarComercial(@PathVariable int idComercial) {
		int statusDelete = comercialService.delete(idComercial);
		switch (statusDelete) {
			case -1: 
				return "El Comercial no se ha podido eliminar por error en el servidor";
			case 0: 
				return "El comercial no se ha eliminado porque no existe";
			case 1: 
				return "El Comercial se ha eliminado correctamente";
			default:
				return "No es posible eliminar el Comercial";
		}
	}

}
