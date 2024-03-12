package eventos.modelo.dao;

import java.util.List;

import eventos.modelo.entitys.Evento;

public interface EventoDao {
	
	Evento altaEvento (Evento evento);
	Evento editarEvento (Evento evento);
	Evento eliminarEvento (Evento evento);
	Evento buscarEvento (int idEvento);
	List<Evento>eventosActivos();
	List<Evento>eventosDestacados();
	List<Evento>eventosActivosDestacados();
	List<Evento>eventosTipo(int idTipo);

}
