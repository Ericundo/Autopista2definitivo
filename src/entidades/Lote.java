package entidades;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Lote {

	// Aqui definimos los atributos
	private int numLote;// sirve para informar de la cantidad de lote un lote es un dato de tipo int con
						// valor mayor o igual que uno de valor invï¿½lido menor que uno que no se puede
						// repetir y con valor por defecto null

	// Aquï¿½ definimos los constructores
	public Lote() {
	}

	public Lote(int nLote) {
		this.setNumLote(nLote);
	}

	// Aqui se incluyen los metodos get y set
	public int getNumLote() {
		return numLote;
	}

	public void setNumLote(int numLote) {
		this.numLote = numLote;
	}

	// Aqui el metodo toString
	@Override
	public String toString() {
		return "Lote [numLote=" + numLote + "]";
	}

	public static Lote nuevoLote() {
		Lote ret = new Lote();
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduca el numero de lote:");
		ret.setNumLote(sc.nextInt());

		sc.close();
		return ret;
	}

	// Metodo público data
	public String data() {
		return "" + "|" + this.numLote;
	}

	// Exportar objetos a fichero txt
	private static String fichero = "Lote.txt";

	public static Lote cargaLote() {
		FileInputStream fis = null;
		ObjectInputStream entrada = null;
		Lote obj = null;
		try {
			fis = new FileInputStream(fichero);
			entrada = new ObjectInputStream(fis);
			obj = (Lote) entrada.readObject();
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
			salida.writeObject(numLote);

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
	private String ruta_archivo = "e:/temporal/Lote.dat";

	public void escribir() {
		try {

			Lote Lote = new Lote(numLote);
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.ruta_archivo));
			file.writeObject(Lote);
			file.close();  
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public void leer() {
		try {
			ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.ruta_archivo));
			Lote clase = (Lote) file.readObject();
			file.close();
			System.out.println("El objeto se llama:" + clase.getNumLote());

		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {
		Lote b = new Lote();
		b.escribir();
	}
}
