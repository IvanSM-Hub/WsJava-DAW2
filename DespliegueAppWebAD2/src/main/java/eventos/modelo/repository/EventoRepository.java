package eventos.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import eventos.modelo.entitys.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer> {
	
	@Query("select e from Evento e where e.estado=?1")
	public List <Evento> findEventoPorEstado(String estado);
	
	@Query("select e from Evento e where e.destacado='S'")
	public List <Evento> findEventoDestacado();
	
	@Query("select e from Evento e where e.destacado='S' and e.estado='ACTIVO'")
	public List <Evento> findEventoEstadoDestacado();
	
	@Query("select e from Evento e where e.tipo.idTipo=?1")
	public List <Evento> findEventoTipo(int idTipo);

}
