package eventos.controller;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;

import eventos.modelo.entitys.Evento;
import eventos.modelo.entitys.Usuario;

public class PeticionesController extends AutowiredController {
	
	/**
	 * Filtra una lista de eventos según el tipo especificado.
	 *
	 * @param List<Evento> eventos
	 * @param String tipo
	 * @return List<Evento> eventosFiltrados
	 */
	protected List<Evento> listarEventos(List<Evento> eventos , String tipo){
		List<Evento> eventosFiltrados = new ArrayList<>(eventos);
		if (tipo != null && !tipo.isBlank()) {
			eventosFiltrados.removeIf(evento -> evento.getTipo().getIdTipo() != Integer.parseInt(tipo));
			System.err.println(Integer.parseInt(tipo));
		}
		return eventosFiltrados;
	}
	
	/**
	 * Establece la sesión autorizada con los datos necesarios.
	 *
	 * @param HttpSession httpSession
	 * @param Authentication authentication
	 */
	protected void sesionAutorizada (HttpSession httpSession , Authentication authentication) {
		httpSession.setAttribute("tipos", tipoDao.buscarTodosTipo());
		if (authentication != null) {
			Usuario usuario = usuarioDao.findById(authentication.getName());
			httpSession.setAttribute("usuario", usuario.getNombre());
		}
	}

}
