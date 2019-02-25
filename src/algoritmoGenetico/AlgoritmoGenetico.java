package algoritmoGenetico;

import cromosoma.Cromosoma;
import cromosoma.CromosomaF1;
import cromosoma.CromosomaF2;
import cromosoma.CromosomaF3;
import cromosoma.CromosomaF4;

public class AlgoritmoGenetico {
	
	Cromosoma[] poblacion;
	int tamPoblacion, numGeneraciones, funcion, numGenes;
	double probabilidadCruce, probabilidadMutacion, precision;
    boolean elitismo;
   
	double mediaGeneracion;
	double mejorGeneracion;
	int pos_mejorGeneracion;
	
	public AlgoritmoGenetico(int tPob, int nGeneracs, double pCruce, double pMutacion, 
							 double prec, int nGenes, boolean elit, int func) {
		this.elitismo = elit;
		this.numGeneraciones = nGeneracs;
		this.tamPoblacion = tPob;
		this.probabilidadCruce = pCruce;
		this.probabilidadMutacion = pMutacion;
		this.funcion = func;
		this.precision = prec;
		this.numGenes = nGenes;
		
		switch (funcion) {
		case 1:
			inicializaPoblacionF1(); 
			break;
			
		case 2:
			inicializaPoblacionF2(); break;
		case 3:
			inicializaPoblacionF3(); break;
		case 4:
			inicializaPoblacionF4(); break;
		}
		
		evaluaPoblacion();
		
		
	}
	
	public void inicializaPoblacionF1() {
		
		for(int i = 0; i < tamPoblacion; i++) {
			this.poblacion[i] = new CromosomaF1(precision);
		}
	}
	
	public void inicializaPoblacionF2() {
		
		for(int i = 0; i < tamPoblacion; i++) {
			this.poblacion[i] = new CromosomaF2(precision);
		}
	}
	
	public void inicializaPoblacionF3() {
		
		for(int i = 0; i < tamPoblacion; i++) {
			this.poblacion[i] = new CromosomaF3(precision);
		}
	}
	
	public void inicializaPoblacionF4() {
		
		for(int i = 0; i < tamPoblacion; i++) {
			this.poblacion[i] = new CromosomaF4(precision, 2);
		}
	}
	
	public void evaluaPoblacion() {
		double fitness, fitness_best, sum_fitness = 0;
		int pos_fitness_best = 0;
		fitness_best = fitness(this.poblacion[0].getFenotipo());
		
		for(int i = 0; i < tamPoblacion; i++) {
			fitness = fitness(this.poblacion[i].getFenotipo());
			
			if((this.funcion == 1 && fitness > fitness_best) || 
			   (this.funcion != 1 && fitness < fitness_best))  { fitness_best = fitness; pos_fitness_best = i; }
			sum_fitness += fitness;
		}
		
		this.mediaGeneracion = sum_fitness / this.tamPoblacion;
		this.mejorGeneracion = fitness_best;
		this.pos_mejorGeneracion = pos_fitness_best;
		
		double puntuacion = 0, puntuacion_acu = 0;
		
		
		for(int i = 0; i < this.tamPoblacion; i++) {
			puntuacion = fitness(this.poblacion[i].getFenotipo()) / sum_fitness;
			puntuacion_acu += puntuacion;
			this.poblacion[i].setPuntuacion(puntuacion);
			this.poblacion[i].setPuntAcumulada(puntuacion_acu);
		}
		
		
	}
	
	public void representarIndividuo() {
		
	}
	
	public double fitness(double[] fen) {
		return 21.5 + fen[0]*(Math.sin(4*Math.PI*fen[0])) + 
				fen[1]*(Math.sin(20*Math.PI*fen[1]));
	}
	

    
    
    
    
    
    
    public Cromosoma[] getPoblacion() {
    	return this.poblacion;
    }
    
    public int getTamPoblacion() {
    	return this.tamPoblacion;
    }
    
    public int getNumGeneraciones() {
    	return this.numGeneraciones;
    }
    
    public double getProbabilidadCruce() {
    	return this.probabilidadCruce;
    }
    
    public double getProbabilidadMutacion() {
    	return this.probabilidadMutacion;
    }
    
    public double getPrecision() {
    	return this.precision;
    }
}
