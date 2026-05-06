/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesArboles._2024_1ra_Fecha_T2;

import java.util.ArrayList;
import java.util.List;
import tp1.ejercicio8.Queue;
import tp3.GeneralTree;

/**
 *
 * @author Fran
 */
public class ParcialArboles {

    GeneralTree<Integer> arbol;

    public List<Integer> nivel(int num) {
        List<Integer> nivelCumple = new ArrayList<>();
        if (arbol != null && !arbol.isEmpty()) {
            Queue<GeneralTree<Integer>> cola = new Queue<>();
            cola.enqueue(arbol);
            boolean cumple;
            while (!cola.isEmpty()) {
                cumple = true;
                nivelCumple.clear();
                int tamano = cola.size();
                for (int i = 0; i < tamano; i++) {
                    GeneralTree<Integer> nodoActual = cola.dequeue();
                    List<GeneralTree<Integer>> children = nodoActual.getChildren();
                    if (cumple) {
                        if (children.size() >= num) {
                            nivelCumple.add(nodoActual.getData());
                        } else {
                            cumple = false;
                        }
                    }
                    for (GeneralTree<Integer> child : children) {
                        cola.enqueue(child);
                    }
                }
                if (cumple) {
                    break;
                }
            }
        }
        return nivelCumple;
    }
}
