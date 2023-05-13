package ar.edu.unlam.pb;

public class MiembroPremium extends Miembro {

	private final Double DESCUENTO;
	private Double valorSubscripcion;

	public MiembroPremium(String nombre, String fecha, int dni, Double valorSubscripcion, Double saldo) {
		super(nombre,fecha,dni,saldo);
		super.setMiembroPremium(true);
		DESCUENTO = 0.40;
		this.valorSubscripcion = valorSubscripcion;
	}
	
	public MiembroPremium(String nombre, String fecha, int dni, Double valorSubscripcion) {
		super(nombre,fecha,dni);
		super.setMiembroPremium(true);
		DESCUENTO = 0.40;
		this.valorSubscripcion = valorSubscripcion;
	}

	public Double getDESCUENTO() {
		return DESCUENTO;
	}
	
	public void setValorSubscripcion(Double valorSubscripcion) {
		this.valorSubscripcion = valorSubscripcion;
	}
	
	public Double getValorSubscripcion() {
		return valorSubscripcion;
	}
}
