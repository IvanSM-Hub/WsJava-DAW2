package restfamilias.service;

import java.util.List;

import restfamilias.modelo.entities.Familia;

public interface FamiliaService {
	
	Familia insertOne(Familia familia);
	Familia updateOne(Familia familia);
	boolean deleteOne(int codigo);
	Familia findOne(int codigo);
	List<Familia> findAll();

}
