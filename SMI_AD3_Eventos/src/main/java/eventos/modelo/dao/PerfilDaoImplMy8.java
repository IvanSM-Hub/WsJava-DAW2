package eventos.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eventos.modelo.entitys.Perfil;
import eventos.modelo.repository.PerfilRepository;

@Repository
public class PerfilDaoImplMy8 implements PerfilDao {
	
	@Autowired
	private PerfilRepository perrepo;

	/**
	 * Busca un perfil por su ID en la base de datos.
	 *
	 * @param int idPerfil
	 * @return Perfil perfil || null
	 */
	@Override
	public Perfil findById(int idPerfil) {
		return perrepo.findById(idPerfil).orElse(null);
	}

}
