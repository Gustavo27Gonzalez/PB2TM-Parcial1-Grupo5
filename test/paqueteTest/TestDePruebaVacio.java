package paqueteTest;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.Enemigo;
import dominio.Heroe;
import dominio.Jefe;
import dominio.Juego;

public class TestDePruebaVacio {

	@Test
	public void queSePuedaCrearUnHeroeDeCadaClase() {
		Heroe mago = new Heroe("Mago", 1);
		Heroe paladin = new Heroe("Paladin", 2);
		Heroe asesino = new Heroe("Asesino", 3);
		Heroe caballero = new Heroe("Caballero", 4);

		String nombreMagoEsperado = "Mago";
		String nombrePaladinEsperado = "Paladin";
		String nombreAsesinoEsperado = "Asesino";
		String nombreCaballeroEsperado = "Caballero";
		Integer vidaMagoEsperada = 50;
		Integer vidaPaladinEsperada = 60;
		Integer vidaAsesinoEsperada = 40;
		Integer vidaCaballeroEsperada = 50;

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
		Enemigo enemigo = new Enemigo(10, 10, 10);

		Integer valorEsperado = 10;

		assertNotNull(enemigo);
		assertEquals(valorEsperado, enemigo.getPuntosDeVida());
		assertEquals(valorEsperado, enemigo.getPuntosDeAtaque());
		assertEquals(valorEsperado, enemigo.getPuntosDeDefensa());
	}

	// ESTE TEST FUE PROBADO SIN LA PROBABILIDAD DE CRITICO APLICADA
	@Test
	public void queSePuedaAtacar() {
		Enemigo enemigo = new Enemigo(30, 0, 20);
		Heroe mago = new Heroe("Mago", 1);

		Integer vidaMagoEsperada = 40;
		Integer vidaEnemigoEsperada = 0;

		mago.atacar(enemigo);
		enemigo.atacar(mago);

		assertEquals(vidaMagoEsperada, mago.getPuntosDeVida());
		assertEquals(vidaEnemigoEsperada, enemigo.getPuntosDeVida());
	}

	// ESTE TEST FUE PROBADO SIN LA PROBABILIDAD DE CRITICO APLICADA
	@Test
	public void queSiLaDefensaEsMayorAlAtaqueAnuleElDaño() {
		Enemigo enemigo = new Enemigo(10, 0, 20);
		Heroe mago = new Heroe("Mago", 1);

		Integer vidaMagoEsperada = 50;

		enemigo.atacar(mago);

		assertEquals(vidaMagoEsperada, mago.getPuntosDeVida());
	}

	// ESTE TEST FUE PROBADO SIN LA PROBABILIDAD DE CRITICO APLICADA
	@Test
	public void queSePuedaPelearConUnEnemigoYElHeroeGane() {
		Juego juego = new Juego();
		Heroe mago = new Heroe("Mago", 1);
		Enemigo enemigo = new Enemigo(10, 10, 20);

		juego.setHeroePrincipal(mago);

		assertTrue(juego.pelea(juego.getHeroePrincipal(), enemigo));
	}

	// ESTE TEST FUE PROBADO SIN LA PROBABILIDAD DE CRITICO APLICADA
	@Test
	public void queSePuedaPelearConUnEnemigoYElHeroePierda() {
		Juego juego = new Juego();
		Heroe mago = new Heroe("Mago", 1);
		Enemigo enemigo = new Enemigo(50, 20, 80);
		juego.setHeroePrincipal(mago);
		assertFalse(juego.pelea(juego.getHeroePrincipal(), enemigo));
	}

	// ESTE TEST FUE PROBADO SIN LA PROBABILIDAD DE CRITICO APLICADA
	@Test
	public void queSePuedaPelearConUnJefeYElHeroeGane() {
		Juego juego = new Juego();
		Heroe mago = new Heroe("Mago", 1);
		Jefe enemigo = new Jefe(10, 10, 20);
		juego.setHeroePrincipal(mago);
		assertTrue(juego.pelea(juego.getHeroePrincipal(), enemigo));
	}

	// ESTE TEST FUE PROBADO SIN LA PROBABILIDAD DE CRITICO APLICADA
	@Test
	public void queSePuedaPelearConUnJefeYElHeroePierda() {
		Juego juego = new Juego();
		Heroe mago = new Heroe("Mago", 1);
		Jefe enemigo = new Jefe(50, 10, 80);
		juego.setHeroePrincipal(mago);
		assertFalse(juego.pelea(juego.getHeroePrincipal(), enemigo));
	}

	@Test
	public void queElJuegoCreeLasArmasADropearAlInicar() {
		Juego juego = new Juego();
		Heroe mago = new Heroe("Mago", 1);
		juego.setHeroePrincipal(mago);
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
}
