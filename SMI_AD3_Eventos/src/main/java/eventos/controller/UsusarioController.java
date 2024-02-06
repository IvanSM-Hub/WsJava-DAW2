package eventos.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import eventos.modelo.dao.PerfilDao;
import eventos.modelo.dao.UsuarioDao;
import eventos.modelo.entitys.Usuario;

@Controller
public class UsusarioController {
	
	@Autowired
	private UsuarioDao usudao;
	
	@Autowired
	private PerfilDao perdao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/registrar")
	public String registrar(Model model) {
		
		model.addAttribute("usuario", new Usuario());
		
		return "formsRegistro";
		
	}
	
	@PostMapping("/registrar")
	public String proregistrar(Model model, Usuario usuario, RedirectAttributes ratt) {
		
		usuario.setEnabled(1);
		usuario.setFechaRegistro(new Date());
	 	usuario.addPerfil(perdao.findById(3));
	  	usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
	 //	usuario.setPassword("{noop}"+ usuario.getPassword());
	 //	System.err.println("Aquí paso el usuario y le añado los datos");
	 	if (usudao.registro(usuario)) {
	 	//	System.err.println("Usuario registrado en la BBDD");
	 		ratt.addFlashAttribute("mensaje", "alta realizada");
	 		return "redirect:/registrar";
	 	}
	 	else {
	 		model.addAttribute("mensaje", "ya existe como usuario");
	 		return "/registrar";
	 		
	 	}
		
	}

}
