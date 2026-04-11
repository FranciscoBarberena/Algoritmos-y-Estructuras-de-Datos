package tp2.ejercicio1;

import tp1.ejercicio8.Queue;

public class BinaryTree<T> {

    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;

    public BinaryTree() {
        super();
    }

    public BinaryTree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * Preguntar antes de invocar si hasLeftChild()
     *
     * @return
     */
    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }

    /**
     * Preguntar antes de invocar si hasRightChild()
     *
     * @return
     */
    public BinaryTree<T> getRightChild() {
        return this.rightChild;
    }

    public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;
    }

    public void removeLeftChild() {
        this.leftChild = null;
    }

    public void removeRightChild() {
        this.rightChild = null;
    }

    public boolean isEmpty() {
        return (this.isLeaf() && this.getData() == null);
    }

    public boolean isLeaf() {
        return (!this.hasLeftChild() && !this.hasRightChild());

    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    @Override
    public String toString() {
        return this.getData().toString();
    }

    public int contarHojas() {
        if (this.isLeaf()) {
            return 1;
        }
        int hojasIzquierda = 0;
        int hojasDerecha = 0;

        if (this.hasLeftChild()) {
            hojasIzquierda = this.getLeftChild().contarHojas();
        }

        if (this.hasRightChild()) {
            hojasDerecha = this.getRightChild().contarHojas();
        }
        return hojasIzquierda + hojasDerecha;
    }

    public BinaryTree<T> espejo() {
        BinaryTree<T> mirrorTree = new BinaryTree<>(this.getData());

        if (this.isLeaf()) {
            return mirrorTree;
        }
        if (this.hasLeftChild()) {
            mirrorTree.addRightChild(this.getLeftChild().espejo());
        }

        if (this.hasRightChild()) {
            mirrorTree.addLeftChild(this.getRightChild().espejo());
        }
        return mirrorTree;

    }

    // 0<=n<=m
    public void entreNiveles(int n, int m) {
        Queue<BinaryTree<T>> cola = new Queue<>();
        cola.enqueue(this);
        int nivelActual = 0;
        int tamano;
        BinaryTree<T> nodoActual = new BinaryTree<>();
        while ((!cola.isEmpty()) && (nivelActual <= m)) {
            tamano = cola.size();
            if (nivelActual >= n) {
                System.out.println("NIVEL " + nivelActual);
                for (int i = 0; i < tamano; i++) {
                    nodoActual = cola.dequeue();
                    System.out.print(nodoActual.getData() + " ");
                    if (nodoActual.hasLeftChild()) {
                        cola.enqueue(nodoActual.getLeftChild());
                    }
                    if (nodoActual.hasRightChild()) {
                        cola.enqueue(nodoActual.getRightChild());
                    }
                }
                System.out.println();
            } else {
                for (int i = 0; i < tamano; i++) {
                    nodoActual = cola.dequeue();
                    if (nodoActual.hasLeftChild()) {
                        cola.enqueue(nodoActual.getLeftChild());
                    }
                    if (nodoActual.hasRightChild()) {
                        cola.enqueue(nodoActual.getRightChild());
                    }
                }
            }
            nivelActual += 1;

        }

    }

    public static void main(String[] args) {
        BinaryTree<Integer> raiz = new BinaryTree<>(10);
        raiz.addLeftChild(new BinaryTree<>(10));
        raiz.addRightChild(new BinaryTree<>(20));
        raiz.getLeftChild().addRightChild(new BinaryTree<>(100));
        BinaryTree<Integer> mirrorTree = raiz.espejo();
        System.out.println(raiz.toString());
        System.out.println(raiz.getLeftChild().toString());
        System.out.println(raiz.getLeftChild().getRightChild().toString());
        System.out.println(raiz.getRightChild().toString());
        System.out.println(mirrorTree.toString());
        System.out.println(mirrorTree.getLeftChild().toString());
        System.out.println(mirrorTree.getRightChild().toString());
        System.out.println(mirrorTree.getRightChild().getLeftChild().toString());

        BinaryTree<Integer> n5 = new BinaryTree<>(5);
        BinaryTree<Integer> n15 = new BinaryTree<>(15);
        raiz.addLeftChild(n5);
        raiz.addRightChild(n15);

        BinaryTree<Integer> n3 = new BinaryTree<>(3);
        BinaryTree<Integer> n7 = new BinaryTree<>(7);
        BinaryTree<Integer> n20 = new BinaryTree<>(20);
        n5.addLeftChild(n3);
        n5.addRightChild(n7);
        n15.addRightChild(n20);

        BinaryTree<Integer> n1 = new BinaryTree<>(1);
        BinaryTree<Integer> n18 = new BinaryTree<>(18);
        n3.addLeftChild(n1);
        n20.addLeftChild(n18);
        raiz.entreNiveles(2, 3);
    }

}
