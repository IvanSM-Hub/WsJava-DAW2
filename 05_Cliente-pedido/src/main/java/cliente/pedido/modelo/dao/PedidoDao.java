package cliente.pedido.modelo.dao;

import java.util.List;

import cliente.pedido.model.entity.Pedido;

public interface PedidoDao {
	
	List<Pedido> buscarTodosPedidos();
	List<Pedido> buscarPedidosPorComercial(int idComercial);
	Pedido buscarUnPedido(int idPedido);

}
