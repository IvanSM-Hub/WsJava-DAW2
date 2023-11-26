package cajero.modelo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="cuentas")
public class Cuenta {
	
	@Id
	@Column(name="id_cuenta")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCuenta;
	
	private double saldo;
	
	@Column(name="tipo_cuenta")
	private String tipoCuenta;
	
	/**
	 * Al invocar este método sumamos al saldo del objeto la cantidad pasada.<br>
	 * @param cantidad
	 * @return boolean
	 */
	public boolean ingresar(double cantidad) {
		saldo+=cantidad;
		return true;
	}
	
	/**
	 * Al invocar este método comprobamos si la cantidad a restar del saldo es menor, ya que esto nos impide que el saldo se quede en negativo, devolviendo un false.<br>
	 * Si la cantidad es inferior al saldo restará las dos cantidades.<br>
	 * @param cantidad
	 * @return boolean
	 */	
	public boolean extraer(double cantidad) {
		if (cantidad > saldo) {
			return false;
		}else {
			saldo-=cantidad;
			return true;
		}
	}

}//End Cuenta
