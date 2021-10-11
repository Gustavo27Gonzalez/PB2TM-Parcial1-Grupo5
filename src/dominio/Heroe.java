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
			this.setPuntosDeVida(40);
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
	
	@Override
	public String toString() {
		return "\tHeroe\n \tNombre=" + nombre + "\n \tClase=" + clase + "\n \tPuntos de vida=" + getPuntosDeVida()
				+ "\n \tPuntos de ataque=" + getPuntosDeAtaque() + "\n \tPuntos de defensa=" + getPuntosDeDefensa() + "\n";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((BONUSATAQUECRITICO == null) ? 0 : BONUSATAQUECRITICO.hashCode());
		result = prime * result + ((clase == null) ? 0 : clase.hashCode());
		result = prime * result + ((contadorDeAtaques == null) ? 0 : contadorDeAtaques.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Heroe other = (Heroe) obj;
		if (BONUSATAQUECRITICO == null) {
			if (other.BONUSATAQUECRITICO != null)
				return false;
		} else if (!BONUSATAQUECRITICO.equals(other.BONUSATAQUECRITICO))
			return false;
		if (clase != other.clase)
			return false;
		if (contadorDeAtaques == null) {
			if (other.contadorDeAtaques != null)
				return false;
		} else if (!contadorDeAtaques.equals(other.contadorDeAtaques))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
	
}