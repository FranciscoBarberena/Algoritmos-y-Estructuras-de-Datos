/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesArboles._2023_1ra_Fecha_T1;

import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author Fran
 */
public class ProcesadorDeArbol {

    private BinaryTree<Integer> arbol;

    public Objeto procesar() {
        Objeto data = new Objeto();
        if (arbol != null && !arbol.isEmpty()) {
            recorrerArbol(arbol, data);
        }
        return data;
    }

    private void recorrerArbol(BinaryTree<Integer> tree, Objeto data) {
        if (tree.getData() % 2 == 0) {
            data.sumarPar();
            if (tree.hasLeftChild() && tree.hasRightChild()) {
                data.agregar(tree);
            }
        }
        if (tree.hasLeftChild()) {
            recorrerArbol(tree.getLeftChild(), data);
        }
        if (tree.hasRightChild()) {
            recorrerArbol(tree.getRightChild(), data);
        }
    }
}
