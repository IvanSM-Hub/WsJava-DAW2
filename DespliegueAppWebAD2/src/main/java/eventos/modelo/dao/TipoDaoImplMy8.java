package eventos.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eventos.modelo.entitys.Tipo;
import eventos.modelo.repository.TipoRepository;

@Repository
public class TipoDaoImplMy8 implements TipoDao {
	
	@Autowired
	private TipoRepository tipoRepository;

	/**
	 * Registra un nuevo tipo en la base de datos.
	 *
	 * @param Tipo tipo
	 * @return Tipo tipo
	 */
	@Override
	public Tipo registrarTipo(Tipo tipo) {
		return tipoRepository.save(tipo);
	}

	/**
	 * Modifica la información de un tipo existente en la base de datos.
	 *
	 * @param Tipo tipo
	 * @return Tipo tipo
	 */
	@Override
	public Tipo modificarTipo(Tipo tipo) {
		return tipoRepository.save(tipo);
	}

	/**
	 * Busca un tipo por su ID en la base de datos.
	 *
	 * @param Tipo tipo
	 * @return Tipo tipo
	 */
	@Override
	public Tipo buscarTipo(Tipo tipo) {
		return tipoRepository.findById(tipo.getIdTipo()).orElse(null);
	}

	/**
	 * Busca todos los tipos de eventos disponibles en la base de datos.
	 *
	 * @return List<Tipo>
	 */
	@Override
	public List<Tipo> buscarTodosTipo() {
		return tipoRepository.findAll();
	}

}
