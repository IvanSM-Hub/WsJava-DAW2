package cajero.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cajero.modelo.entity.Cuenta;
import cajero.modelo.entity.Movimiento;
import cajero.repository.MovimientoRepository;

@Repository
public class MovimientoDaoJpaImplMy8 implements MovimientoDao {
	
	@Autowired
	private MovimientoRepository movimientoRepository;
	
	/**
	 * Método que devuelve un objeto de tipo movimiento, aplicando el método del repositorio findByMovimiento().<br>
	 * @param int idMovimiento
	 * @return Movimiento
	 */
	@Override
	public Movimiento findMovimiento(int idMovimiento) {
		return movimientoRepository.findByIdMovimiento(idMovimiento);
	}

	/**
	 * Método que devuelve una lista de tipo movimiento, aplicando el método del repositorio findAllMovimientos(), cogiendo del objeto pasado de tipo cuenta el atriburo idCuenta.<br>
	 * @param Cuenta
	 * @return List<Movimiento>
	 */
	@Override
	public List<Movimiento> verTodosMovimientos(Cuenta cuenta) {
		return movimientoRepository.findAllMovimientos(cuenta.getIdCuenta());
	}

	/**
	 * Método que devuelve un boolean, el cual aplica un update contra la base de datos, si no encuentra dicho objeto lo transforma en un insert.<br>
	 * @param Movimiento
	 * @return boolean
	 */
	@Override
	public boolean insertMovimiento(Movimiento movimiento) {
		movimientoRepository.save(movimiento);	
		return true;
	}

}
