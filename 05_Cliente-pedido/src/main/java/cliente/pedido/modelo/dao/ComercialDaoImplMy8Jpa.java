package cliente.pedido.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cliente.pedido.model.entity.Comercial;
import cliente.pedido.reository.ComercialRepository;

@Repository
public class ComercialDaoImplMy8Jpa implements ComercialDao {

	@Autowired
	private ComercialRepository comrepo;

	@Override
	public List<Comercial> buscarTodosComerciales() {
		return comrepo.findAllComercial();
	}

	@Override
	public Comercial buscarUnComercial(int idComercial) {
		return comrepo.findOneComercial(idComercial);
	}

	@Override
	public boolean insertarComercial(Comercial comercial) {
		comrepo.save(comercial);
		return true;
	}

	@Override
	public boolean eliminarComercial(int idComercial) {
		Comercial comercial = comrepo.findOneComercial(idComercial);
		comrepo.delete(comercial);
		return true;
	}
	
}
