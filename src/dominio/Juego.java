package dominio;

import java.util.Iterator;

public class Juego {

	private Heroe heroePrincipal;
	private Arma[] armasADropear;
	private String[] nombresDeArma;
	private Integer[] valoresDeArma;
	private Enemigo[] enemigos;
	private Jefe[] jefes;
	private Integer contadorDeBoss;

	public Integer getContadorDeBoss() {
		return contadorDeBoss;
	}

	public void setContadorDeBoss(Integer contadorDeBoss) {
		this.contadorDeBoss = contadorDeBoss;
	}

	public Juego(String nombre, int clase) {
		this.contadorDeBoss=0;
        this.heroePrincipal=new Heroe(nombre, clase);
		
		this.armasADropear = new Arma[10];
        this.nombresDeArma = new String[] { "Espada", "Pistola", "Daga", "Escudo", "Arco" };
        this.valoresDeArma = new Integer[] { 10, 20, 30, 40, 50 };
        enemigos = new Enemigo[100];
        jefes = new Jefe[100];

        this.crearEnemigo();
        this.crearArmas();
    }

	public void crearArmas() {
		for (int i = 0; i < armasADropear.length; i++) {
			if (this.armasADropear[i] == null) {
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
			if (enemigo.getPuntosDeVida() <= 0) {
				victoria = true;
			break;
			}
			enemigo.atacar(heroePrincipal);
			
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
	
	public Enemigo enemigoAPelear() {
		
		Integer enemigosNoNull = 0;
		Enemigo enemigoARetornar = null;
		for (int i = 0; i < enemigos.length; i++) {
			if(enemigos[i]!= null) {
				enemigosNoNull++;
			}
		}
		enemigoARetornar = enemigos[enemigosNoNull - 1];
		return enemigoARetornar;
	}
	
    public void crearJefe() {
        for (int i = 0; i < jefes.length; i++) {
            if (jefes[i] == null) {
                jefes[i] = new Jefe(20, 30, 70);
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
	
	public Boolean verificarArmaEnPosicion(int posicion) {
		Boolean verificar=false;;
		if(this.armasADropear[posicion]!=null) {
			verificar=true;
		}
		return verificar;
	}
	public Jefe jefeAPelear() {

        Integer jefesNoNull = 0;
        Jefe jefeARetornar = null;
        for (int i = 0; i <jefes.length; i++) {
            if(jefes[i]!= null) {
                jefesNoNull++;
            }
        }
        jefeARetornar = jefes[jefesNoNull - 1];
        return jefeARetornar;
    }
	
}
