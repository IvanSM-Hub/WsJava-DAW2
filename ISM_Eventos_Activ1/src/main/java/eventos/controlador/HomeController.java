package eventos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eventos.modelo.dao.EventoDao;

@Controller
public class HomeController {
	
	@Autowired
	private EventoDao edao;

	@GetMapping("/")
	public String mostrarIndex(Model model) {
		model.addAttribute("eventos", edao.findAll());
		return("index");
	}
	
}
