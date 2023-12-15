package cliente.pedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cliente.pedido.modelo.dao.ComercialDao;

@Controller
public class HomeController {
	
	@Autowired
	private ComercialDao comdao;

	@GetMapping({"/",""})
	public String mostrarHome(Model model) {
		model.addAttribute("comerciales", comdao.buscarTodosComerciales());
		return "index";
	}
	
}
