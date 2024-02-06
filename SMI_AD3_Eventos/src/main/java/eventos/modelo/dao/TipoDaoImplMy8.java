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

	@Override
	public Tipo registrarTipo(Tipo tipo) {
		return tipoRepository.save(tipo);
	}

	@Override
	public Tipo modificarTipo(Tipo tipo) {
		return tipoRepository.save(tipo);
	}

	@Override
	public Tipo buscarTipo(Tipo tipo) {
		return tipoRepository.findById(tipo.getIdTipo()).orElse(null);
	}

	@Override
	public List<Tipo> buscarTodosTipo() {
		return tipoRepository.findAll();
	}

}
