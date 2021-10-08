package dominio;

public class Heroe extends Personaje {

	private String nombre;
	private Arma[] inventario;
	private ClaseDeHeroe clase;

	public Heroe(String nombre, int eleccionClase) {
		this.nombre = nombre;
		inventario = new Arma[10];
		eleccionDeClase(eleccionClase);
	}
	public void agregarArma (Arma arma) {
		for (int i = 0; i < inventario.length; i++) {
			if(inventario[i]== null) {
				inventario[i] = arma;
				break;
			}
			i++;
		}
		
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ClaseDeHeroe getClase() {
		return clase;
	}

	public void setClase(ClaseDeHeroe clase) {
		this.clase = clase;
	}
	//@Override
	public void atacar(Personaje objetivo) {
	Integer dañoRealizado= (getPuntosDeAtaque() + obtenerDañoDeArmas()) - objetivo.getPuntosDeDefensa();
	Double multiplicadorMomentaneo= 1.7;
	if (Math.random()<= getProbabilidadDeCritico()) {
		dañoRealizado= (int)(dañoRealizado* multiplicadorMomentaneo);
	}
	if (dañoRealizado<0) {
		dañoRealizado=0;
	}
	objetivo.setPuntosDeVida(objetivo.getPuntosDeVida()-dañoRealizado);
	if (objetivo.getPuntosDeVida() == 0) {
		setPuntosDeVida(getVidaMaxima());
	}	
	}
	
	public Integer obtenerDañoDeArmas () {
		Integer daño=0;
		for (int i = 0; i < inventario.length; i++) {	
			if(inventario[i]!=null) {
				daño += inventario[i].getSumaAtaque();
		}
		}
		return daño;
	}
	
	public String verInventario() {
		
		String aux = " ";
		String nombres = " ";
		for(int i = 0; i<inventario.length; i++) {
		if(inventario[i] != null) {
			
			aux += inventario[i].getNombre()+"\n";
		}
	}
		return aux;
}
	
	public void eleccionDeClase(Integer opcion) {
		
		
		switch (opcion) {
		case 1:{  // MAGO
			this.setPuntosDeAtaque(20);
			this.setPuntosDeVida(50);
			this.setVidaMaxima(50);
			this.setProbabilidadDeCritico(0.15);
			this.setPuntosDeDefensa(20);
			clase = ClaseDeHeroe.MAGO;
			Arma vacia = new Arma(opcion);
			this.agregarArma(vacia);
			break;
		}
		
		case 2:{  // PALADIN
			this.setPuntosDeAtaque(15);
			this.setPuntosDeVida(60);
			this.setVidaMaxima(60);
			this.setProbabilidadDeCritico(0.1);
			this.setPuntosDeDefensa(25);
			clase = ClaseDeHeroe.PALADIN;
			Arma vacia = new Arma(opcion);
			this.agregarArma(vacia);
			break;
		}
		
		case 3:{ // ASESINO
			this.setPuntosDeAtaque(25);
			this.setPuntosDeVida(40);
			this.setVidaMaxima(40);
			this.setProbabilidadDeCritico(0.3);
			this.setPuntosDeDefensa(5);
			clase = ClaseDeHeroe.ASESINO;
			Arma vacia = new Arma(opcion);
			this.agregarArma(vacia);
			break;
		}
		
		case 4:{  // CABALLERO
			this.setPuntosDeAtaque(20);
			this.setPuntosDeVida(50);
			this.setVidaMaxima(50);
			this.setProbabilidadDeCritico(0.15);
			this.setPuntosDeDefensa(20);
			clase = ClaseDeHeroe.CABALLERO;
			Arma vacia = new Arma(opcion);
			this.agregarArma(vacia);
			break;
		}
		
		default:
			this.setPuntosDeAtaque(20);
			this.setPuntosDeVida(50);
			this.setVidaMaxima(50);
			this.setProbabilidadDeCritico(0.1);
			this.setPuntosDeDefensa(20);
			clase = ClaseDeHeroe.CABALLERO;
			Arma vacia = new Arma(opcion);
			this.agregarArma(vacia);
		
	}
}

	
}
