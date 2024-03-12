package restexamen.model.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="empleados_en_proyecto")
@NamedQuery(name="EmpleadoEnProyecto.findAll", query="SELECT e FROM EmpleadoEnProyecto e")
public class EmpleadoEnProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_entrada")
	private int idEntrada;

	@Column(name="dias_previstos")
	private int diasPrevistos;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_incorporacion")
	private Date fechaIncorporacion;

	//uni-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	//uni-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="id_empleado")
	private Empleado empleado;

}