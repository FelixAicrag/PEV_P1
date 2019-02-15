package Gen;
import java.lang.Math;

import Utils.Rango;

public class GenBinario extends Gen<int[]> {
	
	private int longitud;
	
	public GenBinario(Rango rango_x, double precision) {
		this.longitud = longitud_gen(rango_x, precision);
		this.info = random_gen();
	}
	
	@Override
	public int[] getInfo() {
		return this.info;
	}
	
	@Override
	public int getLongitud() {
		return this.longitud;
	}
	

	private int longitud_gen(Rango rango_x, double precision) {
		return (int) Math.ceil(log2(1 + (rango_x.getMax() - rango_x.getMin()) / precision ));
	}
	
	public double log2(double d) {
		   return Math.log(d)/Math.log(2.0);
		}


	private int[] random_gen() {
		int[] gen = new int[this.longitud];
		for(int i = 0; i < longitud; i++) {
			if (Math.random() >= 0.5) gen[i] = 1;
			else gen[i] = 0;
		}
		
		return gen;
	}
}
