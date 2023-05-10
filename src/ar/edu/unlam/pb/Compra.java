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
		if(!miembro.getMiembroPremium()) {
			Double descuento=producto.getPrecio() * miembro.getDESCUENTO();
			 precioFinal= producto.getPrecio()-descuento;
		}
		return precioFinal;
	}
	
	public Double queSiLaCompraLaRealizaUnMiembroPremiumSeHagaUnDescuentoDe40Porciento(MiembroPremium miembro,Producto producto){
		Double precioFinal=0.0;
		if(miembro.getMiembroPremium()) {
			Double descuento=miembro.getDESCUENTO() * producto.getPrecio();
			 precioFinal= producto.getPrecio()-descuento;
		}
		return precioFinal;
	}



	public Double validarLaPromocion2x1(Producto producto1, Producto producto2) {
		Double precioFinal=0.0;
		if(producto1.getTipoDePromocion() == producto2.getTipoDePromocion()) {
			if(producto1.getIdentificador()==producto2.getIdentificador()) {
				precioFinal = producto1.getPrecio();
			}
		}
		return precioFinal;
	}



	public boolean validarLaPromocion5X2(ArrayList<Producto>productos) {
		Promocion tipoPromocionAChequear =productos.get(0).getTipoDePromocion();
		Integer identificadorAChequear = productos.get(0).getIdentificador();
		for (Producto producto : productos) {
			if(!(producto.getTipoDePromocion() == tipoPromocionAChequear) && producto.getIdentificador()== identificadorAChequear) {
				return false;
			}
		}
		return true;
		
	}
	
	public boolean validarLaPromocion3X2(ArrayList<Producto>productos) {
		Promocion tipoPromocionAChequear =productos.get(0).getTipoDePromocion();
		Integer identificadorAChequear = productos.get(0).getIdentificador();
		for (Producto producto : productos) {
			if(!(producto.getTipoDePromocion() == tipoPromocionAChequear) && producto.getIdentificador()== identificadorAChequear) {
				return false;
			}
		}
		return true;
		
	}
	
	
	
	
	
	
	
	

	
	
	

	
	
	
	
}
