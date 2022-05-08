package entidades;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Informe {

	// Aquï¿½ definimos los atributos
	private String descripcion;// descripciï¿½n sirve para describir los datos que aparecen en el informe es un
								// dato de tipo string que puede recibir un valor cualquiera
	private int annoInforme;// annoInforme sirve para referirse al aï¿½o en el que se escribiï¿½ el informe
							// es un dato de tipo int con un valor de 4 digitos y un valor invalido de <2000
	private long remitente;// idRemitente sirve para referirse a quien envia el informe es una clase de
							// tipo long con valor mayor o igual que 0 que no se puede repetir y con valor
							// por defecto null
	private long destinatario;// destinatario sirve para referirse a la persona que recibe el informe es una
								// clase de tipo long con valor mayor o igual que 0 que no se puede repetir y
								// con valor por defecto null

	// Aquï¿½ definimos los constructores
	public Informe() {
	}

	public Informe(String desc, int anno, long remi, long dest) {
		this.setDescripcion(desc);
		this.setAnnoInforme(anno);
		this.setRemitente(remi);
		this.setDestinatario(dest);
	}

	// Aqui se incluyen los metodos get y set
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getAnnoInforme() {
		return annoInforme;
	}

	public void setAnnoInforme(int annoInforme) {
		this.annoInforme = annoInforme;
	}

	public long getRemitente() {
		return remitente;
	}

	public void setRemitente(long remitente) {
		this.remitente = remitente;
	}

	public long getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(long destinatario) {
		this.destinatario = destinatario;
	}

	// Aqui el metodo toString

	@Override
	public String toString() {
		return "Informe [descripcion=" + descripcion + ", annoInforme=" + annoInforme + ", remitente=" + remitente
				+ ", destinatario=" + destinatario + "]";
	}

	public static Informe nuevoInforme() {
		Informe ret = new Informe();
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduca el aï¿½o del informe:");
		ret.setAnnoInforme(sc.nextInt());
		System.out.println("Introduca la descripcion:");
		ret.setDescripcion(sc.nextLine());
		System.out.println("Introduca el remitente:");
		ret.setRemitente(sc.nextLong());
		System.out.println("Introduca el destinatario:");
		ret.setDestinatario(sc.nextLong());

		sc.close();
		return ret;
	}

	// Metodo público data
	public String data() {
		return "" + this.descripcion + "|" + this.annoInforme + "|" + this.remitente + "|" + this.destinatario;
	}

	// Exportar objetos a fichero txt
	private static String fichero = "Informe.txt";

	public static Informe cargaInforme() {
		FileInputStream fis = null;
		ObjectInputStream entrada = null;
		Informe obj = null;
		try {
			fis = new FileInputStream(fichero);
			entrada = new ObjectInputStream(fis);
			obj = (Informe) entrada.readObject();
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
			salida.writeObject(descripcion);
			salida.writeObject(annoInforme);
			salida.writeObject(remitente);
			salida.writeObject(destinatario);

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
	private String ruta_archivo = "e:/temporal/Informe.dat";

	public void escribir() {
		try {

			Informe Informe = new Informe(descripcion, annoInforme, remitente, destinatario);
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.ruta_archivo));
			file.writeObject(Informe);
			file.close();
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public void leer() {
		try {  
			ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.ruta_archivo));
			Informe clase = (Informe) file.readObject();
			file.close();
			System.out.println("El objeto se llama:" + clase.getDescripcion());
			System.out.println("El objeto se llama:" + clase.getAnnoInforme());
			System.out.println("El objeto se llama:" + clase.getRemitente());
			System.out.println("El objeto se llama:" + clase.getDestinatario());

		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {
		Informe b = new Informe();
		b.escribir();
	}
}
