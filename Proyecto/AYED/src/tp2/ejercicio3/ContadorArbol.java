/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.ejercicio3;

import java.util.LinkedList;
import java.util.List;
import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author Fran
 */
public class ContadorArbol {

    private BinaryTree<Integer> arbol;

    public ContadorArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public List<Integer> numerosParesPostOrden() {
        List<Integer> listaPares = new LinkedList<>();
        if (arbol != null) {
            this.crearListaPostOrden(listaPares, arbol);
        }
        return listaPares;
    }

    public List<Integer> numerosParesInOrden() {
        List<Integer> listaPares = new LinkedList<>();
        if (arbol != null) {
            this.crearListaInOrden(listaPares, arbol);
        }
        return listaPares;
    }
// Post orden (hi,hd, raiz)

    private List<Integer> crearListaPostOrden(List<Integer> listaPares, BinaryTree<Integer> nodo) {
        if (nodo.hasLeftChild()) {
            this.crearListaPostOrden(listaPares, nodo.getLeftChild());
        }
        if (nodo.hasRightChild()) {
            this.crearListaPostOrden(listaPares, nodo.getRightChild());
        }
        if (nodo.getData() % 2 == 0) {
            listaPares.add(nodo.getData());
        }

        return listaPares;
    }

    private List<Integer> crearListaInOrden(List<Integer> listaPares, BinaryTree<Integer> nodo) {
        if (nodo.hasLeftChild()) {
            this.crearListaInOrden(listaPares, nodo.getLeftChild());
        }
        if (nodo.getData() % 2 == 0) {
            listaPares.add(nodo.getData());
        }
        if (nodo.hasRightChild()) {
            this.crearListaInOrden(listaPares, nodo.getRightChild());
        }

        return listaPares;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> raiz = new BinaryTree<>(14);
        BinaryTree<Integer> n5 = new BinaryTree<>(5);
        BinaryTree<Integer> n15 = new BinaryTree<>(15);
        raiz.addLeftChild(n5);
        raiz.addRightChild(n15);

        BinaryTree<Integer> n3 = new BinaryTree<>(4);
        BinaryTree<Integer> n7 = new BinaryTree<>(7);
        BinaryTree<Integer> n20 = new BinaryTree<>(20);
        n5.addLeftChild(n3);
        n5.addRightChild(n7);
        n15.addRightChild(n20);

        BinaryTree<Integer> n1 = new BinaryTree<>(1);
        BinaryTree<Integer> n18 = new BinaryTree<>(18);
        n3.addLeftChild(n1);
        n20.addLeftChild(n18);
        ContadorArbol c = new ContadorArbol(raiz);
        List<Integer> listaInOrden = c.numerosParesInOrden();
        List<Integer> listaPostOrden = c.numerosParesPostOrden();
        System.out.println("IN ORDEN");
        for (int i = 0; i < listaInOrden.size(); i++) {
            System.out.println(listaInOrden.get(i));
        }
        System.out.println("POST ORDEN");
        for (int i = 0; i < listaPostOrden.size(); i++) {
            System.out.println(listaPostOrden.get(i));
        }

    }

}
