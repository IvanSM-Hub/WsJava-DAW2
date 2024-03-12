package restventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restventas.modelo.entity.Comercial;

public interface ComercialRepository extends JpaRepository<Comercial, Integer> {

}
