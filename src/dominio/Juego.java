package dominio;

public class Juego {

	private Heroe heroePrincipal;
	private Arma[] armasADropear;
	private String[] nombresDeArma;
	private Integer[] valoresDeArma;
	private Integer[] valoresEnemigos;
	private Enemigo[] enemigos;
	private Jefe[] jefes;
	private Integer contadorDeBoss;
	private Integer batallasGanadasEnTotal;



	public Juego(String nombre, int clase) {
		this.heroePrincipal = new Heroe(nombre, clase);

		this.armasADropear = new Arma[10];
		this.nombresDeArma = new String[] { "Espada", "Lucero del Alba", "Daga", "Escudo", "Arco", "Lanza", "Ballesta", "Maza" };
		this.valoresDeArma = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8};
		this.valoresEnemigos = new Integer[] { 5, 10, 15, 20, 25, 30, 35, 40};
		enemigos = new Enemigo[500];
		jefes = new Jefe[100];

		this.crearArmas();
		this.setContadorDeBoss(0);
		this.setBatallasGanadasEnTotal(0);
	}

	public void crearArmas() {
		for (int i = 0; i < armasADropear.length; i++) {
			if (this.armasADropear[i] == null) {
				armasADropear[i] = new Arma(nombresDeArma[this.valorAleatorio()],
						valoresDeArma[this.valorAleatorio()]);
			}
		}
	}
	
	public int valorAleatorio() {
		int valor = (int)((Math.random()*8));
		return valor;
	}

	

	public Boolean pelea(Heroe heroePrincipal, Personaje enemigo) {
		Boolean victoria = false;
		boolean continuarPeleando = true;
		while (continuarPeleando) {
			heroePrincipal.atacar(enemigo);
			if (enemigo.getPuntosDeVida() <= 0) {
				victoria = true;
				continuarPeleando = false;
			}else {
				enemigo.atacar(heroePrincipal);
				if(heroePrincipal.getPuntosDeVida() <= 0) {
					continuarPeleando = false;
				}
			}
		}
		return victoria;
	}

	public void crearEnemigo() {
		for (int i = 0; i < enemigos.length; i++) {
			if (enemigos[i] == null) {
				enemigos[i] = new Enemigo(this.valoresEnemigos[this.valorAleatorio()],
						this.valoresEnemigos[this.valorAleatorio()], this.valoresEnemigos[this.valorAleatorio()]);
				break;
			}
		}
	}

	public Enemigo enemigoAPelear() {

		Integer enemigosNoNull = 0;
		Enemigo enemigoARetornar = null;
		for (int i = 0; i < enemigos.length; i++) {
			if (enemigos[i] != null) {
				enemigosNoNull++;
			}
		}
		enemigoARetornar = enemigos[enemigosNoNull - 1];
		return enemigoARetornar;
	}

	public void crearJefe() {
		for (int i = 0; i < jefes.length; i++) {
			if (jefes[i] == null) {
				jefes[i] = new Jefe(35, 10, 100);
				break;
			}
		}
	}

	public Jefe jefeAPelear() {

		Integer jefesNoNull = 0;
		Jefe jefeARetornar = null;
		for (int i = 0; i < jefes.length; i++) {
			if (jefes[i] != null) {
				jefesNoNull++;
			}
		}
		jefeARetornar = jefes[jefesNoNull - 1];
		return jefeARetornar;
	}

	public Heroe getHeroePrincipal() {
		return heroePrincipal;
	}

	public void setHeroePrincipal(Heroe heroePrincipal) {
		this.heroePrincipal = heroePrincipal;
	}

	public Boolean verificarArmaEnPosicion(int posicion) {
		Boolean verificar = false;
		;
		if (this.armasADropear[posicion] != null) {
			verificar = true;
		}
		return verificar;
	}
	
	public Integer getContadorDeBoss() {
		return contadorDeBoss;
	}

	public void setContadorDeBoss(Integer contadorDeBoss) {
		this.contadorDeBoss = contadorDeBoss;
	}
	
	public Integer getBatallasGanadasEnTotal() {
		return batallasGanadasEnTotal;
	}

	public void setBatallasGanadasEnTotal(Integer batallasGanadasEnTotal) {
		this.batallasGanadasEnTotal = batallasGanadasEnTotal;
	}

	public void dropearArma(Heroe personaje) {
		for (int i = 0; i < armasADropear.length; i++) {
			if(armasADropear[i]!=null) {
				personaje.agregarArma(armasADropear[i]);
				armasADropear[i]=null;
				break;
			}
		}
	}

}