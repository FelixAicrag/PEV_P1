package funcion;

public class Funcion2 {
	public static double evalua(double[] x) {
		return -(x[1] + 47) * Math.sin(Math.sqrt(Math.abs(x[1] + (x[0] / 2) + 47))) - x[0] * Math.sin(Math.sqrt(Math.abs(x[0] - (x[1] + 47))));
	}
}
