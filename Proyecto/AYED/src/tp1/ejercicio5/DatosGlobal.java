package tp1.ejercicio5;

public class DatosGlobal {
	private static int min = 9999;
	private static int max = -1;
	private static double prom = 0;
	
	

	
	
	public static int getMin() {
		return min;
	}

	public static void setMin(int min) {
		DatosGlobal.min = min;
	}

	public static int getMax() {
		return max;
	}

	public static void setMax(int max) {
		DatosGlobal.max = max;
	}

	public static double getProm() {
		return prom;
	}

	public static void setProm(double prom) {
		DatosGlobal.prom = prom;
	}
	
	
}
