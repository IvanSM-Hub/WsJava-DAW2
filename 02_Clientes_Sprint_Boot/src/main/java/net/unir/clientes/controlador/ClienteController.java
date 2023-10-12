package net.unir.clientes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.unir.clientes.modelo.dao.ClienteDao;
import net.unir.clientes.modelo.javabean.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteDao cdao;
	
	@PostMapping("/alta")
	public String procesarFormularioAlta(Cliente cliente) {
			
		
		return "falso";
	}
	
	@GetMapping("/alta")
	public String mostrarFormularioAlta() {
		return "formularioAlta";
	}
	
	@GetMapping("/detalle/{id}")
	public String verCliente(@PathVariable("id") int idCliente, Model model) {
		Cliente cliente = cdao.findById(idCliente);
		
		if(cliente!=null) {
			model.addAttribute("cliente", cliente);
			return "verDetalle";
		}else {
			model.addAttribute("mensaje", "Este cliente no existe");
			return "forward:/";
		}
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCliente(@PathVariable("id") int idCliente, Model model) {
		
		if(cdao.delete(idCliente) == 1)
			model.addAttribute("mensaje","Cliente eliminado correctamente");
		else
			model.addAttribute("mensaje","Cliente no se ha podido eliminar");
		
		return "forward:/";
	}
	
}
