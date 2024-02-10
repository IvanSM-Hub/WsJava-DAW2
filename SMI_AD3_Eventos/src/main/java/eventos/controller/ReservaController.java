package eventos.controller;

import java.util.Date;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import eventos.modelo.entitys.Evento;
import eventos.modelo.entitys.Reserva;
import eventos.modelo.entitys.Usuario;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/eventos")
public class ReservaController extends PeticionesController {
	
	/**
	 * PostMapping que gestiona las reservas, las cuales tienen varias capas de seguridad para que el usuario tenga que estar iniciado, segundo la cantidad debe estar comprendida ente 1 y 10, despues que las reservas generales no deben ser superiores a 10 reservas por evento y finalmente que el total de las reservas del evento realizada por los usuarios no sea superior del aforo máximo del evento.
	 * @param RedirectAttributes ratt
	 * @param HttpSession httpSession
	 * @param Authentication authentication
	 * @param int idEvento
	 * @param int cantidad
	 * @return String
	 */
	@PostMapping("/reservar/{idEvento}")
	public String procesarReserva (
			RedirectAttributes ratt,
			HttpSession httpSession,
			Authentication authentication,
			@PathVariable int idEvento,
			@RequestParam int cantidad
	){
		
		sesionAutorizada(httpSession, authentication);
		Usuario usuario = usuarioDao.findById(authentication.getName());
		Evento evento = eventoDao.buscarEvento(idEvento);
		
		if (usuario != null) {
			
			if (cantidad >= 1 && cantidad <= 10) {
				
				if((reservaDao.canitdadReservasUsuario(idEvento , usuario.getUsername()) + cantidad) < 11) {
				
					if (evento.getAforoMaximo() > reservaDao.cantidadReservasEvento(idEvento)) {
						
						Reserva reserva = new Reserva();
						Date fechaReserva = new Date();
						
						reserva.setEvento(evento);
						reserva.setUsuario(usuarioDao.findById(usuario.getUsername()));
						reserva.setPrecioVenta(evento.getPrecio() * 1.25);
						reserva.setObservaciones("reserva realizada: " + fechaReserva.toString());
						reserva.setCantidad(cantidad);
						
						reservaDao.realizarReservaEvento(reserva);
						
						ratt.addFlashAttribute("mensajeOk", "Reserva realizada satisfactoriamente");
						
						return "redirect:/eventos/detalle/" + idEvento;
						
					} else {
						ratt.addFlashAttribute("mensajeError", "Reserva no realizada supera el máximo de 10 reserva por evento");
						return "redirect:/eventos/detalle/" + idEvento;
					}
					
				} else {
					ratt.addFlashAttribute("mensajeError", "Reservas validas por usuario de 1 a 10");
					return "redirect:/eventos/detalle/" + idEvento;
				}
				
			}else {
				ratt.addFlashAttribute("mensajeError", "Reservas validas por usuario de 1 a 10");
				return "redirect:/eventos/detalle/" + idEvento;
			}
			
		} else {
			return "redirect:/login";
		}
		
	}
	
	/**
	 * Primeramente capturamos el usuario en una variable Usuario, después obtenemos una List<Reserva> en el cual obtenemos las reservas de un mismo usuario.
	 * Hecho esto filtramos la List<Reserva> para que las reservas que ya hayan pasado de la fecha actual.
	 * Pasamos el List<Reserva> filtrado y retornamos el String con el nombre del .html "misReservas".
	 * @param Model model
	 * @param HttpSession httpSession
	 * @param Authentication authentication
	 * @return String
	 */
	@GetMapping("/mis-reservas")
	public String mostrarMisReservas (
			Model model,
			HttpSession httpSession,
			Authentication authentication
			) {
		
		Usuario usuario = usuarioDao.findById(authentication.getName());
		
		List<Reserva> misReservas = reservaDao.buscarReservasUsuario(usuario.getUsername());
		
		misReservas.removeIf(reserva -> reserva.getEvento().getFechaInicio().before(new Date()));
		
		model.addAttribute("misReservas", misReservas);
		
		return "misReservas";
		
	}
	
	/**
	 * Método del servlet par gestionar la url "/eventos/cancelar/{idReserva}" pasando el id de la reserva seleccionada.
	 * Utilizando el método de la clase reservaDao, eliminamos la reserva pasando un objeto Reserva, utilizando el método de buscar buscarReservaId(), pasando el idReserva que nos viene por la URL.
	 * Finalmente redurecciona a "/eventos/mis-reservas"
	 * @param int idReserva
	 * @return String
	 */
	@GetMapping("/cancelar/{idReserva}")
	public String cancelarReserva(
			@PathVariable int idReserva
			) {
		
		reservaDao.eliminarReserva(reservaDao.buscarReservaId(idReserva));
		return "redirect:/eventos/mis-reservas";
		
	}

}
