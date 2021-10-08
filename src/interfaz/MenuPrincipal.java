package interfaz;

import java.util.Scanner;

import dominio.Enemigo;
import dominio.Heroe;
import dominio.Jefe;
import dominio.Juego;

public class MenuPrincipal {

	public static void main(String[] args) {
		
		Boolean exitFlag = false;
		Juego partidaNueva;
		Heroe jugadorUno;
		Enemigo enemigoGenerico;
		Jefe jefeFinal;
		
		do {
			
		}while(exitFlag != false);

		System.out.println("\t\tSaliendo del juego...");
	}
	
	private static void menuPrincipal() {
		
		Scanner teclado = new Scanner(System.in);
		String nombre;
		System.out.println("\t\tMenu de inicio");
		System.out.println("\tIngrese su nombre");
		
		nombre = teclado.next();
		/**/
	}

}
