package cliente.pedido.reository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cliente.pedido.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	@Query("select c from Cliente c")
	public List<Cliente> findAllClientes();
	
	@Query("select c from Cliente c where c.idCliente=?1")
	public Cliente findOneCliente(int idCliente);

}
