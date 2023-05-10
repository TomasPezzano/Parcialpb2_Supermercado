package ar.edu.unlam.pb;

import java.util.ArrayList;

import supermercado.dominio.Miembro;
import supermercado.dominio.Producto;


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
	
	public Double queSiLaCompraLaRealizaUnMiembroSeHagaUnDescuentoDe20Porciento(Miembro miembro,Producto producto){
		Double precioFinal=0.0;
		Double descuentoInicial=20.0;
		if(miembro.getTARJETA_MIEMBRO()) {
			Double descuento=descuentoInicial% producto.getPrecio();
			 precioFinal= producto.getPrecio()-descuento;
		}
		return precioFinal;
	}
	
	
}
