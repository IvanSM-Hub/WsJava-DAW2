package restexamen.restcontroller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restexamen.configuration.AutowiredController;
import restexamen.model.entity.Empleado;

@RestController
@RequestMapping("/empleados")
public class EmpleadoRestController extends AutowiredController {

	@GetMapping({"/",""})
	public List<Empleado> showAll() {
		return empleadoService.findAll();
	}
	
	@GetMapping("/buscar/{idEmpleado}")
	public ResponseEntity<?> findEmpleado(@PathVariable int idEmpleado) {
		try {
			Empleado empleado = empleadoService.findOne(idEmpleado);
			if(empleado!=null)
				return ResponseEntity.status(200).body(empleado);
			else
				return ResponseEntity.status(400).body("El empleado no existe");
		} catch (Exception e) {
			return ResponseEntity.status(404).body("Error del servidor al buscar el Empleado");
		}
	}
		
	@PostMapping("/alta")
	public ResponseEntity<?> insertEmpleado(@RequestBody Empleado empleado) {
		if(empleadoService.findOne(empleado.getIdEmpleado())!=null)
			return ResponseEntity.status(400).body("El empleado ya existe");
		else
			return ResponseEntity.status(201).body(empleadoService.insertOne(empleado));
	}
	
	@PutMapping("/modificar/{idEmpleado}")
	public ResponseEntity<?> modifyEmpleado(@RequestBody Empleado empleado,@PathVariable int idEmpleado) {
		Empleado empleadoMod = empleadoService.findOne(idEmpleado);
		if(empleadoMod!=null) {
			empleadoMod.setNombre(empleado.getNombre());
			empleadoMod.setEmail(empleado.getEmail());
			empleadoMod.setCategoria(empleado.getCategoria());
			empleadoMod.setSueldo(empleado.getSueldo());
			if(empleadoService.updateOne(empleadoMod)!=null)
				return ResponseEntity.status(200).body(empleadoMod);
			else
				return ResponseEntity.status(400).body("No ha sido posible modificar el Empleado");
		} else 
			return ResponseEntity.status(400).body("El empleado no existe");
	}
	
	@DeleteMapping("/eliminar/{idEmpleado}")
	public ResponseEntity<?> deleteEmpleado(@PathVariable int idEmpleado) {
		int statusDelete = empleadoService.deleteOne(idEmpleado);
		switch (statusDelete) {
			case 1: 
				return ResponseEntity.status(200).body("El empleado se ha borrado correctamente");
			case 0:
				return ResponseEntity.status(404).body("El empleado no existe");
			case -1:
				return ResponseEntity.status(400).body("El servidor tuvo un problema al borrar el empleado");
		}
		return null;
	}
	
}
