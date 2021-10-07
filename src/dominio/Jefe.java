package dominio;

public class Jefe extends Personaje{
	
	public Jefe (Integer ataque, Integer defensa, Integer vida) {
		this.setPuntosDeAtaque(ataque);
		this.setPuntosDeDefensa(defensa);
		this.setPuntosDeVida(vida);
		this.setProbabilidadDeCritico(0.2);
	}
}
