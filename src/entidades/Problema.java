package entidades;

import java.time.LocalDate;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Problema {
	// Aquï¿½ definimos los atributos
	private long numExpediente; // numExpediente es un long mayor o igual que uno el cual no se puede repetir, y
								// su valor por defecto es #null
	private String descripcion;
	private LocalDate fecha;
	private Pago pago;
	private String nomUsuario;
	private long idPago; // idPago es un long mayor o igual que uno el cual no se puede repetir, y su
							// valor por defecto es #null
	private String tlfUsuario;
public Pago dependencia;
	// Aquï¿½ definimos los constructores
	public Problema() {
	}

	public Problema(String desc, String nomU, long numE, long idP, String tlfU) {
		this.setDescripcion(desc);
		this.setNomUsuario(nomU);
		this.setNumExpediente(numE);
		this.setIdPago(idP);
		this.setTlfUsuario(tlfU);
	}

	// Aqui se incluyen los metodos get y set

	public Problema(long numExpediente2, String descripcion2, LocalDate fecha2, Pago pago2, String nomUsuario2,
			long idPago2, String tlfUsuario2) {
		// TODO Auto-generated constructor stub
	}

	public long getNumExpediente() {
		return numExpediente;
	}

	public void setNumExpediente(long numExpediente) {
		this.numExpediente = numExpediente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public long getIdPago() {
		return idPago;
	}

	public void setIdPago(long idPago) {
		this.idPago = idPago;
	}

	public String getTlfUsuario() {
		return tlfUsuario;
	}

	public void setTlfUsuario(String tlfUsuario) {
		this.tlfUsuario = tlfUsuario;
	}
	// Aqui el metodo toString

	@Override
	public String toString() {
		return "Problema [numExpediente=" + numExpediente + ", descripcion=" + descripcion + ", fecha=" + fecha
				+ ", pago=" + pago + ", nomUsuario=" + nomUsuario + ", idPago=" + idPago + ", tlfUsuario=" + tlfUsuario
				+ "]";
	}

	public static Problema nuevaProblema() {
		Problema ret = new Problema();
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduca el numero de expediente:");
		ret.setNumExpediente(sc.nextLong());
		System.out.println("Introduca la descripcion:");
		ret.setDescripcion(sc.next());

		sc.close();
		return ret;
	}

	// Metodo público data
	public String data() {
		return "" + "|" + this.descripcion + "|" + this.idPago + "|" + this.nomUsuario + "|" + this.numExpediente + "|"
				+ this.tlfUsuario;
	}

	// Exportar objetos a fichero txt
	private static String fichero = "Problema.txt";

	public static Problema cargaProblema() {
		FileInputStream fis = null;
		ObjectInputStream entrada = null;
		Problema obj = null;
		try {
			fis = new FileInputStream(fichero);
			entrada = new ObjectInputStream(fis);
			obj = (Problema) entrada.readObject();
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
			salida.writeObject(numExpediente);
			salida.writeObject(descripcion);
			salida.writeObject(fecha);
			salida.writeObject(pago);
			salida.writeObject(nomUsuario);
			salida.writeObject(idPago);
			salida.writeObject(tlfUsuario);

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
	private String ruta_archivo = "e:/temporal/Problema.dat";

	public void escribir() {
		try {

			Problema problema = new Problema(numExpediente, descripcion, fecha, pago, nomUsuario, idPago, tlfUsuario);
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.ruta_archivo));
			file.writeObject(problema);
			file.close();
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public void leer() {
		try {
			ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.ruta_archivo));
			Problema clase = (Problema) file.readObject();
			file.close();
			System.out.println("El objeto se llama:" + clase.getDescripcion());
			System.out.println("El objeto se llama:" + clase.getFecha());
			System.out.println("El objeto se llama:" + clase.getPago());
			System.out.println("El objeto se llama:" + clase.getNomUsuario());
			System.out.println("El objeto se llama:" + clase.getIdPago());
			System.out.println("El objeto se llama:" + clase.getTlfUsuario());

		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {
		Problema b = new Problema();
		b.escribir();
	}
}
