package Gen;
import java.lang.Math;

public class GenBool extends Gen<boolean[]> {
	
	private int longitud;
	
	@Override
	public boolean[] getInfo() {
		return this.info;
	}
	
	@Override
	public int getLongitud() {
		return this.longitud;
	}
	
	public GenBool(double[] rango_x, double precision) {
		this.longitud = longitud_gen(rango_x, precision);
		this.info = random_gen();
	}
	
	private int longitud_gen(double[] rango_x, double precision) {
		return (int) Math.ceil(log2(1 + (rango_x[0] - rango_x[1]) / precision ));
	}
	
	public double log2(double d) {
		   return Math.log(d)/Math.log(2.0);
		}


	private boolean[] random_gen() {
		boolean[] gen = new boolean[this.longitud];
		for(int i = 0; i < longitud; i++) {
			if (Math.random() >= 0.5) gen[i] = true;
			else gen[i] = false;
		}
		
		return gen;
	}

}
