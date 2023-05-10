package ar.edu.unlam.pb;

public class MiembroBasico extends Miembro {

	private final Double DESCUENTO  =0.10;
	
	public MiembroBasico(String nombre, String fecha, int dni, Double saldo) {
		super(nombre,fecha,dni,saldo);
		super.setMiembroPremium(false);
	}

	public Double getDESCUENTO() {
		return DESCUENTO;
	}
	
	
	
	
}
