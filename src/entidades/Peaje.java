package entidades;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class Peaje {

	// Aquï¿½ definimos los atributos
	private long idPeaje; // idPeaje es un long mayor o igual que uno el cual no se puede repetir, y su
							// valor por defecto es #null
	private long idTramo; // idTramo, el identificador para todos los objetos de tipo Tramo es un long
							// mayor o igual que 1, no se puede repetir.
	private int puntokmtramo; // puntokmtramo es un int mayor o igual a 0 con valor por defecto en 0
	private char sentido; // sentido indica el sentrido del peaje, es un char que puede adoptar los
							// valores de 1 o 2 y su valor por defecto es #null
public Pago abonar;
public ArrayList <Pago> pago = new ArrayList();
	// Aquï¿½ definimos los constructores
	public Peaje() {
	}

	public Peaje(long idP, long idT, int pkm, char sent) {
		this.setIdPeaje(idP);
		this.setIdTramo(idT);
		this.setPuntokmtramo(pkm);
		this.setSentido(sent);
	}

	// Aqui se incluyen los metodos get y set
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

	// Aqui el metodo toString
	@Override
	public String toString() {
		return "Peaje [idPeaje=" + idPeaje + ", puntokmtramo=" + puntokmtramo + ", sentido=" + sentido + "]";
	}

	public static Peaje nuevaPeaje() {
		Peaje ret = new Peaje();
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduca el idPeaje:");
		ret.setIdPeaje(sc.nextLong());
		System.out.println("Introduca el idTramo:");
		ret.setIdTramo(sc.nextLong());
		System.out.println("Introduca el punto kilometrico de tramo:");
		ret.setPuntokmtramo(sc.nextInt());

		sc.close();
		return ret;
	}

	// Metodo público data
	public String data() {
		return "" + "|" + this.idPeaje + "|" + this.idTramo + "|" + this.puntokmtramo + "|" + this.sentido;
	}

	// Exportar objetos a fichero txt
	private static String fichero = "Peaje.txt";

	public static Peaje cargaPeaje() {
		FileInputStream fis = null;
		ObjectInputStream entrada = null;
		Peaje obj = null;
		try {
			fis = new FileInputStream(fichero);
			entrada = new ObjectInputStream(fis);
			obj = (Peaje) entrada.readObject();
		} catch (IOException ex) {
			System.out.println("Fallo en la carga del archivo");
		} catch (ClassNotFoundException ex) {
			System.out.println("Fallo en la carga del objeto");
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException ex) {
				System.out.println("Fallo en la carga del archivo");
			}
			try {
				if (entrada != null) {
					entrada.close();
				}
			} catch (IOException ex) {
				System.out.println("Fallo en la carga del archivo");
			}
		}
		return obj;
	}

	ObjectOutputStream salida = null;
	FileOutputStream fos = null;
	{

		try {
			fos = new FileOutputStream(fichero);
			salida = new ObjectOutputStream(fos);
			salida.writeObject(idPeaje);
			salida.writeObject(idTramo);
			salida.writeObject(puntokmtramo);
			salida.writeObject(sentido);

		} catch (IOException ex) {
			System.out.println("Fallo la cerrar del archivo");

		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException ex) {
				System.out.println("Fallo la cerrar del archivo");
			}
			try {
				if (salida != null) {
					salida.close();
				}
			} catch (IOException ex) {
				System.out.println("Fallo la cerrar del archivo");
			}
		}
	}
	// Exportar un objeto a fichero binario.
	private String ruta_archivo = "e:/temporal/Peaje.dat";

	public void escribir() {
		try {

			Peaje peaje = new Peaje(idPeaje, idTramo, puntokmtramo, sentido);
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.ruta_archivo));
			file.writeObject(peaje);
			file.close();
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public void leer() {
		try {
			ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.ruta_archivo));
			Peaje clase = (Peaje) file.readObject();
			file.close();
			System.out.println("El objeto se llama:" + clase.getIdPeaje());
			System.out.println("El objeto se llama:" + clase.getIdTramo());
			System.out.println("El objeto se llama:" + clase.getPuntokmtramo());
			System.out.println("El objeto se llama:" + clase.getSentido());

		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {
		Peaje b = new Peaje();
		b.escribir();
	}
}
