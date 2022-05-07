package entidades;

import java.time.LocalDate;

public class Jornada {

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
	public Jornada() {
	}

	public Jornada(String dniT, char tur) {
		this.setDniTrabajador(dniT);
		this.setTurno(tur);

	}

	public String getDniTrabajador() {
		return dniTrabajador;
	}

	public void setDniTrabajador(String dniTrabajador) {
		this.dniTrabajador = dniTrabajador;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public long getTramo() {
		return tramo;
	}

	public void setTramo(long tramo) {
		this.tramo = tramo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public char getTurno() {
		return turno;
	}

	public void setTurno(char turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "Jornada [dniTrabajador=" + dniTrabajador + ", matricula=" + matricula + ", tramo=" + tramo + ", fecha="
				+ fecha + ", turno=" + turno + "]";
	}

}
