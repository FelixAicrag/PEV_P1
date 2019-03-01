package gen;

public class Gen<T> {
	private T alelo;
	
	public Gen() {
		this.alelo = null;
	}
	
	public Gen(T alelo) {
		this.setAlelo(alelo);
	}

	public T getAlelo() {
		return alelo;
	}

	public void setAlelo(T alelo) {
		this.alelo = alelo;
	}
	
	
}
