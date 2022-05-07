package entidades;

import java.util.Scanner;

import utils.Utilidades;
import validaciones.Validaciones;

public class NoControlado extends Tramo {
	
		// Atributos
	
		private int numPaneles;// numPaneles sirve para referirse al numero de paneles que hay en un tramo de
								// tipo int con valores mayor o igual que 0 y valor por defecto 0
		private double desnivel;// desnivel sirve para referirse al desnivel que hay en el tramo de carretera de
								// tipo double con valor mayor o igual que 0 y valor por defecto 0
		
		public Tramo tramo;
		
		// Constructores:

		// Por Defecto:
		public NoControlado() {
		}

		// Constructores con parámetros:
		
		public NoControlado(long idTramo, int kmInicio, int kmFin, int numPaneles, double desnivel) {
			super(idTramo, kmInicio, kmFin);
			this.numPaneles = numPaneles;
			this.desnivel = desnivel;

		}
		
		
		
		
		public NoControlado(long idTramo, int kmInicio, int kmFin, int numPaneles, double desnivel, Tramo t) {
			super(idTramo, kmInicio, kmFin);
			this.numPaneles = numPaneles;
			this.desnivel = desnivel;
			this.tramo = t;
		}
		
		public NoControlado(int numPaneles, double desnivel, Tramo t) {
			super();
			this.numPaneles = numPaneles;
			this.desnivel = desnivel;
			this.tramo = t;
		}
		
		public NoControlado(long idTramo, int kmInicio, int kmFin, Tramo t) {
			super(idTramo, kmInicio, kmFin);
			this.tramo = t;
		}



		// Constructor copia:
		public NoControlado(NoControlado objNoControlado) {

			this.numPaneles = objNoControlado.numPaneles;
			this.tramo = objNoControlado.tramo;
		}
		
		// Metodos get y set
		
		public int getNumPaneles() {
			return numPaneles;
		}

		public void setNumPaneles(int numPaneles) {
			this.numPaneles = numPaneles;
		}

		public double getDesnivel() {
			return desnivel;
		}

		public void setDesnivel(double desnivel) {
			this.desnivel = desnivel;
		}

		public Tramo getTramo() {
			return tramo;
		}

		public void setTramo(Tramo tramo) {
			this.tramo = tramo;
		}

		
		
		// Metodo toString
		
		@Override
		public String toString() {
			return "NoControlado [numPaneles=" + numPaneles + ", desnivel=" + desnivel + ", tramo=" + tramo + "]";
		}
		
		// Metodo Data:
		
		public String data() {
			return "" + tramo.getIdTramo() + "|" + tramo.getKmInicio() + "|" + tramo.getkmFin() + "|"
					+ this.numPaneles + "|" + this.getDesnivel();
		}
		
		// Metodo nuevoNoControlado:
		
		public static NoControlado nuevoNoControlado() {
			NoControlado ret = null;
			int numPaneles = 1;
			double desnivel = 0;
			Tramo t = null;
			Scanner in;
			boolean valido = false;
			do {
				System.out.println("Introduzca la cantidad de Paneles del Tramo:");
				in = new Scanner(System.in);
				numPaneles = in.nextInt();
				if (numPaneles >= 0)
					valido = true;
				else
					System.out.println("No puede haber menos de 0 paneles.");
			} while (!valido);
			do {
				System.out.println("Introduzca los desniveles que haya:");
				in = new Scanner(System.in);
				desnivel = in.nextDouble();
				if (desnivel >= 0)
					valido = true;
				else
					System.out.println("No puede haber menos de 0 desniveles.");
			} while (!valido);
			

			valido = false;
			
			System.out.println("Introduzca ahora los datos del Tramo:");
			in = new Scanner(System.in);
			t = Tramo.nuevoTramo();

			ret = new NoControlado(numPaneles, desnivel, t);
			return ret;
		}

}
