package net.unir.clientes.controlador;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.unir.clientes.modelo.dao.ClienteDao;
import net.unir.clientes.modelo.javabean.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteDao cdao;
	
	@PostMapping("/editar/{id}")
	public String procesarEditarCliente(Cliente cliente, @PathVariable("id") int idCliente, RedirectAttributes ratt) {
		cliente.setIdCliente(idCliente);
		if(cdao.updateOne(cliente)==1) {
			ratt.addFlashAttribute("mensaje", "Modificación realizada");
		}else {
			ratt.addFlashAttribute("mensaje", "Modificación no realizada");
		}
		
		return "redirect:/";
		
	}
	
	@GetMapping("/editar/{id}")
	public String editarCliente(@PathVariable("id") int idCliente, Model model) {
		Cliente cliente = cdao.findById(idCliente);
		
		if(cliente!=null) {
			model.addAttribute("cliente", cliente);
			return "formularioEdicion";
		}else {
			model.addAttribute("mensaje", "Este cliente no existe");
			return "forward:/";
		}
		
	}
	
	@PostMapping("/alta")
	public String procesarFormularioAlta(Cliente cliente, RedirectAttributes ratt) {
		cliente.setFechaAlta(new Date());
		if(cdao.insert(cliente)==1)
			ratt.addFlashAttribute("mensaje", "Alta realizada correctamente");
		else
			ratt.addFlashAttribute("mensaje", "Alta NO realizada correctamente");
		
		return "redirect:/";
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
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
	}
	
}
