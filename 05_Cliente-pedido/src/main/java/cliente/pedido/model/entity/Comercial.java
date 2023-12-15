package cliente.pedido.model.entity;

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
@Table(name="comerciales")
public class Comercial {
	
	@Id
	@Column(name="id_comercial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComercial;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private double comision;

}
