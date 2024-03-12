package restexamen.service;

import java.util.List;

import restexamen.model.entity.Proyecto;

public interface ProyectoService {

	Proyecto findOne(int idProyecto);
	Proyecto insertOne(Proyecto proyecto);
	Proyecto updateOne(Proyecto proyecto);
	int deleteOne(int idProyecto);
	List<Proyecto> findAll();
	
}
