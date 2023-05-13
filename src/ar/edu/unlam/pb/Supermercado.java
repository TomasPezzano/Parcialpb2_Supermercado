package ar.edu.unlam.pb;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Supermercado {

	private String Nombre;
	private HashSet<Empleado> Personal;
	private Integer cantidadDeDineroEnCuenta;
	private HashSet<Month> listaDeMesesDondeYaSePagaronLosSueldos;
	private HashSet<MiembroPremium>listaDeMiembrosPremium;
	private HashSet<MiembroBasico>listaDeMiembrosBasico;
	private final Integer LIMITE_DE_ADVERTENCIAS;
	private final Integer FALTAS_PARA_SUMAR_ADVERTENCIA;


	public Supermercado() {
		Personal = new HashSet<Empleado>();
		listaDeMesesDondeYaSePagaronLosSueldos = new HashSet<Month>();
		LIMITE_DE_ADVERTENCIAS = 3;
		FALTAS_PARA_SUMAR_ADVERTENCIA = 3;
		cantidadDeDineroEnCuenta = 0;
		this.listaDeMiembrosBasico=new HashSet<MiembroBasico>();
		this.listaDeMiembrosPremium=new HashSet<MiembroPremium>();

	}

	public Supermercado(String Nombre, Integer FALTAS_PARA_SUMAR_ADVERTENCIA, Integer LIMITE_DE_ADVERTENCIAS) {
		this.Nombre = Nombre;
		Personal = new HashSet<Empleado>();
		this.FALTAS_PARA_SUMAR_ADVERTENCIA = FALTAS_PARA_SUMAR_ADVERTENCIA;
		this.LIMITE_DE_ADVERTENCIAS = LIMITE_DE_ADVERTENCIAS;
		cantidadDeDineroEnCuenta = 0;
		this.listaDeMiembrosBasico=new HashSet<MiembroBasico>();
		this.listaDeMiembrosPremium=new HashSet<MiembroPremium>();
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
	
	public Integer getCantidadDeDineroEnCuenta() {
		return cantidadDeDineroEnCuenta;
	}

	public void setCantidadDeDineroEnCuenta(Integer cantidadDeDineroEnCuenta) {
		this.cantidadDeDineroEnCuenta = cantidadDeDineroEnCuenta;
	}

	public boolean agregarEmpleado(Empleado empleado) {
		return Personal.add(empleado);
	}
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(listaDeMiembrosBasico, listaDeMiembrosPremium);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supermercado other = (Supermercado) obj;
		return Objects.equals(listaDeMiembrosBasico, other.listaDeMiembrosBasico)
				&& Objects.equals(listaDeMiembrosPremium, other.listaDeMiembrosPremium);
	}

	public int getCantidadDeEmpleados() {
		int cantidadDeEmpleados = 0;
		for (Empleado empleadoActual : Personal) {
			cantidadDeEmpleados++;
		}

		return cantidadDeEmpleados;
	}

	public void agregarFalta(Empleado empleado) {
		if (!Personal.contains(empleado)) {
			return;
		}

		int cantidadDeFaltas = empleado.getCantidadDeFaltas();
		int cantidadDeAdvertencias = empleado.getCantidadDeAdvertencias();

		cantidadDeFaltas++;
		empleado.setCantidadDeFaltas(cantidadDeFaltas);
		if (cantidadDeFaltas % FALTAS_PARA_SUMAR_ADVERTENCIA == 0) {
			cantidadDeAdvertencias++;
			empleado.setCantidadDeAdvertencias(cantidadDeAdvertencias);
			if (cantidadDeAdvertencias == LIMITE_DE_ADVERTENCIAS) {
				despedir(empleado);
			}
		}
	}

	private void despedir(Empleado empleado) {
		Personal.remove(empleado);
	}

	public boolean empleadoEstaRegistrado(Empleado empleado) {
		return Personal.contains(empleado);
	}

	public Empleado buscarEmpleadoPorDni(String dniDeReferencia) {
		for (Empleado empleadoActual : Personal) {
			if (empleadoActual.getDni() == dniDeReferencia) {
				return empleadoActual;
			}
		}

		return null;
	}

	public ArrayList<Empleado> buscarEmpleadoPorSueldo(Integer sueldoDeReferencia) {
		ArrayList<Empleado> listaDeResultados = new ArrayList<Empleado>();

		for (Empleado empleadoActual : Personal) {
			if (empleadoActual.getSueldo() == sueldoDeReferencia) {
				listaDeResultados.add(empleadoActual);
			}
		}

		return listaDeResultados;
	}

	public ArrayList<Empleado> buscarEmpleadoPorCantidadDeFaltas(Integer cantidadDeFaltas) {
		ArrayList<Empleado> listaDeResultados = new ArrayList<Empleado>();

		for (Empleado empleadoActual : Personal) {
			if (empleadoActual.getCantidadDeFaltas() == cantidadDeFaltas) {
				listaDeResultados.add(empleadoActual);
			}
		}

		return listaDeResultados;
	}

	public ArrayList<Empleado> buscarEmpleadoPorCantidadDeAdvertencias(Integer cantidadDeAdvertencias) {
		ArrayList<Empleado> listaDeResultados = new ArrayList<Empleado>();

		for (Empleado empleadoActual : Personal) {
			if (empleadoActual.getCantidadDeAdvertencias() == cantidadDeAdvertencias) {
				listaDeResultados.add(empleadoActual);
			}
		}

		return listaDeResultados;
	}
	
	public Integer calcularLosSueldosDeUnMes(Month Mes) {
		Integer valorTotalDeLosSueldos = 0;
		Boolean debePagarAguinaldo = false;
		if(Mes == Month.JUNE || Mes == Month.DECEMBER) debePagarAguinaldo = true;
		
		if(debePagarAguinaldo) {
			for(Empleado empleadoActual : Personal) {
				int cuentaDelEmpleadoActual = 0;
				cuentaDelEmpleadoActual = empleadoActual.getSueldo() + empleadoActual.calcularAguinaldo();
				valorTotalDeLosSueldos +=cuentaDelEmpleadoActual;
			}	
		}
		else {
			for(Empleado empleadoActual : Personal) {
				valorTotalDeLosSueldos += empleadoActual.getSueldo();
			}	
		}
		
		return valorTotalDeLosSueldos;
	}
	
	public boolean pagarLosSueldos(Month Mes){
		if(listaDeMesesDondeYaSePagaronLosSueldos.contains(Mes)) {
			throw new IllegalArgumentException("Los sueldos de este mes ya fueron pagados");
		}
		
		Boolean debePagarAguinaldo = false;
		if(Mes == Month.JUNE || Mes == Month.DECEMBER) debePagarAguinaldo = true;
		
		if(debePagarAguinaldo) {
			for(Empleado empleadoActual : Personal) {
				int cuentaDelEmpleadoActual = 0;
				cuentaDelEmpleadoActual = empleadoActual.getSueldo() + empleadoActual.calcularAguinaldo();
				transferir(empleadoActual, cuentaDelEmpleadoActual);
			}	
		}
		else {
			for(Empleado empleadoActual : Personal) {
				transferir(empleadoActual, empleadoActual.getSueldo());
			}	
		}
		
		listaDeMesesDondeYaSePagaronLosSueldos.add(Mes);
		if(listaDeMesesDondeYaSePagaronLosSueldos.size() == 12) {
			listaDeMesesDondeYaSePagaronLosSueldos.clear();
		}
		return true;
	}

	private void transferir(Empleado empleado, int dineroATransferir) {
		int saldoDelEmpleado = empleado.getCantidadDeDineroEnCuentaSueldo();
		saldoDelEmpleado += dineroATransferir;
		cantidadDeDineroEnCuenta -=dineroATransferir;
		empleado.setCantidadDeDineroEnCuentaSueldo(saldoDelEmpleado);
		
	}

}
