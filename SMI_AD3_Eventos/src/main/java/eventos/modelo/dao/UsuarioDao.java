package eventos.modelo.dao;

import eventos.modelo.entitys.Usuario;

public interface UsuarioDao {
	
	Usuario findById(String username);
	boolean registro(Usuario usuario);

}
