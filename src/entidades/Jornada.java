package entidades;

import java.time.LocalDate;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Jornada {

	// Aqu� definimos los atributos
	// dni trabajador sirve para indicar el identificador de trabajador es un dato
	// de tipo string con valor de 8 digitos + una letra que no se puede repetir y
	// con valor por defecto null
	private String dniTrabajador;
	// jorvehiculo sirve para indicar el vehiculo utilizado de dicha jornada es un
	// dato de tipo vehiculo
	private String matricula;
	private long tramo;
	// fecha sirve para indicar la fecha de la jornada es un dato de tipo local date
	// con valor por defecto fecha actual
	private LocalDate fecha;
	// turno sirve para indicar el turno de la jornada desarrollada es un dato de
	// tipo char con valores AM/PM
	private char turno;
	
	public OCarretera ocarretera;
	
	// Aqu� definimos los constructores
	public Jornada() {
		
		ocarretera =new OCarretera();

	}

	public Jornada(String dniT, char tur) {
		this.setDniTrabajador(dniT);
		this.setTurno(tur);

	}

	// Aqui se incluyen los metodos get y set
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String dniTrabajador() {
		return dniTrabajador;
	}

	public void setDniTrabajador(String dniTrabajador) {
		this.dniTrabajador = dniTrabajador;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setJorVehiculo(String matricula) {
		this.matricula = matricula;
	}

	public char getTurno() {
		return turno;
	}

	public void setTurno(char turno) {
		this.turno = turno;
	}

	public long getTramo() {
		return tramo;
	}

	public void setTramo(long tramo) {
		this.tramo = tramo;
	}

	// Aqui el metodo toString
	@Override
	public String toString() {
		return "Jornada [dniTrabajador=" + dniTrabajador + ", matricula=" + matricula + ", tramo=" + tramo + ", fecha="
				+ fecha + ", turno=" + turno + "]";
	}

	public static Jornada nuevaJornada() {
		Jornada ret = new Jornada();
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduca el dni del trabajador:");
		ret.setDniTrabajador(sc.nextLine());

		sc.close();
		return ret;
	}

	// Metodo p�blico data
	public String data() {
		return "" + this.dniTrabajador + "|" + this.matricula + "|" + this.tramo + "|" + this.turno;
	}

	// Exportar objetos a fichero txt
	private static String fichero = "Jornada.txt";

	public static Jornada cargaJornada() {
		FileInputStream fis = null;
		ObjectInputStream entrada = null;
		Jornada obj = null;
		try {
			fis = new FileInputStream(fichero);
			entrada = new ObjectInputStream(fis);
			obj = (Jornada) entrada.readObject();
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
			salida.writeObject(dniTrabajador);
			salida.writeObject(matricula);
			salida.writeObject(tramo);
			salida.writeObject(fecha);
			salida.writeObject(turno);

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
	private String ruta_archivo = "e:/temporal/Jornada.dat";

	public void escribir() {
		try {

			Jornada jornada = new Jornada(dniTrabajador, turno);
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.ruta_archivo));
			file.writeObject(jornada);
			file.close();
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public void leer() {
		try {  
			ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.ruta_archivo));
			Jornada clase = (Jornada) file.readObject();
			file.close();
			System.out.println("El objeto se llama:" + clase.dniTrabajador());
			System.out.println("El objeto se llama:" + clase.getFecha());
			System.out.println("El objeto se llama:" + clase.getTramo());
			System.out.println("El objeto se llama:" + clase.getFecha());
			System.out.println("El objeto se llama:" + clase.getTurno());

		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {
		Jornada b = new Jornada();
		b.escribir();
	}
	
	
	
}
