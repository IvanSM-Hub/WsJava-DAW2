package cajero.modelo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="movimientos")
public class Movimiento {
	
	@Id
	@Column(name="id_movimiento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	int idMovimiento;
	
	@ManyToOne
	@JoinColumn(name="id_cuenta")
	private	Cuenta cuenta;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	private double cantidad;
	
	private String operacion;
	
}
