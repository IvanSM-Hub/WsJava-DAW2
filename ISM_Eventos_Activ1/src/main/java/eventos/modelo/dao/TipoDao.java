package eventos.modelo.dao;

import java.util.List;

import eventos.modelo.javabean.Tipo;

public interface TipoDao {

	int finById(int idTipo);
	List<Tipo> findAll();
	
}
