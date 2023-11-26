package eventos.modelo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import eventos.modelo.javabean.Evento;
import eventos.modelo.javabean.Tipo;

@Repository
public class EventoDaoImpl implements EventoDao {
	
	private List<Evento> lista;
	
	private static int idAuto;
	static {idAuto=0;}
	
	/**
	 * Función que sirve como arranque de datos a la variable lista, lista de eventos.<br>
	 * Llama a la función cargarLista()
	 */
	public EventoDaoImpl() {
		lista=new ArrayList<>();
		cargarLista();
	}
	
	/**
	 * Añade a la 3 eventos junto a sus respectivos tipos, además de asignar a la variable idAuto un valor de 3 para que se auto-incremente posteriormente.<br>
	 * @return void
	 */
	private void cargarLista() {
		
		Tipo tipo1 = new Tipo(1, "Evento Solidario", "Descripción Tipo 1");
		lista.add(new Evento(1, "Evento 1", "Descripción Evento 1", new Date(), 120, "Dirección 1","activo", "no", 200, 50, 19.99, tipo1));
		
		Tipo tipo2 = new Tipo(2, "Concierto", "Descripción Tipo 2");
		lista.add(new Evento(2, "Evento 2", "Descripción Evento 2", new Date(), 90, "Dirección 2","activo", "si", 150, 30, 29.99, tipo2));
		
		Tipo tipo3 = new Tipo(3, "Festival", "Descripción Tipo 3");
		lista.add(new Evento(3, "Evento 3", "Descripción Evento 3", new Date(), 180, "Dirección 3","activo", "no", 300, 70, 24.99, tipo3));
		
		idAuto=3;
	}

	/**
	 * Recorre la el array de eventos nombrada como "lista" mediante un for.<br>
	 * Mientras recorre el lista, va a capturar el elemento evento que de su posición y lo comparará con el idEvento que se le pasará como parametro.<br>
	 * Si hay una coincidencia el objeto coincidente será devuelto por la función.<br>
	 * <br>
	 * @param int idEvento
	 * @return Evento
	 */
	@Override
	public Evento findById(int idEvento) {
		for(int i=0; i<lista.size();i++) {
			if(lista.get(i).getIdEvento()==idEvento)
				return lista.get(i);
		}
		return null;
	}
	
	/**
	 * Dicha función retorna una lista de eventos, utilizando el método .stream(), siendo propio de "Collection". Además añadiremos un método .filter() en el que compararemos dentro de eventos el estado siendo retornados solo los eventos "activos".
	 * <br>
	 * @param void
	 * @return List<Evento>
	 */
	@Override
	public List<Evento> findAllActive() {
		return lista
				.stream()
				.filter(ele -> ele.getEstado().equalsIgnoreCase("activo"))
				.toList();
	}
	
	/**
	 * Retornaremos la lista de todos los objetos Eventos.
	 * <br>
	 * @param void
	 * @return List<Evento>
	 */
	@Override
	public List<Evento> findAll() {
		return lista;
	}

	/**
	 * Primeramente cotejaremos que el evento que queremos insertar en nuestra lista no está, por tanto realizaremos un "if" en el cual mediante el metodo .contains() pasandole el parametro evento.<br>
	 * Si el evento no está en nuestra lista le asignaremos un id del evento que se auto incrementa, al igual que con el tipo.<br>
	 * Finalemente se insertará el Evento a lista, retornado un 1.
	 * <br>
	 * @param Evento evento
	 * @return int
	 */
	@Override
	public int insert(Evento evento) {
		if(!lista.contains(evento)) {
			evento.setIdEvento(++idAuto);
			evento.getTipo().setIdTipo(++idAuto);
			lista.add(evento);
			return 1;
		}
		return 0;
	}
	
	/**
	 * Capturamos el objeto Evento que queremos eliminar creando un objeto evento y utilizando la función findById(idEvento).<br>
	 * Mediante un "if" comprobamos que el objeto tiene datos si el objeto contiene null es porque no se ha encontrado el objeto con el id pasado.<br>
	 * Si el objeto contiene datos procemos a borrarlo de la lista mediante el método .remove(evento), y retornamos un int 1<br>
	 * <br>
	 * @param int idEvento
	 * @return int
	 */
	@Override
	public int delete(int idEvento) {
		Evento evento = findById(idEvento);
		
		if(evento==null)
			return 0;
		
		return  lista.remove(evento) ? 1 : 0;
	}

	/**
	 * Primeramente capturamos la posición del objeto dentro de la lista de objetos eventos.<br>
	 * Mediante un "if" comprobamos si la posición se encuentra dentro de la lista, siendo un -1 una posición en la que el objeto no se encuentra en la lista.<br>
	 * Si se encuetra actualizamos el evento con el método de .set(posicion, evento) y retornando un 1.<br>
	 * <br>
	 * @param Evento evento
	 * @return int
	 */
	@Override
	public int updateOne(Evento evento) {
		
		int posicion = lista.indexOf(evento);
		
		if(posicion!=-1) {
			lista.set(posicion,evento);
			return 1;
		}
		
		
		return 0;
	}

	/**
	 * Con esta función capturaremos el evento que deseamos cambiar su estado a "cancelado", si el evento capturado contiene datos, accederemos al valor de estado y le resasignaremos a "cancelado".
	 * <br>
	 * @param int idEvento
	 * @return int
	 */
	@Override
	public int updateEstado(int idEvento) {
		
		Evento evento = findById(idEvento);
		
		if(evento==null)
			return 0;
		else {
			evento.setEstado("cancelado");
			System.out.println(evento);
			return 1;
		}
		
	}

}//End EventoDaoImpl
