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

}//End Cuenta
