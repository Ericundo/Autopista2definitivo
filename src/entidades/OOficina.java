package entidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class OOficina extends Trabajador {

	// Aqu� definimos los atributos

	private Collection<Nomina> nominas;
	private Collection<Lote> lotes;
	private Collection<Jornada> jornadas;
	public Trabajador trabajador;


	
	public ArrayList<Jornada> redacta = new ArrayList();
	public ArrayList<Lote> envia = new ArrayList();
	public ArrayList<Nomina> imprime = new ArrayList();
	// Aqu� definimos los constructores

	public OOficina() {
		super();

	}

	public OOficina(String dni, String nom, String ape, String dire, String tlf, boolean senior) {
		super(dni, nom, ape, dire, tlf, senior);
	}
//
	// Aqui se incluyen los metodos get y set

	public Collection<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(Collection<Lote> lotes) {
		this.lotes = lotes;
	}

	public Collection<Nomina> getNominas() {
		return nominas;
	}

	public void setNominas(Collection<Nomina> nominas) {
		this.nominas = nominas;
	}

	public Collection<Jornada> getJornadas() {
		return jornadas;
	}

	public void setJornadas(Collection<Jornada> jornadas) {
		this.jornadas = jornadas;
	}

	// Aqui el metodo toString
	@Override
	public String toString() {
		return "OOficina [nominas=" + nominas + ", lotes=" + lotes + ", jornadas=" + jornadas + "]";
	}

	public static OOficina nuevaOOficina() {
		OOficina ret = new OOficina();
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduca el dni del operario de oficina:");
		ret.setDni(sc.nextLine());
		System.out.println("Introduca el nombre del operario de oficina:");
		ret.setNombre(sc.nextLine());
		System.out.println("Introduca los apellidos del operario de oficina:");
		ret.setApellidos(sc.nextLine());
		System.out.println("Introduca la direccion del operario de oficina:");
		ret.setDireccion(sc.nextLine());
		System.out.println("Introduca el telefono del operario de oficina:");
		ret.setTelf(sc.nextLine());
		System.out.println("Introduca si el operario de oficina es senior:");
		ret.setSenior(sc.nextBoolean());

		sc.close();
		return ret;
	}
	 
	
	
	
}
