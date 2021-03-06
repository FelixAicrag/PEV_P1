package algoritmoGenetico;

import cruce.*;
import funcion.*;
import mutacion.Mutacion;
import cromosoma.Cromosoma;
import reemplazo.Aleatorio;

import java.util.ArrayList;

import cromosoma.*;
import seleccion.*;
import utils.*;

public class AlgoritmoGenetico {
	
	Cromosoma[] poblacion; //Poblacion total
	ArrayList<Cromosoma> elite; //Elite seleccionada
	
	//Parametros del algoritmo.
	TipoFuncion funcion;
	TipoSeleccion tipo_seleccion;
	TipoCruce tipo_cruce;
	int tamPoblacion, numGeneraciones, numGenes, generacionActual;
	double probabilidadCruce, probabilidadMutacion, probabilidadUniforme, precision, elitismo;
	
	//Valores para escribir la grafica.
	double[] mediasGeneracion;
	double[] mejoresGeneracion;
	double[] mejoresAbsolutos;
	
	double mediaGeneracion;
	double mejorGeneracion;
	double mejorAbsoluto;
	
	private Cromosoma elMejor; //Mejor cromosoma encontrado hasta ahora.
	int pos_mejorGeneracion;   //Posicion del mejor cromosoma de la generacion
	
	public AlgoritmoGenetico(TipoFuncion tFun, TipoSeleccion tSel, TipoCruce tCrux,
							 int tPob, int nGeneracs, int nGenes, 
							 double pCruce, double pMutacion, double pUnif, double prec,
							 double elit) {

		this.generacionActual = 0;
		this.funcion = tFun;
		this.tipo_seleccion = tSel;
		this.tipo_cruce = tCrux;
		this.numGeneraciones = nGeneracs;
		this.numGenes = nGenes;
		this.tamPoblacion = tPob;
		this.probabilidadCruce = pCruce;
		this.probabilidadMutacion = pMutacion;
		this.probabilidadUniforme = pUnif;
		this.precision = prec;
		this.elitismo = elit;
		
		this.poblacion = new Cromosoma[tPob];
		this.elite = new ArrayList<Cromosoma>();
		
		this.mediasGeneracion = new double[nGeneracs];
		this.mejoresGeneracion = new double[nGeneracs];
		this.mejoresAbsolutos = new double[nGeneracs];
		
		
	}
	
	public void inicializaPoblacion() {
		
		switch (funcion) {
		case F1:
			for(int i = 0; i < tamPoblacion; i++) {
				this.poblacion[i] = new CromosomaF1(this.precision);
			} break;
		case F2:
			for(int i = 0; i < tamPoblacion; i++) {
				this.poblacion[i] = new CromosomaF2(this.precision);
			} break;
		case F3:
			for(int i = 0; i < tamPoblacion; i++) {
				this.poblacion[i] = new CromosomaF3(this.precision);
			} break;
		case F4:
			for(int i = 0; i < tamPoblacion; i++) {
				this.poblacion[i] = new CromosomaF4(this.precision, this.numGenes);
			} break;
		}
		
        this.elMejor = this.duplicarCromosoma(this.poblacion[0]);
        fitness(elMejor);
        this.generacionActual = 0;

	}
	
	public double fitness(Cromosoma cromosoma) {
		double valor = 0.0;
		cromosoma.calcularFenotipo();
		double[] x = cromosoma.getFenotipo();
		switch(this.funcion) {
			case F1: 
				valor = Funcion1.evalua(x);
				break;
			case F2: 
				valor = Funcion2.evalua(x);
				break;
			case F3: 
				valor = Funcion3.evalua(x);
				break;
			case F4:
				valor = Funcion4.evalua(x);
				break;	
			default:
				valor = Funcion1.evalua(x);
				break;
			}
		cromosoma.setFitness(valor);
		return valor;
	}

	public void evaluaPoblacion() {
		double fitness, fitness_best, sum_fitness = 0;
		int pos_fitness_best = 0;
		fitness_best = fitness(this.poblacion[0]);
		
		for(int i = 0; i < tamPoblacion; i++) {
			fitness = fitness(this.poblacion[i]);
			
			if((this.funcion == TipoFuncion.F1 && fitness > fitness_best) || 
			   (this.funcion != TipoFuncion.F1 && fitness < fitness_best))  
			{ fitness_best = fitness; pos_fitness_best = i; }
			sum_fitness += fitness;
		}
		double puntuacion = 0, puntuacion_acu = 0;
		
		for(int i = 0; i < this.tamPoblacion; i++) {
			puntuacion = fitness(this.poblacion[i]) / sum_fitness;
			puntuacion_acu += puntuacion;
			this.poblacion[i].setPuntuacion(puntuacion);
			this.poblacion[i].setPuntAcumulada(puntuacion_acu);
		}
		
		
		if(this.funcion == TipoFuncion.F1) {
			if(elMejor.getFitness() < this.poblacion[pos_fitness_best].getFitness()) {
			elMejor = this.duplicarCromosoma(this.poblacion[pos_fitness_best]); 
			} 
		} 
		else if (elMejor.getFitness() > this.poblacion[pos_fitness_best].getFitness()) {
			elMejor = this.poblacion[pos_fitness_best]; 
		}
		
		
		this.mediasGeneracion[this.generacionActual] = sum_fitness / this.tamPoblacion;
		this.mejoresGeneracion[this.generacionActual] = fitness_best;
		this.mejoresAbsolutos[this.generacionActual] = this.elMejor.getFitness();
		
	}
	
	public void seleccionaPoblacion() {
		
		switch(tipo_seleccion) {
		case ESTOCASTICO: 
			EstocasticoUniversal estocastUniv = new EstocasticoUniversal(this.poblacion, this.tamPoblacion);
			estocastUniv.seleccionEstocastico(this.funcion, this.precision, this.numGenes);
			break;
//		case RESTOS: 
//			Restos restos = new Restos(this.poblacion, this.tamPoblacion, 0.5, 3);
//			restos.seleccionRestos();
//			break;
		case RULETA: 
			Ruleta ruleta = new Ruleta(this.poblacion, this.tamPoblacion);
			ruleta.seleccionRuleta();
			break;
		case TORNEO:
			Torneos torneos = new Torneos(this.poblacion, this.tamPoblacion);
			torneos.seleccionTorneos(this.funcion, this.precision, this.numGenes);
			break;	
		default:
			Ruleta r = new Ruleta(this.poblacion, this.tamPoblacion);
			r.seleccionRuleta();
			break;
		}
	}
	
	/**
	 * Cruza y muta la poblacion en funcion de probabilidadCruce y probabilidadMutacion.
	 */
	public void reproducePoblacion() {
		
		
		
		switch(tipo_cruce) {
		case BIPUNTO: 
			Bipunto bipto = new Bipunto(this.probabilidadCruce, this.tamPoblacion, this.poblacion);
			bipto.cruzar();
			break;
		case MONOPUNTO: 
			Monopunto mp = new Monopunto(this.probabilidadCruce, this.tamPoblacion, this.poblacion);
			mp.cruzar();
			break;
		case UNIFORME: 
			Uniforme uni = new Uniforme(this.probabilidadCruce, this.probabilidadUniforme, this.tamPoblacion, this.poblacion);
			uni.cruzar();
			break;
		default:
			Monopunto mono = new Monopunto(this.probabilidadCruce, this.tamPoblacion, this.poblacion);
			mono.cruzar();
			break;
		}
		
		for(int i = 0; i < this.tamPoblacion; i++ ) {
			Mutacion m = new Mutacion(this.probabilidadMutacion, this.poblacion[i].getCromosoma());
			m.mutar();
		}		
	}
	
	public void seleccionaElite() {
    	int num_elites = (int) (this.tamPoblacion * this.elitismo);
    	this.ordenarPoblacion(0, this.tamPoblacion-1);
    	this.elite.clear();

        if (this.funcion == TipoFuncion.F1) {
            for (int i = 1 ; i <= num_elites; i++)
                    this.elite.add(duplicarCromosoma(this.poblacion[this.tamPoblacion-i]));
        }

        else {
            for (int i = 0 ; i < num_elites; i++)
                    this.elite.add(duplicarCromosoma(this.poblacion[i]));
        }
	}
	
	public void incluyeElite() {
		Aleatorio al = new Aleatorio(this.poblacion, this.elite);
		al.reemplazar();
	}
	
	/**
	 * Devuelve true si se cumple la condicion de
	 * terminacion del bucle; false en c/c.
	 * @param generacion_actual
	 * @return
	 */
	boolean terminado(int generacion_actual) {
		return generacion_actual >= this.numGeneraciones;
	}
	
	
    /**
     * Ordena de menor a mayor fitness
     * @param poblacion
     * @param izq
     * @param der
     */
    private void ordenarPoblacion(int izq, int der) {
    	 
        int i = izq;
        int j = der;
        
        Cromosoma pivote = this.poblacion[(i+j)/2];
        
        do {
            while (this.poblacion[i].getFitness() < pivote.getFitness()){
                i++;
            }
            while (this.poblacion[j].getFitness() > pivote.getFitness()){
                j--;
            }
            if (i<=j){
                Cromosoma aux = duplicarCromosoma(this.poblacion[i]);
                this.poblacion[i] = duplicarCromosoma(this.poblacion[j]);
                this.poblacion[j] = duplicarCromosoma(aux);
                i++;
                j--;
            }
        }while(i<=j);
        if (izq<j){
            ordenarPoblacion(izq, j);
        }
        if (i<der){
            ordenarPoblacion(i, der);
        }
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

	public double[] getMejoresAbsolutos() {
		return this.mejoresAbsolutos;
	}

	public double[] getMejoresGeneracion() {
		return this.mejoresGeneracion;
	}

	public double[] getMedias() {
		return this.mediasGeneracion;
	}

	public Cromosoma getMejor() {
		return duplicarCromosoma(this.elMejor);
	}

	public void aumentaGeneracion() {
		this.generacionActual++;
	}
	
	private Cromosoma duplicarCromosoma(Cromosoma c) {
	    Cromosoma nuevo = null ;
	    
	    switch(this.funcion) {
	    	case F1:
	    		nuevo = new CromosomaF1(this.precision);
	    		break;
	    	case F2:
	    		nuevo = new CromosomaF2(this.precision);
	    		break;
	    	case F3:
	    		nuevo = new CromosomaF3(this.precision);
	    		break;
	    	case F4:
	    		nuevo = new CromosomaF4(this.precision, this.numGenes);
	    		break;
	    	default:
	    		nuevo = new CromosomaF1(this.precision);
	    		break;
	    	}
	    	
	        nuevo.setFitness(c.getFitness());
	        nuevo.setCromosoma(c.getCromosoma());
	        nuevo.setPuntAcumulada(c.getPuntAcumulada());
	        nuevo.getFenotipo();
	                
	    	return nuevo;
	    }

}
