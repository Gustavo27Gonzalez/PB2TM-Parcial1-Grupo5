package dominio;

public class Heroe extends Personaje {

	private String nombre;
	private Arma[] inventario;
	private ClaseDeHeroe clase;
<<<<<<< Updated upstream
=======
	private Integer contadorDeAtaques;
	private Integer BONUSATAQUECRITICO;
>>>>>>> Stashed changes

	public Heroe (String nombre, int eleccionClase) {
		this.nombre = nombre;
		inventario = new Arma[10];
<<<<<<< Updated upstream
=======
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
	
	public String verInventario() {
		
		String aux = " ";
		String nombre = " ";
		for(int i = 0; i<inventario.length; i++) {
		if(inventario[i] != null) {
			
			aux += inventario[i].getNombre()+"\n";
		}
	}
		return aux;
}
	
	public void eleccionDeClase(Integer eleccionClase) {
		
		

		this.contadorDeAtaques=0;
>>>>>>> Stashed changes
		switch (eleccionClase) {
		case 1: { // MAGO
			this.setPuntosDeAtaque(20);
			this.setPuntosDeVida(50);
			this.setVidaMaxima(50);
			this.setProbabilidadDeCritico(0.15);
			this.setPuntosDeDefensa(20);
			clase = ClaseDeHeroe.MAGO;
<<<<<<< Updated upstream
=======
			Arma vacia = new Arma(eleccionClase);
			this.agregarArma(vacia);
>>>>>>> Stashed changes
			break;
		}
		case 2: { // PALADIN
			this.setPuntosDeAtaque(15);
			this.setPuntosDeVida(60);
			this.setVidaMaxima(60);
			this.setProbabilidadDeCritico(0.1);
			this.setPuntosDeDefensa(25);
			clase = ClaseDeHeroe.PALADIN;
<<<<<<< Updated upstream
=======
			Arma vacia = new Arma(eleccionClase);
			this.agregarArma(vacia);
>>>>>>> Stashed changes
			break;
		}
		case 3: { // ASESINO
			this.setPuntosDeAtaque(25);
			this.setPuntosDeVida(40);
			this.setVidaMaxima(40);
			this.setProbabilidadDeCritico(0.3);
			this.setPuntosDeDefensa(5);
			clase = ClaseDeHeroe.ASESINO;
<<<<<<< Updated upstream
=======
			Arma vacia = new Arma(eleccionClase);
			this.agregarArma(vacia);
>>>>>>> Stashed changes
			break;
		}
		case 4: { // CABALLERO
			this.setPuntosDeAtaque(20);
			this.setPuntosDeVida(50);
			this.setVidaMaxima(50);
			this.setProbabilidadDeCritico(0.15);
			this.setPuntosDeDefensa(20);
			clase = ClaseDeHeroe.CABALLERO;
<<<<<<< Updated upstream
=======
			Arma vacia = new Arma(eleccionClase);
			this.agregarArma(vacia);
>>>>>>> Stashed changes
			break;
		}
		default:
			this.setPuntosDeAtaque(20);
			this.setPuntosDeVida(50);
			this.setVidaMaxima(50);
			this.setProbabilidadDeCritico(0.1);
			this.setPuntosDeDefensa(20);
			clase = ClaseDeHeroe.CABALLERO;
<<<<<<< Updated upstream
			break;
		}
	}
	public void agregarArma (Arma arma) {
		inventario[1]= arma;
		
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
	@Override
	public Integer atacar(Personaje objetivo) {
	Integer dañoRealizado= (getPuntosDeAtaque() + obtenerDañoDeArmas()) - objetivo.getPuntosDeDefensa();
	Double multiplicadorMomentaneo= 1.7;
	if (Math.random()<= getProbabilidadDeCritico()) {
		dañoRealizado= (int)(dañoRealizado* multiplicadorMomentaneo);
=======
			Arma vacia = new Arma(eleccionClase);
			this.agregarArma(vacia);
		
		}
}

	public Integer getContadorDeAtaques() {
		return contadorDeAtaques;
	}

	public void setContadorDeAtaques(Integer contadorDeAtaques) {
		this.contadorDeAtaques = contadorDeAtaques;
>>>>>>> Stashed changes
	}
	if (dañoRealizado<0) {
		dañoRealizado=0;
	}
	objetivo.setPuntosDeVida(objetivo.getPuntosDeVida()-dañoRealizado);
	if (objetivo.getPuntosDeVida() == 0) {
		setPuntosDeVida(getVidaMaxima());
	}
		return dañoRealizado;
	}
	
<<<<<<< Updated upstream
	public Integer obtenerDañoDeArmas () {
		Integer daño=0;
		for (int i = 0; i < inventario.length; i++) {	
			if(inventario[i]!=null) {
				daño += inventario[i].getSumaAtaque();
		}
=======
	private Integer sumaDeDanioDeArmasEnInventario() {
		Integer suma=0;
		for (int i = 0; i < this.inventario.length; i++) {
			if(this.inventario[i]!=null) {
				suma += this.inventario[i].getSumaAtaque();
			}
		}
		return suma;
	}

	@Override
	public void atacar(Personaje objetivo) {
		Integer danioRealizado = 0;
		if ( ( ++this.contadorDeAtaques ) == this.getCadaTantosAtaquesNormalesLanzaUnAtaqueCritico() ) {
			danioRealizado = ( ( this.BONUSATAQUECRITICO * this.getPuntosDeAtaque() ) + sumaDeDanioDeArmasEnInventario() ) - objetivo.getPuntosDeDefensa(); 
			this.contadorDeAtaques = 0;
		}else {
			danioRealizado = ( this.getPuntosDeAtaque() + sumaDeDanioDeArmasEnInventario() ) - objetivo.getPuntosDeDefensa(); 
			this.contadorDeAtaques++;
		}
		if(danioRealizado > 0) {
			objetivo.setPuntosDeVida(objetivo.getPuntosDeVida() - danioRealizado);
		}else {
			if(danioRealizado < 0) {
				this.setPuntosDeVida(getPuntosDeVida() - ( objetivo.getPuntosDeDefensa() - danioRealizado ));
			}
>>>>>>> Stashed changes
		}
		return daño;
	}

	
}
