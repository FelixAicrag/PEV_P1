import Cromosoma.Cromosoma;
import Cromosoma.CromosomaF1;

public class AlgoritmoGenetico {

		
		static int tam_poblacion = 100;
		static int num_generaciones = 100;
		static int porcentaje_cruce = 60;
		static int porcentaje_mutacion = 5;
		static double precision = 0.001;
		static boolean elitismo = true;
		Cromosoma[] poblacion = new Cromosoma[tam_poblacion];
		
		public AlgoritmoGenetico() {
			inicializaPoblacion();
		}
		
		public void inicializaPoblacion() {
			for(int i = 0; i < tam_poblacion; i++) {
				this.poblacion[i] = randomIndividual();
			}
		}
		
		public void representarIndividuo() {
			
		}
		
		public void fitness() {
			
		}
		

}
