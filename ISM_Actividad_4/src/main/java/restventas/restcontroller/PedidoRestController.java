package restventas.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restventas.modelo.entity.Comercial;
import restventas.modelo.entity.Pedido;

@RestController
@RequestMapping("/comercial")
public class PedidoRestController extends AutowiredController {
	
	/**
	 * Gestiona las peticiones GetMapping de "/bycliente/{idCliente}" en la cual se le pasa el idCliente, devolviendonos una lista de los comerciales con pedidos sobre ese Cliente.
	 * @param int idCliente
	 * @return List<Comercial>
	 */
	@GetMapping("/bycliente/{idCliente}")
	public List<Comercial> byCliente(@PathVariable int idCliente) {
		return pedidoService.findComercialesPedidosByCliente(idCliente);
	}
	
	/**
	 * Gestiona las peticiones GetMapping de "/conpedidos" en el cual nos mostrará una lista con los comerciales que hayan gestionado algún pedido.
	 * @return List<Comercial>
	 */
	@GetMapping("/conpedidos")
	public List<Comercial> comercialesConPedidos() {
		return pedidoService.findComercialesByPedidos();
	}
	
	/**
	 * Gestiona las peticiones GetMapping de "/pedidos/{idComercial}" en la cual se le pasa el idComercial, devolviendonos una lista de los pedidos que ha gestionado el Comercial.
	 * @param int idComercial
	 * @return
	 */
	@GetMapping("/pedidos/{idComercial}")
	public List<Pedido> pedidosByComercial(@PathVariable int idComercial) {
		return pedidoService.findPedidosByComercial(idComercial);
	}
	
}
