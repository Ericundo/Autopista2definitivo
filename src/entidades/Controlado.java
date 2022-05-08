package entidades;

import java.util.Scanner;

public class Controlado extends Tramo {

	// Aqu� definimos los atributos
	private int numPaneles;// numPaneles es el numero de paneles que hay en el tramo es un tipo de dato int
							// mayor o igual que 0 y con un valor por defecto de 0
public Tramo tramo;
public Peaje peaje;

void ensamblar (Peaje peaj) {
	peaje = peaj;
}
	// Aqu� definimos los constructores
	public Controlado() {
		super();
	}

	public Controlado(long idT, int kmIni, int kmFin, int nPaneles) {
		super();
		this.setIdTramo(idT);
		this.setKmInicio(kmIni);
		this.setImFin(kmFin);
		this.setNumPaneles(nPaneles);
	}

	// Aqui se incluyen los metodos get y set
	public int getNumPaneles() {
		return numPaneles;
	}

	public void setNumPaneles(int numPaneles) {
		this.numPaneles = numPaneles;
	}

	// Aqui el metodo toString
	@Override
	public String toString() {
		return "Controlado [numPaneles=" + numPaneles + "]";
	}

	public static Controlado nuevoControlado() {
		Controlado ret = new Controlado();
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduca el idTramo:");
		ret.setIdTramo(sc.nextLong());
		System.out.println("Introduca el KmFin:");
		ret.setImFin(sc.nextInt());
		System.out.println("Introduca el KmInicio:");
		ret.setKmInicio(sc.nextInt());
		System.out.println("Introduca el numero de paneles:");
		ret.setNumPaneles(sc.nextInt());

		sc.close();
		return ret;
	}

}
