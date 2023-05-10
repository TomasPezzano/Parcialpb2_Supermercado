package ar.edu.unlam.pb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	
	  public void agregarProducto(Producto producto) {
	        productos.add(producto);
	    }
	
	public static int recuentoDeProductos(ArrayList<Producto> productos){
		int contador = 0;
		
		for(Producto producto : productos) {
			contador++;
		}
		
		return contador;
		
	}
	
	public void ordenarProductosPorCategoria() {
        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto primerProducto, Producto segundoProducto) {
                return primerProducto.getCategoria().compareTo(segundoProducto.getCategoria());
            }
        });
    }
	
}
