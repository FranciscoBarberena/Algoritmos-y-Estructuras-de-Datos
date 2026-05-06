/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesArboles._Fecha_Desconocida_02;

import java.util.ArrayList;
import java.util.List;
import tp3.GeneralTree;

/**
 *
 * @author Fran
 */
public class Parcial {

    GeneralTree<Integer> arbol;

    public List<Integer> resolver() {
        List<Integer> lista = new ArrayList<>();
        if (arbol != null && !arbol.isEmpty()) {
            recorrerArbol(arbol, lista);
        }
        return lista;
    }

    private int sumadorElementos(GeneralTree<Integer> tree) {
        List<GeneralTree<Integer>> children = tree.getChildren();
        int suma = 0;
        for (GeneralTree<Integer> child : children) {
            suma += child.getData();
        }
        return suma;
    }

    private void recorrerArbol(GeneralTree<Integer> tree, List<Integer> lista) {
        List<GeneralTree<Integer>> children = tree.getChildren();
        for (GeneralTree<Integer> child : children) {
            recorrerArbol(child, lista);
        }

        if (children.size() % 2 != 0) {
            lista.add(sumadorElementos(tree));
        }
    }
}
