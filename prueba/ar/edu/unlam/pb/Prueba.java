package ar.edu.unlam.pb;

import static org.junit.Assert.*;

import org.junit.Test;

import supermercado.dominio.Caja;
import supermercado.dominio.Compra;
import supermercado.dominio.Empleado;
import supermercado.dominio.Miembro;
import supermercado.dominio.Producto;


public class Prueba {

	@Test
	public void queSeCreeElSupermercado() {
		
	}
	
	@Test
	public void queElSupermercadoTengaEmpleados() {
		
	}
	
	@Test
	public void queNoSePuedaRegistrarUnEmpleadoDuplicado() {
		
	}
	
	@Test
	public void queSePuedaCalcularElAguinaldoDeUnEmpleado(){
		
	}
	
	@Test
	public void queSePuedaDepositarALosEmpleados() {
		
	}
	
	@Test
	public void queSePuedaAgregarUnaFaltaAlEmpleado() {
	
	}
	
	@Test
	public void queSiUnEmpleadoLegaAlLimiteDeFaltasSeLeSumeUnaAdvertencia(){
		
	}
	
	@Test
	public void queSiUnEmpleadoLlegaAlLimiteDeAdvertenciasSeaDespedido(){
		
	}
	
	@Test
	public void queSeCreeUnMiembro() {
		
	}
	
	@Test
	public void queSeCreeUnProducto() {
		
	}
	
	@Test
	public void queSeCreeUnaGondola() {
		
	}
	
	@Test
	public void queSeCreeUnDistribuidor() {
		
	}
	
	@Test
	public void queSeCreeUnEmpleado() {
		
	}
	
	@Test 
	public void queNoSePuedaCrearUnEmpleadoConUnDniQueNoTenga8Digitos() {
	
	}
	
	
	@Test
	public void queSeCreeUnaCaja() {
		
	}
	
	@Test
	public void queSeCreeUnaCompra() {
		
	}
	
	@Test
	public void queElClientePuedaComprarUnProducto(){
	}
	
	
	@Test
	public void queSePuedaDarUnVuelto() {
		String Nombre = "Juan";
		String Dni = "29874213";
		Integer Sueldo = 10000;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);
		
		MiembroBasico miembro = new MiembroBasico("", "", 0, 20.0);
		
		Caja caja = new Caja(1);
		
		Compra compra = new Compra(caja,empleado,miembro);
		
		Producto producto = new Producto(15.0);
		
		Double valorEsperado= 5.0;
		
		assertEquals(compra.darUnVuelto(miembro, caja, producto), valorEsperado);
			
		assertEquals(caja.getDinero(), (Double)15.0);
		
		assertEquals(miembro.getSaldo(),(Double) 5.0);
		
	}
	
	@Test
	public void queSePuedaHacerDescuentoPorSerMiembro() {
		MiembroBasico miembro = new MiembroBasico("", "", 0, 100.0);
		Producto producto = new Producto(100.0);
		Compra compra=new Compra();
		
		Double valorEsperado= 80.0;
		
		assertEquals(valorEsperado, compra.queSiLaCompraLaRealizaUnMiembroSeHagaUnDescuentoDe20Porciento(miembro, producto));
	}
	

}
