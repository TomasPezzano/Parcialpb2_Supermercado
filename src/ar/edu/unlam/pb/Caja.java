package ar.edu.unlam.pb;

public class Caja {
	
	private Double dinero;
	private Integer id;
	
	
	public Caja(Integer id) {
		this.dinero=0.0;
		this.id=id;
	}
	
	public Caja() {
		
	}

	public Double getDinero() {
		return dinero;
	}

	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
