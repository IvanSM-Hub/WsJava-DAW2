package cliente.pedido.reository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cliente.pedido.model.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	@Query("select p from Pedido p")
	public List<Pedido> findAllPedidos();
	
	@Query("select p from Pedido p where p.idPedido=?1")
	public Pedido findOnePedido(int idPedido);
	
	@Query("select p from Pedido p where p.comercial.idComercial=?1")
	public List<Pedido> findPedidosPorComercial(int idComercial);
	
}
