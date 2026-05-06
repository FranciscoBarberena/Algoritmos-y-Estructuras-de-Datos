/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesArboles._2024_1ra_Fecha_T1;

import java.util.ArrayList;
import java.util.List;
import tp3.GeneralTree;

/**
 *
 * @author Fran
 */
public class ParcialArboles {

    GeneralTree<Integer> arbol;

    public List<Integer> camino(int num) {
        List<Integer> resultado = new ArrayList<>();
        if (arbol != null && !arbol.isEmpty()) {
            buscar(arbol, num, resultado);
        }
        return resultado;
    }

    private boolean buscar(GeneralTree<Integer> nodo, int num, List<Integer> caminoActual) {
        caminoActual.add(nodo.getData());
        if (nodo.isLeaf()) {
            return true;
        }
        List<GeneralTree<Integer>> children = nodo.getChildren();
        if (children.size() >= num) {
            for (GeneralTree<Integer> child : children) {
                if (buscar(child, num, caminoActual)) {
                    return true;
                }
            }
        }
        caminoActual.remove(caminoActual.size() - 1);
        return false;
    }
}
