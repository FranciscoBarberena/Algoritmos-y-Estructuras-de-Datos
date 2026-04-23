/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejercicio4;

import java.util.List;
import tp1.ejercicio8.Queue;
import tp3.GeneralTree;

/**
 *
 * @author Fran
 */
public class AnalizadorArbol {

    public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
        if ((arbol != null) && (!arbol.isEmpty())) {
            Queue<GeneralTree<AreaEmpresa>> cola = new Queue<>();
            cola.enqueue(arbol);
            double promedioMax = 0;
            while (!cola.isEmpty()) {
                int tamano = cola.size();
                int total = 0;
                for (int i = 0; i < tamano; i++) {
                    GeneralTree<AreaEmpresa> hijoActual = cola.dequeue();
                    total += hijoActual.getData().getTardanza();
                    List<GeneralTree<AreaEmpresa>> children = hijoActual.getChildren();
                    for (GeneralTree<AreaEmpresa> child: children){
                        cola.enqueue(child);
                    }
                }
                if ((double) total / tamano > promedioMax) {
                    promedioMax = (double) total / tamano;
                }
            }
            return promedioMax;     
        } else {
            return 0.0;
        }

    }
}
