package ar.edu.unlam.pb;

import static org.junit.Assert.*;

import org.junit.Test;



public class Prueba {

	@Test
	public void queSeCreeElSupermercado() {
		Supermercado supermercado = new Supermercado();
		assertNotNull(supermercado);
	}
	
	@Test
	public void queElSupermercadoTengaEmpleados() {
		Supermercado supermercado = new Supermercado();
		Empleado empleado = new Empleado();
		assertTrue(supermercado.registrarEmpleado(empleado));
		
	}
	
	@Test
	public void queSeCreeUnEmpleado() {
		Empleado empleado = new Empleado();
		assertNotNull(empleado);
	}
	
	@Test
	public void queNoSePuedaRegistrarUnEmpleadoDuplicado() {
		Supermercado supermercado = new Supermercado();
		String Nombre = "Apu";
		String Dni = "35012345";
		Integer Sueldo = 100000;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);
		Empleado empleado2 = new Empleado(Nombre, Dni, Sueldo);
		
		int cantidadDeEmpleadosEsperada = 1;
		
		assertTrue(supermercado.agregarEmpleado(empleado));
		assertFalse(supermercado.agregarEmpleado(empleado2));
		assertEquals(cantidadDeEmpleadosEsperada, supermercado.getCantidadDeEmpleados());
	}
	
	@Test
	public void queSePuedaCalcularElAguinaldoDeUnEmpleado(){
		String Nombre = "Apu";
		String Dni = "35012345";
		Integer Sueldo = 100000;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);
		
		int valorEsperado = 600000;
		
		assertEquals(valorEsperado, empleado.calcularAguinaldo());
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
