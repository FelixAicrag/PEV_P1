package Cromosoma;

public abstract class Cromosoma {
	
	boolean[] genes;
	double fenotipo;
	double fitness;
	double puntuacion;
	double puntuacion_acu;
	int longitud;
	
	public abstract double[] fenotipo();
	public abstract void puntuacion();
	public abstract void puntuacion_acu();
	public abstract void longitud();
	
}
