/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesArboles._Fecha_Desconocida_01;

import tp1.ejercicio8.Queue;
import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author Fran
 */
public class NivelArbol {

    BinaryTree<Integer> arbol = new BinaryTree<>();

    public BinaryTree<Integer> minEnNiveldeAB(int n) {
        if (arbol.isEmpty()) {
            return null;
        }
        Queue<BinaryTree<Integer>> cola = new Queue<>();
        cola.enqueue(arbol);
        int nivel = 0;
        while (!cola.isEmpty()) {
            int tamano = cola.size();
            if (nivel == n) {
                int min = Integer.MAX_VALUE;
                BinaryTree<Integer> minLeaf = null;

                for (int i = 0; i < tamano; i++) {
                    BinaryTree<Integer> nodoActual = cola.dequeue();

                    if (nodoActual.isLeaf()) {
                        int dato = nodoActual.getData();
                        if (dato < min) {
                            min = dato;
                            minLeaf = nodoActual;
                        }
                    }
                }
                return minLeaf;
            } else {
                for (int i = 0; i < tamano; i++) {
                    BinaryTree<Integer> nodo = cola.dequeue();

                    if (nodo.hasLeftChild()) {
                        cola.enqueue(nodo.getLeftChild());
                    }
                    if (nodo.hasRightChild()) {
                        cola.enqueue(nodo.getRightChild());
                    }
                }
                nivel += 1;
            }
        }
        return null;
    }
}
