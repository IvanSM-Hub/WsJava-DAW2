package cajero.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cajero.modelo.entity.Cuenta;
import cajero.repository.CuentaRepository;

@Repository
public class CuentaDaoJpaImplMy8 implements CuentaDao {
	
	@Autowired
	private CuentaRepository cuentaRepository;

	@Override
	public Cuenta login(int idCuenta) {
		return cuentaRepository.findByCuenta(idCuenta);
	}

}
