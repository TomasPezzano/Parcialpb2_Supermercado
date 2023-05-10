package ar.edu.unlam.pb;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
		String Nombre = "Apu";
		String Dni = "35012345";
		Integer Sueldo = 100000;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);
		assertTrue(supermercado.agregarEmpleado(empleado));

	}

	@Test
	public void queSeCreeUnEmpleado() {
		String Nombre = "Apu";
		String Dni = "35012345";
		Integer Sueldo = 100000;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);
		assertNotNull(empleado);
	}

	@Test
	public void queSePuedaAgregarMasDeUnEmpleado() {
		Supermercado supermercado = new Supermercado();
		String Nombre = "Apu";
		String Dni = "35012345";
		Integer Sueldo = 100000;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);

		String Dni2 = "45012345";
		Empleado empleado2 = new Empleado(Nombre, Dni2, Sueldo);

		supermercado.agregarEmpleado(empleado);
		supermercado.agregarEmpleado(empleado2);

		int cantidadEsperada = 2;
		assertEquals(cantidadEsperada, supermercado.getCantidadDeEmpleados());
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

	@Test(expected = IllegalArgumentException.class)
	public void queNoSePuedaCrearUnEmpleadoConUnDniQueNoTenga8Digitos() {
		String Nombre = "Juan";
		String Dni = "874213";
		Integer Sueldo = 100000;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);
	}

	@Test
	public void queSePuedaAgregarUnaFaltaAlEmpleado() {
		Supermercado supermercado = new Supermercado();
		String Nombre = "Apu";
		String Dni = "29874213";
		Integer Sueldo = 100000;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);
		supermercado.agregarEmpleado(empleado);

		int faltasEsperadas = 1;
		supermercado.agregarFalta(empleado);

		assertEquals(faltasEsperadas, empleado.getCantidadDeFaltas());
	}

	@Test
	public void queSiUnEmpleadoLegaAlLimiteDeFaltasSeLeSumeUnaAdvertencia() {
		Supermercado supermercado = new Supermercado();
		String Nombre = "Apu";
		String Dni = "29874213";
		Integer Sueldo = 100000;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);
		supermercado.agregarEmpleado(empleado);

		int advertenciasEsperadas = 1;
		supermercado.agregarFalta(empleado);
		supermercado.agregarFalta(empleado);
		supermercado.agregarFalta(empleado);

		assertEquals(advertenciasEsperadas, empleado.getCantidadDeAdvertencias());
	}

	@Test
	public void queSiUnEmpleadoLlegaAlLimiteDeAdvertenciasSeaDespedido() {
		Supermercado supermercado = new Supermercado();
		String Nombre = "Juan";
		String Dni = "29874213";
		Integer Sueldo = 100000;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);
		supermercado.agregarEmpleado(empleado);

		for (int i = 0; i < 9; i++) {
			supermercado.agregarFalta(empleado);
		}

		assertFalse(supermercado.empleadoEstaRegistrado(empleado));
	}

	@Test
	public void queSePuedaBuscarUnEmpleadoPorDni() {
		Supermercado supermercado = new Supermercado();
		String Nombre = "Apu";
		String Dni = "35012345";
		Integer Sueldo = 100000;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);
		supermercado.agregarEmpleado(empleado);

		assertEquals(empleado, supermercado.buscarEmpleadoPorDni(Dni));
	}

	@Test
	public void queSePuedaBuscarEmpleadosPorSueldo() {
		Supermercado supermercado = new Supermercado();
		String Nombre = "Apu";
		String Dni = "35012345";
		Integer Sueldo = 100000;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);

		String Dni2 = "45012345";
		Empleado empleado2 = new Empleado(Nombre, Dni2, Sueldo);

		supermercado.agregarEmpleado(empleado);
		supermercado.agregarEmpleado(empleado2);

		ArrayList<Empleado> listaDeResultados = supermercado.buscarEmpleadoPorSueldo(Sueldo);

		assertTrue(listaDeResultados.contains(empleado) && listaDeResultados.contains(empleado2));
	}

	@Test
	public void queSePuedaBuscarEmpleadosPorCantidadDeFaltas() {
		Supermercado supermercado = new Supermercado();
		String Nombre = "Apu";
		String Dni = "35012345";
		Integer Sueldo = 100000;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);

		String Dni2 = "45012345";
		Empleado empleado2 = new Empleado(Nombre, Dni2, Sueldo);

		supermercado.agregarEmpleado(empleado);
		supermercado.agregarEmpleado(empleado2);

		supermercado.agregarFalta(empleado);
		supermercado.agregarFalta(empleado);
		supermercado.agregarFalta(empleado2);
		supermercado.agregarFalta(empleado2);

		int cantidadDeFaltas = 2;

		ArrayList<Empleado> listaDeResultados = supermercado.buscarEmpleadoPorCantidadDeFaltas(cantidadDeFaltas);
		assertTrue(listaDeResultados.contains(empleado) && listaDeResultados.contains(empleado2));
	}

	@Test
	public void queSePuedaBuscarEmpleadosPorCantidadDeAdvertencias() {
		Supermercado supermercado = new Supermercado();
		String Nombre = "Apu";
		String Dni = "35012345";
		Integer Sueldo = 100000;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);

		String Dni2 = "45012345";
		Empleado empleado2 = new Empleado(Nombre, Dni2, Sueldo);

		supermercado.agregarEmpleado(empleado);
		supermercado.agregarEmpleado(empleado2);

		for (int i = 0; i < 6; i++) {
			supermercado.agregarFalta(empleado);
		}

		for (int i = 0; i < 6; i++) {
			supermercado.agregarFalta(empleado2);
		}
		;

		int cantidadDeAdvertencias = 2;

		ArrayList<Empleado> listaDeResultados = supermercado
				.buscarEmpleadoPorCantidadDeAdvertencias(cantidadDeAdvertencias);
		assertTrue(listaDeResultados.contains(empleado) && listaDeResultados.contains(empleado2));
	}

	@Test
	public void queSePuedaCalcularElAguinaldoDeUnEmpleado() {
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
	public void queSeCreeUnaCaja() {

	}

	@Test
	public void queSeCreeUnaCompra() {

	}

	@Test
	public void queElClientePuedaComprarUnProducto() {
	}

	@Test
	public void queSePuedaDarUnVuelto() {
		String Nombre = "Juan";
		String Dni = "29874213";
		Integer Sueldo = 10000;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);

		MiembroBasico miembro = new MiembroBasico("", "", 0, 20.0);

		Caja caja = new Caja(1);

		Compra compra = new Compra(caja, empleado, miembro);

		Producto producto = new Producto(15.0);

		Double valorEsperado = 5.0;

		assertEquals(compra.darUnVuelto(miembro, caja, producto), valorEsperado);

		assertEquals(caja.getDinero(), (Double) 15.0);

		assertEquals(miembro.getSaldo(), (Double) 5.0);

	}

	@Test
	public void queSePuedaHacerDescuentoPorSerMiembro() {
		MiembroBasico miembro = new MiembroBasico("", "", 0, 100.0);
		Producto producto = new Producto(100.0);
		Compra compra = new Compra();

		Double valorEsperado = 90.0;

		assertEquals(valorEsperado,
				compra.queSiLaCompraLaRealizaUnMiembroSeHagaUnDescuentoDe10Porciento(miembro, producto));
	}

	@Test
	public void queSePuedaHacerDescuentoPorSerMiembroPremium() {
		MiembroPremium miembro = new MiembroPremium("", "", 0, 100.0);
		Producto producto = new Producto(100.0);
		Compra compra = new Compra();

		Double valorEsperado = 60.0;

		assertEquals(valorEsperado,
				compra.queSiLaCompraLaRealizaUnMiembroPremiumSeHagaUnDescuentoDe40Porciento(miembro, producto));
	}

	@Test
	public void queSePuedaValidarUnDescuentoDeUnProducto() {

	}

}
