package mutacion;


public class Mutacion {
	
	boolean[] cromosoma;
	double probMutacion;
	
	public Mutacion(double probMutacion) {
		this.probMutacion = probMutacion;
	}
	
    public void mutar() { 
       
        for (int i = 0; i < this.cromosoma.length; i++) {
            double valor = Math.random();
            if (valor <= this.probMutacion) {
                if (this.cromosoma[i]) 
                    this.cromosoma[i] = false;
                else 
                    this.cromosoma[i] = true;
            }
        }
    }
}
