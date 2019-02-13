package Cromosoma;

import java.lang.Math;

import Gen.GenBool;

public class CromosomaF1 extends Cromosoma{

	GenBool[] cromosoma = new GenBool[2];

	static double precision = 0.001;
	
	public CromosomaF1(double[] rango_x1, double[] rango_x2) {
		cromosoma[0] = new GenBool(rango_x1, precision);
		cromosoma[1] = new GenBool(rango_x2, precision);
	}
	
	@Override
	public double[] fenotipo() {
		return null;
	}

	public void evalua() {
	
	}

	@Override
	public void puntuacion() {
	
	}

	@Override
	public void puntuacion_acu() {
	
	}
	
	@Override
	public void longitud() {
		this.longitud = cromosoma[0].getLongitud() + cromosoma[1].getLongitud();
	}
}
