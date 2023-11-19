package unir.familias.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.familias.modelo.entity.Familia;
import unir.familias.repository.FamiliaRepository;

@Repository
public class FamiliaDaoImplMy8Jpa implements FamiliaDao {
	
	@Autowired
	private FamiliaRepository frepo;

	@Override
	public Familia buscarUna(int idFamilia) {
		return frepo.findById(idFamilia).orElse(null);
	}

	@Override
	public List<Familia> todas() {
		return frepo.findAll();
	}

}
