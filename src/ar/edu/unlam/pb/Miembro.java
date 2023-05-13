package ar.edu.unlam.pb;

public abstract class Miembro {
	private String nombre;
	private String fecha;
	private int dni;
	private Double saldo;
	private Boolean miembroPremium;
	
	public Miembro(String nombre, String fecha, int dni){
		this.nombre = nombre;
		this.fecha = fecha;
		this.dni = dni;
		this.saldo = 0.0;
	}
	
	public Miembro(String nombre, String fecha, int dni, Double saldo){
		this.nombre = nombre;
		this.fecha = fecha;
		this.dni = dni;
		this.saldo = saldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Boolean getMiembroPremium() {
		return miembroPremium;
	}

	public void setMiembroPremium(Boolean miembroPremium) {
		this.miembroPremium = miembroPremium;
	}

	public static boolean sePuedeComprar(double saldo, Producto producto) {
		if(saldo >= producto.getPrecio()){
			return true;
		}
		else {
		return false;
		}
	}
}
