package restventas.service;

import org.springframework.stereotype.Service;

import restventas.modelo.entity.Comercial;

@Service
public class ComercialServiceImplMy8 extends AutowiredRepository implements ComercialService {

	/**
	 * Método que lanza una petición de inserción a la base de datos para dar de alta un objeto de la clase Comercial. Si el alta ha sido exitosa, nos devolverá el objeto de la alta, si el comercial ya exidye nos devolverá null.
	 * @param Comercial comercial
	 * @return Comercial comercial
	 */
	@Override
	public Comercial insert(Comercial comercial) {
		if (comercialRepository.findById(comercial.getIdComercial())!=null)
			return comercialRepository.save(comercial);
		return null;
	}

	/**
	 * Para prevenir que al realizar la petición la base de datos nos devuelva un excepción o error añadiremos un control tryCatch en el cual si salta la excepción nos devolverá un -1.
	 * Dentro del "try" pondremos un if el cual buscará el objeto Comercial que se desea eliminar, si lo encuantra procede a su eliminación y retorna un 1.
	 * Si no encuentra el Comercial devuelve un 0.
	 * @param int idComercial
	 * @return int
	 */
	@Override
	public int delete(int idComercial) {
		try {
			if(comercialRepository.findById(idComercial)!=null) {
				comercialRepository.deleteById(idComercial);
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * Este método retorna un comercial, el cual obtendremos lanzando una busqueda a la base de datos usando el idComercial, sino lo encuentra nos devolverá un null.
	 * @param int idComercial
	 * @return Comercial comercial
	 */
	@Override
	public Comercial findOne(int idComercial) {
		return comercialRepository.findById(idComercial).orElse(null);
	}

}
