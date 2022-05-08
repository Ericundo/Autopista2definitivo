package entidades;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class Trabajador {

	private static final Object Trabajador = null;
	// Aqu� definimos los atributos
	protected String dni; // dni es el DNI del trabajador es un String que acepta 8 numeros + letra, no se
							// puede repetir y su valor por defecto es #null
	protected String nombre; // nombre es el nombre del trabajador, es un String que acepta cualquier valor,
								// menos caracteres que no sean valores alfanumericos
	protected String apellidos; // apellidos son los apellidos del trabajador, es un String que acepta cualquier
								// valor, menos caracteres que no sean valores alfanumericos
	protected String direccion; // direccion es la direcci�n del trabajador es un String que acepta cualquier
								// valor
	protected String telf; // telf es el telefono del trabajador es un String que acepta cualquier valor
							// numerico
	protected boolean senior; // senior indica si el trabajor es senior o no mediante un boolean, valor por
								// defecto false
	
	
	public ArrayList<Nomina> confirmar = new ArrayList();

	// Aqu� definimos los constructores
	public Trabajador() {
	}

	public Trabajador(String dni, String nom, String ape, String dire, String tlf, boolean senior) {
		this.setDni(dni);
		this.setNombre(nom);
		this.setApellidos(ape);
		this.setDireccion(dire);
		this.setTelf(tlf);
		this.setSenior(senior);
	}

	// Aqui se incluyen los metodos get y set
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelf() {
		return telf;
	}

	public void setTelf(String telf) {
		this.telf = telf;
	}

	public boolean isSenior() {
		return senior;
	}

	public void setSenior(boolean senior) {
		this.senior = senior;
	}

	// Aqui el metodo toString
	@Override
	public String toString() {
		return "Trabajador [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", telf=" + telf + ", senior=" + senior + "]";
	}

	// Metodo p�blico data
	public String data() {
		return "" + "|" + this.dni + "|" + this.nombre + "|" + this.apellidos + "|" + this.direccion + "|" + this.telf
				+ "|" + this.senior;
	}

	// Exportar objetos a fichero txt
	private static String fichero = "Trabajador.txt";

	public static Trabajador cargaTrabajador() {
		FileInputStream fis = null;
		ObjectInputStream entrada = null;
		Trabajador obj = null;
		try {
			fis = new FileInputStream(fichero);
			entrada = new ObjectInputStream(fis);
			obj = (Trabajador) entrada.readObject();
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
			salida.writeObject(dni);
			salida.writeObject(nombre);
			salida.writeObject(apellidos);
			salida.writeObject(direccion);
			salida.writeObject(telf);
			salida.writeObject(senior);

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
	private String ruta_archivo = "e:/temporal/Trabajador.dat";

	public void escribir() {
		try {

			Trabajador trabajador = new Trabajador(dni, nombre, apellidos, direccion, telf, senior);
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(this.ruta_archivo));
			file.writeObject(trabajador);
			file.close();
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public void leer() {
		try {
			ObjectInputStream file = new ObjectInputStream(new FileInputStream(this.ruta_archivo));
			Trabajador clase = (Trabajador) file.readObject();
			file.close();
			System.out.println("El objeto se llama:" + clase.getDni());
			System.out.println("El objeto se llama:" + clase.getNombre());
			System.out.println("El objeto se llama:" + clase.getApellidos());
			System.out.println("El objeto se llama:" + clase.getDireccion());
			System.out.println("El objeto se llama:" + clase.getTelf());
			System.out.println("El objeto se llama:" + clase.isSenior());

		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {
		Trabajador b = new Trabajador();
		b.escribir();
	}
	
//prueba
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
