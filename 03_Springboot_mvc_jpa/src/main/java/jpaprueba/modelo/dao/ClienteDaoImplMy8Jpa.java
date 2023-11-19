package jpaprueba.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jpaprueba.modelo.entitybean.Cliente;
import jpaprueba.repository.ClienteRepository;

@Repository
public class ClienteDaoImplMy8Jpa implements ClienteDao {

	@Autowired
	private ClienteRepository cRepo;

	@Override
	public List<Cliente> buscarTodos() {
		return cRepo.findAll();
	}

	@Override
	public Cliente buscarUno(int idCliente) {
		return cRepo.findById(idCliente).orElse(null);
	}

	@Override
	public Cliente insertOne(Cliente cliente) {
		try {
			return cRepo.save(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateOne(Cliente cliente) {
		if (buscarUno(cliente.getIdCliente())!=null) {
			cRepo.save(cliente);
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public int deleteOne(int idCliente) {
		if (buscarUno(idCliente)!=null) {
			cRepo.deleteById(idCliente);
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public List<Cliente> buscarPorFacturacionMayorQue(double facturacionAnual) {
		return cRepo.findFacturMayor(facturacionAnual);
	}
	
	
}//End ClienteDaoImplMy8Jpa
