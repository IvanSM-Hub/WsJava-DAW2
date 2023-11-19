package unir.familias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import unir.familias.modelo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	@Query("select u from Usuario u where u.username=?1 and u.password=?2")
	public Usuario usuarioPorUsernameAndPassword(String usuername , String password);
	
	//public Usuario findByUsernameAndPassword(String usuername , String password);
	
}
