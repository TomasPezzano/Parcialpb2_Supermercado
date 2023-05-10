package ar.edu.unlam.pb;

import java.util.ArrayList;

public class Gondolas {
	private Integer id;
	private ArrayList<Producto> productos;
	private final Integer CANTIDAD_MAXIMA_DE_PRODUCTOS;
	
	public Gondolas(Integer CANTIDAD_MAXIMA_DE_PRODUCTOS){
		this.CANTIDAD_MAXIMA_DE_PRODUCTOS = CANTIDAD_MAXIMA_DE_PRODUCTOS;
		this.id = id;
		productos = new ArrayList<Producto>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public Integer getCANTIDAD_MAXIMA_DE_PRODUCTOS() {
		return CANTIDAD_MAXIMA_DE_PRODUCTOS;
	}

	
}
