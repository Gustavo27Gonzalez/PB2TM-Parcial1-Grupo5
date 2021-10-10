package dominio;

public abstract class Personaje {
			
	private Integer puntosDeVida;
	private Integer puntosDeAtaque;
	private Integer cadaTantosAtaquesNormalesLanzaUnAtaqueCritico;
	private Integer puntosDeDefensa;
	
	public Integer getPuntosDeDefensa() {
		return puntosDeDefensa;
	}
	public void setPuntosDeDefensa(Integer puntosDeDefensa) {
		this.puntosDeDefensa = puntosDeDefensa;
	}
	public Integer getPuntosDeVida() {
		return puntosDeVida;
	}
	public void setPuntosDeVida(Integer puntosDeVida) {
		this.puntosDeVida = puntosDeVida;
	}
	public Integer getPuntosDeAtaque() {
		return puntosDeAtaque;
	}
	public void setPuntosDeAtaque(Integer puntosDeAtaque) {
		this.puntosDeAtaque = puntosDeAtaque;
	}
	public Integer getCadaTantosAtaquesNormalesLanzaUnAtaqueCritico() {
		return cadaTantosAtaquesNormalesLanzaUnAtaqueCritico;
	}
	public void setCadaTantosAtaquesNormalesLanzaUnAtaqueCritico(Integer ataqueCriticoCadaXataques) {
		this.cadaTantosAtaquesNormalesLanzaUnAtaqueCritico = ataqueCriticoCadaXataques;
	}
	
	public abstract void atacar(Personaje objetivo);
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cadaTantosAtaquesNormalesLanzaUnAtaqueCritico == null) ? 0
				: cadaTantosAtaquesNormalesLanzaUnAtaqueCritico.hashCode());
		result = prime * result + ((puntosDeAtaque == null) ? 0 : puntosDeAtaque.hashCode());
		result = prime * result + ((puntosDeDefensa == null) ? 0 : puntosDeDefensa.hashCode());
		result = prime * result + ((puntosDeVida == null) ? 0 : puntosDeVida.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personaje other = (Personaje) obj;
		if (cadaTantosAtaquesNormalesLanzaUnAtaqueCritico == null) {
			if (other.cadaTantosAtaquesNormalesLanzaUnAtaqueCritico != null)
				return false;
		} else if (!cadaTantosAtaquesNormalesLanzaUnAtaqueCritico
				.equals(other.cadaTantosAtaquesNormalesLanzaUnAtaqueCritico))
			return false;
		if (puntosDeAtaque == null) {
			if (other.puntosDeAtaque != null)
				return false;
		} else if (!puntosDeAtaque.equals(other.puntosDeAtaque))
			return false;
		if (puntosDeDefensa == null) {
			if (other.puntosDeDefensa != null)
				return false;
		} else if (!puntosDeDefensa.equals(other.puntosDeDefensa))
			return false;
		if (puntosDeVida == null) {
			if (other.puntosDeVida != null)
				return false;
		} else if (!puntosDeVida.equals(other.puntosDeVida))
			return false;
		return true;
	}
	
	
}
