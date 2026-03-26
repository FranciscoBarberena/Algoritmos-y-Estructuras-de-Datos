package tp1.ejercicio5;

public class Datos {
	private int min = 9999;
	private int max = -1;
	private double prom = 0;
	
	
	
	
	
	

	
	public String toString() {
		String aux = "Maximo: "+getMax();
		aux+= " Minimo: "+getMin();
		aux+=" Promedio: "+ getProm();
		return aux;
	}
	
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public double getProm() {
		return prom;
	}
	public void setProm(double prom) {
		this.prom = prom;
	}
	
	
	
}
