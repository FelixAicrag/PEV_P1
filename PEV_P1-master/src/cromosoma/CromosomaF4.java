package cromosoma;

public class CromosomaF4 extends Cromosoma{

	private double min;
	private double max;

	public CromosomaF4(double precision, int numparams) {
		this.numGenes = numparams;
		this.min = 0.0;
		this.max = Math.PI;
		this.precision = precision;
		calcularLongitudes();
		int sumaLongs = 0;
		for (int i = 0; i < numparams; i++) {
			sumaLongs += this.longitudes[1];
		}
		this.cromosoma = new boolean[sumaLongs];
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
