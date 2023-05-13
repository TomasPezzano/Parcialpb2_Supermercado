package ar.edu.unlam.pb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Gondolas {
	private Integer id;
	private ArrayList<Producto> productos;	
	public Gondolas(){
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
	
	  public void agregarProducto(Producto producto) {
	        productos.add(producto);
	    }
	
	public static int recuentoDeProductos(ArrayList<Producto> productos){
		int contador = 0;
		
		for(Producto gondola : productos) {
			contador++;
		}
		
		return contador;
		
	}
    public int obtenerCantidadProductos() {
        return recuentoDeProductos(productos);
    }
    
	public static int sumaDelPrecioDeLosProductos(ArrayList<Producto> productos){
		int precioTotal = 0;
		
		for(Producto gondola : productos) {
			precioTotal += gondola.getPrecio();
		}
		
		return precioTotal;
		
	}
    
	public void ordenarProductosPorCategoria() {
        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto primerProducto, Producto segundoProducto) {
                return primerProducto.getCategoria().compareTo(segundoProducto.getCategoria());
            }
        });
    }

    public static int contarProductosEnTodasLasGondolas(ArrayList<Gondolas> gondolas) {
        int cantidadTotal = 0;
        
        for (Gondolas gondola : gondolas) {
            cantidadTotal += gondola.obtenerCantidadProductos();
        }

        return cantidadTotal;
    }
    
    public boolean descontarProductoDeLaGondola(Producto producto) {
        if (productos.contains(producto)) {
            productos.remove(producto);
            return true;
        }
        else {
        	return false;
        }
    }
    public boolean volverALlenarLaGondola(int cantidadMaxima, Producto producto) {
        if (obtenerCantidadProductos() <= cantidadMaxima) {
            while (obtenerCantidadProductos() < cantidadMaxima) {
                productos.add(producto);
            }
            return true;
        } else {
        	return false;
        }
    }
}
