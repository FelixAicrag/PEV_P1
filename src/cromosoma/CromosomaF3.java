package cromosoma;

import java.util.Random;

import gen.Gen;

public class CromosomaF3 extends Cromosoma<boolean[]> {
	double min;
	double max;
	
	public CromosomaF3(double precision) {
		this.numGenes = 2;
		this.min = -10.0;
		this.max = 10.8;
		this.precision = precision;
		calcularLongitudes();
		for(int i = 0; i < this.numGenes; i++) {
			this.cromosoma[i] = new Gen<boolean[]>(generarGenRandom(longitudes[i]));
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
		double[] fenotipo = new double[2];
		boolean[] alelox1 = this.cromosoma[0].getAlelo();
		boolean[] alelox2 = this.cromosoma[1].getAlelo();

		fenotipo[0] = min + bin2dec(alelox1) * (max - min) / (Math.pow(2, longitudes[0]) - 1);
		fenotipo[1] = min + bin2dec(alelox2) * (max - min) / (Math.pow(2, longitudes[1]) - 1);
		this.fenotipo = fenotipo;
	}

	@Override
	public boolean[] generarGenRandom(int longitud) {
	        Random rand = new Random();
	        boolean[] alelo = new boolean[longitud];
	        for(int i = 0; i < longitud; i++) {
	        	alelo[i] = rand.nextBoolean();
	        }
	        
	        return alelo;
	}
}
