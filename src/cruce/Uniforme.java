package cruce;

import cromosoma.Cromosoma;

public class Uniforme {
	double probCruce, probUnif;
	int tamPoblacion;
	Cromosoma[] poblacion;
	
	public Uniforme(double probCruce, double probUnif, int tamPoblacion, Cromosoma[] pob) {
		this.probCruce = probCruce;
		this.probUnif = probUnif;
		this.tamPoblacion = tamPoblacion;
		this.poblacion = pob;
	}
	
	public void cruzar() {
		
		boolean[] progenitores = new boolean[this.tamPoblacion];
		Cromosoma soltero = null;
		//seleccionamos las cromosomas a cruzar
		for(int i = 0; i < this.tamPoblacion; i++) {
			double aleatorio = Math.random();
			if(aleatorio < this.probCruce) { progenitores[i] = true;}
			else progenitores[i] = false;
		}
		
		
		//de los seleccionados, va haciendo parejas y las cruza.
		for(int i = 0; i < this.tamPoblacion; i++) {
			if(progenitores[i]) {
				if(soltero != null) {
					cruzarGenesUnif(soltero, this.poblacion[i]);
					soltero = null;
				}
				else soltero =  this.poblacion[i];
			}
		}		
	}
	
	
	/**
	 * Cruza dos genes por 2 puntos
	 */
	private void cruzarGenesUnif(Cromosoma padre, Cromosoma madre) {
		int longCromosoma = this.poblacion[0].getLongitudCrom();
	
		boolean[] infoPadre = padre.getCromosoma();
		boolean[] infoMadre = madre.getCromosoma();
		boolean aux;
		
		
		
		for(int i = 0; i < longCromosoma; i++) {
			double ale = Math.random();
			if(ale < this.probUnif) {
				aux = infoPadre[i];
				infoPadre[i] = infoMadre[i];
				infoMadre[i] = aux;
			}
			
		}
		padre.setCromosoma(infoPadre);
		madre.setCromosoma(infoMadre);
	}
}
