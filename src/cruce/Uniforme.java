package cruce;

import java.util.ArrayList;

import cromosoma.Cromosoma;

public class Uniforme {
	boolean[] cromosoma1, cromosoma2;
	double probCruce, probUnif;
	int tamPoblacion;
	ArrayList<Cromosoma> seleccionados;
	ArrayList<Integer> posSeleccionados;
	int num_sele_cruce;
	Cromosoma[] poblacion;
	
	public Uniforme(double probCruce, double probUnif, int tamPoblacion, Cromosoma[] pob) {
		this.probCruce = probCruce;
		this.probUnif = probUnif;
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
	
		//hacemos el cruce
		for(int i = 0; i < this.num_sele_cruce - 1; i += 2) {
			this.cromosoma1 = this.seleccionados.get(i).getCromosoma();
			this.cromosoma2 = this.seleccionados.get(i + 1).getCromosoma();
			
			boolean[] c1_nueva = new boolean[this.cromosoma1.length];
			boolean[] c2_nueva = new boolean[this.cromosoma2.length];

			for(int j = 0; j < this.cromosoma1.length; j++) {
				double ale = Math.random();
				if(ale < this.probUnif) {
					boolean aux = this.cromosoma1[j];
					c1_nueva[j] = this.cromosoma2[j];
					c2_nueva[j] = aux;
				}
				
			}
			//guardamos las nuevas cromosomas en las posiciones que estaban 
			//las cromosomas que hemos seleccionado para cruzar
			this.poblacion[this.posSeleccionados.get(i)].setCromosoma(c1_nueva);
			this.poblacion[this.posSeleccionados.get(i + 1)].setCromosoma(c2_nueva);
		}
	
	
	}
}
