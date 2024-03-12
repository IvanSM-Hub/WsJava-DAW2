package restventas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import restventas.modelo.entity.Comercial;
import restventas.modelo.entity.Pedido;

@Service
public class PedidoServiceImplMy8 extends AutowiredRepository implements PedidoService {
	
	/**
	 * Método que nos devolverá una lista de los comerciales que han atendido pedidos del cliente que coincida con ese id.
	 * @param int idCliente
	 * @return List<Comercial>
	 */
	@Override
	public List<Comercial> findComercialesPedidosByCliente(int idCliente) {
		return pedidoRepository.findComercialesPedidosByCliente(idCliente);
	}
	
	/**
	 * Método que nos devolverá una lista de comerciales que han atendido algún pedido.
	 * @return List<Comercial>
	 */
	@Override
	public List<Comercial> findComercialesByPedidos() {
		return pedidoRepository.findComercialesByPedidos();			
	}

	/**
	 * Método que nos devolverá una lista de pedidos gestionados por el comercial que coincida con ese id.
	 * @param int idComercial
	 * @return List<Pedido>
	 */
	@Override
	public List<Pedido> findPedidosByComercial(int idComercial) {
		return pedidoRepository.findPedidosByComercial(idComercial);
	}

}
