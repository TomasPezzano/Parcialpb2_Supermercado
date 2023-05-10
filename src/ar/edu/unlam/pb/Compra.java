package ar.edu.unlam.pb;

import java.util.ArrayList;

public class Compra {

	private Caja caja;
	private Empleado empleado;
	private Miembro miembro;
	private ArrayList<Producto> productos;
	
	
	
	public Compra(Caja caja, Empleado empleado, Miembro miembro) {
	
		this.caja = caja;
		this.empleado = empleado;
		this.miembro = miembro;
		this.productos = new ArrayList<Producto>();
	}



	public Compra() {
		
	}
	
	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}
	
	
	public Double darUnVuelto(Miembro miembro,Caja caja,Producto producto) {
		Double vuelto=0.0;
		if(miembro.getSaldo()>producto.getPrecio()) {
			vuelto=miembro.getSaldo()-producto.getPrecio();
			Double dinero= caja.getDinero()+(miembro.getSaldo()-vuelto);
			caja.setDinero(dinero);
			miembro.setSaldo(vuelto);
		}
		return vuelto;
	}
	
	public Double queSiLaCompraLaRealizaUnMiembroSeHagaUnDescuentoDe10Porciento(MiembroBasico miembro,Producto producto){
		Double precioFinal=0.0;
		Double descuentoInicial=10.0;
		if(!miembro.getMiembroPremium()) {
			Double descuento=descuentoInicial% producto.getPrecio();
			 precioFinal= producto.getPrecio()-descuento;
		}
		return precioFinal;
	}
	
	public Double queSiLaCompraLaRealizaUnMiembroPremiumSeHagaUnDescuentoDe40Porciento(MiembroPremium miembro,Producto producto){
		Double precioFinal=0.0;
		Double descuentoInicial=40.0;
		if(miembro.getMiembroPremium()) {
			Double descuento=descuentoInicial % producto.getPrecio();
			 precioFinal= producto.getPrecio()-descuento;
		}
		return precioFinal;
	}
	
	
	
	
}
