package eventos.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eventos.modelo.entitys.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	
	

}
