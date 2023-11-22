package cajero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cajero.modelo.entity.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
	
	@Query("select c from Cuenta c where c.idCuenta=?1")
	public Cuenta findByCuenta (int idCuenta);

}
