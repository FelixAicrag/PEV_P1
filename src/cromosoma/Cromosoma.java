package cromosoma;

import java.util.Random;

public abstract class Cromosoma implements Comparable<Cromosoma>{
	
	boolean[] cromosoma; 
    int[] longitudes; //array de longitudes de cada gen del cromosoma
    double[] fenotipo;
    double fitness;
    double puntuacion;
    double punt_Acumulada;
    int numGenes;
    double precision;
	

    public Cromosoma() {
    	this.longitudes = new int[7];
    	this.fitness = 0.0;
    	this.puntuacion = 0.0;
    	this.punt_Acumulada = 0.0;
    }
    
    public Cromosoma(boolean[] cromosoma, double[] fenotipo,int[] longitudes) {
    	this.cromosoma = cromosoma;
    	this.fenotipo = fenotipo;
    	this.longitudes = longitudes;
    	this.fitness = 0.0;
    	this.puntuacion = 0.0;
    	this.punt_Acumulada = 0.0;
    }
    
    
    
    
    public boolean[] getCromosoma() {
        return this.cromosoma;
    }
     
    public void setCromosoma(boolean[] cromosoma) {
        this.cromosoma = cromosoma;
    }

    public double[] getFenotipo() {
        return this.fenotipo;
    }
    
    public void setFenotipo(double[] fenotipo) {
    	this.fenotipo = fenotipo;
    }
    
    public double getFitness() {
        return this.fitness;
    }
    
    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getPuntuacion() {
        return this.puntuacion;
    }
    
    public void setPuntuacion(double puntuacion) {
    	this.puntuacion = puntuacion;
    }
    
    public double getPuntAcumulada() {
        return this.punt_Acumulada;
    }
    
    public void setPuntAcumulada(double punt_Acumulada) {
        this.punt_Acumulada = punt_Acumulada;
    }
    
    public int[] getLongitudes() {
        return this.longitudes;
    }
    
    public void setLongitudes(int[] longitudes) {
    	this.longitudes = longitudes;
    }
    
    public int getNumGenes() {
        return this.numGenes;
    }
    
    public void setNumGenes(int numGenes) {
    	this.numGenes = numGenes;
    }

    public double getTolerancia() {
    	return this.precision;
    }
    
    public void setTolerancia(double precision) {
    	this.precision = precision;
    }

    public void generarCromosomaRandom() {
        Random rand = new Random();
        int cont = 0;
        for (int i = 0; i < this.numGenes; i++) {
            for (int j = 0; j < this.longitudes[i]; j++) {
                cromosoma[cont] = rand.nextBoolean();
                cont++;
            }
        }
    }

    public double bin2dec(boolean[] genotipo) {
        double total = 0;
        int j = 0;
        int bool;
        for (int i = genotipo.length - 1; i >= 0; i--) {
            if (genotipo[i]) 
                bool = 1;
            else 
                bool = 0;
            total += bool * Math.pow(2, j);
            j++;
        }
        return total;
    }
    
    //creo que esta mal   ?????????
	public double bin2float(boolean[] genotipo) {
		String geno = "";
		for(int i = 0; i < genotipo.length; i++) 
			geno += genotipo[i];
		
		int intBits = Integer.parseInt(geno, 2);
		float myFloat = Float.intBitsToFloat(intBits);
		return myFloat;
		//Integer.toBinaryString(i)
	}

    public void mutar(double probabilidad) { 
        double valor;

        for (int i = 0; i < this.cromosoma.length; i++) {
            valor = Math.random();
            if (valor <= probabilidad) {
                if (cromosoma[i]) 
                    cromosoma[i] = false;
                else 
                    cromosoma[i] = true;
            }
        }
    }

    public int compareTo(Cromosoma cromosoma) {
    	return (int) (this.getFitness() - cromosoma.getFitness());
    }

    public abstract void calcularLongitudes();
    public abstract void calcularFenotipo();

}

