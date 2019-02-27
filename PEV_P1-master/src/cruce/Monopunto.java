package cruce;

import java.util.ArrayList;

import cromosoma.Cromosoma;

public class Monopunto {
	boolean[] cromosoma1, cromosoma2;
	double probCruce;
	int tamPoblacion;
	int puntoCruce;
	ArrayList<Cromosoma> seleccionados;
	ArrayList<Integer> posSeleccionados;
	int num_sele_cruce;
	Cromosoma[] poblacion;
	
	public Monopunto(double probCruce, int tamPoblacion, Cromosoma[] pob) {
		this.probCruce = probCruce;
		this.tamPoblacion = tamPoblacion;
		this.num_sele_cruce = 0;
		this.seleccionados = new ArrayList<Cromosoma>();
		this.posSeleccionados = new ArrayList<Integer>();
		this.poblacion = pob;
	}
	
	public void cruzar() {
		
		//seleccionamos las cromosomas a cruzar
		for(int i = 0; i < this.tamPoblacion; i++) {
			double aleatorio = Math.random();
			if(aleatorio < this.probCruce) {
				this.seleccionados.add(this.poblacion[i]);
				this.posSeleccionados.add(i);
				num_sele_cruce++;
			}
		}
		
		if(num_sele_cruce % 2 == 1)
			num_sele_cruce--;
		
		//obtenemos el punto de cruce
		this.puntoCruce = (int) (Math.random() * this.poblacion[0].getLongitudCrom() ) + 1;
		
		//hacemos el cruce
		for(int i = 0; i < this.num_sele_cruce - 1; i += 2) {
			this.cromosoma1 = this.seleccionados.get(i).getCromosoma();
			this.cromosoma2 = this.seleccionados.get(i + 1).getCromosoma();
			
			boolean[] c1_nueva = new boolean[this.cromosoma1.length];
			boolean[] c2_nueva = new boolean[this.cromosoma2.length];

			for(int j = 0; j < this.puntoCruce; j++) {
				c1_nueva[j] = this.cromosoma1[j];
				c2_nueva[j] = this.cromosoma2[j];
			}
			
			for(int k = this.puntoCruce; k < this.cromosoma1.length; k++) {
				c1_nueva[k] = this.cromosoma2[k];
				c2_nueva[k] = this.cromosoma1[k];
			}
			
			//guardamos las nuevas cromosomas en las posiciones que estaban 
			//las cromosomas que hemos seleccionado para cruzar
			this.poblacion[this.posSeleccionados.get(i)].setCromosoma(c1_nueva);
			this.poblacion[this.posSeleccionados.get(i + 1)].setCromosoma(c2_nueva);
		}
	
	
	}
}
