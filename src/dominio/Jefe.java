package dominio;

public class Jefe extends Personaje{
	
	private Integer ataque;
	private Integer defensa;
	private Integer cadaTantosAtaquesNormalesLanzaUnAtaqueCritico;
	private Integer puntosDeVida;
	private Integer contadorDeAtaques;
	private final Integer BONUSATAQUECRITICO;
	
	public Jefe (Integer ataque, Integer defensa, Integer vida) {
		this.setPuntosDeAtaque(ataque);
		this.setPuntosDeDefensa(defensa);
		this.setPuntosDeVida(vida);
		this.setCadaTantosAtaquesNormalesLanzaUnAtaqueCritico(3);
		this.contadorDeAtaques = 0;
		this.BONUSATAQUECRITICO = 7;
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
		Integer danioRealizado = 0;
		if ( ( ++this.contadorDeAtaques ) == this.getCadaTantosAtaquesNormalesLanzaUnAtaqueCritico() ) {
			danioRealizado = ( this.BONUSATAQUECRITICO * this.getPuntosDeAtaque() ) - objetivo.getPuntosDeDefensa(); 
			this.contadorDeAtaques = 0;
		}else {
			danioRealizado = this.getPuntosDeAtaque() - objetivo.getPuntosDeDefensa(); 
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
}
