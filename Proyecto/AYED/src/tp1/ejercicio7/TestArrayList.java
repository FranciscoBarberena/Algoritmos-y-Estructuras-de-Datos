package tp1.ejercicio7;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class TestArrayList {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<Integer> lista = new ArrayList<>();
		int numeroLeido;
		System.out.println("Ingrese un numero para agregar a la secuencia (0 para terminar)");
		numeroLeido= s.nextInt();
		while(numeroLeido != 0) {
			lista.add(numeroLeido);
			System.out.println("Ingrese un numero para agregar a la secuencia (0 para terminar)");
			numeroLeido = s.nextInt();
		}
		for (int i = 0;i<lista.size();i++) {
			System.out.print(lista.get(i));
		}
		s.close();

	}

}
