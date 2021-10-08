package dominio;

public abstract class Personaje {
			
	private Integer puntosDeVida;
	private Integer puntosDeAtaque;
	private Double probabilidadDeCritico;
	private Integer puntosDeDefensa;
	private Integer vidaMaxima;
	
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
	public Double getProbabilidadDeCritico() {
		return probabilidadDeCritico;
	}
	public void setProbabilidadDeCritico(Double probabilidadDeCritico) {
		this.probabilidadDeCritico = probabilidadDeCritico;
	}
	public Integer getVidaMaxima() {
		return vidaMaxima;
	}
	public void setVidaMaxima(Integer vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
	}
	
	public Integer atacar(Personaje objetivo) {
		//ATAQUE DEFAULT SIN AGREGAR
		Integer dañoRealizado=this.puntosDeAtaque-objetivo.getPuntosDeDefensa();
		//if (Math.random()<=this.getProbabilidadDeCritico()) {
		//	dañoRealizado*=2;
		//}
		if (dañoRealizado<0) {
			dañoRealizado=0;
		}
		objetivo.setPuntosDeVida(objetivo.getPuntosDeVida()-dañoRealizado);
		return dañoRealizado;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
