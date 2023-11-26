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
public class LoginController {
	
	@Autowired
	private CuentaDao cuentaDao;
	
	/**
	 * 	GetMapping para la url "/login" que muestra la pantalla de login.
	 * @return String, archivo que muestra el formulario de login
	 */
	@GetMapping("/login")
	public String mostrarLogin () {
		return "loginCuenta";
	}
	
	/**
	 * 	PostMapping para la url "/login" el cual procesa la petición de sesión para cuentas.
	 * @return String, si es un login válido muestra la pantalla de home, sino muestra un mensaje de error.
	 */
	@PostMapping("/login")
	public String procesarLogin (HttpSession session , RedirectAttributes ratt , @RequestParam int idCuenta) {
		
		Cuenta cuenta = cuentaDao.login(idCuenta);
		//System.out.println(cuenta);
		
		if(cuenta!=null) {
			session.setAttribute("cuenta", cuenta);
			return "redirect:/";
		}
		ratt.addFlashAttribute("mensaje","La cuenta introducida no existe");
		return "redirect:/login";
		
	}
	
	/**
	 * 	GetMapping para la url "/logout" cierra la sesión de la cuenta iniciada.
	 * @return String, nos devuelve al formulario de login
	 */	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("usuario");
		session.invalidate();
		return "forward:login";
	}

}//End LoginController
