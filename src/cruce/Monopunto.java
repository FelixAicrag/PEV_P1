package cruce;
import cromosoma.Cromosoma;

public class Monopunto {
	double probCruce;
	int tamPoblacion;
	Cromosoma[] poblacion;
	
	public Monopunto(double probCruce, int tamPoblacion, Cromosoma[] pob) {
		this.probCruce = probCruce;
		this.tamPoblacion = tamPoblacion;
		this.poblacion = pob;
	}
	
	public void cruzar() {
		
		boolean[] progenitores = new boolean[this.tamPoblacion];
		Cromosoma soltero = null;
		//seleccionamos los cromosomas a cruzar.
		for(int i = 0; i < this.tamPoblacion; i++) {
			double aleatorio = Math.random();
			if(aleatorio < this.probCruce) { progenitores[i] = true;}
			else progenitores[i] = false;
		}
		
		//de los seleccionados, va haciendo parejas y las cruza.
		for(int i = 0; i < this.tamPoblacion; i++) {
			if(progenitores[i]) {
				if(soltero != null) {
					cruzarGenesMonopunto(soltero, this.poblacion[i]);
					soltero = null;
				}
				else soltero =  this.poblacion[i];
			}
		}
	}

	/**
	 * Cruza dos genes por un punto.
	 */
	private void cruzarGenesMonopunto(Cromosoma padre, Cromosoma madre) {
		//obtenemos el punto de cruce
		int longCromosoma = this.poblacion[0].getLongitudCrom();
		int puntoCruce = (int) (Math.random() * longCromosoma) + 1;
		
		boolean[] infoPadre = padre.getCromosoma();
		boolean[] infoMadre = madre.getCromosoma();
		boolean aux;
		for(int i = puntoCruce; i < longCromosoma; i++) {
			
			aux = infoPadre[i];
			infoPadre[i] = infoMadre[i];
			infoMadre[i] = aux;
			
		}
		padre.setCromosoma(infoPadre);
		madre.setCromosoma(infoMadre);
		
	}
}
