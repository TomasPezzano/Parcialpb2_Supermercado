package ar.edu.unlam.pb;

public class Caja {
	
	private Double dinero;
	private Integer id;
	private Boolean estaActiva; 
	
	public Caja() {
		this.dinero=0.0;
		estaActiva = true;
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

	public Boolean getEstaActiva() {
		return estaActiva;
	}

	public void setEstaActiva(Boolean estaActiva) {
		this.estaActiva = estaActiva;
	}

}
