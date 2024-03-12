package restventas.service;

import java.util.List;

import restventas.modelo.entity.Comercial;
import restventas.modelo.entity.Pedido;

public interface PedidoService {
	
	List<Comercial> findComercialesPedidosByCliente(int idCliente);
	List<Comercial> findComercialesByPedidos();
	List<Pedido> findPedidosByComercial(int idComercial);

}
