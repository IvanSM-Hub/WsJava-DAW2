package eventos.modelo.dao;

import java.util.List;

import eventos.modelo.entitys.Tipo;

public interface TipoDao {
	
	Tipo registrarTipo(Tipo tipo);
	Tipo modificarTipo(Tipo tipo);
	Tipo buscarTipo(Tipo tipo);
	List<Tipo> buscarTodosTipo();

}
