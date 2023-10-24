package eventos.modelo.javabean;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Evento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idEvento;
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private int duracion;
	private String direccion;
	private String estado;
	private String destacado;
	private int aforoMax;
	private int minimoAsis;
	private double precio;
	private Tipo tipo;

}
