package cliente.pedido.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cliente.pedido.model.entity.Cliente;
import cliente.pedido.reository.ClienteRepository;

@Repository
public class ClienteDaoImplMy8Jpa implements ClienteDao {

	@Autowired
	private ClienteRepository clirepo;

	@Override
	public List<Cliente> buscarTodosClientes() {
		return clirepo.findAllClientes();
	}

	@Override
	public Cliente buscarUnCliente(int idCliente) {
		return clirepo.findOneCliente(idCliente);
	}

}
