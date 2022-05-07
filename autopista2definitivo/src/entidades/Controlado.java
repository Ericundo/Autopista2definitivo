package entidades;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import utils.Utilidades;
import validaciones.Validaciones;

public class Controlado extends Tramo {

	// Atributos:
	private int numPaneles;// numPaneles es el numero de paneles que hay en el tramo es un tipo de dato int
							// mayor o igual que 0 y con un valor por defecto de 0
	public Tramo tramo;
	public Peaje peaje;

	void ensamblar(Peaje peaj) {
		peaje = peaj;
	}

	
	
	// Constructores:

	// Por Defecto:
	
	public Controlado() {
	}

	// Constructores con parámetros:
	
	public Controlado(long idTramo, int kmInicio, int kmFin, int numPaneles) {
		super(idTramo, kmInicio, kmFin);
		this.numPaneles = numPaneles;
	}
	
	public Controlado(long idTramo, int kmInicio, int kmFin, int numPaneles, Tramo t, Peaje p) {
		super(idTramo, kmInicio, kmFin);
		this.numPaneles = numPaneles;
		this.peaje = p;
		this.tramo = t;
	}
	
	public Controlado(int numPaneles, Tramo t, Peaje p) {
		super();
		this.numPaneles = numPaneles;
		this.peaje = p;
		this.tramo = t;
	}
	
	public Controlado(long idTramo, int kmInicio, int kmFin, Tramo t, Peaje p) {
		super(idTramo, kmInicio, kmFin);
		this.peaje = p;
		this.tramo = t;
	}



	// Constructor copia:
	public Controlado(Controlado objControlado) {

		this.numPaneles = objControlado.numPaneles;
		this.tramo = objControlado.tramo;
		this.peaje = objControlado.peaje;
	}
	// Metodos get y set:

	public int getNumPaneles() {
		return numPaneles;
	}

	public void setNumPaneles(int numPaneles) {
		this.numPaneles = numPaneles;
	}
	
	public Tramo getTramo() {
		return tramo;
	}

	public void setTramo(Tramo tramo) {
		this.tramo = tramo;
	}

	public Peaje getPeaje() {
		return peaje;
	}

	public void setPeaje(Peaje peaje) {
		this.peaje = peaje;
	}


	// Metodo toString:

	@Override
	public String toString() {
		return "Controlado [numPaneles=" + numPaneles + ", tramo=" + tramo + ", peaje=" + peaje + "]";
	}
	
	// Metodo Data:

	public String data() {
		return "" + tramo.getIdTramo() + "|" + tramo.getKmInicio() + "|" + tramo.getkmFin() + "|"
				+ this.numPaneles;
	}
	
	// Metodo nuevoControlado:
	
	public static Controlado nuevoControlado() {
		Controlado ret = null;
		int numPaneles = 1;
		Tramo t = null;
		Peaje p = null;
		Scanner in;
		boolean valido = false;
		do {
			System.out.println("Introduzca la cantidad de Paneles del Tramo:");
			in = new Scanner(System.in);
			numPaneles = in.nextInt();
			if (numPaneles >= 0)
				valido = true;
			else
				System.out.println("No puede haber menos de 0 paneles.");
		} while (!valido);

		valido = false;
		
		System.out.println("Introduzca ahora los datos del Tramo:");
		in = new Scanner(System.in);
		t = Tramo.nuevoTramo();
		
		System.out.println("Introduzca ahora los datos del Peaje:");
		in = new Scanner(System.in);
		p = Peaje.nuevoPeaje();

		ret = new Controlado(numPaneles, t, p);
		return ret;
	}
	
	}
   
