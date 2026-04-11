package tp2.ejercicio5;

import tp1.ejercicio8.Queue;
import tp2.ejercicio1.BinaryTree;

public class ProfundidadDeArbolBinario {

    private BinaryTree<Integer> arbol;

    public int sumaElementosProfundidad(int p) {
        Queue<BinaryTree<Integer>> cola = new Queue<>();
        cola.enqueue(this.arbol);
        int tamano;
        int suma = 0;
        int prof = 0;
        BinaryTree<Integer> nodoActual;
        if (this.arbol != null) {
            while ((!cola.isEmpty()) && (prof <= p)) {
                tamano = cola.size();
                for (int i = 0; i < tamano; i++) {
                    nodoActual = cola.dequeue();
                    if (prof == p) {
                        suma += nodoActual.getData();
                    } else {
                        if (nodoActual.hasLeftChild()) {
                            cola.enqueue(nodoActual.getLeftChild());
                        }
                        if (nodoActual.hasRightChild()) {
                            cola.enqueue(nodoActual.getRightChild());
                        }
                    }
                }
                prof += 1;
            }
        }
        return suma;
    }

    public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
        super();
        this.arbol = arbol;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> raiz = new BinaryTree<>(10);
        BinaryTree<Integer> n5 = new BinaryTree<>(5);
        BinaryTree<Integer> n15 = new BinaryTree<>(15);
        raiz.addLeftChild(n5);
        raiz.addRightChild(n15);
        BinaryTree<Integer> n2 = new BinaryTree<>(2);
        BinaryTree<Integer> n7 = new BinaryTree<>(7);
        BinaryTree<Integer> n12 = new BinaryTree<>(12);
        BinaryTree<Integer> n20 = new BinaryTree<>(20);
        n5.addLeftChild(n2);
        n5.addRightChild(n7);
        n15.addLeftChild(n12);
        n15.addRightChild(n20);
        ProfundidadDeArbolBinario g = new ProfundidadDeArbolBinario(raiz);
        System.out.println(g.sumaElementosProfundidad(2));
    }

}
