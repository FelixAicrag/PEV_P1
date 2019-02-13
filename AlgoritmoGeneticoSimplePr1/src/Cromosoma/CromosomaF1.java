package Cromosoma;

import java.lang.Math;

import Gen.GenBool;

public class CromosomaF1 extends Cromosoma{

	GenBool[] cromosoma = new GenBool[2];
	static double x1_min = -3.0;
	static double x1_max = 12.1;
	static double x2_min = 4.1;
	static double x2_max = 5.8;
	static double precision = 0.001;
	private boolean validez;
	
	public CromosomaF1() {
		cromosoma[0] = new GenBool(x1_min, x1_max, precision);
		cromosoma[1] = new GenBool(x2_min, x2_max, precision);
		
		
	}
	
	@Override
	public void fenotipo() {
		//fenotipo de x1 y x2
		
		
	}

	@Override
	public void evalua() {
	
	}

	@Override
	public void puntuacion() {
	
	}

	@Override
	public void puntuacion_acu() {
	
	}

	//hace falta saber la long de x1 y x2 por separado????
	@Override
	public void longitud() {

		this.longitud = longitud_gen(x1_min, x1_max) + longitud_gen(x2_min, x2_max);
		
	}

	@Override
	public void fenotipo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void genera() {
		// TODO Auto-generated method stub
		
	}

}
