package dominio;

public class Arma {
	
	private String nombre;
	private Integer sumaAtaque;
	private Integer sumaDefensa;
	
	public Arma(String nombre, Integer sumaAtaque, Integer sumaDefensa) {
		this.nombre = nombre;
		this.sumaAtaque = sumaAtaque;
		this.sumaDefensa = sumaDefensa;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getSumaAtaque() {
		return sumaAtaque;
	}

	public Integer getSumaDefensa() {
		return sumaDefensa;
	}
	
	

}
