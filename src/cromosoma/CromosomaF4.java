package cromosoma;

import gen.Gen;

public class CromosomaF4 extends Cromosoma<Double> {

	private double min;
	private double max;

	public CromosomaF4(double precision, int numparams) {
		this.numGenes = numparams;
		this.min = 0.0;
		this.max = Math.PI;
		this.precision = precision;
		calcularLongitudes();
		
		for(int i = 0; i < this.numGenes; i++) {
			this.cromosoma[i] = new Gen<Double>(generarGenRandom(longitudes[i]));
		}
		calcularFenotipo();
		
	}
	
	@Override
	public void calcularLongitudes() {
		for(int i = 0; i < numGenes; i++) {
			this.longitudes[i] = (int) (Math.log(1 + ((max - min) / precision)) / Math.log(2));
		}
		
	}

	@Override
	public void calcularFenotipo() {
		double[] fenotipo = new double[numGenes];
		boolean[][] x = new boolean[numGenes][longitudes[0]];
		
		for(int i = 0; i < longitudes[0]; i++) { 
			for(int j = 0; j < numGenes; j++) { 
				x[j][i] = this.cromosoma[i + j*longitudes[0]].; 
				} 
			}
		
		
		for(int i = 0; i < numGenes; i++) {
			fenotipo[i] = min + bin2dec(x[i]) * (max - min) / (Math.pow(2, longitudes[0]) - 1);
		}

		this.fenotipo = fenotipo;	
	}

	@Override
	public Double generarGenRandom(int longitud) {
		// TODO Auto-generated method stub
		return null;
	}

}
