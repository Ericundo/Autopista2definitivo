package entidades;

import java.time.LocalDate;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Nomina {

	// Aqui definimos los atributos
	private LocalDate mesAnno;// sirve para referirse a la fecha es un dato de tipo local date con valor de
								// fecha y valor por defecto del a�o actual
	private String dniTrabajador;// sirve para identificar al trabajador es un dato de tipo string con valor de 8
									// digitos + una letra con valor invalido alfanumerico que no se puede repetir y
									// valor por defecto null
	private double sueldo;// sirve para referirse al sueldo que se cobra en dicha nomina es un dato de
							// tipo double con valor mayor o igual que 1 y valor invalido menor que 1
	private double numSS;// sirve para indicar el numero de la seguridad social es un dato de tipo double
							// con valor mayor o igual que 1 y valor invalido menor que 1

	public Trabajador trabajador;
	// Aqu� definimos los constructores
	public Nomina(LocalDate mesAnno2, String dniTrabajador2, double sueldo2, double numSS2) {
	}

	public Nomina(String dniT, double sueldo, double numss) {
		this.setDniTrabajador(dniT);
		this.setSueldo(sueldo);
		this.setNumSS(numss);
	}

	public Nomina() {
		// TODO Auto-generated constructor stub
	}

	// Aqui se incluyen los metodos get y set
	public LocalDate getMesAnno() {
		return mesAnno;
	}

	public void setMesAnno(LocalDate mesAnno) {
		this.mesAnno = mesAnno;
	}

	public String getDniTrabajador() {
		return dniTrabajador;
	}

	public void setDniTrabajador(String dniTrabajador) {
		this.dniTrabajador = dniTrabajador;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public double getNumSS() {
		return numSS;
	}

	public void setNumSS(double numSS) {
		this.numSS = numSS;
	}

	// Aqui el metodo toString
	@Override
	public String toString() {
		return "Nomina [mesAnno=" + mesAnno + ", dniTrabajador=" + dniTrabajador + ", sueldo=" + sueldo + ", numSS="
				+ numSS + "]";
	}

	public static Nomina nuevaNomina() {
		Nomina ret = new Nomina();
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduca el dniTrabajador:");
		ret.setDniTrabajador(sc.nextLine());
		System.out.println("Introduca el sueldo:");
		ret.setSueldo(sc.nextDouble());
		System.out.println("Introduca el numero de la seguridad social:");
		ret.setNumSS(sc.nextDouble());

		sc.close();
		return ret;
	}

	// Metodo p�blico data
	public String data() {
		return "" + this.getDniTrabajador() + "|" + this.getNumSS() + "|" + this.mesAnno + "|" + this.sueldo + "|";
	}

	// Exportar objetos a fichero txt
	private static String fichero = "Nomina.txt";

	public static Nomina cargaNomina() {
		FileInputStream fis = null;
		ObjectInputStream entrada = null;
		Nomina obj = null;
		try {
			fis = new FileInputStream(fichero);
			entrada = new ObjectInputStream(fis);
			obj = (Nomina) entrada.readObject();
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
			salida.writeObject(mesAnno);
			salida.writeObject(dniTrabajador);
			salida.writeObject(sueldo);
			salida.writeObject(numSS);

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
	private String ruta_archivo = "e:/temporal/Nomina.dat";

	public void escribir() {
		try {

			Nomina nomina = new Nomina(mesAnno, dniTrabajador, sueldo, numSS);
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.ruta_archivo));
			file.writeObject(nomina);
			file.close();
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public void leer() {
		try {
			ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.ruta_archivo));
			Nomina clase = (Nomina) file.readObject();
			file.close();
			System.out.println("El objeto se llama:" + clase.getMesAnno());
			System.out.println("El objeto se llama:" + clase.getDniTrabajador());
			System.out.println("El objeto se llama:" + clase.getSueldo());
			System.out.println("El objeto se llama:" + clase.getNumSS());

		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {
		Nomina b = new Nomina();
		b.escribir();
	}

	
	}



