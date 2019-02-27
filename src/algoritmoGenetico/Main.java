package algoritmoGenetico;

import javax.swing.*;
import org.math.plot.*;


public class Main {
	

	public static void main(String[] args) {
		
		// define your data
		double[] Generacion = {1,2,3,4,5,6};
		double[] Evaluacion_MejorAbs = { 4, 5, 6, 7, 8, 9 };
		double[] Evaluacion_MejorGen = { 45, 89, 6, 32, 63, 12 };
		double[] Evaluacion_MediaGen = { 100, 100, 100, 100, 100, 100 };

		// create your PlotPanel (you can use it as a JPanel)
		Plot2DPanel plot = new Plot2DPanel();

		// define the legend position
		plot.addLegend("SOUTH");

		// add a line plot to the PlotPanel
		plot.addLinePlot("Mejor Absoluto", Generacion, Evaluacion_MejorAbs);
		plot.addLinePlot("Mejor Generacion", Generacion, Evaluacion_MejorGen);
		plot.addLinePlot("Media Generacion", Generacion, Evaluacion_MediaGen);

		// put the PlotPanel in a JFrame like a JPanel
		JFrame frame = new JFrame("a plot panel");
		frame.setSize(600, 600);
		frame.setContentPane(plot);
		frame.setVisible(true);
		
		
		
		/*
		int tPob = 100, nGeneracs = 50, nGenes = 2, func = 1;
		int generacion_actual = 0;
		double pCruce = 0.6, pMutacion = 0.05, prec = 0.001;
		boolean elitismo = false;
		//Creamos la población inicial aleatoria y la evaluamos
		//(depende del problema genera cromosomas de determinado tipo).
		AlgoritmoGenetico AG = new AlgoritmoGenetico(func, nGeneracs, nGenes, tPob, 
													 pCruce, pMutacion, prec, elitismo);
		AG.inicializaPoblacion();
		AG.evaluaPoblacion();

		while(!AG.terminado(generacion_actual)) {
			generacion_actual++;
			
			AG.seleccionaPoblacion();
			AG.reproducePoblacion();
			AG.reemplazaPoblacion();
			
			AG.evaluaPoblacion();
			
		
		
		}
		*/
	}
}
