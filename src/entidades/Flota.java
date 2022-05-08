package entidades;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class Flota {

	// Aquï¿½ definimos los atributos
	private long idFlota;// idFlota es el identificador de la clase flota es un dato de tipo long mayor o
							// igual que 0 que no se puede repetir y con valor por defecto null
	private String NombreFlota;// nombre flota es el nombre que recibe la cual y es un dato de tipo string con
								// cualquier valor
	private OCarretera responsable;// responsable es el cual se encarga de gestionar las acciones en carretera es
									// un dato de tipo operario de carretera
public Vehiculo vehiculo;
public ArrayList <Vehiculo> vehiculos = new ArrayList();
	// Aquï¿½ definimos los constructores
	public Flota() {
		vehiculo = new Vehiculo();
		ocarretera = new OCarretera();
	}
	public OCarretera ocarretera;
	

	public Flota(long idF, String nom) {
		this.setIdFlota(idF);
		this.setNombreFlota(nom);
	}

	// Aqui se incluyen los metodos get y set
	public long getIdFlota() {
		return idFlota;
	}

	public void setIdFlota(long idFlota) {
		this.idFlota = idFlota;
	}

	public String getNombreFlota() {
		return NombreFlota;
	}

	public void setNombreFlota(String nombreFlota) {
		NombreFlota = nombreFlota;
	}

	public OCarretera getResponsable() {
		return responsable;
	}

	public void setResponsable(OCarretera responsable) {
		this.responsable = responsable;
	}

	// Aqui el metodo toString
	@Override
	public String toString() {
		return "Flota [idFlota=" + idFlota + ", NombreFlota=" + NombreFlota + ", responsable=" + responsable + "]";
	}

	public static Flota nuevaFlota() {
		Flota ret = new Flota();
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduca el idFlota:");
		ret.setIdFlota(sc.nextLong());
		System.out.println("Introduca el nombre:");
		ret.setNombreFlota(sc.nextLine());

		sc.close();
		return ret;
	}

	// Metodo público data
	public String data() {
		return "" + this.idFlota + "|" + this.NombreFlota + "|" + this.responsable;
	}

	// Exportar objetos a fichero txt
	private static String fichero = "Flota.txt";

	public static Flota cargaFlota() {
		FileInputStream fis = null;
		ObjectInputStream entrada = null;
		Flota obj = null;
		try {
			fis = new FileInputStream(fichero);
			entrada = new ObjectInputStream(fis);
			obj = (Flota) entrada.readObject();
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
			salida.writeObject(idFlota);
			salida.writeObject(NombreFlota);
			salida.writeObject(responsable);

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
	private String ruta_archivo = "e:/temporal/Flota.dat";

	public void escribir() {
		try {

			Flota flota = new Flota(idFlota, NombreFlota);
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.ruta_archivo));
			file.writeObject(flota);
			file.close();
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public void leer() {
		try {
			ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.ruta_archivo));
			Flota clase = (Flota) file.readObject();
			file.close();
			System.out.println("El objeto se llama:" + clase.getIdFlota());
			System.out.println("El objeto se llama:" + clase.getNombreFlota());
			System.out.println("El objeto se llama:" + clase.getResponsable());

		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {
		Flota b = new Flota();
		b.escribir();
	}
}
