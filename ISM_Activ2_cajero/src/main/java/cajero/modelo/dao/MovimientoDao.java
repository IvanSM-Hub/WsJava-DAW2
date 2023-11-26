package cajero.modelo.dao;

import java.util.List;

import cajero.modelo.entity.Cuenta;
import cajero.modelo.entity.Movimiento;

public interface MovimientoDao {

	List<Movimiento> verTodosMovimientos(Cuenta cuenta);
	Movimiento findMovimiento(int idMovimiento);
	boolean insertMovimiento(Movimiento movimiento);
	
}
