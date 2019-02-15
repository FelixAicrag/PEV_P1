package Cromosoma;

import java.lang.Math;

import Gen.GenBinario;
import Utils.Rango;

public class CromosomaF1 extends Cromosoma{

	Rango rango_x1;
	Rango rango_x2;
	GenBinario[] genes = new GenBinario[2];

	static double precision = 0.001;
	
	public CromosomaF1(Rango rango_x1, Rango rango_x2) {
		this.rango_x1 = rango_x1;
		this.rango_x2 = rango_x2;
		genes[0] = new GenBinario(rango_x1, precision);
		genes[1] = new GenBinario(rango_x2, precision);
	}
	
	@Override
	public double[] fenotipo() {
		double[] fen = new double[2];
		
		fen[0] = rango_x1.getMin() + bin2float(genes[0].getInfo()) * (rango_x1.getMax() - rango_x1.getMin()) / (Math.pow(2, genes[0].getLongitud()) - 1);
		fen[1] = rango_x2.getMin() + bin2float(genes[1].getInfo()) * (rango_x2.getMax() - rango_x2.getMin()) / (Math.pow(2, genes[1].getLongitud()) - 1);
		return fen;
	}
	
	public void  mostrarGen() {
		int[] miGen = this.genes[0].getInfo();
		double[] feno = this.fenotipo();
		String gen = "";
		for(int i = 0; i < miGen.length; i++) 
			gen += miGen[i];
		
		
		System.out.println("Genotipo: " + gen);
		System.out.println("Fenotipo: " + feno[0]);
		
	}

	public double fitness() {
		double[] fen = this.fenotipo();
		return 21.5 + fen[0]*(Math.sin(4*Math.PI*fen[0])) + 
				fen[1]*(Math.sin(20*Math.PI*fen[1]));
	}

	@Override
	public void puntuacion() {
	
	}

	@Override
	public void puntuacion_acu() {
	
	}
	
	@Override
	public void longitud() {
		this.longitud = genes[0].getLongitud() + genes[1].getLongitud();
	}
	
	private double bin2float(int[] gen) {
		String geno = "";
		for(int i = 0; i < gen.length; i++) 
			geno += gen[i];
		
		int intBits = Integer.parseInt(geno, 2);
		float myFloat = Float.intBitsToFloat(intBits);
		return myFloat;
		//Integer.toBinaryString(i)
	}
}
