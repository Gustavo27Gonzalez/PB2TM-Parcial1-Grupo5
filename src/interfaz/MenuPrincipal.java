package interfaz;

	import java.util.Scanner;
	import dominio.Enemigo;
	import dominio.Heroe;
	import dominio.Jefe;
	import dominio.Juego;

	public class MenuPrincipal {

		public static void main(String[] args) {

			Boolean exitFlag = false;
			
			
			Juego partidaNueva = menuPrincipal();
			do {
				opcionesDelMenu();
				exitFlag = seleccionesMenu(partidaNueva);

			} while (!exitFlag);

			System.out.println("\n\t...Saliendo del juego...");
		}
			
			
		
			
		
		private static Juego menuPrincipal() {
			
			Scanner teclado = new Scanner(System.in);
			String nombre;
			Integer seleccionClase;
			
			System.out.println("\t******Menu de inicio******\n");
			System.out.println("\t-> Ingrese su nombre <-\n");

			System.out.print("\t-> ");
			nombre = teclado.nextLine();

			do {
				System.out.println("\n\t******Seleccione la clase******\n" 
						+ "\t1 -> Mago\n" 
						+ "\t2 -> Paladin\n" 
						+ "\t3 -> Asesino\n"
						+ "\t4 -> Caballero\n"
						+ "\t*******************************\n");
			
				
				System.out.print("\t-> ");
				seleccionClase = Integer.parseInt(teclado.nextLine());
				if (seleccionClase > 0 && seleccionClase <= 4) {

					break;
				}
				System.out.println("\tError al crear la clase, Seleccione un numero de entre las opciones\n");
			} while (true);

			Juego partidaNueva = new Juego(nombre, seleccionClase);

			System.out.println("\t-> Se ha creado el heroe: " + partidaNueva.getHeroePrincipal().getNombre() + ", de clase: "
					+ partidaNueva.getHeroePrincipal().getClase() + "\n");
			
			return partidaNueva;

		}

			

		private static void opcionesDelMenu() {

			System.out.println("\t********Menu principal********\n");

			System.out.println("\t1 - Combate a muerte");
			System.out.println("\t2 - Ver inventario de armas");
			System.out.println("\t3 - Ver status del heroe");
			System.out.println("\t4 - Salir\n");
			System.out.println("\t*****************************\n");

		}

		private static Boolean seleccionesMenu(Juego partida) {
			Scanner teclado = new Scanner(System.in);
			System.out.print("\t-> ");
			Integer opcion = Integer.parseInt(teclado.nextLine());
			Boolean inExitFlag = false;

			switch (opcion) {
			case 1: {
				if(case1(partida)) {
					inExitFlag = true;
				}
				break;
			}

			case 2: {
				System.out.println(partida.getHeroePrincipal().verInventario());
				break;
			}
			case 3: {
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

		private static Boolean case1(Juego partida) {
			Boolean inExitFlag = false;
			
			if (partida.getContadorDeBoss() < 5) {
				partida.crearEnemigo();
				if (resultadoDePeleaContraElEnemigoComun(partida, partida.getHeroePrincipal(),
						partida.enemigoAPelear())) {
					partida.setContadorDeBoss(partida.getContadorDeBoss() + 1);
					
				} else {
					partida.setContadorDeBoss(0);
					inExitFlag = true;

				}
			} else {
				partida.crearJefe();
				if (resultadoDePeleaContraElJefe(partida, partida.getHeroePrincipal(), partida.jefeAPelear())) {
					partida.setContadorDeBoss(0);
					partida.dropearArma(partida.getHeroePrincipal());
				} else {
					inExitFlag = true;
				}
			}

			return inExitFlag;
		
		}
		private static Boolean resultadoDePeleaContraElEnemigoComun(Juego partida, Heroe jugador, Enemigo enemigo) {

			if (partida.pelea(partida.getHeroePrincipal(), partida.enemigoAPelear())) {
				System.out.println("\t-> Has vencido al mounstro <-\n");
				return true;
			} else {
				System.out.println("\tCaiste en batalla..." + " GAME OVER!!");
				return false;

			}
		}

		private static Boolean resultadoDePeleaContraElJefe(Juego partida, Heroe jugador, Jefe enemigo) {

			System.out.println("\t...BOSS INCOMING...\n");
			if (partida.pelea(partida.getHeroePrincipal(), partida.jefeAPelear())) {
				System.out.println("\t-> Has vencido al JEFE <-\n");
				return true;
			} else {
				System.out.println("\tCaiste en batalla..." + "GAME OVER!!");
				return false;

			}
		}
		
		
	}