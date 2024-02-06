package eventos.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import eventos.modelo.entitys.Reserva;

public interface ReservaRepository extends JpaRepository <Reserva, Integer> {
	
	@Query("select r.cantidad from Reserva r where r.evento.idEvento=?1")
	public int findCantidadReservas (int idEvento);

}
