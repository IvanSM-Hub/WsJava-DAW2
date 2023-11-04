package eventos.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import eventos.modelo.javabean.Evento;
import eventos.modelo.javabean.Tipo;

@Repository
public class TipoDaoImpl implements TipoDao {
	
	private EventoDao edao = new EventoDaoImpl(); 
	private List<Evento> listaEvento;
	private List<Tipo> listaTipo;

	@Override
	public Tipo findById(int idTipo) {
		
		listaEvento = edao.findAll();
		
		for (int i=0; i<listaEvento.size();i++) {
			if(listaEvento.get(i).getTipo().getIdTipo()==idTipo) {
				return listaEvento.get(i).getTipo();
			}
		}
		
		return null;
	}

	@Override
	public List<Tipo> findAll() {
		
		listaTipo = new ArrayList<>();
		listaEvento = new ArrayList<>();
		
		listaEvento = edao.findAll();
		
		for (int i=0;i<listaEvento.size();i++) {
			listaTipo.add(listaEvento.get(i).getTipo());
		}
		return listaTipo;
	}

}
