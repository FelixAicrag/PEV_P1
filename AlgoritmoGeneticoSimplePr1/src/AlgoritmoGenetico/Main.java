package AlgoritmoGenetico;

import Cromosoma.CromosomaF1;
import Gen.GenBinario;
import Utils.Rango;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rango rango_x1 = new Rango(-3.0, 12.1);
		Rango rango_x2 = new Rango(4.1, 5.8);
		
		CromosomaF1 gen = new CromosomaF1(rango_x1, rango_x2);
		
		gen.mostrarGen();
	}

}
