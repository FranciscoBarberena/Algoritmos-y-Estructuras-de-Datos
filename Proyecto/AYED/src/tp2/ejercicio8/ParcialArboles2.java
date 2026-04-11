/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.ejercicio8;

import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author Fran
 */
public class ParcialArboles2 {

    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        boolean aux;
        if ((arbol1 == null) || (arbol1.isEmpty())) {
            aux = true;
        } else if ((arbol2 == null) || (arbol2.isEmpty())) {
            aux = false;
        } else {
            aux = this.compararNodos(arbol1, arbol2);
        }
        return aux;
    }

    private boolean compararNodos(BinaryTree<Integer> a1, BinaryTree<Integer> a2) {
        boolean aux = true;
        if (!(a1.getData().equals(a2.getData())) || (a1.hasLeftChild() && (!a2.hasLeftChild())) || ((a1.hasRightChild()
                && (!a2.hasRightChild())))) {
            aux = false;
        } else {

            if ((a1.hasLeftChild()) && (a2.hasLeftChild())) {
                aux = this.compararNodos(a1.getLeftChild(), a2.getLeftChild());
            }
            if ((a1.hasRightChild()) && (a2.hasRightChild()) && (aux)) {
                aux = this.compararNodos(a1.getRightChild(), a2.getRightChild());

            }

        }
        return aux;
    }

    public static void main(String[] args) {
        //Crea arboles que son prefijos como en la imagen del TP
        // ARBOL 1
        BinaryTree<Integer> arbol1 = new BinaryTree<>(65);
        BinaryTree<Integer> a1_37 = new BinaryTree<>(37);
        BinaryTree<Integer> a1_81 = new BinaryTree<>(81);
        arbol1.addLeftChild(a1_37);
        arbol1.addRightChild(a1_81);
        BinaryTree<Integer> a1_47 = new BinaryTree<>(47);
        BinaryTree<Integer> a1_93 = new BinaryTree<>(93);
        a1_37.addRightChild(a1_47);
        a1_81.addRightChild(a1_93);

        // ÁRBOL 2
        BinaryTree<Integer> arbol2 = new BinaryTree<>(65);
        BinaryTree<Integer> a2_37 = new BinaryTree<>(37);
        BinaryTree<Integer> a2_81 = new BinaryTree<>(81);
        arbol2.addLeftChild(a2_37);
        arbol2.addRightChild(a2_81);
        BinaryTree<Integer> a2_22 = new BinaryTree<>(22);
        BinaryTree<Integer> a2_47 = new BinaryTree<>(47);
        BinaryTree<Integer> a2_76 = new BinaryTree<>(76);
        BinaryTree<Integer> a2_93 = new BinaryTree<>(93);
        a2_37.addLeftChild(a2_22);
        a2_37.addRightChild(a2_47);
        a2_81.addLeftChild(a2_76);
        a2_81.addRightChild(a2_93);
        BinaryTree<Integer> a2_11 = new BinaryTree<>(11);
        BinaryTree<Integer> a2_29 = new BinaryTree<>(29);
        BinaryTree<Integer> a2_85 = new BinaryTree<>(85);
        BinaryTree<Integer> a2_94 = new BinaryTree<>(94);
        a2_22.addLeftChild(a2_11);
        a2_22.addRightChild(a2_29);
        a2_93.addLeftChild(a2_85);
        a2_93.addRightChild(a2_94);

        ParcialArboles2 p = new ParcialArboles2();
        System.out.println("--------------------------------");
        if (p.esPrefijo(arbol1, arbol2)) {
            System.out.println("Arbol 1 ES prefijo de arbol 2");
        } else {
            System.out.println("Arbol 1 NO ES prefijo de arbol 2");
        }
        System.out.println("--------------------------------");

    }
}
