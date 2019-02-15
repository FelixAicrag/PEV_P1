package AlgoritmoGenetico;
import Cromosoma.Cromosoma;
import Cromosoma.CromosomaF1;
import Utils.Rango;

public class AlgoritmoGenetico {

		
		static int tam_poblacion = 100;
		static int num_generaciones = 100;
		static int porcentaje_cruce = 60;
		static int porcentaje_mutacion = 5;
		static double precision = 0.001;
		static boolean elitismo = true;
		
		CromosomaF1 elMejor;
		double mediaGeneracion;
		
		static Rango rango_x1 = new Rango(-3.0, 12.1);
		static Rango rango_x2 = new Rango(4.1, 5.8);
		
		Cromosoma[] poblacion = new Cromosoma[tam_poblacion];
		
		public AlgoritmoGenetico(int problema) {
			inicializaPoblacion();
			evaluaPoblacion();
			
		}
		
		public void inicializaPoblacion() {
			for(int i = 0; i < tam_poblacion; i++) {
				this.poblacion[i] = new CromosomaF1(rango_x1, rango_x2);
			}
		}
		
		public void evaluaPoblacion() {
			double fitness, fitness_mejor = Double.MIN_VALUE, fitness_acu = 0; 
			for(int i = 0; i < tam_poblacion; i++) {
				fitness = this.poblacion[i].fitness();
				fitness_acu += fitness;
				
				if(fitness_mejor < fitness) fitness_mejor = fitness;
			}
			
			double media_pob = fitness_acu / tam_poblacion;
			
			
		}
		
		public void representarIndividuo() {
			
		}
}
