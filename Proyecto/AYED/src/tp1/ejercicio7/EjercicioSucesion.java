/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Fran
 */
public class EjercicioSucesion {

    public List<Integer> calcularSucesion(int n) {
        List<Integer> L = new ArrayList<>();
        L = calcularSecuencia(L, n);

        return L;
    }

    public List<Integer> calcularSecuencia(List<Integer> L, int n) {
        if (n != 1) {
            if (n % 2 == 0) {
                calcularSecuencia(L, n / 2);
            } else {
                calcularSecuencia(L, 3 * n + 1);
            }
        }
        L.add(n);
        return L;
    }

    public void invertirArrayList(ArrayList<Integer> lista) {
        List<Integer> listaInvertida = new ArrayList<>();
        ArrayList<Integer> listaInvertidaArray = (ArrayList<Integer>) listaInvertida;
        for (int i = 0; i < lista.size(); i++) {
            listaInvertidaArray.add(lista.get(lista.size() - i - 1));
        }
        lista.clear();
        lista.addAll(listaInvertida);
    }

    private int recorrer(Iterator<Integer> iterador, int suma) {
        if (iterador.hasNext()) {
            suma = recorrer(iterador, suma + iterador.next());
        }
        return suma;
    }

    public int sumarLinkedList(LinkedList<Integer> lista) {
        Iterator<Integer> iterador = lista.iterator();
        int suma = 0;
        return recorrer(iterador, suma);

    }

    public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1,
            ArrayList<Integer> lista2) {

        ArrayList<Integer> listaOrdenada = new ArrayList<>();
        int i = 0;
        int j = 0;
        while ((i < lista1.size()) && (j < lista2.size())) {
            if (lista1.get(i) < lista2.get(j)) {
                listaOrdenada.add(lista1.get(i));
                i += 1;
            } else {
                listaOrdenada.add(lista2.get(j));
                j += 1;
            }
        }
        while (i < lista1.size()) {
            listaOrdenada.add(lista1.get(i));
            i += 1;
        }
        while (j < lista2.size()) {
            listaOrdenada.add(lista2.get(j));
            j += 1;
        }
        return listaOrdenada;
    }

    public static void main(String[] args) {
        int n = 4;
        EjercicioSucesion e = new EjercicioSucesion();
        ArrayList<Integer> secuenciaInvertida = (ArrayList<Integer>) e.calcularSucesion(n);
        e.invertirArrayList(secuenciaInvertida);
        for (int i = 0; i < secuenciaInvertida.size(); i++) {
            System.out.println(secuenciaInvertida.get(i));
        }
        LinkedList<Integer> linked = new LinkedList<>();
        linked.add(120);
        linked.add(80);

        System.out.println("Suma de lista recursiva: " + e.sumarLinkedList(linked));
        ArrayList<Integer> array1 = new ArrayList<>();
        array1.add(25);
        array1.add(80);
        ArrayList<Integer> array2 = new ArrayList<>();
        array2.add(10);
        array2.add(30);
        array2.add(50);

        ArrayList<Integer> listaOrdenada = e.combinarOrdenado(array1, array2);
        for (int i = 0; i < listaOrdenada.size(); i++) {
            System.out.println(listaOrdenada.get(i));
        }

    }

}
