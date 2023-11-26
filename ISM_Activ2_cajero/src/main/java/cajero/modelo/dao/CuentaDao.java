package cajero.modelo.dao;

import cajero.modelo.entity.Cuenta;

public interface CuentaDao {
	
	
	Cuenta login(int idCuenta);
	int insertCuenta(Cuenta cuenta);
	Cuenta buscarCuenta(int idCuenta);

}
