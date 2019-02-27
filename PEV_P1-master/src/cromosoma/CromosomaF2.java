package cromosoma;

public class CromosomaF2 extends Cromosoma {

	double min;
    double max;

    public CromosomaF2(double precision) {
        this.min = -512.0;
        this.max = 512.0;
        super.numGenes = 2;
        this.precision = precision;
        calcularLongitudes();
        this.cromosoma = new boolean[this.longitudes[0]*2];
		generarCromosomaRandom();
		calcularFenotipo();
    }
	
	
	@Override
	public void calcularLongitudes() {
		this.longitudes[0] = (int) (Math.log(1 + ((max - min) / precision)) / Math.log(2));
		this.longitudes[1] = (int) (Math.log(1 + ((max - min) / precision)) / Math.log(2));
	}

	@Override
	public void calcularFenotipo() {
				
	}

}
