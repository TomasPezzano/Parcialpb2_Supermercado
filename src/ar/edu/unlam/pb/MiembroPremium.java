package ar.edu.unlam.pb;

public class MiembroPremium extends Miembro {

	private final Double DESCUENTO  =0.40;
	
	public MiembroPremium(String nombre, String fecha, int dni, Double saldo) {
		super(nombre,fecha,dni,saldo);
		super.setMiembroPremium(true);
	}

	public Double getDESCUENTO() {
		return DESCUENTO;
	}
	
	
	
	
}
