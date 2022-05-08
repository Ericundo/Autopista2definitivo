package entidades;

import java.sql.Time;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Scanner;

public class Pago {

	// Aqui definimos los atributos
	private long idPago; // idPago es un long mayor o igual que uno el cual no se puede repetir, y su
							// valor por defecto es #null
	private LocalDate fecha; // fecha indica la fecha actual
	private char tipPago; // tipPago indica el tipo de pago, puede ser en efectivo o tarjeta asi que sus
							// valores validos son "e" o "t" y valor por defecto en #null
	private Time hora; // hora indica la hora del pago
	private long idPeaje; // idPeaje es un long mayor o igual que uno el cual no se puede repetir, y su
							// valor por defecto es #null
public Peaje abonar;
	// Aquï¿½ definimos los constructores
	public Pago(long idPago2, LocalDate fecha2, char tipPago2, Time hora2, long idPeaje2) {
	}

	public Pago(long idp, char tpago) {
		this.setIdPago(idp);
		this.setTipPago(tpago);
	}

	public Pago() {
		// TODO Auto-generated constructor stub
	}

	// Aqui se incluyen los metodos get y set
	public long getIdPago() {
		return idPago;
	}

	public void setIdPago(long idPago) {
		this.idPago = idPago;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public char getTipPago() {
		return tipPago;
	}

	public void setTipPago(char tipPago) {
		this.tipPago = tipPago;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public long getIdPeaje() {
		return idPeaje;
	}

	public void setIdPeaje(long idPeaje) {
		this.idPeaje = idPeaje;
	}

	// Aqui el metodo toString
	@Override
	public String toString() {
		return "Pago [idPago=" + idPago + ", fecha=" + fecha + ", tipPago=" + tipPago + ", hora=" + hora + "]";
	}

	public static Pago nuevaPago() {
		Pago ret = new Pago();
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduca el idPago:");
		ret.setIdPago(sc.nextLong());

		sc.close();
		return ret;
	}

	// Metodo público data
	public String data() {
		return "" + "|" + this.idPago + "|" + this.idPeaje + "|" + this.tipPago + "|" + this.fecha + "|" + this.hora;
	}

	// Exportar objetos a fichero txt
	private static String fichero = "Pago.txt";

	public static Pago cargaPago() {
		FileInputStream fis = null;
		ObjectInputStream entrada = null;
		Pago obj = null;
		try {
			fis = new FileInputStream(fichero);
			entrada = new ObjectInputStream(fis);
			obj = (Pago) entrada.readObject();
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
			salida.writeObject(idPago);
			salida.writeObject(fecha);
			salida.writeObject(tipPago);
			salida.writeObject(hora);
			salida.writeObject(idPeaje);

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
	private String ruta_archivo = "e:/temporal/Pago.dat";

	public void escribir() {
		try {

			Pago pago = new Pago(idPago, fecha, tipPago, hora, idPeaje);
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.ruta_archivo));
			file.writeObject(pago);
			file.close();
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public void leer() {
		try {
			ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.ruta_archivo));
			Pago clase = (Pago) file.readObject();
			file.close();
			System.out.println("El objeto se llama:" + clase.getIdPago());
			System.out.println("El objeto se llama:" + clase.getFecha());
			System.out.println("El objeto se llama:" + clase.getTipPago());
			System.out.println("El objeto se llama:" + clase.getHora());
			System.out.println("El objeto se llama:" + clase.getIdPeaje());

		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {
		Pago b = new Pago();
		b.escribir();
	}
}
