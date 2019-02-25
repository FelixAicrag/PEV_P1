package algoritmoGenetico;

import Utils.Rango;
import cromosoma.CromosomaF1;
import gen.GenBinario;

public class Main {

	public static void main(String[] args) {
		
		CromosomaF1 cromo = new CromosomaF1(0.001);
		
		double[] feno = cromo.getFenotipo();
		
		System.out.println(feno[0]);
		System.out.println(feno[1]);
	}

}
