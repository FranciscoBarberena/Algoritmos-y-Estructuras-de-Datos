package tp1.ejercicio1;

public class Enteros {
	public static void imprimirRangoFor(int a,int b) {
		for (int i = a; i<=b;i++) {
			System.out.print(i+"\n");
		}
	}
	public static void imprimirRangoWhile(int a, int b) {
		int i = a;
		while (i<=b) {
			System.out.print(i+"\n");
			i++;
		}
	}
	public static void imprimirRangoRecursivo(int a, int b) {
		if (a<=b) {
			System.out.print(a+"\n");
			a+=1;
			imprimirRangoRecursivo(a,b);
		}
			
	}
	public static void main(String[] args) {
		Enteros.imprimirRangoFor(0, 2);
		Enteros.imprimirRangoWhile(3,5);
		Enteros.imprimirRangoRecursivo(6, 8);
	}
}