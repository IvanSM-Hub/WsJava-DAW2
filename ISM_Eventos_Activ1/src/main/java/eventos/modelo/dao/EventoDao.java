package eventos.modelo.dao;

import java.util.List;

import eventos.modelo.javabean.Evento;

public interface EventoDao {

	int findById(int idEvento);
	List<Evento> findAll();
	int insert(Evento evento);
	int delete(int idEvento);
	int updateOne(int idEvento);
	
}
