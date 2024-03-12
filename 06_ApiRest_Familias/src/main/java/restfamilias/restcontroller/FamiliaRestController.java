package restfamilias.restcontroller;

import java.util.List;

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

import restfamilias.modelo.entities.Familia;
import restfamilias.service.FamiliaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest/familias")
public class FamiliaRestController {
	
	@Autowired
	private FamiliaService familiaService;
	
	@GetMapping({"/",""})
	public List<Familia> todas() {
		return familiaService.findAll();
	}
	
	@GetMapping("/{idFamilia}")
	public Familia una(@PathVariable int idFamilia) {
		return familiaService.findOne(idFamilia);
	}
	
	@PostMapping("/")
	public Familia alta(@RequestBody Familia familia) {
		return familiaService.insertOne(familia);
	}
	
	@PutMapping("/")
	public Familia modificar(@RequestBody Familia familia) {
		return familiaService.updateOne(familia);
	}
	
	@DeleteMapping("/{idFamilia}")
	public String eliminar(@PathVariable int idFamilia) {
		if (familiaService.deleteOne(idFamilia))
			return "Familia eliminada correctamente";
		else
			return "Familia no se ha podido eliminar";
		
	}

}
