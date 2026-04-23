/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejercicio7;

import java.util.ArrayList;
import java.util.List;
import tp3.GeneralTree;

/**
 *
 * @author Fran
 */
public class Caminos {

    GeneralTree<Integer> arbol;

    public List<Integer> caminoAHojaMasLejana() {
        List<Integer> lista = new ArrayList();
        if ((arbol != null) && (!arbol.isEmpty())) {
            this.encontrarCamino(arbol);
        }
        return lista;
    }

    private List<Integer> encontrarCamino(GeneralTree<Integer> tree) {
        if (tree.isLeaf()){
            List<Integer> lista = new ArrayList();
            lista.add(tree.getData());
            return lista;
        }
        List<GeneralTree<Integer>> children = tree.getChildren();
        List<Integer> caminoMaximo= new ArrayList();
        for (GeneralTree<Integer> child : children) {
            List<Integer> caminoEncontrado = this.encontrarCamino(child);
            if (caminoEncontrado.size()>caminoMaximo.size()){
                caminoMaximo = caminoEncontrado;
            }
        }       
        caminoMaximo.add(0,tree.getData());
        return caminoMaximo;
    }
}
