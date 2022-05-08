package entidades;

import java.util.Scanner;

public class NoControlado extends Tramo {

	// Aqu� definimos los atributos
	private int numPaneles;// numPaneles sirve para referirse al numero de paneles que hay en un tramo de
							// tipo int con valores mayor o igual que 0 y valor por defecto 0
	private double denivel;// desnivel sirve para referirse al desnivel que hay en el tramo de carretera de
							// tipo double con valor mayor o igual que 0 y valor por defecto 0
	
	public Tramo tramo;

	// Aqu� definimos los constructores
	public NoControlado() {
		super();
	}

	public NoControlado(int numP, double desnivel) {
		super();
		this.setNumPaneles(numP);
		this.setDenivel(desnivel);
	}

	// Aqui se incluyen los metodos get y set
	public int getNumPaneles() {
		return numPaneles;
	}

	public void setNumPaneles(int numPaneles) {
		this.numPaneles = numPaneles;
	}

	public double getDenivel() {
		return denivel;
	}

	public void setDenivel(double denivel) {
		this.denivel = denivel;
	}

	// Aqui el metodo toString
	@Override
	public String toString() {
		return "NoControlado [numPaneles=" + numPaneles + ", denivel=" + denivel + "]";
	}

	public static NoControlado nuevoNoControlado() {
		NoControlado ret = new NoControlado();
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduca el idTramo:");
		ret.setIdTramo(sc.nextLong());
		System.out.println("Introduca el KmFin:");
		ret.setImFin(sc.nextInt());
		System.out.println("Introduca el KmInicio:");
		ret.setKmInicio(sc.nextInt());
		System.out.println("Introduca el numero de paneles:");
		ret.setNumPaneles(sc.nextInt());
		System.out.println("Introduca el desnivel:");
		ret.setDenivel(sc.nextDouble());

		sc.close();
		return ret;
	}

}
