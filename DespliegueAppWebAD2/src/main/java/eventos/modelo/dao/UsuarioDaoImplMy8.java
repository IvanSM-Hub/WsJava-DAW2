package eventos.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eventos.modelo.entitys.Usuario;
import eventos.modelo.repository.UsuarioRepository;

@Repository
public class UsuarioDaoImplMy8 implements UsuarioDao {
	
	@Autowired
	private UsuarioRepository usuRepo;
	
	/**
	 * Método que busca y devuelve el usuario que buscamos, sino lo encuentra devuelve null.
	 * 
	 * @param String username
	 * @return Usuario
	 */
	@Override
	public Usuario findById(String username) {
		return usuRepo.findById(username).orElse(null);
	}

	/**
	 * Mediante este método, podemos dar de alta un usuario que se nos pasa como atributo y lanzamos un .save() contra la base de datos, salvando dicho usuario.
	 * Si el usuario existe, nos retornará false y si no existe este usuario nos devolverá un true.
	 * 
	 * @param Usuario usuario
	 * @return boolean
	 */
	@Override
	public boolean registro(Usuario usuario) {
		if (findById(usuario.getUsername())==null) {
			usuRepo.save(usuario);
			return true;
		}
			
		return false;
	}

}
