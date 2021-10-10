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
	
	public Arma(Integer eleccionPrincipiante) {
		
		eleccionPrincipiante(eleccionPrincipiante);
	}


	
	public String getNombre() {
		return nombre;
	}

	public Integer getSumaAtaque() {
		return sumaAtaque;
	}
	
	public void setSumaAtaque(Integer a) {
		
		this.sumaAtaque = a;
	}

	public Integer getSumaDefensa() {
		return sumaDefensa;
	}


	public void setSumaDefensa(Integer sumaDefensa) {
		this.sumaDefensa = sumaDefensa;
	}
	
	public void setNombre(String nombre) {
		
		this.nombre = nombre;
	}
	
	public void eleccionPrincipiante(Integer opcion) {
		
		switch(opcion) {
		case 1:
			this.setNombre("Vara de mago");
			this.setSumaAtaque(9);
			this.setSumaDefensa(1);
			break;
		
		case 2:
			this.setNombre("Lucero de paladin");
			this.setSumaAtaque(3);
			this.setSumaDefensa(7);
			break;
		
		case 3:
			this.setNombre("Dagas de asesino");
			this.setSumaAtaque(7);
			this.setSumaDefensa(3);
			break;
		
		case 4:
			this.setNombre("Espada y escudo de caballero");
			this.setSumaAtaque(5);
			this.setSumaDefensa(5);
			break;
		
		default:
			this.setNombre("Manos desnudas");
			this.setSumaAtaque(1);
			this.setSumaDefensa(1);
			break;
		
	}

	


	}
}
