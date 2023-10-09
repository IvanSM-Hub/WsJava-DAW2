package net.unir.clientes.modelo.dao;

import java.util.List;

import net.unir.clientes.modelo.javabean.Cliente;

public interface ClienteDao {

	Cliente findById(int idCliente);
	List<Cliente> findAll();
	Cliente insert(Cliente cliente);
	int delete(int idCliente);
	
}//End ClienteDao
