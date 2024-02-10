package eventos.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController extends PeticionesController {
	
	/**
	 * Controlador para mostrar la página de inicio.
	 * Mediante sesionAutorizada() Establece la sesión autorizada con los datos necesarios.
	 * Finalmente pasamos una lista la cual filtramos según el tipo especificado.
	 * @param HttpSession httpSession
	 * @param Authentication authentication
	 * @param List<Evento> eventos
	 * @param String tipo
	 * @return String index
	 */
	@GetMapping("/")
	public String mostrarHome (Model model , HttpSession httpSession , Authentication authentication , @RequestParam(required = false) String tipo) {
		sesionAutorizada(httpSession,authentication);
		model.addAttribute("eventosActivosDestacados", listarEventos(eventoDao.eventosActivosDestacados(), tipo));
		return "index";
	}

}
