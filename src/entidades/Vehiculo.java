package entidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import utils.Datos;

public class Vehiculo {

	// Aquï¿½ definimos los atributos
	private String modelo; // modelo es el modelo de coche es un string con valor por defecto #null
	private String matricula; // matricula es la matricula del coche es un string, el cual no se puede repetir
								// con valor por defecto #null
	private boolean remolque; // remolque indica si el vehiculo tiene remolque, es un boolean con valor por
								// defecto en false
public Flota flota;
	// Aquï¿½ definimos los constructores
	public Vehiculo() {
	}

	public Vehiculo(String mod, String mat, boolean remolque) {
		this.setModelo(mod);
		this.setMatricula(mat);
		this.setRemolque(remolque);
	}

	// Aqui se incluyen los metodos get y set
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean isRemolque() {
		return remolque;
	}

	public void setRemolque(boolean remolque) {
		this.remolque = remolque;
	}

	// Aqui el metodo toString
	@Override
	public String toString() {
		return "Vehiculo [modelo=" + modelo + ", matricula=" + matricula + ", remolque=" + remolque + "]";
	}

	public static Vehiculo nuevaVehiculo() {
		Vehiculo ret = new Vehiculo();
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduca el modelo:");
		ret.setModelo(sc.nextLine());
		System.out.println("Introduca la matricula:");
		ret.setMatricula(sc.nextLine());
		System.out.println("Introduca si tiene remolque:");
		ret.setRemolque(sc.nextBoolean());

		sc.close();
		return ret;
	}

	// Metodo público data
	public String data() {
		return "" + this.modelo + "|" + this.matricula + "|" + this.remolque;
	}
	// Exportar objetos a un fichero.txt

	private static String fichero = "Vehiculo.txt";

	public static Vehiculo cargaVehiculo() {
		FileInputStream fis = null;
		ObjectInputStream entrada = null;
		Vehiculo obj = null;
		try {
			fis = new FileInputStream(fichero);
			entrada = new ObjectInputStream(fis);
			obj = (Vehiculo) entrada.readObject();
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
			salida.writeObject(modelo);
			salida.writeObject(matricula);
			salida.writeObject(remolque);
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
	private String ruta_archivo = "e:/temporal/Vehiculo.dat";

	public void escribir() {
		try {

			Vehiculo vehiculo = new Vehiculo(modelo, matricula, remolque);
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.ruta_archivo));
			file.writeObject(vehiculo);
			file.close();
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public void leer() {
		try {
			ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.ruta_archivo));
			Vehiculo clase = (Vehiculo) file.readObject();
			file.close();
			System.out.println("El objeto se llama:" + clase.getModelo());
			System.out.println("El objeto se llama:" + clase.getMatricula());
			System.out.println("El objeto se llama:" + clase.getModelo());

		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {
		Vehiculo b = new Vehiculo();
		b.escribir();
	}

	{
		// Importar una coleccion de objetos desde un fichero de binario

		try {
			String nombreFichero = "c:\\Vehiculo.dat";
			FileInputStream ficheroEntrada = new FileInputStream(nombreFichero);
			ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);
			// se leen tres objetos de la clase Vehiculo
			Vehiculo v1 = (Vehiculo) objetoEntrada.readObject();
			Vehiculo v2 = (Vehiculo) objetoEntrada.readObject();
			Vehiculo v3 = (Vehiculo) objetoEntrada.readObject();

			// se cierra el flujo de objetos objetoEntrada
			objetoEntrada.close();
			System.out.println("DNI\t Nombre");
			System.out.println(v1.getModelo());
			System.out.println(v2.getMatricula());
			System.out.println(v3.isRemolque());

		} catch (FileNotFoundException e) {
			System.out.println("¡El fichero no existe!");
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}

	}
}
