package entidades;

import java.util.ArrayList;
import java.util.Scanner;

public class OCarretera extends Trabajador {

	public ArrayList<Informe> elabora = new ArrayList();
	public Trabajador trabajador;

	
	// Aqu� definimos los constructores

	public OCarretera() {
		super();
	}

	public OCarretera(String dni, String nom, String ape, String dire, String tlf, boolean senior) {
		super(dni, nom, ape, dire, tlf, senior);
	}

	// Aqui el metodo toString
	@Override
	public String toString() {
		return "OCarretera [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", telf=" + telf + ", senior=" + senior + "]";
	}

	public static OCarretera nuevaOCarretera() {
		OCarretera ret = new OCarretera();
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduca el dni del operario de carretera:");
		ret.setDni(sc.nextLine());
		System.out.println("Introduca el nombre del operario de carretera:");
		ret.setNombre(sc.nextLine());
		System.out.println("Introduca los apellidos del operario de carretera:");
		ret.setApellidos(sc.nextLine());
		System.out.println("Introduca la direccion del operario de carretera:");
		ret.setDireccion(sc.nextLine());
		System.out.println("Introduca el telefono del operario de carretera:");
		ret.setTelf(sc.nextLine());
		System.out.println("Introduca si el operario de carretera es senior:");
		ret.setSenior(sc.nextBoolean());

		sc.close();
		return ret;
	}



}


