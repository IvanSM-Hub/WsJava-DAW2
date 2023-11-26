package cajero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cajero.modelo.entity.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

	/**
	 * Método que lanza una query contra la base de datos en la que selecciona y monta una lista de movimiento de la cuenta que tiene asignados los movimientos.<br>
	 * @param int idCuenta
	 * @return List<Movimiento>
	 */
	@Query("select m from Movimiento m where m.cuenta.idCuenta=?1")
	public List<Movimiento> findAllMovimientos(int idCuenta);
	
	/**
	 * Método que lanza una query contra la base de datos en la que selecciona y monta uno bjeto de tipo movimiento del idMoviemiento que le pasamos.<br>
	 * @param int idMovimiento
	 * @return Movimiento
	 */
	@Query("select m from Movimiento m where m.idMovimiento=?1")
	public Movimiento findByIdMovimiento(int idMovimiento);
	
}
