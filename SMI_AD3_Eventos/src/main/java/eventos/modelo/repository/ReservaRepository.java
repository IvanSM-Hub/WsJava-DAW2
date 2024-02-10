package eventos.modelo.repository;

import java.util.List;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import eventos.modelo.entitys.Reserva;

public interface ReservaRepository extends JpaRepository <Reserva, Integer> {
	
	@Query("select sum(r.cantidad) from Reserva r where r.evento.idEvento=?1")
	public int findCantidadReservas (int idEvento);
	
	@Query("select sum(r.cantidad) from Reserva r where r.evento.idEvento=?1 and r.usuario.username=?2")
	public int findCantidadReservasUsuario (int idEvento,String username);
	
	@Query("select r from Reserva r where r.usuario.username=?1")
	public List<Reserva> findReservasUsuario (String username);
	
	@Query("select r from Reserva r where r.evento.idEvento=?1 and r.usuario.username=?2")
	public Reserva findReservaEventoUsuario (int idEvento , String username);

}
