package Cromosoma;

public abstract class Cromosoma {
	
	boolean[] genes;
	double fenotipo;
	double fitness;
	double puntuacion;
	double puntuacion_acu;
	int longitud;
	
	public abstract void fenotipo();
	public abstract void fitness();
	public abstract void puntuacion();
	public abstract void puntuacion_acu();
	public abstract void longitud();
	
}
