package eventos.controller;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;

import eventos.modelo.entitys.Evento;
import eventos.modelo.entitys.Usuario;

public class PeticionesController extends AutowiredController {
	
	protected List<Evento> listarEventos(List<Evento> eventos , String tipo){
		List<Evento> eventosFiltrados = new ArrayList<>(eventos);
		if (tipo != null && !tipo.isBlank()) {
			eventosFiltrados.removeIf(evento -> evento.getTipo().getIdTipo() != Integer.parseInt(tipo));
		}
		return eventosFiltrados;
	}
	
	protected void sesionAutorizada (HttpSession httpSession , Authentication authentication) {
		httpSession.setAttribute("tipos", tipoDao.buscarTodosTipo());
		if (authentication != null) {
			Usuario usuario = usuarioDao.findById(authentication.getName());
			httpSession.setAttribute("usuario", usuario.getNombre());
		}
	}

}
