package cruce;

import cromosoma.Cromosoma;

public class Bipunto {
	double probCruce;
	int tamPoblacion;
	Cromosoma[] poblacion;
	
	public Bipunto(double probCruce, int tamPoblacion, Cromosoma[] pob) {
		this.probCruce = probCruce;
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
					cruzarGenesBipunto(soltero, this.poblacion[i]);
					soltero = null;
				}
				else soltero =  this.poblacion[i];
			}
		}		
	}
		
		
		/**
		 * Cruza dos genes por 2 puntos
		 */
		private void cruzarGenesBipunto(Cromosoma padre, Cromosoma madre) {
			int longCromosoma = this.poblacion[0].getLongitudCrom();
			//obtenemos los puntos de cruce
			int puntoCruce1 = (int) (Math.random() * longCromosoma) + 1;
			int puntoCruce2 = (int) (Math.random() * longCromosoma) + 1;
			
			boolean[] infoPadre = padre.getCromosoma();
			boolean[] infoMadre = madre.getCromosoma();
			boolean aux;
			
			//intercambiamos valores si el valor de puntoCruce1 es mayor
			if(puntoCruce1 > puntoCruce2) {
				int aux1 = puntoCruce1;
				puntoCruce1 = puntoCruce2;
				puntoCruce2 = aux1;
			}
			
			for(int i = puntoCruce1; i < puntoCruce2; i++) {
				aux = infoPadre[i];
				infoPadre[i] = infoMadre[i];
				infoMadre[i] = aux;
				
			}
			padre.setCromosoma(infoPadre);
			madre.setCromosoma(infoMadre);
		}
	}
	
	
	

