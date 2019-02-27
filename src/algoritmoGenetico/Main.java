package algoritmoGenetico;

import Utils.Rango;
import cromosoma.CromosomaF1;
import gen.GenBinario;

public class Main {

	public static void main(String[] args) {
		
		int tPob = 100, nGeneracs = 50, nGenes = 2, func = 1;
		double pCruce = 0.6, pMutacion = 0.05, prec = 0.001;
		boolean elitismo = false;
		//Creamos la población inicial aleatoria y la evaluamos
		//(depende del problema genera cromosomas de determinado tipo).
		AlgoritmoGenetico AG = new AlgoritmoGenetico(func, nGeneracs, nGenes, tPob, pCruce, pMutacion, prec, elitismo);
		AG.inicializaPoblacion();
		AG.evaluaPoblacion();
		int generacion_actual = 0;
		while(!AG.terminado(generacion_actual)) {
			generacion_actual++;
			
			AG.seleccionaPoblacion();
			AG.reproducePoblacion();
			AG.mutaPoblacion();
			
			AG.evaluaPoblacion();
		}
	}
}
