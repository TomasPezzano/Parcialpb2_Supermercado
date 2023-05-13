package ar.edu.unlam.pb;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Prueba {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

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
		Double Sueldo = 100000.0;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);
		assertTrue(supermercado.agregarEmpleado(empleado));

	}

	@Test
	public void queSeCreeUnEmpleado() {
		String Nombre = "Apu";
		String Dni = "35012345";
		Double Sueldo = 100000.0;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);
		assertNotNull(empleado);
	}

	@Test
	public void queSePuedaAgregarMasDeUnEmpleado() {
		Supermercado supermercado = new Supermercado();
		String Nombre = "Apu";
		String Dni = "35012345";
		Double Sueldo = 100000.0;
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
		Double Sueldo = 100000.0;
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
		Double Sueldo = 100000.0;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);
	}

	@Test
	public void queSePuedaAgregarUnaFaltaAlEmpleado() {
		Supermercado supermercado = new Supermercado();
		String Nombre = "Apu";
		String Dni = "29874213";
		Double Sueldo = 100000.0;
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
		Double Sueldo = 100000.0;
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
		Double Sueldo = 100000.0;
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
		Double Sueldo = 100000.0;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);
		supermercado.agregarEmpleado(empleado);

		assertEquals(empleado, supermercado.buscarEmpleadoPorDni(Dni));
	}

	@Test
	public void queSePuedaBuscarEmpleadosPorSueldo() {
		Supermercado supermercado = new Supermercado();
		String Nombre = "Apu";
		String Dni = "35012345";
		Double Sueldo = 100000.0;
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
		Double Sueldo = 100000.0;
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
		Double Sueldo = 100000.0;
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
	public void queSePuedaCalcularLosSueldosDeUnMes() {
		Supermercado supermercado = new Supermercado();
		String Nombre = "Apu";
		String Dni = "35012345";
		Double Sueldo = 100000.0;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);

		String Dni2 = "28345987";
		Empleado empleado2 = new Empleado(Nombre, Dni2, Sueldo);

		supermercado.agregarEmpleado(empleado2);
		supermercado.agregarEmpleado(empleado);

		Month Mes = Month.FEBRUARY;
		Double resultadoEsperado = 200000.0;
		assertEquals(resultadoEsperado, supermercado.calcularLosSueldosDeUnMes(Mes));

	}

	@Test
	public void queSePuedaCalcularElAguinaldoDeUnEmpleado() {
		String Nombre = "Apu";
		String Dni = "35012345";
		Double Sueldo = 100000.0;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);

		Double valorEsperado = 50000.0;

		assertEquals(valorEsperado, empleado.calcularAguinaldo());
	}

	@Test
	public void queSePuedaCalcularLosSueldosDeUnMesConAguinaldos() {
		Supermercado supermercado = new Supermercado();
		String Nombre = "Apu";
		String Dni = "35012345";
		Double Sueldo = 100000.0;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);

		String Dni2 = "28345987";
		Empleado empleado2 = new Empleado(Nombre, Dni2, Sueldo);

		supermercado.agregarEmpleado(empleado2);
		supermercado.agregarEmpleado(empleado);

		Month Mes = Month.DECEMBER;
		Double resultadoEsperado = 300000.0;
		assertEquals(resultadoEsperado, supermercado.calcularLosSueldosDeUnMes(Mes));

	}

	@Test
	public void queSePuedaDepositarLosSueldoDeUnMes() {
		Supermercado supermercado = new Supermercado();
		String Nombre = "Apu";
		String Dni = "35012345";
		Double Sueldo = 100000.0;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);

		String Dni2 = "28345987";
		Empleado empleado2 = new Empleado(Nombre, Dni2, Sueldo);

		supermercado.agregarEmpleado(empleado2);
		supermercado.agregarEmpleado(empleado);
		Month Mes = Month.APRIL;
		supermercado.setCantidadDeDineroEnCuenta(supermercado.calcularLosSueldosDeUnMes(Mes));
		Double cantidadDeDineroEsperadoDespuesDePagar = 0.0;

		supermercado.pagarLosSueldos(Mes);

		assertEquals(cantidadDeDineroEsperadoDespuesDePagar, supermercado.getCantidadDeDineroEnCuenta());
		assertEquals(Sueldo, empleado.getCantidadDeDineroEnCuentaSueldo());
		assertEquals(Sueldo, empleado2.getCantidadDeDineroEnCuentaSueldo());

	}

	@Test
	public void queSePuedaDepositarLosSueldoDeUnMesConAguinaldos() {
		Supermercado supermercado = new Supermercado();
		String Nombre = "Apu";
		String Dni = "35012345";
		Double Sueldo = 100000.0;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);

		String Dni2 = "28345987";
		Double Sueldo2 = 200000.0;
		Empleado empleado2 = new Empleado(Nombre, Dni2, Sueldo2);

		supermercado.agregarEmpleado(empleado2);
		supermercado.agregarEmpleado(empleado);
		Month Mes = Month.DECEMBER;
		supermercado.setCantidadDeDineroEnCuenta(supermercado.calcularLosSueldosDeUnMes(Mes));
		Double cantidadDeDineroEsperadoDespuesDePagar = 0.0;
		Double cantidadQueDeberiaCobrarEmpleado = Sueldo + empleado.calcularAguinaldo();
		Double cantidadQueDeberiaCobrarEmpleado2 = Sueldo2 + empleado2.calcularAguinaldo();

		supermercado.pagarLosSueldos(Mes);

		assertEquals(cantidadDeDineroEsperadoDespuesDePagar, supermercado.getCantidadDeDineroEnCuenta());
		assertEquals(cantidadQueDeberiaCobrarEmpleado, empleado.getCantidadDeDineroEnCuentaSueldo());
		assertEquals(cantidadQueDeberiaCobrarEmpleado2, empleado2.getCantidadDeDineroEnCuentaSueldo());

	}

	@Test
	public void queNoSePuedaPagarDosVecesLosSueldosDeUnMismoMes() {
		thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Los sueldos de este mes ya fueron pagados");
		
		Supermercado supermercado = new Supermercado();
		String Nombre = "Apu";
		String Dni = "35012345";
		Double Sueldo = 100000.0;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);

		String Dni2 = "28345987";
		Empleado empleado2 = new Empleado(Nombre, Dni2, Sueldo);

		supermercado.agregarEmpleado(empleado2);
		supermercado.agregarEmpleado(empleado);
		Month Mes = Month.APRIL;
		supermercado.setCantidadDeDineroEnCuenta(supermercado.calcularLosSueldosDeUnMes(Mes));
		supermercado.pagarLosSueldos(Mes);
		supermercado.pagarLosSueldos(Mes);
	}

	@Test
	public void queSeCreeUnMiembroBasico() {
		MiembroBasico miembro = new MiembroBasico("lucas", "", 45487987, 100.0);
	}

	@Test
	public void queSeCreeUnMiembro() {
		MiembroPremium miembro = new MiembroPremium("marcos", "", 35757987, 900.0);
	}

	@Test
	public void queSeCreeUnProducto() {
		Producto producto = new Producto();
		assertNotNull(producto);
	}

	@Test
	public void queSeCreeUnaGondola() {

	}

	@Test
	public void queSeCreeUnDistribuidor() {

	}

	@Test
	public void queSeCreeUnaCaja() {
		Caja caja = new Caja();
		assertNotNull(caja);
	}

	@Test
	public void queSePuedaRegistrarUnaCajaEnUnSupermercado() {
		Supermercado supermercado = new Supermercado();
		Caja caja1 = new Caja();

		assertTrue(supermercado.agregarCaja(caja1));
	}

	@Test
	public void queSePuedaRegistrarMasDeUnaCaja() {
		Supermercado supermercado = new Supermercado();
		Caja caja1 = new Caja();
		Caja caja2 = new Caja();
		Integer cantidadDeCajasEsperada = 2;

		assertTrue(supermercado.agregarCaja(caja1));
		assertTrue(supermercado.agregarCaja(caja2));
		assertEquals(cantidadDeCajasEsperada, supermercado.getCantidadDeCajas());

		Integer numeroDeCajaEsperado = 1;
		assertEquals(numeroDeCajaEsperado, caja1.getId());
		numeroDeCajaEsperado = 2;
		assertEquals(numeroDeCajaEsperado, caja2.getId());

	}

	@Test
	public void queSePuedaEliminarUnaCaja() {
		Supermercado supermercado = new Supermercado();
		Caja caja1 = new Caja();
		Caja caja2 = new Caja();
		Integer cantidadDeCajasEsperada = 1;

		supermercado.agregarCaja(caja1);
		supermercado.agregarCaja(caja2);

		assertTrue(supermercado.eliminarCaja(caja1.getId()));
		assertEquals(cantidadDeCajasEsperada, supermercado.getCantidadDeCajas());
	}

	@Test
	public void queAlEliminarUnaCajaSeCambieElNumeroDeLasDemas() {
		Supermercado supermercado = new Supermercado();
		Caja caja1 = new Caja();
		Caja caja2 = new Caja();
		Caja caja3 = new Caja();
		Caja caja4 = new Caja();

		supermercado.agregarCaja(caja1);
		supermercado.agregarCaja(caja2);
		supermercado.agregarCaja(caja3);
		supermercado.agregarCaja(caja4);

		supermercado.eliminarCaja(caja1.getId());

		Integer idEsperadoParaCaja2 = 1;
		Integer idEsperadoParaCaja3 = 2;
		Integer idEsperadoParaCaja4 = 3;
		assertEquals(idEsperadoParaCaja2, caja2.getId());
		assertEquals(idEsperadoParaCaja3, caja3.getId());
		assertEquals(idEsperadoParaCaja4, caja4.getId());
	}

	@Test
	public void queAlEliminarUnaCajaElDineroPaseALaCuentaDelSupermercado() {
		Supermercado supermercado = new Supermercado();
		Caja caja1 = new Caja();
		supermercado.agregarCaja(caja1);

		Double dineroDeCaja = 100.0;
		caja1.setDinero(dineroDeCaja);
		supermercado.eliminarCaja(1);

		assertEquals(dineroDeCaja, supermercado.getCantidadDeDineroEnCuenta());

	}

	@Test
	public void queSePuedaTransferirDineroDeUnaCajaALaCuentaDelSupermercado() {
		Supermercado supermercado = new Supermercado();
		Caja caja1 = new Caja();
		supermercado.agregarCaja(caja1);
		Double dineroDeCaja = 120.0;
		Double dineroATransferir = 50.0;
		caja1.setDinero(dineroDeCaja);
		supermercado.transferirACuentaSupermercado(caja1, dineroATransferir);
		dineroDeCaja -= dineroATransferir;

		assertEquals(dineroATransferir, supermercado.getCantidadDeDineroEnCuenta());
		assertEquals(dineroDeCaja, caja1.getDinero());
	}

	@Test
	public void queSiAlPagarLosSueldosNoHayDineroSuficienteSeTomeDeLasCajas() {
		Supermercado supermercado = new Supermercado();
		Double dineroParaCadaCaja = 10000.0;
		Caja caja1 = new Caja();
		supermercado.agregarCaja(caja1);
		caja1.setDinero(dineroParaCadaCaja);

		Caja caja2 = new Caja();
		supermercado.agregarCaja(caja2);
		caja2.setDinero(dineroParaCadaCaja);

		Caja caja3 = new Caja();
		supermercado.agregarCaja(caja3);
		caja3.setDinero(dineroParaCadaCaja);

		Caja caja4 = new Caja();
		supermercado.agregarCaja(caja4);
		caja4.setDinero(dineroParaCadaCaja);

		String Nombre = "Apu";
		String Dni = "35012345";
		Double Sueldo = 20000.0;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);
		supermercado.agregarEmpleado(empleado);

		Month Mes = Month.APRIL;
		Double cantidadEsperadaLuegoDePagarLosSueldos = 5000.0;

		assertTrue(supermercado.pagarLosSueldos(Mes));
		assertEquals(Sueldo, empleado.getCantidadDeDineroEnCuentaSueldo());
		assertEquals(cantidadEsperadaLuegoDePagarLosSueldos, caja1.getDinero());
		assertEquals(cantidadEsperadaLuegoDePagarLosSueldos, caja2.getDinero());
		assertEquals(cantidadEsperadaLuegoDePagarLosSueldos, caja3.getDinero());
		assertEquals(cantidadEsperadaLuegoDePagarLosSueldos, caja4.getDinero());
	}

	@Test
	public void queSePuedaPagarSueldosConElDineroDeLasCajasInclusoSiHayCajasVacias() {
		Supermercado supermercado = new Supermercado();
		Caja caja1 = new Caja();
		supermercado.agregarCaja(caja1);

		Caja caja2 = new Caja();
		supermercado.agregarCaja(caja2);
		caja2.setDinero(20000.0);

		Caja caja3 = new Caja();
		supermercado.agregarCaja(caja3);
		caja3.setDinero(5000.0);

		Caja caja4 = new Caja();
		supermercado.agregarCaja(caja4);
		caja4.setDinero(2000.0);

		String Nombre = "Apu";
		String Dni = "35012345";
		Double Sueldo = 20000.0;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);
		supermercado.agregarEmpleado(empleado);

		Month Mes = Month.APRIL;

		Double cantidadDeDineroEsperadaParaCajasUnoTresYCuatro = 0.0;
		Double cantidadDeDineroEsperadaParaCajaDos = 7000.0;

		assertTrue(supermercado.pagarLosSueldos(Mes));
		assertEquals(Sueldo, empleado.getCantidadDeDineroEnCuentaSueldo());
		assertEquals(cantidadDeDineroEsperadaParaCajasUnoTresYCuatro, caja1.getDinero());
		assertEquals(cantidadDeDineroEsperadaParaCajaDos, caja2.getDinero());
		assertEquals(cantidadDeDineroEsperadaParaCajasUnoTresYCuatro, caja3.getDinero());
		assertEquals(cantidadDeDineroEsperadaParaCajasUnoTresYCuatro, caja3.getDinero());
	}

	@Test
	public void queNoSePuedaPagarSueldosSiNoHayDineroSuficienteNiEnCuentaNiEnLasCajas() {
		thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("No hay dinero suficiente para efectuar los pagos automáticos");
		
		Supermercado supermercado = new Supermercado();
		Caja caja1 = new Caja();
		supermercado.agregarCaja(caja1);
		caja1.setDinero(2000.0);
		
		Caja caja2 = new Caja();
		supermercado.agregarCaja(caja2);
		caja2.setDinero(2000.0);

		Caja caja3 = new Caja();
		supermercado.agregarCaja(caja3);
		caja3.setDinero(2000.0);

		Caja caja4 = new Caja();
		supermercado.agregarCaja(caja4);
		caja4.setDinero(2000.0);

		String Nombre = "Apu";
		String Dni = "35012345";
		Double Sueldo = 20000.0;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);
		supermercado.agregarEmpleado(empleado);

		Month Mes = Month.APRIL;

		Double cantidadDeDineroEsperadaParaCajasUnoTresYCuatro = 0.0;
		Double cantidadDeDineroEsperadaParaCajaDos = 7000.0;

		assertTrue(supermercado.pagarLosSueldos(Mes));
		assertEquals(Sueldo, empleado.getCantidadDeDineroEnCuentaSueldo());
		assertEquals(cantidadDeDineroEsperadaParaCajasUnoTresYCuatro, caja1.getDinero());
		assertEquals(cantidadDeDineroEsperadaParaCajaDos, caja2.getDinero());
		assertEquals(cantidadDeDineroEsperadaParaCajasUnoTresYCuatro, caja3.getDinero());
		assertEquals(cantidadDeDineroEsperadaParaCajasUnoTresYCuatro, caja3.getDinero());
	}

	@Test
	public void queSeCreeUnaCompra() {
		Compra compra = new Compra();
		assertNotNull(compra);
	}

	@Test
	public void queElClientePuedaComprarUnProducto() {
		Caja caja = new Caja();
		MiembroBasico miembroBasicoActual = new MiembroBasico("", "", 0, 50.0);
		MiembroPremium miembroPremiumActual = new MiembroPremium("", "", 0, 25.55);
		Producto productoActual = new Producto(50.0);

		assertTrue(Miembro.sePuedeComprar(miembroBasicoActual, productoActual, caja));
		assertFalse(Miembro.sePuedeComprar(miembroPremiumActual, productoActual, caja));
	}

	public void queSeSumeElPrecioDeTodosLosProductos() {
		double precioFinalActual = 93.0;
		ArrayList<Producto> gondola = new ArrayList<>();
        gondola.add(new Producto(50.0));
        gondola.add(new Producto(32.0));
        gondola.add(new Producto(11.0));
        
        double precioFinalPrueba = Gondolas.sumaDelPrecioDeLosProductos(gondola);
        
		assertEquals(precioFinalPrueba, precioFinalActual, 0);
	}

	@Test
	public void queSePuedaHacerUnRecuentoDeUnaGondola(){
		int cantidadDeProductos = 3;
		ArrayList<Producto> gondola = new ArrayList<>();
		gondola.add(new Producto());
		gondola.add(new Producto());
		gondola.add(new Producto());

		int resultado = Gondolas.recuentoDeProductos(gondola);
		assertEquals(cantidadDeProductos, resultado);

	}

	@Test
	public void queSeRealiceUnRecuentoDeProductosDeTodasLasGondola() {
		int cantidadTotal = 6;

		Gondolas gondola1 = new Gondolas();
		Gondolas gondola2 = new Gondolas();
		Gondolas gondola3 = new Gondolas();

		gondola1.agregarProducto(new Producto());
		gondola2.agregarProducto(new Producto());
		gondola2.agregarProducto(new Producto());
		gondola3.agregarProducto(new Producto());
		gondola3.agregarProducto(new Producto());
		gondola3.agregarProducto(new Producto());

		ArrayList<Gondolas> gondolas = new ArrayList<>();
		gondolas.add(gondola1);
		gondolas.add(gondola2);
		gondolas.add(gondola3);

		int gondolasCantidadTotal = Gondolas.contarProductosEnTodasLasGondolas(gondolas);

		assertEquals(cantidadTotal, gondolasCantidadTotal);
	}

	@Test
	public void queSePuedaOrdenarProductosSegunCategoriaEnMismaGondola(){

		Gondolas gondolaActual = new Gondolas();
		gondolaActual.agregarProducto(new Producto(Categoria.comestible));
		gondolaActual.agregarProducto(new Producto(Categoria.bebible));
		gondolaActual.agregarProducto(new Producto(Categoria.comestible));
		gondolaActual.agregarProducto(new Producto(Categoria.bebible));

		gondolaActual.ordenarProductosPorCategoria();
		assertEquals(Categoria.bebible, gondolaActual.getProductos().get(0).getCategoria());
		assertEquals(Categoria.bebible, gondolaActual.getProductos().get(1).getCategoria());
		assertEquals(Categoria.comestible, gondolaActual.getProductos().get(2).getCategoria());
		assertEquals(Categoria.comestible, gondolaActual.getProductos().get(3).getCategoria());

	}

	@Test
	public void queCuandoSeCompreUnProductoEsteSeDescuenteDeLaGondola(){
		int cantidadDeProductosFinal = 2;
		Caja caja = new Caja();
		Gondolas gondola = new Gondolas();
		MiembroBasico miembro = new MiembroBasico(null, null, 0, 26.0);
		
		gondola.agregarProducto(new Producto(50.0));
		gondola.agregarProducto(new Producto(25.0));
		gondola.agregarProducto(new Producto(10.0));
				
		Miembro.sePuedeComprar(miembro, gondola.getProductos().get(1), caja);
		assertTrue(Miembro.sePuedeComprar(miembro, gondola.getProductos().get(1), caja));

		gondola.descontarProductoDeLaGondola(gondola.getProductos().get(1));
        assertEquals(cantidadDeProductosFinal, gondola.obtenerCantidadProductos());
	}
	
	@Test
	public void queSiLaGondolaTieneCiertaCantidadSeLleneNuevamente() {
		int productosEsperados = 5;
		int capacidadMaximaDeLaGondola = 5;
        Gondolas gondola = new Gondolas();
        gondola.agregarProducto(new Producto(10.0));
        gondola.agregarProducto(new Producto(5.0));
        gondola.volverALlenarLaGondola(capacidadMaximaDeLaGondola, gondola.getProductos().get(0));
        
        assertEquals(productosEsperados, gondola.obtenerCantidadProductos());
	}
	
	@Test
	public void queSePuedaDarUnVuelto() {
		String Nombre = "Juan";
		String Dni = "29874213";
		Double Sueldo = 100000.0;
		Empleado empleado = new Empleado(Nombre, Dni, Sueldo);

		MiembroBasico miembro = new MiembroBasico("", "", 0, 20.0);

		Caja caja = new Caja();

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

	@Test
	public void queSePuedaValidarUnaPromocion() {
		Double precio = 100.0;
		Promocion tipoPromocion = Promocion._3x1;
		Integer identificador = 1;

		Producto producto = new Producto(precio, tipoPromocion, 1);

		Promocion esperada = Promocion._3x1;

		assertEquals(producto.getTipoDePromocion(), esperada);

	}

	@Test
	public void queSePuedaValidarUnaPromocion2x1() {
		Promocion tipoPromocion = Promocion._2x1;
		Producto producto = new Producto(100.0, tipoPromocion, 1);
		Producto producto2 = new Producto(100.0, tipoPromocion, 1);
		Compra compra = new Compra();
		Double precioFinalEsperado = 100.0;

		assertEquals(compra.validarLaPromocion2x1(producto, producto2), precioFinalEsperado);

	}

	@Test
	public void queSePuedaValidarUnaPromocion5x2() {
		Promocion tipoPromocion = Promocion._5x2;
		Producto producto = new Producto(100.0, tipoPromocion, 1);
		Producto producto2 = new Producto(100.0, tipoPromocion, 1);
		Producto producto3 = new Producto(100.0, tipoPromocion, 1);
		Producto producto4 = new Producto(100.0, tipoPromocion, 1);
		Producto producto5 = new Producto(100.0, tipoPromocion, 1);
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(producto);
		productos.add(producto2);
		productos.add(producto3);
		productos.add(producto4);
		productos.add(producto5);

		Compra compra = new Compra();

		assertTrue(compra.validarLaPromocion5X2(productos));
	}

	@Test
	public void queSePuedaValidarUnaPromocion3x2() {
		Promocion tipoPromocion = Promocion._5x2;
		Producto producto = new Producto(100.0, tipoPromocion, 1);
		Producto producto2 = new Producto(100.0, tipoPromocion, 1);
		Producto producto3 = new Producto(100.0, tipoPromocion, 1);

		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(producto);
		productos.add(producto2);
		productos.add(producto3);

		Compra compra = new Compra();

		assertTrue(compra.validarLaPromocion3X2(productos));
	}
	
	@Test
	public void queSiLaCajaEstaInactivaNoSePuedaComprar() {		
		Caja caja = new Caja();
		MiembroBasico miembro = new MiembroBasico(null, null, 0, 50.0);
		Producto producto = new Producto(50.0);
		caja.setEstaActiva(false);
		
		assertFalse(Miembro.sePuedeComprar(miembro, producto, caja));
		
		
		
	}
}
