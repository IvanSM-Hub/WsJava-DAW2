package eventos.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController extends PeticionesController {
	
	@GetMapping("/")
	public String mostrarHome (Model model , HttpSession httpSession , Authentication authentication , @RequestParam(required = false) String tipo) {
		
		sesionAutorizada(httpSession,authentication);
		model.addAttribute("eventosDestacados", listarEventos(eventoDao.eventosActivosDestacados(), tipo));
		return "index";
	
	}

}
