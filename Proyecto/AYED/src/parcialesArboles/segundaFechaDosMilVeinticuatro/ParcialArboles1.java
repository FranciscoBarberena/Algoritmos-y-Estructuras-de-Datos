/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesArboles.segundaFechaDosMilVeinticuatro;

import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author Fran
 */
public class ParcialArboles1 {
    // Es la 2da fecha del parcial de 2024, tema 1 29/6/2024   
    BinaryTree<Integer> arbol;
    public BinaryTree<Integer> nuevoTree(){
        BinaryTree<Integer> nuevoArbol = new BinaryTree<>();
        if ((arbol != null) && (!arbol.isEmpty()))
            crearArbol(arbol,nuevoArbol,0,false);
        return nuevoArbol;
    }

    private void crearArbol(BinaryTree<Integer> tree, BinaryTree<Integer> newTree, int valorPadre, boolean soyIzq) {
        if (soyIzq)
            newTree.setData(valorPadre + tree.getData());
        else newTree.setData(tree.getData());
        if (tree.hasLeftChild()){
            BinaryTree<Integer> nuevoNodoIzq = new BinaryTree<>();
            newTree.addLeftChild(nuevoNodoIzq);
            crearArbol(tree.getLeftChild(),newTree.getLeftChild(),tree.getData(),true);
        }
        if (tree.hasRightChild()){
            BinaryTree<Integer> nuevoNodoDer = new BinaryTree<>();
            newTree.addRightChild(nuevoNodoDer);
            crearArbol(tree.getRightChild(),newTree.getRightChild(),tree.getData(),false);
        }
    }
}   
