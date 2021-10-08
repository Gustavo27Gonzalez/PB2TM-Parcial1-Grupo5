package dominio;

public class Juego {

	private Heroe heroePrincipal;
	private Arma[] armasADropear;
	private String[] nombresDeArma;
	private Integer[] valoresDeArma;
	private Enemigo[] enemigos;
	private Jefe[] jefes;

	public Juego(String nombreHeroe, int numeroClase) {
		this.heroePrincipal = new Heroe(nombreHeroe, numeroClase);
		this.armasADropear = new Arma[10];
		this.nombresDeArma = new String[] { "Espada", "Pistola", "Daga", "Escudo", "Arco" };
		this.valoresDeArma = new Integer[] { 10, 20, 30, 40, 50 };
		this.crearArmas();
		enemigos=new Enemigo[100];
		jefes=new Jefe[100];
	}

	public void crearArmas() {
		for (int i = 0; i < armasADropear.length; i++) {
			if (this.armasADropear == null) {
				armasADropear[i] = new Arma(nombresDeArma[this.seleccionValorArma()],
						valoresDeArma[this.seleccionValorArma()], this.valoresDeArma[this.seleccionValorArma()]);
			}
		}
	}

	public int seleccionValorArma() {
		Double random = Math.random();
		int valor = 0;
		if (random > 0.8) {
			valor = 4;
		} else if (random > 0.6 && random <= 0.8) {
			valor = 3;
		} else if (random > 0.4 && random <= 0.6) {
			valor = 2;
		} else if (random > 0.2 && random <= 0.4) {
			valor = 1;
		} else if (random > 0.0 && random <= 0.2) {
			valor = 0;
		}
		return valor;
	}

	public Boolean pelea(Heroe heroePrincipal, Personaje enemigo) {
		Boolean victoria = false;
		while (heroePrincipal.getPuntosDeVida() > 0) {
			heroePrincipal.atacar(enemigo);
			enemigo.atacar(heroePrincipal);
			if (enemigo.getPuntosDeVida() <= 0) {
				victoria = true;
			break;}
		}
		return victoria;
	}
	
	public void crearEnemigo() {
		for (int i = 0; i < enemigos.length; i++) {
			if(enemigos[i]==null) {
				enemigos[i]=new Enemigo(this.valoresDeArma[this.seleccionValorArma()],this.valoresDeArma[this.seleccionValorArma()],this.valoresDeArma[this.seleccionValorArma()]);
				break;
			}
		}
	}
	
	public void crearJefe() {
		for (int i = 0; i < jefes.length; i++) {
			if(enemigos[i]==null) {
				enemigos[i]=new Enemigo(20, 30, 70);
				break;
			}
		}
	}

	public Heroe getHeroePrincipal() {
		return heroePrincipal;
	}

	public void setHeroePrincipal(Heroe heroePrincipal) {
		this.heroePrincipal = heroePrincipal;
	}
	
	public Arma verificarArmaEnPosicion(int posicion) {
		return this.armasADropear[posicion];
	}
}
