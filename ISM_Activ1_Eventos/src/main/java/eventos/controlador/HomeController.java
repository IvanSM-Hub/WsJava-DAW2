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
	
	/**
	 * Función para mostrar todos los eventos de la ruta "/" la cual muestra el archivo index.html.
	 * <br>
	 * @param Model model
	 * @return String
	 */
	@GetMapping("/")
	public String mostrarIndex(Model model) {
		model.addAttribute("eventos", edao.findAllActive());
		return("index");
	}
	
}
