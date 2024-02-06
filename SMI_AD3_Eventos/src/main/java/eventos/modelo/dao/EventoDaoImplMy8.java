package eventos.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eventos.modelo.entitys.Evento;
import eventos.modelo.repository.EventoRepository;

@Repository
public class EventoDaoImplMy8 implements EventoDao {
	
	@Autowired
	private EventoRepository eventoRepository;

	@Override
	public Evento altaEvento(Evento evento) {
		
		try {
			return eventoRepository.save(evento);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		
	}

	@Override
	public Evento editarEvento(Evento evento) {
		
		try {
			return eventoRepository.save(evento);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		
	}

	@Override
	public Evento eliminarEvento(Evento evento) {
		
		try {
			eventoRepository.delete(evento);
			return evento;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		
	}

	@Override
	public Evento buscarEvento(int idEvento) {
		
		return eventoRepository.findById(idEvento).orElse(null);

	}

	@Override
	public List<Evento> eventosActivos() {
		return eventoRepository.findEventoPorEstado("activo");
	}

	@Override
	public List<Evento> eventosDestacados() {
		return eventoRepository.findEventoDestacado();
	}
	
	@Override
	public List<Evento> eventosActivosDestacados() {
		return eventoRepository.findEventoEstadoDestacado();
	}

	@Override
	public List<Evento> eventosTipo(int idTipo) {
		return eventoRepository.findEventoTipo(idTipo);
	}

}
