package ar.edu.unlam.pb;

public class MiembroPremium extends Miembro {

	public MiembroPremium(String nombre, String fecha, int dni, Double saldo) {
		super(nombre,fecha,dni,saldo);
		super.setMiembroPremium(true);
	}
	
	
	
	
}
