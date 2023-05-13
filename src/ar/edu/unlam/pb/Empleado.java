package ar.edu.unlam.pb;

import java.util.Objects;

public class Empleado {
	private String Nombre;
	private String Dni;
	private Double Sueldo;
	private Integer cantidadDeFaltas;
	private Integer cantidadDeAdvertencias;
	private Double cantidadDeDineroEnCuentaSueldo;

	public Empleado(String Nombre, String Dni, Double Sueldo) {
		if(validarDni(Dni)) {
			this.Dni=Dni;
			this.Nombre=Nombre;
			this.Sueldo=Sueldo;
			cantidadDeFaltas=0;
			cantidadDeAdvertencias=0;	
			cantidadDeDineroEnCuentaSueldo=0.0;
	}
	else throw new IllegalArgumentException("El DNI ingresado no es válido");
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(Dni, other.Dni);
	}

	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public String getDni() {
		return Dni;
	}
	
	public void setDni(String dni) {
		Dni = dni;
	}
	
	public Double getSueldo() {
		return Sueldo;
	}

	public void setSueldo(Double sueldo) {
		Sueldo = sueldo;
	}

	
	public int getCantidadDeFaltas() {
		return cantidadDeFaltas;
	}
	
	public void setCantidadDeFaltas(Integer cantidadDeFaltas) {
		this.cantidadDeFaltas = cantidadDeFaltas;
	}
	
	public int getCantidadDeAdvertencias() {
		return cantidadDeAdvertencias;
	}
	

	public void setCantidadDeAdvertencias(Integer cantidadDeAdvertencias) {
		this.cantidadDeAdvertencias = cantidadDeAdvertencias;
	}
	
	public Double getCantidadDeDineroEnCuentaSueldo() {
		return cantidadDeDineroEnCuentaSueldo;
	}

	public void setCantidadDeDineroEnCuentaSueldo(Double cantidadDeDineroEnCuentaSueldo) {
		this.cantidadDeDineroEnCuentaSueldo = cantidadDeDineroEnCuentaSueldo;
	}
	
	public Double calcularAguinaldo() {
		return Sueldo/2;
	}
	
	public boolean validarDni(String dni) {
		boolean sePudoValidar=false;
		if(dni.length()==8) {
			sePudoValidar = true;
		}
		
		return sePudoValidar;
	}

}
