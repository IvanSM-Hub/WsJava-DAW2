package cajero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cajero.modelo.dao.CuentaDao;
import cajero.modelo.entity.Cuenta;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private CuentaDao cuentaDao;
	
	@GetMapping({"","/","/home"})
	public String mostrarHome() {
		return "home";
	}
	
	@GetMapping("/login")
	public String mostrarLogin () {
		return "loginCuenta";
	}
	
	@PostMapping("/login")
	public String procesarLogin (HttpSession session , RedirectAttributes ratt , @RequestParam int idCuenta) {
		
		Cuenta cuenta = cuentaDao.login(idCuenta);
		System.out.println(cuenta);
		
		if(cuenta!=null) {
			session.setAttribute("cuenta", cuenta);
			return "redirect:/";
		}
		ratt.addFlashAttribute("mensaje","La cuenta introducida no existe");
		return "redirect:/login";
		
	}
	
	
	
}
