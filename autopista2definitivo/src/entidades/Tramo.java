package entidades;

import java.util.ArrayList;
import java.util.Scanner;

import utils.Utilidades;
import validaciones.Validaciones;

public class Tramo {
	
	// Atributos
	
	protected long idTramo; // idTramo, el identificador para todos los objetos de tipo Tramo es un long
	// mayor o igual que 1, no se puede repetir.
	protected int kmInicio; // kmInicio es el punto de inicio del tramo es un int mayor o igual a 0
	protected int kmFin; // kmFin es el punto final del tramo, es un int mayor o igual a 0
	public ArrayList<Jornada> contiene = new ArrayList();
	//Constructor por defecto:
	
	public Tramo() {
	}
	
	// Constructor con parametros:
	
	public Tramo(long idTramo, int kmInicio, int kmFin) {
		super();
		this.idTramo = idTramo;
		this.kmInicio = kmInicio;
		this.kmFin = kmFin;
	}
	// Metodos get y set:

	public long getIdTramo() {
		return idTramo;
	}

	public void setIdTramo(long idTramo) {
		this.idTramo = idTramo;
	}

	public int getKmInicio() {
		return kmInicio;
	}

	public void setKmInicio(int kmInicio) {
		this.kmInicio = kmInicio;
	}

	public int getkmFin() {
		return kmFin;
	}

	public void setImFin(int kmFin) {
		this.kmFin = kmFin;
	}
	
	// Metodo nuevoTramo:
	
	public static Tramo nuevoTramo() {
		Tramo ret = null;
		long idTramo = -1;
		int kmInicio = 0;
		int kmFin = 1;
		Tramo t = null;
		Scanner in;
		boolean valido = false;
		do {
			System.out.println("Introduzca el id del tramo:");
			in = new Scanner(System.in);
			idTramo = in.nextInt();
			if (idTramo > 0)
				valido = true;
			else
				System.out.println("Valor incorrecto para el id del tramo.");
		} while (!valido);

		valido = false;
		do {
			System.out.println("Introduzca el km de inicio:");
			in = new Scanner(System.in);
			kmInicio = in.nextInt();
			if (kmInicio >= 0)
				valido = true;
			else
				System.out.println("Valor incorrecto para el inicio.");
		} while (!valido);

		valido = false;
		do {
			System.out.println("Introduzca el km de fin:");
			in = new Scanner(System.in);
			kmFin = in.nextInt();
			if (kmFin > 0)
				valido = true;
			else
				System.out.println("Valor incorrecto para el id del tramo.");
		} while (!valido);

		System.out.println("Introduzca ahora los datos personales:");
		in = new Scanner(System.in);
		t = Tramo.nuevoTramo();

		ret = new Tramo(idTramo, kmInicio, kmFin);
		return ret;
	}
	
}
