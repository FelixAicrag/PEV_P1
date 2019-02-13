package Gen;
import java.lang.Math;

public class GenBool extends Gen<boolean[]> {
	
	int longitud;
	
	@Override
	public boolean[] getInfo() {
		return this.info;
	}
	
	public GenBool(double min, double max, double precision) {
		this.longitud = longitud_gen(min, max, precision);
		this.info = random_gen();
	}
	
	public int longitud_gen(double min, double max, double precision) {
		return (int) Math.ceil(log2(1 + (min - max) / precision ));
	}
	

	public int getLongitud() {
		return this.info.length;
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
