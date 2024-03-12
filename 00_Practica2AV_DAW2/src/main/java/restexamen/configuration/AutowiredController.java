package restexamen.configuration;

import org.springframework.beans.factory.annotation.Autowired;

import restexamen.service.EmpleadoService;
import restexamen.service.ProyectoService;

public class AutowiredController {
	
	@Autowired
	protected EmpleadoService empleadoService;
	
	@Autowired
	protected ProyectoService proyectoService;

}
