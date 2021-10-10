package dominio;

public class Heroe extends Personaje {

	private String nombre;
	private Arma[] inventario;
	private ClaseDeHeroe clase;

	private Integer contadorDeAtaques;
	private Integer BONUSATAQUECRITICO;

	public Heroe (String nombre, int eleccionClase) {
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
		switch (eleccionClase) {
		case 1: { // MAGO

			this.setPuntosDeAtaque(20);
			this.setPuntosDeVida(50);
			this.setCadaTantosAtaquesNormalesLanzaUnAtaqueCritico(4);
			this.setPuntosDeDefensa(20);
			this.BONUSATAQUECRITICO = 5;
      
			clase = ClaseDeHeroe.MAGO;
			Arma vacia = new Arma(eleccionClase);
			this.agregarArma(vacia);
			break;
		}
		case 2:{  // PALADIN
			this.setPuntosDeAtaque(15);
			this.setPuntosDeVida(60);
			this.setCadaTantosAtaquesNormalesLanzaUnAtaqueCritico(6);
			this.setPuntosDeDefensa(25);
			this.BONUSATAQUECRITICO = 3;
      
			clase = ClaseDeHeroe.PALADIN;
			Arma vacia = new Arma(eleccionClase);
			this.agregarArma(vacia);
			break;
		}
		
		case 3:{ // ASESINO
			this.setPuntosDeAtaque(25);
			this.setPuntosDeVida(40);
			this.setCadaTantosAtaquesNormalesLanzaUnAtaqueCritico(5);
			this.setPuntosDeDefensa(5);
			this.BONUSATAQUECRITICO = 2;
      
			clase = ClaseDeHeroe.ASESINO;
			Arma vacia = new Arma(eleccionClase);
			this.agregarArma(vacia);
			break;
		}
		case 4:{  // CABALLERO
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
		if(danioRealizado > 0) {
			objetivo.setPuntosDeVida(objetivo.getPuntosDeVida() - danioRealizado);
		}else {
			if(danioRealizado < 0) {
				this.setPuntosDeVida(getPuntosDeVida() - ( objetivo.getPuntosDeDefensa() - danioRealizado ));
			}
		}
	}

	public String getStatusHeroe() {

        String aux = "";
        aux += ("\t\tNombre: " + this.getNombre()  + "\n"
                + "Clase: " + this.getClase() + "\n"
                + "Puntos de vida: " + this.getPuntosDeVida() + "\n"
                + "Puntos de ataque: " + this.getPuntosDeAtaque() + "\n"
                + "Puntos de defensa: " + this.getPuntosDeDefensa() + "\n");

        return aux;
    }
	
}
