package cliente.pedido.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cliente.pedido.model.entity.Pedido;
import cliente.pedido.reository.PedidoRepository;

@Repository
public class PedidoDaoImplMy8Jpa implements PedidoDao {
	
	@Autowired
	private PedidoRepository pedrepo;

	@Override
	public List<Pedido> buscarTodosPedidos() {
		return pedrepo.findAllPedidos();
	}

	@Override
	public Pedido buscarUnPedido(int idPedido) {
		return pedrepo.findOnePedido(idPedido);
	}

	@Override
	public List<Pedido> buscarPedidosPorComercial(int idComercial) {
		return pedrepo.findPedidosPorComercial(idComercial);
	}
	
	

}
