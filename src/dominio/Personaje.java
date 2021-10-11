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
	
	
	
	
	
}
