/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.ejercicio9;

import java.util.ArrayList;
import java.util.List;
import tp1.ejercicio8.Queue;
import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author Fran
 */
public class ParcialArboles3 {

    public BinaryTree<ArrayList<Integer>> sumAndDif(BinaryTree<Integer> arbol) {
        int suma = 0;
        int actual = 0;
        BinaryTree<ArrayList<Integer>> aux =null;   
        if ((arbol != null) && (!arbol.isEmpty())){
            aux = calcularArbol(arbol,suma,actual);
        }
        return aux;
      
    }

    private BinaryTree<ArrayList<Integer>> calcularArbol(BinaryTree<Integer> arbol, int suma, int anterior) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(suma + arbol.getData());
        lista.add(arbol.getData() - anterior);
        BinaryTree<ArrayList<Integer>> miNodo = new BinaryTree<>(lista);
        if (arbol.hasLeftChild()){
           
            miNodo.addLeftChild(this.calcularArbol(arbol.getLeftChild(), suma+arbol.getData(), arbol.getData()));
        }
        if (arbol.hasRightChild()){
            miNodo.addRightChild(this.calcularArbol(arbol.getRightChild(), suma+arbol.getData(), arbol.getData()));
        }
        return miNodo;
    }

    public static void main(String[] args) {

        BinaryTree<Integer> raiz = new BinaryTree<>(20);

        BinaryTree<Integer> n5 = new BinaryTree<>(5);
        BinaryTree<Integer> n30 = new BinaryTree<>(30);

        raiz.addLeftChild(n5);
        raiz.addRightChild(n30);

        BinaryTree<Integer> nMenos5 = new BinaryTree<>(-5);
        BinaryTree<Integer> n10 = new BinaryTree<>(10);

        n5.addLeftChild(nMenos5);
        n5.addRightChild(n10);

        BinaryTree<Integer> n50 = new BinaryTree<>(50);
        BinaryTree<Integer> nMenos9 = new BinaryTree<>(-9);

        n30.addLeftChild(n50);
        n30.addRightChild(nMenos9);

        BinaryTree<Integer> n1 = new BinaryTree<>(1);
        BinaryTree<Integer> n4 = new BinaryTree<>(4);

        n10.addLeftChild(n1);   
        n50.addRightChild(n4); 

  
        BinaryTree<Integer> n6 = new BinaryTree<>(6);

        n4.addRightChild(n6);   

        ParcialArboles3 p = new ParcialArboles3();
        BinaryTree<ArrayList<Integer>> nuevoArbol = p.sumAndDif(raiz);
        Queue<BinaryTree<ArrayList<Integer>>> cola = new Queue<>();
        cola.enqueue(nuevoArbol);
        int tamano;
        int suma = 0;
        int prof = 0;
        BinaryTree<ArrayList<Integer>> nodoActual;
        if ((nuevoArbol != null) && (!nuevoArbol.isEmpty())) {
            while ((!cola.isEmpty())) {
                tamano = cola.size();
                for (int i = 0; i < tamano; i++) {
                    nodoActual = cola.dequeue();

                    if (nodoActual.hasLeftChild()) {
                        cola.enqueue(nodoActual.getLeftChild());
                    }
                    if (nodoActual.hasRightChild()) {
                        cola.enqueue(nodoActual.getRightChild());
                    }
                    System.out.print(nodoActual.getData()+" ");

                }
                System.out.println();
                prof += 1;
            }
        } else System.out.println("El arbol esta vacio o es nulo");
    }
}
