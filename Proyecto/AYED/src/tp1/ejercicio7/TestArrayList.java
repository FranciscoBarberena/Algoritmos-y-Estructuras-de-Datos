package tp1.ejercicio7;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio3.Persona;
import tp1.ejercicio3.Estudiante;

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
                s.close();
                ArrayList<Integer> listaArray = (ArrayList<Integer>) lista;
                TestArrayList.esCapicua(listaArray);
		/*for (int i = 0;i<lista.size();i++) { //Imprimir iterando sobre cada elemento
			System.out.print(lista.get(i));
		}
                System.out.println();
                for (int i : lista){ //Opcion 2 para recorrer
                    System.out.print(lista.get(i-1));
                }
                TestArrayList t = new TestArrayList();
                t.crearLista();*/
                
	}
        
        public void crearLista(){
         
            List<Estudiante> lista1 = new ArrayList<>();
            for (int i = 0;i<3;i++){
                lista1.add(new Estudiante(i,"Calle 2","Estudiante","Generico","unMail@gmail.com"));
            }
            List<Estudiante> lista2 = new ArrayList<>();
            lista2 = lista1;
            System.out.println("LISTAS ANTES DE CAMBIAR EL NOMBRE DEL ESTUDIANTE 0");
            System.out.println("------- LISTA 1 -------");
            for (int i = 0;i<lista1.size();i++) { 
			System.out.print(lista1.get(i).tusDatos());
            }
            System.out.println("------- LISTA 2 -------");
            for (int i = 0;i<lista2.size();i++) { 
			System.out.print(lista2.get(i).tusDatos());   
            }
            System.out.println("LISTAS DESPUES DE CAMBIAR EL NOMBRE DEL ESTUDIANTE 0");
            lista1.get(0).setNombre("CAMBIE MI NOMBRE");
            System.out.println("------- LISTA 1 -------");
            for (int i = 0;i<lista1.size();i++) { 
			System.out.print(lista1.get(i).tusDatos());
            }
            System.out.println("------- LISTA 2 -------");
            for (int i = 0;i<lista2.size();i++) { 
			System.out.print(lista2.get(i).tusDatos());   
            }
            System.out.println("----------------------");
            System.out.println("CONCLUSIÓN: 'lista1 = lista2' hace que ambas variables apunten a la misma lista. Cambiar un elemento de una hace que cambie la otra, ya que ambas apuntan a la misma direccion de memoria.");
            Estudiante e = new Estudiante(2,"Calle 452","Estudiante","Generico","alumno@gmail.com");
            TestArrayList.agregarEstudiante(lista1, e);
            TestArrayList.agregarEstudiante(lista1, e);
        }
        public static boolean agregarEstudiante(List<Estudiante> L, Estudiante e){
            boolean agrego = false;
            if (!(L.contains(e))){
                L.add(e);
                agrego = true;
            }
            System.out.println(L.get(3).tusDatos());
            
            return agrego;
        }
        public static boolean esCapicua(ArrayList<Integer> lista){
            boolean seguir = true;
            int i = 0;
            while((i<lista.size()) && (seguir)){
                if (!(lista.get(i).equals(lista.get(lista.size()-i-1)))){
                    seguir = false;
                }
                i= i+1;
            }
            if(seguir){
                System.out.println("ES CAPICUA");
            } else System.out.println("NO ES CAPICUA");
            return seguir;
        }
}
