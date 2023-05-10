package ar.edu.unlam.pb;

public class Producto {

	private Double precio;
	private Promocion tipoDePromocion;
	private Categoria categoria;
	
	public Producto() {
		
	}
		public Producto(Double precio) {
			this.precio=precio;
		}
		
		public Producto(Double precio,Promocion tipoDePromocion) {
			this.precio=precio;
			this.tipoDePromocion=tipoDePromocion;
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
		
		
		
		public Promocion getTipoDePromocion() {
			return tipoDePromocion;
		}
		public void setTipoDePromocion(Promocion tipoDePromocion) {
			this.tipoDePromocion = tipoDePromocion;
		}
		public void validarPromocion() {
			switch (this.tipoDePromocion) {
			
			case _2x1:
				setTipoDePromocion(tipoDePromocion);
				
				
				break;
			case _3x1:
				
				setTipoDePromocion(tipoDePromocion);
				break;
				
			case _5x2:
				
				setTipoDePromocion(tipoDePromocion);
				break;
			}
		}
		public Categoria getCategoria() {
			return categoria;
		}
		
		
		
	}

