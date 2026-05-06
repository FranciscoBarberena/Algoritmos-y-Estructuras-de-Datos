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
}
