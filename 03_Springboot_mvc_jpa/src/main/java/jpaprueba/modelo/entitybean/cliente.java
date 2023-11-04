package jpaprueba.modelo.entitybean;

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
@Table(name="clientes")
public class cliente {
	
	@Id
	@Column(name="id_cliente")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCliente;
	
	private String nombre;
	
	@Column(name="facturacion_anual")
	private double facturacionAnual;
	
	@Column(name="numero_Empleados")
	private int numeroEmpleados;

}
