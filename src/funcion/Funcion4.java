package funcion;

import cromosoma.Cromosoma;

public class Funcion4 {
	
	public static double evalua(Cromosoma cromosoma) {
		double suma = 0.0;
		
		for(int i = 0 ; i < cromosoma.getNumGenes(); i++) {
			suma += Math.sin(cromosoma.getFenotipo()[i]) * Math.pow(Math.sin((i + 2) * Math.pow(cromosoma.getFenotipo()[i], 2)/Math.PI), 20);
		}
		return -suma;
	}
}
