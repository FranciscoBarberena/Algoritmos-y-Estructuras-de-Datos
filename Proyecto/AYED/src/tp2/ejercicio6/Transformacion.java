/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.ejercicio6;

import tp1.ejercicio8.Queue;
import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author Fran
 */
public class Transformacion {

    private BinaryTree<Integer> tree;

    public Transformacion(BinaryTree<Integer> tree) {
        this.tree = tree;
    }

    public BinaryTree<Integer> suma() {

        if ((this.tree != null) && (!this.tree.isEmpty())) {
            this.crearArbol(this.tree);
        } else {
            this.tree = new BinaryTree<>(0);
        }
        return this.tree;
    }

    private int crearArbol(BinaryTree<Integer> arbol) {
        int suma = 0;
        int valor = arbol.getData();
        if (arbol.hasLeftChild()) {
            suma += this.crearArbol(arbol.getLeftChild());
        }
        if (arbol.hasRightChild()) {
            suma += this.crearArbol(arbol.getRightChild());
        }
        arbol.setData(suma);
        return valor + suma;
    }

    public static void main(String[] args) {

        BinaryTree<Integer> raiz = new BinaryTree<>(1);
        BinaryTree<Integer> n5 = new BinaryTree<>(2);
        BinaryTree<Integer> n15 = new BinaryTree<>(3);
        raiz.addLeftChild(n5);
        raiz.addRightChild(n15);

        BinaryTree<Integer> n7 = new BinaryTree<>(4);
        BinaryTree<Integer> n12 = new BinaryTree<>(5);
        BinaryTree<Integer> n20 = new BinaryTree<>(6);

        n5.addRightChild(n7);
        n15.addLeftChild(n12);
        n15.addRightChild(n20);
        
        BinaryTree<Integer> n13 = new BinaryTree<>(7);
        BinaryTree<Integer> n21 = new BinaryTree<>(8);
        n12.addLeftChild(n13);
        n12.addRightChild(n21);
        Queue<BinaryTree<Integer>> cola = new Queue<>();
        cola.enqueue(raiz);
         BinaryTree<Integer> nodoActual;
        int tamano;
        if (raiz != null) {
            while (!cola.isEmpty()) {
                tamano = cola.size();
                for (int i = 0; i < tamano; i++) {
                    nodoActual = cola.dequeue();
                    System.out.print(nodoActual.getData()+"   ");
                    if (nodoActual.hasLeftChild()) {
                        
                        cola.enqueue(nodoActual.getLeftChild());
                    }
                    if (nodoActual.hasRightChild()) {
                        cola.enqueue(nodoActual.getRightChild());
                    }
                }
                System.out.println( );
                System.out.println("--------------------");
            }
        }
        Transformacion t = new Transformacion(raiz);
        BinaryTree<Integer> sumas = t.suma();
        
        System.out.println( );

        cola.enqueue(sumas);
        if (sumas != null) {
            while (!cola.isEmpty()) {
                tamano = cola.size();
                for (int i = 0; i < tamano; i++) {
                    nodoActual = cola.dequeue();
                    System.out.print(nodoActual.getData()+"   ");
                    if (nodoActual.hasLeftChild()) {
                        
                        cola.enqueue(nodoActual.getLeftChild());
                    }
                    if (nodoActual.hasRightChild()) {
                        cola.enqueue(nodoActual.getRightChild());
                    }
                }
                System.out.println( );
                System.out.println("--------------------");
            }
        }
    }
}
