/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejercicio11;

import java.util.List;
import tp1.ejercicio8.Queue;
import tp3.GeneralTree;

/**
 *
 * @author Fran
 */
public class ParcialArboles3 {

    public static boolean resolver(GeneralTree<Integer> arbol) {
        if (arbol == null) {
            return false;
        } else if (arbol.isEmpty()) {
            return true;
        }
        Queue<GeneralTree<Integer>> cola = new Queue();
        cola.enqueue(arbol);
        int nivelAnterior = 0;
        boolean cumple = true;
        while (!cola.isEmpty() && (cumple)) {
            int tamano = cola.size();
            for (int i = 0; i < tamano; i++) {
                GeneralTree<Integer> hijoActual = cola.dequeue();
                List<GeneralTree<Integer>> children = hijoActual.getChildren();
                for (GeneralTree<Integer> child : children) {
                    cola.enqueue(child);
                }
            }
            if (tamano == nivelAnterior + 1) {
                nivelAnterior = tamano;
            } else {
                cumple = false;
            }
        }
        return cumple;
    }
}
