package eventos.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import eventos.modelo.entitys.Evento;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/eventos")
@Controller
public class EventosController extends PeticionesController {
	
	@GetMapping("/detalle/{idEvento}")
	public String mostrarDetalle (@PathVariable int idEvento , Model model , HttpSession httpSession , Authentication authentication) {
		sesionAutorizada(httpSession,authentication);
		Evento evento = eventoDao.buscarEvento(idEvento);
		model.addAttribute(evento);
		model.addAttribute("quedan", evento.getAforoMaximo() - reservaDao.cantidadReservasEvento(idEvento));
		return "verDetalle";
	}
	
	@GetMapping("/activos")
	public String mostrarActivos (Model model , HttpSession httpSession , Authentication authentication) {
		model.addAttribute("eventosActivos", eventoDao.eventosActivos());
		return "eventosActivos";
	}
	
	@GetMapping("/destacados")
	public String mostrarDestacados (Model model , HttpSession httpSession , Authentication authentication) {
		model.addAttribute("eventosDestacados", eventoDao.eventosDestacados());
		return "eventosDestacados";
	}

}
