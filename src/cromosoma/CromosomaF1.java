package cromosoma;

public class CromosomaF1 extends Cromosoma {
	
	double x1_min;
	double x1_max;
	double x2_min;
	double x2_max;
	
	public CromosomaF1(double precision) {
		this.numGenes = 2;
		this.x1_min = -3.0;
		this.x1_max = 12.1;
		this.x2_min = 4.1;
		this.x2_max = 5.8;
		this.precision = precision;
		calcularLongitudes();
		this.cromosoma = new boolean[this.longitudes[0] + this.longitudes[1]];
		generarCromosomaRandom();
		calcularFenotipo();
		
	}

	@Override
	public void calcularLongitudes() {
		this.longitudes[0] = (int) (Math.log(1 + ((x1_max - x1_min) / precision)) / Math.log(2));
		this.longitudes[1] = (int) (Math.log(1 + ((x2_max - x2_min) / precision)) / Math.log(2));	
	}

	@Override
	public void calcularFenotipo() {
		double[] fenotipo = new double[2];
		boolean[] x1 = new boolean[longitudes[0]];
		boolean[] x2 = new boolean[longitudes[1]];
		for(int i = 0; i < longitudes[0]; i++) { x1[i] = this.cromosoma[i]; }
		for(int i = 0; i < longitudes[1]; i++) { x2[i] = this.cromosoma[i + longitudes[0]]; }

		fenotipo[0] = x1_min + bin2dec(x1) * (x1_max - x1_min) / (Math.pow(2, longitudes[0]) - 1);
		fenotipo[1] = x2_min + bin2dec(x2) * (x2_max - x2_min) / (Math.pow(2, longitudes[1]) - 1);
		this.fenotipo = fenotipo;
	}

}
