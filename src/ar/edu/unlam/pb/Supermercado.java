package ar.edu.unlam.pb;


import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Iterator;
import java.util.LinkedHashSet;


public class Supermercado {

	private String Nombre;
	private HashSet<Empleado> Personal;
	private LinkedHashSet<Caja> listaDeCajas;
	private Double cantidadDeDineroEnCuenta;
	private HashSet<Month> listaDeMesesDondeYaSePagaronLosSueldos;
	private HashSet<MiembroPremium>listaDeMiembrosPremium;
	private HashSet<MiembroBasico>listaDeMiembrosBasico;
	private final Integer LIMITE_DE_ADVERTENCIAS;
	private final Integer FALTAS_PARA_SUMAR_ADVERTENCIA;


	public Supermercado() {
		Personal = new HashSet<Empleado>();
		listaDeCajas = new LinkedHashSet<Caja>();
		listaDeMesesDondeYaSePagaronLosSueldos = new HashSet<Month>();
		LIMITE_DE_ADVERTENCIAS = 3;
		FALTAS_PARA_SUMAR_ADVERTENCIA = 3;

		cantidadDeDineroEnCuenta = 0.0;
		this.listaDeMiembrosBasico=new HashSet<MiembroBasico>();
		this.listaDeMiembrosPremium=new HashSet<MiembroPremium>();

		cantidadDeDineroEnCuenta = 0.0;
	}

	public Supermercado(String Nombre, Integer FALTAS_PARA_SUMAR_ADVERTENCIA, Integer LIMITE_DE_ADVERTENCIAS) {
		this.Nombre = Nombre;
		Personal = new HashSet<Empleado>();
		this.FALTAS_PARA_SUMAR_ADVERTENCIA = FALTAS_PARA_SUMAR_ADVERTENCIA;
		this.LIMITE_DE_ADVERTENCIAS = LIMITE_DE_ADVERTENCIAS;

		cantidadDeDineroEnCuenta = 0.0;
		this.listaDeMiembrosBasico=new HashSet<MiembroBasico>();
		this.listaDeMiembrosPremium=new HashSet<MiembroPremium>();

		cantidadDeDineroEnCuenta = 0.0;

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
	
	public Double getCantidadDeDineroEnCuenta() {
		return cantidadDeDineroEnCuenta;
	}

	public void setCantidadDeDineroEnCuenta(Double cantidadDeDineroEnCuenta) {
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

	public ArrayList<Empleado> buscarEmpleadoPorSueldo(Double sueldoDeReferencia) {
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
	
	public Double calcularLosSueldosDeUnMes(Month Mes) {
		Double valorTotalDeLosSueldos = 0.0;
		Boolean debePagarAguinaldo = false;
		if(Mes == Month.JUNE || Mes == Month.DECEMBER) debePagarAguinaldo = true;
		
		if(debePagarAguinaldo) {
			for(Empleado empleadoActual : Personal) {
				Double cuentaDelEmpleadoActual = 0.0;
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
		
		Double cantidadDeDineroTotalDelSupermercado = getCantidadDeDineroEnCuenta();
		for(Caja cajaActual : listaDeCajas) {
			cantidadDeDineroTotalDelSupermercado += cajaActual.getDinero();
			}
		
		if(calcularLosSueldosDeUnMes(Mes) > cantidadDeDineroTotalDelSupermercado) {
			throw new IllegalArgumentException("No hay dinero suficiente para efectuar los pagos automáticos");
		}
		
		if(cantidadDeDineroEnCuenta < calcularLosSueldosDeUnMes(Mes)) {
			Double dineroATransferirPorCadaCaja = calcularLosSueldosDeUnMes(Mes)/getCantidadDeCajas();
			Double dineroFaltante = 0.0;
			for(Caja cajaActual : listaDeCajas) {
				if(cajaActual.getDinero() < dineroATransferirPorCadaCaja){
					dineroFaltante += (dineroATransferirPorCadaCaja - cajaActual.getDinero());
				}
				transferirACuentaSupermercado(cajaActual, dineroATransferirPorCadaCaja);
			}
			
			Iterator<Caja> iterador = listaDeCajas.iterator();
			while(iterador.hasNext() && dineroFaltante != 0.0){
				Caja cajaActual = iterador.next();
				if(cajaActual.getDinero() < dineroFaltante) {
					Double dineroTransferido = cajaActual.getDinero();
					transferirACuentaSupermercado(cajaActual, dineroFaltante);
					dineroFaltante -= dineroTransferido;
				}
				else{
					transferirACuentaSupermercado(cajaActual, dineroFaltante);
					dineroFaltante = 0.0;
				}
			}
		}
		
		Boolean debePagarAguinaldo = false;
		if(Mes == Month.JUNE || Mes == Month.DECEMBER) debePagarAguinaldo = true;
		
		if(debePagarAguinaldo) {
			for(Empleado empleadoActual : Personal) {
				Double cuentaDelEmpleadoActual = 0.0;
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

	private void transferir(Empleado empleado, Double dineroATransferir) {
		Double saldoDelEmpleado = empleado.getCantidadDeDineroEnCuentaSueldo();
		saldoDelEmpleado += dineroATransferir;
		cantidadDeDineroEnCuenta -=dineroATransferir;
		empleado.setCantidadDeDineroEnCuentaSueldo(saldoDelEmpleado);
	}
	
	public void transferirACuentaSupermercado(Caja caja, Double dineroATransferir) {
		Double dineroDeLaCaja = caja.getDinero();
		
		if(dineroDeLaCaja>=dineroATransferir) {
			dineroDeLaCaja -= dineroATransferir;
			cantidadDeDineroEnCuenta += dineroATransferir;
			caja.setDinero(dineroDeLaCaja);
		}
		else {
			cantidadDeDineroEnCuenta += dineroDeLaCaja;
			caja.setDinero(0.0);
		}
		
	}

	public boolean agregarCaja(Caja cajaNueva) {
		cajaNueva.setId(listaDeCajas.size() + 1);
		return listaDeCajas.add(cajaNueva);
	}
	
	public boolean eliminarCaja(Integer numeroDeCajaDeReferencia) {
		for(Caja cajaActual : listaDeCajas) {
			if(cajaActual.getId()==numeroDeCajaDeReferencia) {
				transferirACuentaSupermercado(cajaActual, cajaActual.getDinero());
				listaDeCajas.remove(cajaActual);
				renombrarCajas();
				return true;
			}
		}
		return false;
	}
	
	private void renombrarCajas(){
		Integer numeroDeCaja = 1;
		
		for(Caja cajaActual : listaDeCajas) {
			cajaActual.setId(numeroDeCaja);
			numeroDeCaja++;
		}
	}

	public Integer getCantidadDeCajas() {
		return listaDeCajas.size();
	}

}
