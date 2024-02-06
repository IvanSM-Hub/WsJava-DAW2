package eventos.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eventos.modelo.repository.ReservaRepository;

@Repository
public class ReservaDaoImplMy8 implements ReservaDao {
	
	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	public int cantidadReservasEvento(int idEvento) {
		
		try {
			return reservaRepository.findCantidadReservas(idEvento);
		} catch (Exception e) {
			return 0;
		}

	}

}
