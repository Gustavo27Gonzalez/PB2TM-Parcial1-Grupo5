package interfaz;

import java.util.Scanner;

import dominio.Enemigo;
import dominio.Heroe;
import dominio.Jefe;
import dominio.Juego;

public class MenuPrincipal {

	public static void main(String[] args) {
		
		Integer exitFlag = 0;
		Juego partidaNueva = new Juego(null, 0);
		Enemigo enemigoGenerico;
		Jefe jefeFinal;
		
		menuPrincipal(partidaNueva);
		do {
			opcionesDelMenu();
			exitFlag = seleccionesMenu(partidaNueva);
			
		}while(exitFlag != 3);

		System.out.println("\t\tSaliendo del juego...");
	}
	
	private static void menuPrincipal(Juego partida) {
		
		Heroe nuevo = new Heroe(null, 0);
		
		Scanner teclado = new Scanner(System.in);
		String nombre;
		Integer seleccionClase;
		
		System.out.println("\t\tMenu de inicio");
		System.out.println("\t\tIngrese su nombre");
		
		nombre = teclado.next();
		nuevo.setNombre(nombre);
		
		
		System.out.println("\t Seleccione la clase\n"
				+ "1 -> Mago\n"
				+ "2 -> Paladin\n"
				+ "3 -> Asesino\n"
				+ "4 -> Caballero\n"
				+ "5 -> Default\n");
		
		seleccionClase = teclado.nextInt();
	
		partida.setHeroePrincipal(nuevo);
		partida.getHeroePrincipal().eleccionDeClase(seleccionClase);
		
		System.out.println("Se ha creado el heroe: " + partida.getHeroePrincipal().getNombre() + ", de clase: " + partida.getHeroePrincipal().getClase());
		System.out.println("***************************************************");
	}

	
	private static void opcionesDelMenu() {
		
		System.out.println("\t\tMenu principal\n");
		
		System.out.println("1 - Combate a muerte");
		System.out.println("2 - Ver inventario");
		System.out.println("3 - Salir");
		
	}
	
	private static Integer seleccionesMenu(Juego partida) {
		Scanner teclado = new Scanner(System.in);
		Integer opcion = teclado.nextInt();
		Integer back = 0;
		
		switch(opcion) {
		case 1:
			partida.crearEnemigo();
			if(partida.pelea(partida.getHeroePrincipal(), partida.enemigoAPelear())) {
				System.out.println("Ganaste!!!");
				break;
			}else {
			System.out.println("Perdiste!!");
			back = 3;
			break;
			}
		case 2:
			System.out.println(partida.getHeroePrincipal().verInventario());
			break;
		case 3:
			back = 3;
			break;
		default:
				break;
		}
		
		return back;
	}
}
