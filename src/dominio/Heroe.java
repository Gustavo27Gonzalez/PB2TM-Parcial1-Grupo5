package dominio;

public class Heroe extends Personaje {

	private String nombre;
	private Arma[] inventario;
	private ClaseDeHeroe clase;

	public Heroe(String nombre, int eleccionClase) {
		this.nombre = nombre;
		inventario = new Arma[10];
		switch (eleccionClase) {
		case 1: { // MAGO
			this.setPuntosDeAtaque(20);
			this.setPuntosDeVida(50);
			this.setProbabilidadDeCritico(0.1);
			this.setPuntosDeDefensa(20);
			clase = ClaseDeHeroe.MAGO;
			break;
		}
		case 2: { // PALADIN
			this.setPuntosDeAtaque(15);
			this.setPuntosDeVida(60);
			this.setProbabilidadDeCritico(0.1);
			this.setPuntosDeDefensa(25);
			clase = ClaseDeHeroe.PALADIN;
			break;
		}
		case 3: { // ASESINO
			this.setPuntosDeAtaque(25);
			this.setPuntosDeVida(40);
			this.setProbabilidadDeCritico(0.3);
			this.setPuntosDeDefensa(5);
			clase = ClaseDeHeroe.ASESINO;
			break;
		}
		case 4: { // CABALLERO
			this.setPuntosDeAtaque(20);
			this.setPuntosDeVida(50);
			this.setProbabilidadDeCritico(0.15);
			this.setPuntosDeDefensa(20);
			clase = ClaseDeHeroe.CABALLERO;
			break;
		}
		default:
			this.setPuntosDeAtaque(20);
			this.setPuntosDeVida(50);
			this.setProbabilidadDeCritico(0.20);
			this.setPuntosDeDefensa(20);
			clase = ClaseDeHeroe.CABALLERO;
			break;
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
	
	
}
