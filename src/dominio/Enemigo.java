package dominio;

public class Enemigo extends Personaje {

	private Integer ataque;
	private Integer defensa;
	private Integer cadaTantosAtaquesNormalesLanzaUnAtaqueCritico;
	private Integer puntosDeVida;
	private Integer contadorDeAtaques;
	private final Integer BONUSATAQUECRITICO;
	
	public Enemigo (Integer ataque, Integer defensa, Integer vida) {
		this.setPuntosDeAtaque(ataque);
		this.setPuntosDeDefensa(defensa);
		this.setPuntosDeVida(vida);
		this.setCadaTantosAtaquesNormalesLanzaUnAtaqueCritico(10);
		this.contadorDeAtaques = 0;
		this.BONUSATAQUECRITICO = 2;
	}

	public Integer getAtaque() {
		return ataque;
	}

	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}

	public Integer getDefensa() {
		return defensa;
	}

	public void setDefensa(Integer defensa) {
		this.defensa = defensa;
	}

	public Integer getCadaTantosAtaquesNormalesLanzaUnAtaqueCritico() {
		return cadaTantosAtaquesNormalesLanzaUnAtaqueCritico;
	}
	public void setCadaTantosAtaquesNormalesLanzaUnAtaqueCritico(Integer ataqueCriticoCadaXataques) {
		this.cadaTantosAtaquesNormalesLanzaUnAtaqueCritico = ataqueCriticoCadaXataques;
	}

	public Integer getPuntosDeVida() {
		return puntosDeVida;
	}

	public void setPuntosDeVida(Integer puntosDeVida) {
		this.puntosDeVida = puntosDeVida;
	}

	public Integer getContadorDeAtaques() {
		return contadorDeAtaques;
	}

	public void setContadorDeAtaques(Integer contadorDeAtaques) {
		this.contadorDeAtaques = contadorDeAtaques;
	}

	@Override
	public void atacar(Personaje objetivo) {
		Integer dañoRealizado = 0;
		if ( ( ++this.contadorDeAtaques ) == this.getCadaTantosAtaquesNormalesLanzaUnAtaqueCritico() ) {
			dañoRealizado = ( this.BONUSATAQUECRITICO * this.getPuntosDeAtaque() ) - objetivo.getPuntosDeDefensa(); 
			this.contadorDeAtaques = 0;
		}else {
			dañoRealizado = this.getPuntosDeAtaque() - objetivo.getPuntosDeDefensa(); 
			this.contadorDeAtaques++;
		}
		if(dañoRealizado > 0) {
			objetivo.setPuntosDeVida(objetivo.getPuntosDeVida() - dañoRealizado);
		}else {
			if(dañoRealizado < 0) {
				this.setPuntosDeVida(getPuntosDeVida() - ( objetivo.getPuntosDeDefensa() - dañoRealizado ));
			}
		}
		
	}

	
	
	
	
	
	
}
