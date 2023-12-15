package cliente.pedido.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {
	
	@GetMapping("/detalleCliente/{idCliente}")
	public String mostrarDetalleCliente(@PathVariable int idCliente , Model model) {
		return "";
	}

}
