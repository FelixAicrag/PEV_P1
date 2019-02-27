package seleccion;

import java.util.ArrayList;

import cromosoma.Cromosoma;

public class Ruleta {
	Cromosoma[] pob, nuevaPob;
	int tamPob;
	double prob;
	int posSuperviviente;
	int[] supervivientes;
	
	public Ruleta (Cromosoma[] pob, Cromosoma[] nuevaPob, int tamPob) {
		this.pob = pob;
		this.nuevaPob = nuevaPob;
		this.tamPob = tamPob;
		this.prob = 0;
		this.supervivientes = new int[this.tamPob];
	}
	

	public void seleccionRuleta(Cromosoma[] pob, Cromosoma[] nuevaPob, int tamPob) {
		
		for(int i = 0; i < this.tamPob; i++) {
			this.prob = Math.random();
			this.posSuperviviente = 0;
			
			while((prob > this.pob[posSuperviviente].getPuntAcumulada())
					&& (posSuperviviente < this.tamPob)) {
				posSuperviviente++;
			}
			supervivientes[i] = posSuperviviente;
		}
		
		for(int j = 0; j < this.tamPob; j++) {
			copiarPoblacion(this.pob[this.supervivientes[j]], this.nuevaPob);
		}
	}
	
	private void copiarPoblacion(Cromosoma cromosoma, Cromosoma[] nuevaPob) {
		
	}
}
