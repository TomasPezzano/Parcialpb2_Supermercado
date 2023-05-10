package ar.edu.unlam.pb;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import supermercado.dominio.Empleado;



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
	
	
		@Test (expected = IllegalArgumentException.class)
		 	public void queNoSePuedaCrearUnEmpleadoConUnDniQueNoTenga8Digitos() {
			String Nombre = "Juan";
			String Dni = "874213";
			Integer Sueldo = 100000;
			Empleado empleado = new Empleado(Nombre, Dni, Sueldo);
		}
	
	
	@Test
	public void queSeCreeUnaCaja() {
		
	}
	
	@Test
	public void queSeCreeUnaCompra() {
		
	}
	
	@Test
	public void queElClientePuedaComprarUnProducto(){
		MiembroBasico miembroBasicoActual = new MiembroBasico("", "", 0, 50.0);
		MiembroPremium miembroPremiumActual = new MiembroPremium("", "", 0, 25.55);
		Compra compraActual = new Compra();
		Producto productoActual = new Producto(50.0);
				
		assertTrue(Miembro.sePuedeComprar(miembroBasicoActual.getSaldo(), productoActual));
		assertFalse(Miembro.sePuedeComprar(miembroPremiumActual.getSaldo(), productoActual));
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
	public void ordenarProductosSegunCategoriaEnMismaGondola(){
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
		
		Double valorEsperado= 90.0;
		
		assertEquals(valorEsperado, compra.queSiLaCompraLaRealizaUnMiembroSeHagaUnDescuentoDe10Porciento(miembro, producto));
	}
	
	
	@Test
	public void queSePuedaHacerDescuentoPorSerMiembroPremium() {
		MiembroPremium miembro = new MiembroPremium("", "", 0, 100.0);
		Producto producto = new Producto(100.0);
		Compra compra=new Compra();
		
		Double valorEsperado= 60.0;
		
		assertEquals(valorEsperado, compra.queSiLaCompraLaRealizaUnMiembroPremiumSeHagaUnDescuentoDe40Porciento(miembro, producto));
	}
	
	@Test 
	public void queSePuedaValidarUnDescuentoDeUnProducto() {
		
	}
	
	

}
