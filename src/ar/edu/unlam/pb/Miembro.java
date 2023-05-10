package ar.edu.unlam.pb;

public abstract class Miembro {
	private String nombre;
	private String fecha;
	private int dni;
	private Double saldo;
	private final Boolean TARJETA_MIEMBRO=true;
	
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

	public Boolean getTARJETA_MIEMBRO() {
		return TARJETA_MIEMBRO;
	}
}
