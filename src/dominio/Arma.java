package dominio;

public class Arma {
	
	private String nombre;
	private Integer sumaAtaque;
	private Integer sumaDefensa;
	
	public Arma(String nombre, Integer sumaAtaque, Integer sumaDefensa) {
		this.nombre = nombre;
		this.setSumaAtaque(sumaAtaque);
		this.sumaDefensa = sumaDefensa;
	}

	public Integer getSumaAtaque() {
		return sumaAtaque;
	}

	public void setSumaAtaque(Integer sumaAtaque) {
		this.sumaAtaque = sumaAtaque;
	}
	
	

}
