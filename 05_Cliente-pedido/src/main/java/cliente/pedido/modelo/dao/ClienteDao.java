package cliente.pedido.modelo.dao;

import java.util.List;

import cliente.pedido.model.entity.Cliente;

public interface ClienteDao {
	
	List<Cliente> buscarTodosClientes();
	Cliente buscarUnCliente(int idCliente);

}
