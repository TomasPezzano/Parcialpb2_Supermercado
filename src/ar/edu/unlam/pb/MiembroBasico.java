package ar.edu.unlam.pb;

public class MiembroBasico extends Miembro {

	
	
	public MiembroBasico(String nombre, String fecha, int dni, Double saldo) {
		super(nombre,fecha,dni,saldo);
		super.setMiembroPremium(false);
	}
	
	
}
