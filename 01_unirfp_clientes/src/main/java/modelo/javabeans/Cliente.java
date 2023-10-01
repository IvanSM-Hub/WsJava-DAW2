package modelo.javabeans;

import java.io.Serializable;

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int idCliente;
	private String nombre;
	private int cantidadEmpleados;
	private double facturacionAnual;
	
	//Constructores
	public Cliente(int idCliente, String nombre, int cantidadEmpleados, double facturacionAnual) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.cantidadEmpleados = cantidadEmpleados;
		this.facturacionAnual = facturacionAnual;
	}
	public Cliente( String nombre, int cantidadEmpleados, double facturacionAnual) {
		super();
		this.nombre = nombre;
		this.cantidadEmpleados = cantidadEmpleados;
		this.facturacionAnual = facturacionAnual;
	}
	public Cliente() {
		super();
	}
	
	//Getter & Setter
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidadEmpleados() {
		return cantidadEmpleados;
	}
	public void setCantidadEmpleados(int cantidadEmpleados) {
		this.cantidadEmpleados = cantidadEmpleados;
	}
	public double getFacturacionAnual() {
		return facturacionAnual;
	}
	public void setFacturacionAnual(double facturacionAnual) {
		this.facturacionAnual = facturacionAnual;
	}

	//Metodo própio
	public double ratioFacturacion() {
		return facturacionAnual/cantidadEmpleados;
	}
	
}//End Cliente
