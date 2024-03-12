package restventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import restventas.modelo.entity.Comercial;
import restventas.modelo.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	@Query("select p.comercial from Pedido p where p.cliente.idCliente=?1")
	public List<Comercial> findComercialesPedidosByCliente(int idCliente);
	
	@Query("select p.comercial from Pedido p")
	public List<Comercial> findComercialesByPedidos();
	
	@Query("select p from Pedido p where p.comercial.idComercial=?1")
	public List<Pedido> findPedidosByComercial(int idComercial);
}
