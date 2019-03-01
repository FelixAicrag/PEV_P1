package cromosoma;

import java.util.Random;

import gen.Gen;

public class CromosomaF1 extends Cromosoma<boolean[]> {
	
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
		for(int i = 0; i < this.numGenes; i++) {
			this.cromosoma[i] = new Gen<boolean[]>(generarGenRandom(longitudes[i]));
		}
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
		boolean[] alelox1 = this.cromosoma[0].getAlelo();
		boolean[] alelox2 = this.cromosoma[1].getAlelo();

		fenotipo[0] = x1_min + bin2dec(alelox1) * (x1_max - x1_min) / (Math.pow(2, longitudes[0]) - 1);
		fenotipo[1] = x2_min + bin2dec(alelox2) * (x2_max - x2_min) / (Math.pow(2, longitudes[1]) - 1);
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



	@Override
	public Gen<boolean[]>[] getCromosoma() {
    	Gen<boolean[]> cromo = new Gen<boolean[]>();
    	for(int i = 0; i < this.numGenes; i++) {
    		cromo[i] = this.cromosoma[i];
    	}
        return cromo;

	}



	@Override
	public void setCromosoma(boolean[] cromosoma) {
		// TODO Auto-generated method stub
		
	}





}
