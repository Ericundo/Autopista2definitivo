package entidades;

public class Informe {
	
		private String descripcion;// descripci�n sirve para describir los datos que aparecen en el informe es un
		// dato de tipo string que puede recibir un valor cualquiera
	private int annoInforme;// annoInforme sirve para referirse al a�o en el que se escribi� el informe
	// es un dato de tipo int con un valor de 4 digitos y un valor invalido de <2000
	private long remitente;// idRemitente sirve para referirse a quien envia el informe es una clase de
	// tipo long con valor mayor o igual que 0 que no se puede repetir y con valor
	// por defecto null
	private long destinatario;// destinatario sirve para referirse a la persona que recibe el informe es una
		// clase de tipo long con valor mayor o igual que 0 que no se puede repetir y
		// con valor por defecto null
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getAnnoInforme() {
		return annoInforme;
	}
	public void setAnnoInforme(int annoInforme) {
		this.annoInforme = annoInforme;
	}
	public long getRemitente() {
		return remitente;
	}
	public void setRemitente(long remitente) {
		this.remitente = remitente;
	}
	public long getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(long destinatario) {
		this.destinatario = destinatario;
	}
	public Informe() {
	}

	public Informe(String desc, int anno, long remi, long dest) {
		this.setDescripcion(desc);
		this.setAnnoInforme(anno);
		this.setRemitente(remi);
		this.setDestinatario(dest);
	}
	@Override
	public String toString() {
		return "Informe [descripcion=" + descripcion + ", annoInforme=" + annoInforme + ", remitente=" + remitente
				+ ", destinatario=" + destinatario + "]";
	}
	public String data() {
		return "" + this.descripcion + "|" + this.annoInforme + "|" + this.remitente + "|" + this.destinatario;
	}

	}


