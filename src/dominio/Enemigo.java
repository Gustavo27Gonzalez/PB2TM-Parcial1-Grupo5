package dominio;

public class Enemigo extends Personaje {

	
	public Enemigo (Integer ataque, Integer defensa, Integer vida) {
		this.setPuntosDeAtaque(ataque);
		this.setPuntosDeDefensa(defensa);
		this.setPuntosDeVida(vida);
		this.setProbabilidadDeCritico(0.0001);
	}
}
