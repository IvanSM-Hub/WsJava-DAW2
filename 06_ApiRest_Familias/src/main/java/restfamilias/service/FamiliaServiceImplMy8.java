package restfamilias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restfamilias.modelo.entities.Familia;
import restfamilias.repository.FamiliaRepository;

@Service
public class FamiliaServiceImplMy8 implements FamiliaService {

	@Autowired
	private FamiliaRepository familiaRepository;
	
	@Override
	public Familia insertOne(Familia familia) {
		return familiaRepository.save(familia);
	}

	@Override
	public Familia updateOne(Familia familia) {
		try {
			return familiaRepository.save(familia);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public boolean deleteOne(int idFamilia) {
		try {
			if(findOne(idFamilia)!=null) {
				familiaRepository.deleteById(idFamilia);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Familia findOne(int idFamilia) {
		return familiaRepository.findById(idFamilia).orElse(null);
	}

	@Override
	public List<Familia> findAll() {
		return familiaRepository.findAll();
	}

}
