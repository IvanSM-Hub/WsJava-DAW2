package eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;

import eventos.modelo.dao.EventoDao;
import eventos.modelo.dao.ReservaDao;
import eventos.modelo.dao.TipoDao;
import eventos.modelo.dao.UsuarioDao;

public class AutowiredController {
	
	@Autowired
	protected EventoDao eventoDao;
	
	@Autowired
	protected TipoDao tipoDao;
	
	@Autowired
	protected ReservaDao reservaDao;
	
	@Autowired
	protected UsuarioDao usuarioDao;

}
