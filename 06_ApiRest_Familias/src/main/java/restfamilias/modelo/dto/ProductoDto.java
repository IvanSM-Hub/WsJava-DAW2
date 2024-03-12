package restfamilias.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import restfamilias.modelo.entities.Familia;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductoDto {
	
	private int codigo;
	private String descripcion;
	private double precioUnitario;
	private String marca;
	private String color;
	private Familia familia;
	private int codigoFamilia;
	
	

}
