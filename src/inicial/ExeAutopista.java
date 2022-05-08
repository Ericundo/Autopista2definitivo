package inicial;

import java.util.Scanner;

import entidades.*;
import utils.Datos;

public class ExeAutopista {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		boolean validP = false;


		String str = "Bienvenido al programa de gestion de autopistas.\n";

		for (int i = 0; i < str.length(); i++) {
			Thread.sleep(70);
			System.out.print(str.charAt(i));
		}


		do {

			String strMP = "Seleccione el menu al que desea dirigirse:\n\n";

			for (int i = 0; i < strMP.length(); i++) {
				Thread.sleep(70);
				System.out.print(strMP.charAt(i));
			}

			System.out.println("\t\t1: Gestion de Trabajadores.");
			System.out.println("\t\t2: Gestion de tramos y peajes.");
			System.out.println("\t\t3: Gestion de Vehiculos.");
			System.out.println("\t\t4: Salir\n");

			boolean validT = false;
			int selec = sc.nextInt();

			switch (selec) {

			case 1:// Aqu� va el menu de los trabajadores
				do {

					String strMT = "Bienvenido al Menu de Trabajadores:\n\n";

					for (int i = 0; i < strMT.length(); i++) {
						Thread.sleep(70);
						System.out.print(strMT.charAt(i));
					}

					System.out.println("\t\t1: Visualizar trabajadores.");
					System.out.println("\t\t2: Annadir trabajador.");
					System.out.println("\t\t3: Buscar trabajador.");
					System.out.println("\t\t4: Volver al menu principal.\n");

					int selecT = sc.nextInt();

					switch (selecT) {

					case 1:
						System.out.println("Lista de trabajadores:\n");

						System.out.println("Operarios de Cabina:");
						for (OCabina i : Datos.OCABINAS) {
							System.out.println(i.toString());
						}

						System.out.println("\nOperarios de Carretera:");
						for (OCarretera i : Datos.OCARRETERAS) {
							System.out.println(i.toString());
						}

						System.out.println("\nOperarios de Oficina:");
						for (OOficina i : Datos.OOFICINAS) {
							System.out.println(i.toString());
						}
						System.out.println();

						break;
					case 2:
						boolean validCT = false;
						System.out.println("Seleccione el tipo de trabajador que quiere crear:");

						System.out.println("\t\t1: Operario de Cabina.");
						System.out.println("\t\t2: Operario de Carretera.");
						System.out.println("\t\t3: Operario de Oficina.");
						System.out.println("\t\t4: Cancelar operacion.");

						do {
							switch (sc.nextInt()) {
							case 1:
								OCabina.nuevaOCabina();
								break;
							case 2:
								OCarretera.nuevaOCarretera();
								break;
							case 3:
								OOficina.nuevaOOficina();
								break;
							case 4:
								validCT = true;
								break;
							default:
								System.out
										.println("Ha introducido un valor invalido, por favor vuelva a intentarlo.\n");
								break;
							}
						} while (!validCT);

						break;
					case 3:
						break;
					case 4:
						validT = true;
						break;
					default:
						System.out.println("Ha introducido un valor invalido, por favor vuelva a intentarlo.\n");
						break;
					}
				} while (!validT);

				break;

			case 2:// Aqu� va el menu de los tramos
				boolean validTr = false;
				do {

					String strMR = "Bienvenido al Menu de Tramos:\n\n";

					for (int i = 0; i < strMR.length(); i++) {
						Thread.sleep(70);
						System.out.print(strMR.charAt(i));
					}

					System.out.println("\t\t1: Visualizar tramo peaje/s.");
					System.out.println("\t\t2: Nuevo tramo/peaje.");
					System.out.println("\t\t3: Buscar tramo/peaje.");
					System.out.println("\t\t4: Problemas en peajes.");
					System.out.println("\t\t5: Volver al menu principal.\n");

					int selecTr = sc.nextInt();

					switch (selecTr) {

					case 1:
						System.out.println("Lista de tramos y peajes:\n");

						System.out.println("Tramos No Controlados:");
						for (NoControlado i : Datos.NOCONTROLADOS) {
							System.out.println(i.toString());
						}

						System.out.println("\nTramos No Controlados:");
						for (Controlado i : Datos.CONTROLADOS) {
							System.out.println(i.toString());
						}

						System.out.println("Peajes:");
						for (Peaje i : Datos.PEAJES) {
							System.out.println(i.toString());
						}
						System.out.println();

						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						validTr = true;
						break;
					default:
						System.out.println("Ha introducido un valor invalido, por favor vuelva a intentarlo.\n");
						break;
					}
				} while (!validTr);

				break;

			case 3:// Aqu� va el menu de los vehiculos
				boolean validV = false;
				do {
					String strMT = "Bienvenido al Menu de Vehiculos:\n\n";

					for (int i = 0; i < strMT.length(); i++) {
						Thread.sleep(70);
						System.out.print(strMT.charAt(i));
					}
					System.out.println("\t\t1: Visualizar vehiculo.");
					System.out.println("\t\t2: Nuevo vehiculo.");
					System.out.println("\t\t3: Buscar vehiculo.");
					System.out.println("\t\t4: Informes de flotas.");
					System.out.println("\t\t5: Volver al menu principal.");

					int selecV = sc.nextInt();

					switch (selecV) {
					case 1:

						System.out.println("Lista de vehiculos:\n");

						for (Vehiculo i : Datos.VEHICULOS) {
							System.out.println(i.toString());
						}
						System.out.println();

						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						validV = true;
						break;
					default:
						System.out.println("Ha introducido un valor invalido, por favor vuelva a intentarlo.\n");
						break;
					}
				} while (!validV);

				break;

			case 4:// Aqu� se cierra el programa
				validP = true;
				break;
			default:// Mensaje de error
				System.out.println("Ha introducido un valor invalido, por favor vuelva a intentarlo.\n");
				break;

			}

		} while (!validP);


	}

}
