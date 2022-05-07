package entidades;

import java.util.ArrayList;
import java.util.Scanner;

public class Peaje {
	
		//Atributos

		private long idPeaje; // idPeaje es un long mayor o igual que uno el cual no se puede repetir, y su
								// valor por defecto es #null
		private long idTramo; // idTramo, el identificador para todos los objetos de tipo Tramo es un long
								// mayor o igual que 1, no se puede repetir.
		private int puntokmtramo; // puntokmtramo es un int mayor o igual a 0 con valor por defecto en 0
		private char sentido; // sentido indica el sentrido del peaje, es un char que puede adoptar los
								// valores de 1 o 2 y su valor por defecto es #null
	public Pago abonar;
	public ArrayList <Pago> pago = new ArrayList();
	
		//Constructores
	
		// Por Defecto:

		public Peaje(long idPeaje, long idTramo, int puntokmtramo, char sentido, Pago p) {
		}
		
		// Constructores con parámetros:

		public Peaje(long idP, long idT, int pkm, char sent) {
			this.setIdPeaje(idP);
			this.setIdTramo(idT);
			this.setPuntokmtramo(pkm);
			this.setSentido(sent);
		}

		
		
		// Metodos get y set:

		public long getIdPeaje() {
			return idPeaje;
		}

		public void setIdPeaje(long idPeaje) {
			this.idPeaje = idPeaje;
		}

		public long getIdTramo() {
			return idTramo;
		}

		public void setIdTramo(long idTramo) {
			this.idTramo = idTramo;
		}

		public int getPuntokmtramo() {
			return puntokmtramo;
		}

		public void setPuntokmtramo(int puntokmtramo) {
			this.puntokmtramo = puntokmtramo;
		}

		public char getSentido() {
			return sentido;
		}

		public void setSentido(char sentido) {
			this.sentido = sentido;
		}

		public Pago getAbonar() {
			return abonar;
		}

		public void setAbonar(Pago abonar) {
			this.abonar = abonar;
		}

		public ArrayList<Pago> getPago() {
			return pago;
		}

		public void setPago(ArrayList<Pago> pago) {
			this.pago = pago;
		}
		
		// Metodo nuevoPeaje:
		
		public static Peaje nuevoPeaje() {
			Peaje ret = null;
			long idPeaje = 1;
			long idTramo = 1;
			int puntokmtramo = 1;
			char sentido = 0;
			Pago p = null;


			Scanner in;
			boolean valido = false;
			do {
				System.out.println("Introduzca el id del peaje:");
				in = new Scanner(System.in);
				idPeaje = in.nextLong();
				if (idPeaje > 0)
					valido = true;
				else
					System.out.println("Valor incorrecto del id.");
			} while (!valido);
			do {
				System.out.println("Introduzca el id del tramo en el que se encuentra:");
				in = new Scanner(System.in);
				idPeaje = in.nextLong();
				if (idPeaje > 0)
					valido = true;
				else
					System.out.println("Valor incorrecto del id.");
			} while (!valido);
			do {
				System.out.println("Introduzca el punto kilometrico del tramo:");
				in = new Scanner(System.in);
				puntokmtramo = in.nextInt();
				if (puntokmtramo >= 0)
					valido = true;
				else
					System.out.println("Valor incorrecto para el km.");
			} while (!valido);
			do {
				System.out.println("Introduzca el sentido del Tramo:");
				in = new Scanner(System.in);
				sentido = in.next().charAt(0);
				if (sentido >= 0)
					valido = true;
				else
					System.out.println("Valor incorrecto para el sentido.");
			} while (!valido);

			valido = false;
			
			System.out.println("Introduzca ahora los datos de los pagos:");
			in = new Scanner(System.in);
			p = Pago.nuevoPago();
			
			

			ret = new Peaje(idPeaje, idTramo, puntokmtramo, sentido, p);
			return ret;
		}


}
