 package eventos.controlador;

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

import eventos.modelo.dao.EventoDao;
import eventos.modelo.dao.TipoDao;
import eventos.modelo.javabean.Evento;


@Controller
@RequestMapping("/eventos")
public class EventosController {
	
	
	@Autowired
	private EventoDao edao;
	
	@Autowired
	private TipoDao tdao;
	
	
	/**
	 * Mediante este método el cual nos pasa por la url el id del evento que se quiere modificar el estado del evento a "cancelado"<br>
	 * Con un "if" el cual ejecuta la función .updateEstado(idEvento), cambiará el estado del evento, si se ha ejecutado correctamente devolverà un 1 lo cual mandará un mensaje informativo.<br>
	 * Retornando el string "forward:/" el cual manda todo este proceso a la url "/" el cual lo procesa el homeController.
	 * <br>
	 * @return String
	 * @param int idEvento , Model model
	 */
	@GetMapping("/cancelar/{id}")
	private String cancelarEvento (@PathVariable("id") int idEvento , Model model) {
		
		if(edao.updateEstado(idEvento)==1)
			model.addAttribute("mensaje", "Evento cancelado");
		else
			model.addAttribute("mensaje", "El evento no se ha podido cancelar");
		
		return "forward:/";
	}
	
	/**
	 * Función para editar el evento pasado por la url, insertando el idEvento que nos viene por la petición, al igual que capturando el id del tipo de evento, los demás datos serán insertados en el objeto llamando a la función updateOne(idEvento) y redireccionaremos el control del proceso al homeController. 
	 * <br>
	 * @return String
	 * @param Evenot evento , int idEvento , RedirectAttributes ratt
	 */
	@PostMapping("/editar/{id}")
	private String procesarFormularioEditar(Evento evento , @PathVariable("id") int idEvento , RedirectAttributes ratt) {
		
		evento.setIdEvento(idEvento);
		evento.setTipo(tdao.findById(evento.getTipo().getIdTipo()));
		
		if (edao.updateOne(evento) == 1)
			ratt.addFlashAttribute("mensaje", "Edición realizada correctamente");
		else
			ratt.addFlashAttribute("mensaje", "Edición no realizada correctamente");
		
		return "redirect:/";
	}
	
	/**
	 * Dicha función capturará el objeto con el id pasado por la url el cual cotejaremos, si no es null la función preparará el objeto evento encontrado, y además también le pasaremos todos los tipos de eventos, para despúes retornar el String "formularioEdicion" para que trate los datos pasados. Sino, mandará un mensaje informativo diciendo que no se ha podido encontrar el evento con el id pasado.
	 * <br>
	 * @return String
	 * @param int idEvento , RedirectAttributes ratt
	 */
	@GetMapping("/editar/{id}")
	private String editarEvento(@PathVariable("id") int idEvento , Model model) {
		
		Evento evento = edao.findById(idEvento);
		
		if(evento!=null) {
			model.addAttribute("evento", evento);
			model.addAttribute("tipos", tdao.findAll());
			return "formularioEdicion";
		} else {
			model.addAttribute("mensaje", "Este evento no existe");
			return "forward:/";
		}
		
	}
	
	/**
	 * Para dar de alta un evento recibiremos un objeto evento y un objeto de redirección de atributos, una vez obtenido el objeto evento haremos un "if" aplicando la función findById(evento) el cual retornará un 1 si el objeto se ha insertado correctamente o un 0 si no ha sido posible.<br>
	 * <br>
	 * @return String
	 * @param Evenot evento , int idEvento , RedirectAttributes ratt
	 */
	@PostMapping("/alta")
	private String procesarFormularioAlta(Evento evento,RedirectAttributes ratt) {
		
		evento.setFechaInicio(new Date());
		
		evento.setTipo(tdao.findById(evento.getTipo().getIdTipo()));
		
		System.out.println(evento);
		
		if(edao.insert(evento)==1)
			ratt.addFlashAttribute("mensaje","Alta realizada correctamente");
		else
			ratt.addFlashAttribute("mensaje", "Alta no realizada correctamente");
		
		return "redirect:/";
	}
	
	/**
	 * Cuando se invoque esta URL la función controladora retornará un string que contiene el nombre del archivo html formualrioAlta.html 
	 * <br>
	 * @return String
	 * @param Model model
	 */
	@GetMapping("/alta")
	private String mostrarFormularioAlta(Model model) {
		model.addAttribute("evento", new Evento());
		model.addAttribute("tipos", tdao.findAll());
		return "formularioAlta";
	}
	
	/**
	 * capturamos en un objeto evento utilizando la función findById(idEvento), si dicho objeto contiene datos, mediante el objeto model pasaremos los datos del objeto y retornaremos el string "verDetalle" la cual mostrará el archivo html del mismo nombre.<br>
	 * <br>
	 * @return String
	 * @param int idEvento , Model model
	 */
	@GetMapping("/detalle/{id}")
	private String detalleEvento(@PathVariable("id") int idEvento, Model model) {
		
		Evento evento = edao.findById(idEvento);
		
		if(evento!=null) {
			model.addAttribute("evento", evento);
			return "verDetalle";
		}else {
			model.addAttribute("mensaje", "Este cliente no existe");
			return "formawrd:/";
		}
		
	}
	
	/**
	 * Con esta función eliminaremos el evento con el id que se nos pasa, utilizando la función delete(idEvento) eliminaremos el vento de la lista de eventos.<br>
	 * Si la función delete() nos devuelve un 1 se habrá eliminado correctamente, pero si nos devuelve un 0 no se habrá podido realizar la eliminación del evento<br>
	 * <br>
	 * @return String
	 * @param int idEvento , RedirectAttributes ratt
	 */
	@GetMapping("/eliminar/{id}")
	private String eliminarEvento(@PathVariable("id") int idEvento, Model model) {
		
		if(edao.delete(idEvento)==1)
			model.addAttribute("mensaje","El Evento se ha eliminado correctamente");
		else
			model.addAttribute("mensaje","El Evento no se ha podido eliminar");
		
		return "forward:/";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
	}

}
