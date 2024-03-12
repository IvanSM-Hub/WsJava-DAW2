package restexamen.configuration;

import org.springframework.beans.factory.annotation.Autowired;

import restexamen.repository.EmpleadoEnProyectoRepository;
import restexamen.repository.EmpleadoRepository;
import restexamen.repository.ProyectoRepository;

public class AutowiredRepository {
	
	@Autowired
	protected EmpleadoRepository empleadoRepository;
	
	@Autowired
	protected ProyectoRepository proyectoRepository;
	
	@Autowired
	protected EmpleadoEnProyectoRepository empleadoEnProyectoRepository;

}
