package AlgoritmoGenetico;
import Cromosoma.Cromosoma;
import Cromosoma.CromosomaF1;

public class AlgoritmoGeneticoF1 {

		
		static int tam_poblacion = 100;
		static int num_generaciones = 100;
		static int porcentaje_cruce = 60;
		static int porcentaje_mutacion = 5;
		static double precision = 0.001;
		static boolean elitismo = true;
		CromosomaF1 elMejor;
		double mediaGeneracion;
		
		static double[] rango_x1 = {-3.0, 12.1};
		static double[] rango_x2 = {4.1, 5.8};
		
		Cromosoma[] poblacion = new Cromosoma[tam_poblacion];
		
		public AlgoritmoGeneticoF1() {
			inicializaPoblacion();
			evaluaPoblacion();
			
		}
		
		public void inicializaPoblacion() {
			for(int i = 0; i < tam_poblacion; i++) {
				this.poblacion[i] = new CromosomaF1(rango_x1, rango_x2);
			}
		}
		
		public void evaluaPoblacion() {
			double fitness, fitness_max, fitness_acu;
			for(int i = 0; i < tam_poblacion; i++) {
				fitness = fitness(this.poblacion[i].fenotipo());
			}
			
			
		}
		
		public void representarIndividuo() {
			
		}
		
		public double fitness(double[] fen) {
			return 21.5 + fen[0]*(Math.sin(4*Math.PI*fen[0])) + 
					fen[1]*(Math.sin(20*Math.PI*fen[1]));
		}
		

}
