package eventos.modelo.dao;

import java.util.List;

import eventos.modelo.entitys.Reserva;

public interface ReservaDao {
	
	int cantidadReservasEvento(int idEvento);
	int canitdadReservasUsuario(int idEvento , String username);
	Reserva realizarReservaEvento(Reserva reserva);
	Reserva buscarReservaId(int idReserva);
	List<Reserva> buscarReservasUsuario(String username);
	int buscarReservaEventoUsuario(int idEvento , String username);
	Reserva eliminarReserva (Reserva reserva);

}
