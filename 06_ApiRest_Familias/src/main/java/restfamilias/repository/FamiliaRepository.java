package restfamilias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import restfamilias.modelo.entities.Familia;

public interface FamiliaRepository extends JpaRepository<Familia, Integer> {

}
