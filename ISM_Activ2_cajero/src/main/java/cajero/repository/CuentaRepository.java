package cajero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cajero.modelo.entity.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
	
	/**
	 * Método que lanza una query contra la base de datos en la que selecciona y monta un objeto de la clase cuenta.<br>
	 * @param int idCuenta
	 * @return Cuenta
	 */
	@Query("select c from Cuenta c where c.idCuenta=?1")
	public Cuenta findByCuenta (int idCuenta);

}
