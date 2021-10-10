package interfaz;

import java.util.Scanner;

import dominio.Enemigo;
import dominio.Heroe;
import dominio.Jefe;
import dominio.Juego;

public class MenuPrincipal {

	public static void main(String[] args) {

        Boolean exitFlag = false;
        Juego partidaNueva = new Juego();
        Jefe jefeFinal;
        Integer contadorParaJefe = 0;

        menuPrincipal(partidaNueva);
        do {
            opcionesDelMenu();
            exitFlag = seleccionesMenu(partidaNueva);

        } while (!exitFlag);

        System.out.println("\t\tSaliendo del juego...");
    }
	
	private static void menuPrincipal(Juego partida) {

        Scanner teclado = new Scanner(System.in);
        String nombre;
        Integer seleccionClase;

        System.out.println("\t\tMenu de inicio");
        System.out.println("\t\tIngrese su nombre");

        nombre = teclado.nextLine();

        do {
            System.out.println("\t Seleccione la clase\n" + "1 -> Mago\n" + "2 -> Paladin\n" + "3 -> Asesino\n"
                    + "4 -> Caballero\n");
            seleccionClase = Integer.parseInt(teclado.nextLine());
            if (seleccionClase > 0 && seleccionClase <= 4) {

                Heroe nuevo = new Heroe(nombre, seleccionClase);
                partida.setHeroePrincipal(nuevo);

                System.out.println("Se ha creado el heroe: " + partida.getHeroePrincipal().getNombre() + ", de clase: "
                        + partida.getHeroePrincipal().getClase());
                System.out.println("***");
                break;
            }
            System.out.println("Error al crear la clase, Seleccione un numero de entre las opciones");
        } while (true);

    }

	
	private static void opcionesDelMenu() {

        System.out.println("\t\tMenu principal\n");

        System.out.println("1 - Combate a muerte");
        System.out.println("2 - Ver inventario de armas");
        System.out.println("3 - Ver status del heroe");
        System.out.println("4 - Salir");

    }
	
	private static Boolean seleccionesMenu(Juego partida) {
        Scanner teclado = new Scanner(System.in);
        Integer opcion = Integer.parseInt(teclado.nextLine());
        Boolean inExitFlag = false;
        Integer contadorParaElJefe = 5;

        switch (opcion) {
        case 1: {
            do {
                if (resultadoDePeleaContraElEnemigoComun(partida, partida.getHeroePrincipal(),
                        partida.enemigoAPelear())) {
                    contadorParaElJefe--;
                    System.out.println(contadorParaElJefe);
                    break;
                }
                contadorParaElJefe = 5;
                inExitFlag = true;
                break;
            } while (contadorParaElJefe > 0);
            break;
        }
        case 2:{
            System.out.println(partida.getHeroePrincipal().verInventario());
            break;
        }
        case 3:{
            System.out.println(partida.getHeroePrincipal().getStatusHeroe());
            break;
        }
        case 4:
            inExitFlag = true;
            break;
        default:
            break;

        }

        return inExitFlag;
    }
	
	private static Boolean resultadoDePeleaContraElEnemigoComun(Juego partida, Heroe jugador, Enemigo enemigo) {

        if (partida.pelea(partida.getHeroePrincipal(), partida.enemigoAPelear())) {
            System.out.println("\t\tHas vencido al mounstro\n");
            return true;
        } else {
            System.out.println("\tCaiste en batalla...\n" + "\tGAME OVER!!");
            return false;

        }
    }
	
	
}
