package utils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilidades {

	public static String insertNombre() {
		Scanner sc = new Scanner(System.in);
		boolean valido = true;
		String ret;

		do {
			System.out.println("Introduce un nombre:");
			ret = sc.next();

			if (ret.length() < 3 || ret.length() > 12) {

			} else {
				valido = false;
			}

		} while (valido);
		sc.close();

		return ret;
	}

	public static double leerDouble() {
		double ret = 0.0;
		boolean correcto = false;
		Scanner in;
		do {
			System.out.println("Introduzca un valor decimal (xx.xx)");
			in = new Scanner(System.in, "ISO-8859-1");
			try {
				ret = in.nextDouble();
				correcto = true;
			} catch (InputMismatchException ime) {
				System.out.println("Formato introducido incorrecto.");
				correcto = false;
			}
		} while (!correcto);
		return ret;
	}

	public static char letraTurno() {
		char ret;
		Scanner in;
		char resp;
		boolean valid = true;
		do {
			System.out.println("Pulse A para ascendente o D para descendente");
			in = new Scanner(System.in, "ISO-8859-1");
			resp = in.nextLine().charAt(0);
			if (resp != 'a' && resp != 'A' && resp != 'd' && resp != 'D') {
				System.out.println("Valor introducido incorrecto.");
			} else {
				valid = false;
			}
		} while (valid);
		if (resp == 'a' || resp != 'A') {
			ret = 'A';
		} else {
			ret = 'D';
		}
		return ret;
	}

	public static java.sql.Date leerFecha() {
		Date ret = null;
		int dia, mes, anio;
		boolean correcto = false;
		Scanner in;
		do {
			System.out.println("Introduzca un valor para el día (1...31)");
			in = new Scanner(System.in, "ISO-8859-1");
			dia = in.nextInt();
			System.out.println("Introduzca un valor para el mes (1...12)");
			in = new Scanner(System.in, "ISO-8859-1");
			mes = in.nextInt();
			System.out.println("Introduzca un valor para el año");
			in = new Scanner(System.in, "ISO-8859-1");
			anio = in.nextInt();

			try {
				ret = Date.valueOf(LocalDate.of(anio, mes, dia));
				correcto = true;
			} catch (Exception e) {
				System.out.println("Fecha introducida incorrecta.");
				correcto = false;
			}
		} while (!correcto);
		return ret;
	}
}
