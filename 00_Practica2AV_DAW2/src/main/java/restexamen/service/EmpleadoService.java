package restexamen.service;

import java.util.List;

import restexamen.model.entity.Empleado;

public interface EmpleadoService {
	
	Empleado findOne(int idEmpleado);
	Empleado insertOne(Empleado empleado);
	Empleado updateOne(Empleado empleado);
	int deleteOne(int idEmpleado);
	List<Empleado> findAll();

}
