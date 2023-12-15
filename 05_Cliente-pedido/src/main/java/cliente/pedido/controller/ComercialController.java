package cliente.pedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cliente.pedido.model.entity.Comercial;
import cliente.pedido.modelo.dao.ComercialDao;
import cliente.pedido.modelo.dao.PedidoDao;

@Controller
public class ComercialController {
	
	@Autowired
	private ComercialDao comdao;
	
	@Autowired
	private PedidoDao peddao;

	@GetMapping("/detalles/{idComercial}")
	public String mostrarDetalleComercial(@PathVariable int idComercial , Model model) {
		model.addAttribute("comercial" , comdao.buscarUnComercial(idComercial));
		model.addAttribute("pedidos", peddao.buscarPedidosPorComercial(idComercial));
		return "detalleComercial";
	}
	
	@GetMapping("/altaComercial")
	public String mostrarAltaComercial(Model model) {
		model.addAttribute("comercial",new Comercial());
		return "formsAltaComercial";
	}
	
	@PostMapping("/altaComercial")
	public String procesarAltaComercial(Comercial comercial , RedirectAttributes redirect) {
		
		if(comdao.insertarComercial(comercial)) {
			return "redirect:/";
		} else {
			return "redirect:altaComercial";
		}	
	}
	
	@GetMapping("/eliminarComercial/{idComercial}")
	public String eliminarComercial (@PathVariable int idComercial) {
		comdao.eliminarComercial(idComercial);
		return "forward:/";
	}
	
}
