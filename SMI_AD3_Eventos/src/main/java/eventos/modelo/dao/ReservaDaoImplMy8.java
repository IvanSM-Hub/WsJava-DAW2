package eventos.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eventos.modelo.entitys.Reserva;
import eventos.modelo.repository.ReservaRepository;

@Repository
public class ReservaDaoImplMy8 implements ReservaDao {
	
	@Autowired
	private ReservaRepository reservaRepository;

	/**
	 * Devuelve la cantidad de reservas para un evento específico identificado por su ID.
	 *
	 * @param idEvento
	 * @return int cantidad || 0
	 */
	@Override
	public int cantidadReservasEvento(int idEvento) {
		try {
			return reservaRepository.findCantidadReservas(idEvento);
		} catch (Exception e) {
			return 0;
		}
	}
	
	/**
	 * Realiza una reserva para un evento.
	 *
	 * @param Reserva reserva.
	 * @return El objeto de reserva que se ha guardado en el repositorio.
	 */
	@Override
	public Reserva realizarReservaEvento(Reserva reserva) {
		return reservaRepository.save(reserva);
	}
	
	/**
	 * Busca la reserva de un usuario para un evento específico.
	 *
	 * @param int idEvento
	 * @param String username
	 * @return cantidad || 0.
	 */
	@Override
	public int buscarReservaEventoUsuario(int idEvento, String username) {
		try {
			return reservaRepository.findReservaEventoUsuario(idEvento, username).getCantidad();
		} catch (Exception e) {
			return 0;
		}
	}
	
	/**
	 * Busca todas las reservas asociadas a un usuario específico.
	 *
	 * @param String username
	 * @return List<Reserva> || null
	 */
	@Override
	public List<Reserva> buscarReservasUsuario(String username) {
		try {
			return reservaRepository.findReservasUsuario(username);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Elimina una reserva específica.
	 *
	 * @param Reserva reserva
	 * @return Reserva reserva || null.
	 */
	@Override
	public Reserva eliminarReserva(Reserva reserva) {
		try {
			reservaRepository.delete(reserva);
			return reserva;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Busca una reserva por su ID.
	 *
	 * @param int idReserva
	 * @return Reserva reserva || null.
	 */
	@Override
	public Reserva buscarReservaId(int idReserva) {
		return reservaRepository.findById(idReserva).orElse(null);
	}

	/**
	 * Devuelve la cantidad de reservas de un usuario para un evento específico.
	 *
	 * @param int idEvento
	 * @param String username
	 * @return cantidad || 0.
	 */
	@Override
	public int canitdadReservasUsuario(int idEvento, String username) {
		try {
			return reservaRepository.findCantidadReservasUsuario(idEvento, username);
		} catch (Exception e) {
			return 0;
		}
	}

}
