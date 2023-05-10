package ar.edu.unlam.pb;

import java.util.ArrayList;

public class Producto {

	private Double precio;
	private Promocion tipoDePromocion;
	private Categoria categoria;
	private Integer identificador;
	
	public Producto() {
		
	}
		public Producto(Double precio) {
			this.precio=precio;
		}
		
		public Producto(Double precio,Promocion tipoDePromocion, Integer identificador) {
			this.precio=precio;
			this.tipoDePromocion=tipoDePromocion;
			this.identificador=identificador;
		}
		
		public Integer getIdentificador() {
			return identificador;
		}
		public void setIdentificador(Integer identificador) {
			this.identificador = identificador;
		}
		public Producto (Categoria categoria) {
			this.categoria=categoria;
		}
	

		public Double getPrecio() {
			return precio;
		}

		public void setPrecio(Double precio) {
			this.precio = precio;
		}
		
		public Categoria getCategoria() {
			return categoria;
		}
		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}
		public Promocion getTipoDePromocion() {
			return tipoDePromocion;
		}
		public void setTipoDePromocion(Promocion tipoDePromocion) {
			this.tipoDePromocion = tipoDePromocion;
			
		}

		
		
	}

