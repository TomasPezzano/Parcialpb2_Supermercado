package ar.edu.unlam.pb;

import java.util.HashSet;

public class Supermercado {
	
	private String Nombre;
	private HashSet<Empleado> Personal;
	private final Integer LIMITE_DE_ADVERTENCIAS;
	private final Integer FALTAS_PARA_SUMAR_ADVERTENCIA;
	
	public Supermercado() {
		Personal = new HashSet<Empleado>();
		LIMITE_DE_ADVERTENCIAS = 3;
		FALTAS_PARA_SUMAR_ADVERTENCIA = 3;
	}

	public Supermercado(String Nombre, Integer FALTAS_PARA_SUMAR_ADVERTENCIA, Integer LIMITE_DE_ADVERTENCIAS) {
		this.Nombre = Nombre;
		Personal = new HashSet<Empleado>();
		this.FALTAS_PARA_SUMAR_ADVERTENCIA = FALTAS_PARA_SUMAR_ADVERTENCIA;
		this.LIMITE_DE_ADVERTENCIAS = LIMITE_DE_ADVERTENCIAS;
	}
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public HashSet<Empleado> getPersonal() {
		return Personal;
	}

	public void setPersonal(HashSet<Empleado> personal) {
		Personal = personal;
	}

	public Integer getLIMITE_DE_ADVERTENCIAS() {
		return LIMITE_DE_ADVERTENCIAS;
	}

	public Integer getFALTAS_PARA_SUMAR_ADVERTENCIA() {
		return FALTAS_PARA_SUMAR_ADVERTENCIA;
	}
	
	
	
	

	
}
