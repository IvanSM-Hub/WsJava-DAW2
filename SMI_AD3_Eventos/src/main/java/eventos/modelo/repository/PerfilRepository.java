package eventos.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eventos.modelo.entitys.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

}
