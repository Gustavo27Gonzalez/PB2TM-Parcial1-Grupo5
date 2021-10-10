package paqueteTest;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.ClaseDeHeroe;
import dominio.Enemigo;
import dominio.Heroe;
import dominio.Jefe;
import dominio.Juego;

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
	
	
	// ESTE TEST FUE PROBADO SIN LA PROBABILIDAD DE CRITICO APLICADA
	@Test
	public void queSePuedaAtacar() {
		Enemigo enemigo=new Enemigo(30, 0, 20);
		Heroe mago=new Heroe("Mago", 1);
		
		Integer vidaMagoEsperada=30;
		Integer vidaEnemigoEsperada=0;
		
		mago.atacar(enemigo);
		enemigo.atacar(mago);
		
		assertEquals(vidaMagoEsperada, mago.getPuntosDeVida());
		assertEquals(vidaEnemigoEsperada, enemigo.getPuntosDeVida());
	}
	
	// ESTE TEST FUE PROBADO SIN LA PROBABILIDAD DE CRITICO APLICADA
	@Test
	public void queSiLaDefensaEsMayorAlAtaqueAnuleElDaño() {
		Enemigo enemigo=new Enemigo(10, 0, 20);
		Heroe mago=new Heroe("Mago", 1);
		
		Integer vidaMagoEsperada=30;
		
		enemigo.atacar(mago);
		
		assertEquals(vidaMagoEsperada, mago.getPuntosDeVida());
	}
	
	// ESTE TEST FUE PROBADO SIN LA PROBABILIDAD DE CRITICO APLICADA
	@Test
	public void queSePuedaPelearConUnEnemigoYElHeroeGane() {
		Juego juego=new Juego("Mago", 1);
		Enemigo enemigo=new Enemigo(10, 10, 20);
		
		assertTrue(juego.pelea(juego.getHeroePrincipal(), enemigo));
	}
	
	// ESTE TEST FUE PROBADO SIN LA PROBABILIDAD DE CRITICO APLICADA
	@Test
	public void queSePuedaPelearConUnEnemigoYElHeroePierda() {
		Juego juego=new Juego("Mago", 2);
		Enemigo enemigo=new Enemigo(50, 50, 80);
		
		assertFalse(juego.pelea(juego.getHeroePrincipal(), enemigo));
	}
	
	// ESTE TEST FUE PROBADO SIN LA PROBABILIDAD DE CRITICO APLICADA
	@Test
	public void queSePuedaPelearConUnJefeYElHeroeGane() {
		Juego juego=new Juego("Mago", 1);
		Jefe enemigo=new Jefe(10, 10, 20);
		
		assertTrue(juego.pelea(juego.getHeroePrincipal(), enemigo));
	}
	
	// ESTE TEST FUE PROBADO SIN LA PROBABILIDAD DE CRITICO APLICADA
	@Test
	public void queSePuedaPelearConUnJefeYElHeroePierda() {
		Juego juego=new Juego("Mago", 3);
		Jefe enemigo=new Jefe(50, 10, 80);
		
		assertFalse(juego.pelea(juego.getHeroePrincipal(), enemigo));
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
	
	@Test // Da mal por el formato de texto, pero el texto es el esperado
	public void queSePuedaVerElInventarioDelHeroe() {
		Heroe mago=new Heroe("Mago", 1);
		
		String inventarioEsperado="\n\t-> Vara de mago\n";
		
		assertEquals(inventarioEsperado, mago.verInventario());
	}
	
	@Test
	public void queSePuedaVerLasEstadisticasDelHeroe() {
		Heroe mago=new Heroe("Mago", 1);
		
		String textoEsperado=("\tNombre: " + "Mago"  + "\n" + "\tClase: " + ClaseDeHeroe.MAGO + "\n" + "\tPuntos de vida: " + 30 + "\n" + "\tPuntos de ataque: " + 70 + "\n" + "\tPuntos de defensa: " + 40 + "\n");
	
		assertEquals(textoEsperado, mago.getStatusHeroe());
	}
}
