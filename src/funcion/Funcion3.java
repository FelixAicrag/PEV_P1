package funcion;

public class Funcion3 {
	public static double evalua(double x1, double x2) {
		double suma1 = 0.0;
		double suma2 = 0.0;
		for(int i = 1; i <= 5 ;i++) {
			suma1 += i * Math.cos((i + 1) * x1 + i);
			suma2 += i * Math.cos((i + 1) * x2 + i);
		}
		return  suma1 * suma2;
	}
}
