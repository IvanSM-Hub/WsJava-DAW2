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

	/**
	 * Guarda un nuevo evento en la base de datos.
	 *
	 * @param Evento evento
	 * @return Evento evento || null
	 */
	@Override
	public Evento altaEvento(Evento evento) {
		try {
			return eventoRepository.save(evento);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	/**
	 * Actualiza la información de un evento existente en la base de datos.
	 *
	 * @param Evento evento
	 * @return Evento evento|| null
	 */
	@Override
	public Evento editarEvento(Evento evento) {
		try {
			return eventoRepository.save(evento);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	/**
	 * Elimina un evento de la base de datos.
	 *
	 * @param Evento evento
	 * @return Evento evento || null
	 */
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

	/**
	 * Busca un evento por su ID.
	 *
	 * @param int idEvento
	 * @return Evento evento || null
	 */
	@Override
	public Evento buscarEvento(int idEvento) {
		return eventoRepository.findById(idEvento).orElse(null);
	}

	/**
	 * Devuelve una lista de todos los eventos que están activos.
	 *
	 * @return List<Evento>
	 */
	@Override
	public List<Evento> eventosActivos() {
		return eventoRepository.findEventoPorEstado("activo");
	}

	/**
	 * Devuelve una lista de todos los eventos que están marcados como destacados.
	 *
	 * @return List<Evento>
	 */
	@Override
	public List<Evento> eventosDestacados() {
		return eventoRepository.findEventoDestacado();
	}
	
	/**
	 * Devuelve una lista de todos los eventos que están activos y destacados.
	 *
	 * @return List<Evento>
	 */
	@Override
	public List<Evento> eventosActivosDestacados() {
		return eventoRepository.findEventoEstadoDestacado();
	}

	/**
	 * Devuelve una lista de eventos que pertenecen a un tipo específico.
	 *
	 * @param int idTipo
	 * @return List<Evento>
	 */
	@Override
	public List<Evento> eventosTipo(int idTipo) {
		return eventoRepository.findEventoTipo(idTipo);
	}

}
