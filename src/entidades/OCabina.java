package entidades;

import java.util.Collection;
import java.util.Scanner;

public class OCabina extends Trabajador {

	// Aqu� definimos los atributos

	private Collection<Problema> problema;
	public Trabajador trabajador;

	//
	// Aqu� definimos los constructores

	public OCabina() {
		super();
	}

	public OCabina(String dni, String nom, String ape, String dire, String tlf, boolean senior) {
		super(dni, nom, ape, dire, tlf, senior);
	}

	// Aqui se incluyen los metodos get y set

	public Collection<Problema> getProblema() {
		return problema;
	}

	public void setProblema(Collection<Problema> problema) {
		this.problema = problema;
	}

	// Aqui el metodo toString
	@Override
	public String toString() {
		return "OCabina [problema=" + problema + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", telf=" + telf + ", senior=" + senior + "]";
	}

	public static OCabina nuevaOCabina() {
		OCabina ret = new OCabina();
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduca el dni del operario de cabina:");
		ret.setDni(sc.nextLine());
		System.out.println("Introduca el nombre del operario de cabina:");
		ret.setNombre(sc.nextLine());
		System.out.println("Introduca los apellidos del operario de cabina:");
		ret.setApellidos(sc.nextLine());
		System.out.println("Introduca la direccion del operario de cabina:");
		ret.setDireccion(sc.nextLine());
		System.out.println("Introduca el telefono del operario de cabina:");
		ret.setTelf(sc.nextLine());
		System.out.println("Introduca si el operario de cabina es senior:");
		ret.setSenior(sc.nextBoolean());

		sc.close();
		return ret;
	}

	
}
