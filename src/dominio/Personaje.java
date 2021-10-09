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
<<<<<<< Updated upstream
	public Integer getVidaMaxima() {
		return vidaMaxima;
	}
	public void setVidaMaxima(Integer vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
	}
=======
>>>>>>> Stashed changes
	
	public Integer atacar(Personaje objetivo) {
		//ATAQUE DEFAULT SIN AGREGAR
<<<<<<< Updated upstream
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
=======
		Integer danioRealizado=this.puntosDeAtaque-objetivo.getPuntosDeDefensa();
		//if (Math.random()<=this.getProbabilidadDeCritico()) {
		//	danioRealizado*=2;
		//}
		if (danioRealizado<0) {
			danioRealizado=0;
		}
		objetivo.setPuntosDeVida(objetivo.getPuntosDeVida()-danioRealizado);
	}
>>>>>>> Stashed changes
}

