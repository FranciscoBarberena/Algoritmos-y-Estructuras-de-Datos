/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesArboles._Fecha_Desconocida_03;

import java.util.ArrayList;
import java.util.List;
import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author Fran
 */
public class Parcial {

    public List<Integer> resolver(BinaryTree<Integer> arbol) {
        List<Integer> lista = new ArrayList<>();
        if (arbol != null && !arbol.isEmpty()) {
            recorrerYContar(arbol, lista);
        }
        return lista;
    }

    private int recorrerYContar(BinaryTree<Integer> nodo, List<Integer> lista) {
        int cantIzq = 0;
        int cantDer = 0;

        if (nodo.hasLeftChild()) {
            cantIzq = recorrerYContar(nodo.getLeftChild(), lista);
        }
        
        if (nodo.hasRightChild()) {
            cantDer = recorrerYContar(nodo.getRightChild(), lista);
        }

        if (cantIzq == cantDer) {
            lista.add(nodo.getData());
        }

        return cantIzq + cantDer + 1;
    }
}
