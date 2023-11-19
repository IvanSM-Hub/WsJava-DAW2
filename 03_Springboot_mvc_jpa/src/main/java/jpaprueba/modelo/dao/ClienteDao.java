package jpaprueba.modelo.dao;

import java.util.List;

import jpaprueba.modelo.entitybean.Cliente;

public interface ClienteDao {
	
	List<Cliente> buscarTodos();
	Cliente buscarUno(int idCliente);
	Cliente insertOne(Cliente cliente);
	int updateOne(Cliente cliente);
	int deleteOne(int idCliente);
	List<Cliente> buscarPorFacturacionMayorQue(double facturacionAnual);

}
