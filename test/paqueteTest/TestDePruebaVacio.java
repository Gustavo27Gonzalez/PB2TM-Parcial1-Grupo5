package paqueteTest;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.*;

public class TestDePruebaVacio {

	@Test
	public void queSePuedaCrearUnHeroeDeCadaClase() {
		Heroe mago=new Heroe("Mago", 1);
		Heroe paladin=new Heroe("Paladin", 2);
		Heroe asesino=new Heroe("Asesino", 3);
		Heroe caballero=new Heroe("Caballero", 4);
		
		String nombreMagoEsperado="Mago";
		String nombrePaladinEsperado="Paladin";
		String nombreAsesinoEsperado="Asesino";
		String nombreCaballeroEsperado="Caballero";
		Integer vidaMagoEsperada=30;
		Integer vidaPaladinEsperada=80;
		Integer vidaAsesinoEsperada=40;
		Integer vidaCaballeroEsperada=60;
		
		assertNotNull(mago);
		assertEquals(nombreMagoEsperado, mago.getNombre());
		assertEquals(vidaMagoEsperada, mago.getPuntosDeVida());
		assertNotNull(paladin);
		assertEquals(nombrePaladinEsperado, paladin.getNombre());
		assertEquals(vidaPaladinEsperada, paladin.getPuntosDeVida());
		assertNotNull(asesino);
		assertEquals(nombreAsesinoEsperado, asesino.getNombre());
		assertEquals(vidaAsesinoEsperada, asesino.getPuntosDeVida());
		assertNotNull(caballero);
		assertEquals(nombreCaballeroEsperado, caballero.getNombre());
		assertEquals(vidaCaballeroEsperada, caballero.getPuntosDeVida());
		
	}
	
	@Test
	public void queSePuedaCrearUnEnemigo() {
		Enemigo enemigo=new Enemigo(10, 10, 10);
		
		Integer valorEsperado=10;
		
		assertNotNull(enemigo);
		assertEquals(valorEsperado, enemigo.getPuntosDeVida());
		assertEquals(valorEsperado, enemigo.getPuntosDeAtaque());
		assertEquals(valorEsperado, enemigo.getPuntosDeDefensa());
	}
	
	@Test
	public void queSePuedaAtacar() {
		Enemigo enemigo=new Enemigo(30, 0, 20);
		Heroe mago=new Heroe("Mago", 1);
		
		Integer vidaMagoEsperada=30;
		Integer vidaEnemigoEsperada=0;
		
		mago.atacar(enemigo);
		assertEquals(vidaMagoEsperada, mago.getPuntosDeVida());
		
		enemigo.atacar(mago);
		assertEquals(vidaEnemigoEsperada, enemigo.getPuntosDeVida());
	}
	
	@Test
	public void queSiLaDefensaEsMayorAlAtaqueAnuleElDaño() {
		Enemigo enemigo=new Enemigo(10, 0, 20);
		Heroe mago=new Heroe("Mago", 1);
		
		Integer vidaMagoEsperada=30;
		
		enemigo.atacar(mago);
		
		assertEquals(vidaMagoEsperada, mago.getPuntosDeVida());
	}
	
	@Test
	public void queSePuedaPelearConUnEnemigoYElHeroeGane() {
		Juego juego=new Juego("Mago", 1);
		Enemigo enemigo=new Enemigo(10, 10, 20);
		
		assertTrue(juego.pelea(juego.getHeroePrincipal(), enemigo));
	}
	
	@Test
	public void queSePuedaPelearConUnEnemigoYElHeroePierda() {
		Juego juego=new Juego("Mago", 2);
		Enemigo enemigo=new Enemigo(50, 50, 80);
		
		assertFalse(juego.pelea(juego.getHeroePrincipal(), enemigo));
	}
	
	@Test
	public void queSePuedaPelearConUnJefeYElHeroeGane() {
		Juego juego=new Juego("Mago", 1);
		Jefe enemigo=new Jefe(10, 10, 20);
		
		assertTrue(juego.pelea(juego.getHeroePrincipal(), enemigo));
	}
	
	@Test
	public void queSePuedaPelearConUnJefeYElHeroePierda() {
		Juego juego=new Juego("Mago", 1); // 70, 15, 30 ataque, defensa, vida + 9 de ataque del arma predeterminada del mago
		Jefe enemigo=new Jefe(45, 10, 100);// 45, 10, 100
		
		Integer vidaDelHeroeLuegoDePelearConUnEnemigoMasFuerte = 0;
		Integer vidaDelJefeLuegoDePelearConUnHeroeMasDebil = 31;
		
		juego.pelea(juego.getHeroePrincipal(), enemigo);
		assertEquals(vidaDelHeroeLuegoDePelearConUnEnemigoMasFuerte, juego.getHeroePrincipal().getPuntosDeVida());
		assertEquals(vidaDelJefeLuegoDePelearConUnHeroeMasDebil, enemigo.getPuntosDeVida());
		
	}
	
	@Test
	public void queElJuegoCreeLasArmasADropearAlInicar() {
		Juego juego=new Juego("Mago", 1);
		
		assertTrue(juego.verificarArmaEnPosicion(0));
		assertTrue(juego.verificarArmaEnPosicion(1));
		assertTrue(juego.verificarArmaEnPosicion(2));
		assertTrue(juego.verificarArmaEnPosicion(3));
		assertTrue(juego.verificarArmaEnPosicion(4));
		assertTrue(juego.verificarArmaEnPosicion(5));
		assertTrue(juego.verificarArmaEnPosicion(6));
		assertTrue(juego.verificarArmaEnPosicion(7));
		assertTrue(juego.verificarArmaEnPosicion(8));
		assertTrue(juego.verificarArmaEnPosicion(9));
		
		
	}
	
	@Test
	public void queSePuedaVerElInventarioDelHeroe() {
		Heroe mago=new Heroe("Mago", 1);
		
		String inventarioEsperado="\n\t-> Vara de mago\n";
		
		assertEquals(inventarioEsperado, mago.verInventario());
	}
	
	@Test
	public void queSePuedaVerLasEstadisticasDelHeroe() {
		Heroe mago1 = new Heroe("Mago", 1);
		Heroe mago2 = new Heroe("Mago",1);
			
		assertEquals(mago1.toString(), mago2.toString());
	}
	
	@Test
	public void queElHeroePeleaConUnEnemigoYRealizaElAtaqueConBonificacion() {
		Juego juego3 = new Juego("Caballero", 4);// 35 atq, 40 def, 60 vida + 5 atq arma y cada 3 ataques lanza un ataque critico (multiplica por 4 el ataque base del asesino)
		Enemigo enemigo3 = new Enemigo(40,5,245);
		
		Integer vidaEsperadaDelHeroeTrasPelear = 15;
		Integer vidaEsperadaDelEnemigoTrasPelear = 0;
		
		juego3.pelea(juego3.getHeroePrincipal(), enemigo3);
		
		assertEquals(vidaEsperadaDelHeroeTrasPelear, juego3.getHeroePrincipal().getPuntosDeVida());
		assertEquals(vidaEsperadaDelEnemigoTrasPelear, enemigo3.getPuntosDeVida());
		
	}
	
	@Test
	public void que2HeroesConMismoNombreYmismoTipoSonIguales() {
		Heroe heroe1 = new Heroe("Gandalf",1);
		Heroe heroe2 = new Heroe("Gandalf", 1);
		assertEquals(heroe1, heroe2);
	}
	
	@Test
	public void que2HeroesDelMismoTipoConDistintoNombreNoSonIguales() {
		Heroe heroeA = new Heroe("Gandalf",1);
		Heroe heroeB = new Heroe("gANDALF", 1);
		assertNotEquals(heroeA,heroeB);
	}
	
	
}
