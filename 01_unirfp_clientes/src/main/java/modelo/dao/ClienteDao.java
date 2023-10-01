package modelo.dao;

import java.util.List;

import modelo.javabeans.Cliente;

public interface ClienteDao {

	Cliente findById(int idCliente);
	List<Cliente> findAll();
	Cliente insert(Cliente cliente);
	int delete(int idCliente);
	
}//End ClienteDao
