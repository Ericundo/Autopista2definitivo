package entidades;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class Tramo {

	// Aquï¿½ definimos los atributos
	protected long idTramo; // idTramo, el identificador para todos los objetos de tipo Tramo es un long
							// mayor o igual que 1, no se puede repetir.
	protected int kmInicio; // kmInicio es el punto de inicio del tramo es un int mayor o igual a 0
	protected int kmFin; // kmFin es el punto final del tramo, es un int mayor o igual a 0
	public ArrayList <Jornada> contiene = new ArrayList();
	// Aquï¿½ definimos los constructores
	public Tramo() {
	}

	public Tramo(long idT, int kmI, int kmF) {
		this.setIdTramo(idT);
		this.setKmInicio(kmI);
		this.setImFin(kmF);
	}

	// Aqui se incluyen los metodos get y set
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

	// Aqui el metodo toString
	@Override
	public String toString() {
		return "Tramo [idTramo=" + idTramo + ", kmInicio=" + kmInicio + ", kmFin=" + kmFin + "]";
	}

	// Metodo público data
	public String data() {
		return "" + this.idTramo + "|" + this.kmInicio + "|" + this.kmFin;
	}

	// Exportar objetos a fichero txt
	private static String fichero = "Tramo.txt";

	public static Tramo cargaTramo() {
		FileInputStream fis = null;
		ObjectInputStream entrada = null;
		Tramo obj = null;
		try {
			fis = new FileInputStream(fichero);
			entrada = new ObjectInputStream(fis);
			obj = (Tramo) entrada.readObject();
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
			salida.writeObject(idTramo);
			salida.writeObject(kmInicio);
			salida.writeObject(kmFin);
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
}
	


