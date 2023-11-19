package unir.familias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import unir.familias.modelo.dao.UsuarioDao;
import unir.familias.modelo.entity.Usuario;

@Controller
public class HomeController {

	@Autowired
	private UsuarioDao udao;
	
	@GetMapping({"","/","/home"})
	public String mostrarHome() {
		return "home";
	}
	
	@GetMapping("/login")
	public String mostrarFormularioLogin() {
		return "formLogin";
	}
	
	@PostMapping("/login")
	public String procesarFormularioLogin(RedirectAttributes ratt , HttpSession session , @RequestParam String username , @RequestParam String password) {
		
		Usuario usuario = udao.login(username, password);
		System.out.println(usuario);
		
		if(usuario!=null) {
			session.setAttribute("usuario", usuario);
			return "redirect:/";
		}
		
		ratt.addFlashAttribute("mensaje","usuario o password incorrecto");
		return "redirect:/login";
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("usuario");
		session.invalidate();
		return "forward:/";
	}
	
	
}
