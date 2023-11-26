package cajero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	/**
	 * GetMapping "","/" y "home" todas las url estas url llamarán a nuestro método.<br>
	 * @return String, nos lleva a la home
	 */
	@GetMapping({"","/","/home"})
	public String mostrarHome() {
		return "home";
	}
	
}//End HomeController
