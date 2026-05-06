/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesArboles._2025_1ra_Fecha_T2;

import java.util.ArrayList;
import java.util.List;
import tp3.GeneralTree;

/**
 *
 * @author Fran
 */
public class ParcialArboles {

    public static List<Integer> caminoSignoAlternante(GeneralTree<Integer> arbol) {
        List<Integer> caminoMax = new ArrayList<>();
        if (arbol != null && !arbol.isEmpty()) {
            List<Integer> caminoActual = new ArrayList<>();
            buscarMax(arbol, caminoActual, caminoMax, 0, Integer.MIN_VALUE);
        }
        return caminoMax;
    }

    private static int buscarMax(GeneralTree<Integer> arbol, List<Integer> caminoActual,
            List<Integer> caminoMax, int sumaActual, int sumaMax) {

        int dato = arbol.getData();
        caminoActual.add(dato);
        sumaActual = sumaActual + dato;
        if (arbol.isLeaf()) {
            if (sumaActual > sumaMax) {
                sumaMax = sumaActual;
                caminoMax.clear();
                caminoMax.addAll(caminoActual);
            }
        } else {
            List<GeneralTree<Integer>> children = arbol.getChildren();
            for (GeneralTree<Integer> child : children) {
                int datoHijo = child.getData();
                if (((dato >= 0) && (datoHijo < 0)) || ((dato < 0) && (datoHijo >= 0))) {
                    sumaMax = buscarMax(child, caminoActual, caminoMax, sumaActual, sumaMax);
                }
            }
        }
        caminoActual.remove(caminoActual.size() - 1);
        return sumaMax;
    }

    public static List<List<Integer>> todosLosCaminosEntre(GeneralTree<Integer> arbol, int min, int max) {
        List<List<Integer>> listaDeCaminos = new ArrayList<>();
        if ((arbol != null) && (!arbol.isEmpty())) {
            List<Integer> listaActual = new ArrayList<>();
            encontrarCaminos(arbol, min, max, listaDeCaminos, listaActual);
        }
        return listaDeCaminos;
    }

    public static List<List<Integer>> todosLosCaminosEntre2(GeneralTree<Integer> arbol, int min, int max) {
        List<List<Integer>> listaDeCaminos = new ArrayList<>();
        if ((arbol != null) && (!arbol.isEmpty()) && (arbol.getData() <= max && arbol.getData() >= min)) {
            List<Integer> listaActual = new ArrayList<>();
            encontrarCaminos2(arbol, min, max, listaDeCaminos, listaActual);
        }
        return listaDeCaminos;
    }

    private static void encontrarCaminos(GeneralTree<Integer> arbol, int min, int max, List<List<Integer>> listaDeCaminos, List<Integer> listaActual) {
        int dato = arbol.getData();
        if (!(dato >= min && dato <= max)) {
            return;
        }
        listaActual.add(dato);
        if (arbol.isLeaf()) {
            listaDeCaminos.add(new ArrayList<>(listaActual));
        } else {
            List<GeneralTree<Integer>> children = arbol.getChildren();
            for (GeneralTree<Integer> child : children) {
                encontrarCaminos(child, min, max, listaDeCaminos, listaActual);
            }
        }
        listaActual.remove(listaActual.size() - 1);
    }

    private static void encontrarCaminos2(GeneralTree<Integer> arbol, int min, int max, List<List<Integer>> listaDeCaminos, List<Integer> listaActual) {
        listaActual.add(arbol.getData());
        if (arbol.isLeaf()) {
            listaDeCaminos.add(new ArrayList<>(listaActual));
        } else {
            List<GeneralTree<Integer>> children = arbol.getChildren();
            for (GeneralTree<Integer> child : children) {
                if (child.getData() <= max && child.getData() >= min) {
                    encontrarCaminos2(child, min, max, listaDeCaminos, listaActual);
                }
            }
        }
        listaActual.remove(listaActual.size() - 1);
    }

}
