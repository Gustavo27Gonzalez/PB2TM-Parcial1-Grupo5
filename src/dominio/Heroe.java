package dominio;

public class Heroe extends Personaje {

	private String nombre;
	private Arma[] inventario;
	private ClaseDeHeroe clase;

	private Integer contadorDeAtaques;
	private Integer BONUSATAQUECRITICO;

	public Heroe (String nombre, int eleccionClase) {
		this.nombre = nombre;
		inventario = new Arma[11];
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

	public ClaseDeHeroe getClase() {
		return clase;
	}

	public void setClase(ClaseDeHeroe clase) {
		this.clase = clase;
	}
	
	public String verInventario() {
		String aux = "";
		for(int i = 0; i<inventario.length; i++) {
		if(inventario[i] != null) {
			aux += "\n\t-> " + inventario[i].getNombre()+"\n";
		}
	}
		return aux;
}
	

	public void eleccionDeClase(Integer eleccionClase) {
		this.contadorDeAtaques=0;
		switch (eleccionClase) {
		case 1: { // MAGO

			this.setPuntosDeAtaque(70);
			this.setPuntosDeVida(30);
			this.setCadaTantosAtaquesNormalesLanzaUnAtaqueCritico(4);
			this.setPuntosDeDefensa(10);
			this.BONUSATAQUECRITICO = 5;
      
			clase = ClaseDeHeroe.MAGO;
			Arma vacia = new Arma(eleccionClase);
			this.agregarArma(vacia);
			break;
		}
		case 2:{  // PALADIN
			this.setPuntosDeAtaque(50);
			this.setPuntosDeVida(80);
			this.setCadaTantosAtaquesNormalesLanzaUnAtaqueCritico(6);
			this.setPuntosDeDefensa(30);
			this.BONUSATAQUECRITICO = 3;
      
			clase = ClaseDeHeroe.PALADIN;
			Arma vacia = new Arma(eleccionClase);
			this.agregarArma(vacia);
			break;
		}
		
		case 3:{ // ASESINO
			this.setPuntosDeAtaque(55);
			this.setPuntosDeVida(30);
			this.setCadaTantosAtaquesNormalesLanzaUnAtaqueCritico(2);
			this.setPuntosDeDefensa(30);
			this.BONUSATAQUECRITICO = 2;
      
			clase = ClaseDeHeroe.ASESINO;
			Arma vacia = new Arma(eleccionClase);
			this.agregarArma(vacia);
			break;
		}
		case 4:{  // CABALLERO
			this.setPuntosDeAtaque(35);
			this.setPuntosDeVida(60);
			this.setCadaTantosAtaquesNormalesLanzaUnAtaqueCritico(3);
			this.setPuntosDeDefensa(40);
			this.BONUSATAQUECRITICO = 4;
      
			clase = ClaseDeHeroe.CABALLERO;
			Arma vacia = new Arma(eleccionClase);
			this.agregarArma(vacia);
			break;
		}	
		default:
			this.setPuntosDeAtaque(20);
			this.setPuntosDeVida(50);
			this.setCadaTantosAtaquesNormalesLanzaUnAtaqueCritico(3);
			this.setPuntosDeDefensa(20);
			this.BONUSATAQUECRITICO = 4;
        
			clase = ClaseDeHeroe.CABALLERO;
      Arma vacia = new Arma(eleccionClase);
			this.agregarArma(vacia);
			break;
		}
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getContadorDeAtaques() {
		return contadorDeAtaques;
	}

	public void setContadorDeAtaques(Integer contadorDeAtaques) {
		this.contadorDeAtaques = contadorDeAtaques;

	}

	public Arma[] getInventario() {
		return this.inventario;
	}

	public void setInventario(Arma inventario) {
		if(!elInventarioEstaLLeno()) {
			for( int i = 0; i < this.inventario.length; i++) {
				if(this.inventario[i]==null) {
					this.inventario[i]= inventario;
					i = 10;
				}
			}
		}
	}
	
	private Integer sumaDeDanioDeArmasEnInventario() {
		Integer suma=0;
		for (int i = 0; i < this.inventario.length; i++) {
			if(this.inventario[i]!=null) {
				suma += this.inventario[i].getSumaAtaque();
			}
		}
		return suma;
	}
  
	public boolean elInventarioEstaLLeno() {
		boolean estaLLeno = false;
		int contadorObjetosInventario = 0;
		int i;
		for( i=0 ; i < this.inventario.length; i++) {
			if(this.inventario[i]!=null) {
				contadorObjetosInventario++;
			}
		}
		if(contadorObjetosInventario == this.inventario.length) {
			estaLLeno = true;
		}else {
			estaLLeno = false;
		}
		return estaLLeno;
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
		
		if(danioRealizado > 0 && (objetivo.getPuntosDeVida()-danioRealizado)>=0) {
			objetivo.setPuntosDeVida(objetivo.getPuntosDeVida() - danioRealizado);
		}else if (danioRealizado > 0 && (objetivo.getPuntosDeVida()-danioRealizado)<0) {
			objetivo.setPuntosDeVida(0);
		}
	}

	public String getStatusHeroe() {

        String aux = "";
        aux += (  "\tNombre: " + this.getNombre()  + "\n"
                + "\tClase: " + this.getClase() + "\n"
                + "\tPuntos de vida: " + this.getPuntosDeVida() + "\n"
                + "\tPuntos de ataque: " + this.getPuntosDeAtaque() + "\n"
                + "\tPuntos de defensa: " + this.getPuntosDeDefensa() + "\n");

        return aux;
    }
	
}
