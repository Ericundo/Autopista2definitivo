package ejemploMenu;

import java.util.Scanner;

public class menus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		boolean validP = false;

		do {

			System.out.println("Seleccione men�:");
			System.out.println("1: Gesti�n de Trabajadores.");
			System.out.println("2:Gesti�n de tramos y peajes.");
			System.out.println("3: Gesti�n de Veh�culos .");
			System.out.println("4: Salir");

			boolean validT = false;
			int selec = sc.nextInt();

			switch (selec) {

			case 1:// Aqu� va el menu de los trabajadores
				do {
					System.out.println("Men� de Trabajadores:");
					System.out.println("1: Visualizar trabajadores.");
					System.out.println("2: A�adir trabajador.");
					System.out.println("3: Buscar trabajador.");
					System.out.println("4: Volver al men� principal.");

					int selecT = sc.nextInt();

					switch (selecT) {

					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						validT = true;
						break;
					default:
						break;
					}
				} while (!validT);

				break;

			case 2:// Aqu� va el menu de los tramos
				boolean validTr = false;
				do {
					System.out.println("Men� de Tramos:");
					System.out.println("1: Visualizar tramo peaje/s.");
					System.out.println("2: Nuevo tramo/peaje.");
					System.out.println("3: Buscar tramo/peaje.");
					System.out.println("4:Problemas en peajes.");
					System.out.println("5: Volver al men� principal.");

					int selecTr = sc.nextInt();

					switch (selecTr) {

					case 1:
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
						break;
					}
				} while (!validTr);

				break;

			case 3:// Aqu� va el menu de los vehiculos
				boolean validV = false;
				do {
					System.out.println("Men� de Veh�culos:");
					System.out.println("1: Visualizar veh�culo.");
					System.out.println("2: Nuevo veh�culo.");
					System.out.println("3: Buscar veh�culo.");
					System.out.println("4:Informes de flotas.");
					System.out.println("5: Volver al men� principal.");

					int selecV = sc.nextInt();

					switch (selecV) {
					case 1:
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
						break;
					}
				} while (!validV);

				break;

			case 4:// Aqu� se cierra el programa
				validP = true;
				break;
			default:// Mensaje de error
				System.out.println("Ha introducido un valor inv�lido, por favor vuelva a intentarlo.");
				break;

			}

		} while (!validP);
		System.out.println("El programa ha sido cerrado.");
	}

}
