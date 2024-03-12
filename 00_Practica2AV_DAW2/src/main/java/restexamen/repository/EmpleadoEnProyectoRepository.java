package restexamen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import restexamen.model.entity.EmpleadoEnProyecto;

@Repository
public interface EmpleadoEnProyectoRepository extends JpaRepository<EmpleadoEnProyecto, Integer>{

}
