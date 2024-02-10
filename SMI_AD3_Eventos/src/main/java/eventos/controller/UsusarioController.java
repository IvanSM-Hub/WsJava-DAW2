package eventos.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import eventos.modelo.entitys.Usuario;

@Controller
public class UsusarioController extends PeticionesController {
	
	/**
	 * Método de controlador para mostrar la página de inicio de sesión.
	 *
	 * @return String formsLogin
	 */
	@GetMapping("/login")
	public String mostrarLogin() {
		return "formsLogin";
	}
	
	/**
	 * Método de controlador para mostrar el formulario de registro.
	 *
	 * @param Model model
	 * @return String formsRegistro
	 */
	@GetMapping("/registrar")
	public String registrar(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "formsRegistro";
	}
	
	/**
	 * Método de controlador para procesar el registro de un nuevo usuario.
	 * Pasaremos un mensaje especificando al usuario de que el registro ha sido un éxito o si ya existia el usuario.
	 *
	 * @param Model model
	 * @param Usuario usuario
	 * @param RedirectAttributes ratt
	 * @return String redirect"/registrar"
	 */
	@PostMapping("/registrar")
	public String proregistrar(Model model, Usuario usuario, RedirectAttributes ratt) {
		usuario.setEnabled(1);
		usuario.setFechaRegistro(new Date());
	 	usuario.addPerfil(perfilDao.findById(3));
	  	usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
	 	if (usuarioDao.registro(usuario)) {
	 		ratt.addFlashAttribute("mensaje", "alta realizada");
	 		return "redirect:/registrar";
	 	}
	 	else {
	 		model.addAttribute("mensaje", "ya existe como usuario");
	 		return "/registrar";
	 	}
	}

}
