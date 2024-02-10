package eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import eventos.modelo.dao.EventoDao;
import eventos.modelo.dao.PerfilDao;
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
	
	@Autowired
	protected PerfilDao perfilDao;
	
	@Autowired
	protected PasswordEncoder passwordEncoder;

}
