package dominio;

public class Arma {
	
	private String nombre;
	private Integer sumaAtaque;
	
	public Arma(String nombre, Integer sumaAtaque) {
		this.nombre = nombre;
		this.sumaAtaque = sumaAtaque;
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
	
	public void setNombre(String nombre) {
		
		this.nombre = nombre;
	}
	
	public void eleccionPrincipiante(Integer opcion) {
		
		switch(opcion) {
		case 1:
			this.setNombre("Vara de mago");
			this.setSumaAtaque(9);
			break;
		
		case 2:
			this.setNombre("Lucero de paladin");
			this.setSumaAtaque(3);
			break;
		
		case 3:
			this.setNombre("Dagas de asesino");
			this.setSumaAtaque(7);
			break;
		
		case 4:
			this.setNombre("Espada y escudo de caballero");
			this.setSumaAtaque(5);
			break;
		
		default:
			this.setNombre("Manos desnudas");
			this.setSumaAtaque(1);
			break;
		
	}

	


	}
}
