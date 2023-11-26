package cajero.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cajero.modelo.entity.Cuenta;
import cajero.repository.CuentaRepository;

@Repository
public class CuentaDaoJpaImplMy8 implements CuentaDao {
	
	@Autowired
	private CuentaRepository cuentaRepository;

	/**
	 * Método que devuelve un objeto de tipo cuenta, aplicando el método del repositorio findByCuenta().<br>
	 * @param int idCuenta
	 * @return Cuenta
	 */
	@Override
	public Cuenta login(int idCuenta) {
		return cuentaRepository.findByCuenta(idCuenta);
	}

	/**
	 * Lanza un update a la base de datos si no encuentra dicho objeto lo cambia por un insert.<br>
	 * @param Cuenta
	 * @return int
	 */
	@Override
	public int insertCuenta(Cuenta cuenta) {
		cuentaRepository.save(cuenta);		
		return 1;
	}

	/**
	 * Método que devuelve un objeto de tipo cuenta, aplicando el método del repositorio findByCuenta().<br>
	 * @param int idCuenta
	 * @return Cuenta
	 */
	@Override
	public Cuenta buscarCuenta(int idCuenta) {
		return cuentaRepository.findByCuenta(idCuenta);
	}

}
