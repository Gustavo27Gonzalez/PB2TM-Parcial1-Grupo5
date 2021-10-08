package paqueteTest;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.Enemigo;
import dominio.Heroe;

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
		Integer vidaMagoEsperada=50;
		Integer vidaPaladinEsperada=60;
		Integer vidaAsesinoEsperada=40;
		Integer vidaCaballeroEsperada=50;
		
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
		
		Integer vidaMagoEsperada=40;
		Integer vidaEnemigoEsperada=0;
		
		mago.atacar(enemigo);
		enemigo.atacar(mago);
		
		assertEquals(vidaMagoEsperada, mago.getPuntosDeVida());
		assertEquals(vidaEnemigoEsperada, enemigo.getPuntosDeVida());
	}
	
	@Test
	public void queSiLaDefensaEsMayorAlAtaqueAnuleElDaño() {
		Enemigo enemigo=new Enemigo(10, 0, 20);
		Heroe mago=new Heroe("Mago", 1);
		
		Integer vidaMagoEsperada=50;
		
		enemigo.atacar(mago);
		
		assertEquals(vidaMagoEsperada, mago.getPuntosDeVida());
	}
}
