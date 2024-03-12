package restventas.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;

import restventas.service.ComercialService;
import restventas.service.PedidoService;

public class AutowiredController {
	
	@Autowired
	protected ComercialService comercialService;
	
	@Autowired
	protected PedidoService pedidoService;

}
