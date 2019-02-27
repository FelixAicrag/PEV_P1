package cromosoma;

public class CromosomaF3 extends Cromosoma {
	double min;
	double max;
	
	public CromosomaF3(double precision) {
		this.numGenes = 2;
		this.min = -10.0;
		this.max = 10.8;
		this.precision = precision;
		calcularLongitudes();
		this.cromosoma = new boolean[this.longitudes[0] + this.longitudes[1]];
		generarCromosomaRandom();
		calcularFenotipo();
		
	}

	@Override
	public void calcularLongitudes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calcularFenotipo() {
		// TODO Auto-generated method stub
		
	}
}
