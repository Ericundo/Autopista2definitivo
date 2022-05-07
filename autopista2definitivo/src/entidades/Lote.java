package entidades;

public class Lote {
	
	private int numLote;// sirve para informar de la cantidad de lote un lote es un dato de tipo int con
	// valor mayor o igual que uno de valor inv�lido menor que uno que no se puede
	// repetir y con valor por defecto null

	public int getNumLote() {
		return numLote;
	}

	public void setNumLote(int numLote) {
		this.numLote = numLote;
	}
	public Lote() {
	}

	public Lote(int nLote) {
		this.setNumLote(nLote);
	}

	@Override
	public String toString() {
		return "Lote [numLote=" + numLote + "]";
	}
	public String data() {
		return "" + "|" + this.numLote;
	}

}
