

package tp1.ejercicio2;
import java.util.Scanner;
/**
 *
 * @author Fran
 */
public class Arreglos {
    public static int[] obtenerArreglo(int n){
        int[] nuevoArreglo = new int[n];
        for (int i = 0;i<n;i++){
            nuevoArreglo[i] = (i+1)*n;
        }
        return nuevoArreglo;
    }
    public static void main(String[] args) {
       System.out.println("Ingrese el numero a partir del cual quiere generar un arreglo (0 para terminar):");
       Scanner s = new Scanner(System.in);
       int n = s.nextInt();
        while (n != 0){
            int [] arreglo = Arreglos.obtenerArreglo(n);
            for (int i = 0;i<n;i++){
                System.out.println(arreglo[i]);
            }
            System.out.println("Ingrese el numero a partir del cual quiere generar un arreglo (0 para terminar):");
            n = s.nextInt();
        }
    }
}
