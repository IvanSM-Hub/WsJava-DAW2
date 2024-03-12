package restventas.service;

import org.springframework.beans.factory.annotation.Autowired;

import restventas.repository.ComercialRepository;
import restventas.repository.PedidoRepository;

public class AutowiredRepository {
	
	@Autowired
	protected ComercialRepository comercialRepository;
	
	@Autowired
	protected PedidoRepository pedidoRepository;

}
