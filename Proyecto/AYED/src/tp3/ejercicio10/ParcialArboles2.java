/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejercicio10;

import java.util.ArrayList;
import java.util.List;
import tp3.GeneralTree;

/**
 *
 * @author Fran
 */
public class ParcialArboles2 {

    public static List<Integer> resolver(GeneralTree<Integer> arbol) {
        List<Integer> lista = new ArrayList();
        if ((arbol != null) && (!arbol.isEmpty())) {
            //lista = crearCamino(arbol, 0);resolucion con post orden
            //lista.remove(0);resolucion con post orden
            List<Integer> lista2 = new ArrayList();
            int sumaMaxima = recorrerArbolBacktracking(arbol, 0, lista2, lista, 0, Integer.MIN_VALUE);

        }
        return lista;
    }

    private static List<Integer> crearCamino(GeneralTree<Integer> arbol, int nivelActual) {
        if (arbol.isLeaf()) {
            List<Integer> lista = new ArrayList();
            lista.add(arbol.getData() * nivelActual);
            if (arbol.getData() == 1) {
                lista.add(arbol.getData());
            }
            return lista;
        }
        List<GeneralTree<Integer>> children = arbol.getChildren();

        List<Integer> listaMaxima = new ArrayList();
        listaMaxima.add(-1);
        for (GeneralTree<Integer> child : children) {
            List<Integer> listaEncontrada = crearCamino(child, nivelActual + 1);
            if ((listaEncontrada.get(0) > listaMaxima.get(0))) {
                listaMaxima = listaEncontrada;
            }
        }
        listaMaxima.set(0, listaMaxima.get(0) + arbol.getData() * nivelActual);
        if (arbol.getData() == 1) {
            listaMaxima.add(arbol.getData());

        }

        return listaMaxima;
    }

    private static int recorrerArbolBacktracking(GeneralTree<Integer> arbol, int nivelActual, List<Integer> caminoActual, List<Integer> caminoMaximo, int sumaActual, int sumaMaxima) {

        if (arbol.getData() == 1) {
            caminoActual.add(arbol.getData());
            sumaActual += nivelActual * 1;

        }
        if (arbol.isLeaf()) {
            if (sumaActual > sumaMaxima) {
                caminoMaximo.clear();
                caminoMaximo.addAll(caminoActual);
                sumaMaxima = sumaActual;
            }
        } else {
            List<GeneralTree<Integer>> children = arbol.getChildren();
            for (GeneralTree<Integer> child : children) {
                sumaMaxima = recorrerArbolBacktracking(child, nivelActual + 1, caminoActual, caminoMaximo, sumaActual, sumaMaxima);

            }
        }
        if (arbol.getData() == 1) {
            caminoActual.remove(caminoActual.size() - 1);
        }
        return sumaMaxima;
    }

}
