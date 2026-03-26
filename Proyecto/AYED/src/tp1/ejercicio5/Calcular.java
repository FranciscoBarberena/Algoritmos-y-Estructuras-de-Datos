package tp1.ejercicio5;

public class Calcular {
	
	public static Datos calcularReturn(Integer [] arreglo) {
		Datos d = new Datos();
		int total = 0;
		for (int i = 0;i<arreglo.length;i++) {
			if (arreglo[i]>d.getMax()) {
				d.setMax(arreglo[i]);
			}
			if (arreglo[i]<d.getMin()) {
				d.setMin(arreglo[i]);
			}
			total+=arreglo[i];
		}
		d.setProm(total/arreglo.length);
		return d;
	}
	
	public static void calcularSinNada(Integer[] arreglo) {
		int total = 0;
		for (int i = 0;i<arreglo.length;i++) {
			if (arreglo[i]>DatosGlobal.getMax()) {
				DatosGlobal.setMax(arreglo[i]);
			}
			if (arreglo[i]<DatosGlobal.getMin()) {
				DatosGlobal.setMin(arreglo[i]);
			}
			total+=arreglo[i];
		}
		DatosGlobal.setProm(total/arreglo.length);
	}
	
	
	public static void calcularParametro(Integer [] arreglo, Datos d) {
		int total = 0;
		for (int i = 0;i<arreglo.length;i++) {
			if (arreglo[i]>d.getMax()) {
				d.setMax(arreglo[i]);
			}
			if (arreglo[i]<d.getMin()) {
				d.setMin(arreglo[i]);
			}
			total+=arreglo[i];
		}
		d.setProm(total/arreglo.length);
	}
}
