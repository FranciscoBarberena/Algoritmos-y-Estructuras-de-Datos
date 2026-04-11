package tp2.ejercicio7;

import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author Fran
 */
public class ParcialArboles {

    private BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public boolean isLeftTree(int num) {
        BinaryTree<Integer> nodoNum;
        int nodosIzq = -1;
        int nodosDer = -1;
        if ((!(this.arbol == null) && (!this.arbol.isEmpty()))) {
            nodoNum = this.encontrarNum(this.arbol, num);
            if ((nodoNum != null) && (nodoNum.hasLeftChild())) {
                nodosIzq = this.contarNodos(nodoNum.getLeftChild());
                if (nodoNum.hasRightChild()) {
                    nodosDer = this.contarNodos(nodoNum.getRightChild());

                }
            }
        }
        return (nodosIzq > nodosDer);
    }

    private BinaryTree<Integer> encontrarNum(BinaryTree<Integer> tree, int num) {
        BinaryTree<Integer> arbolNum = null;
        if (tree.getData() == num) {
            arbolNum = tree;
        } else {
            if (tree.hasLeftChild()) {
                arbolNum = this.encontrarNum(tree.getLeftChild(), num);
            }
            if (arbolNum == null) {
                if (tree.hasRightChild()) {
                    arbolNum = this.encontrarNum(tree.getRightChild(), num);
                }
            }
        }
        if ((arbolNum != null) && (arbolNum.getData() == num)) {
            return arbolNum;

        } else {
            return null;
        }
    }

    private int contarNodos(BinaryTree<Integer> nodoNum) {
        int nodosIzq = 0;
        if (nodoNum.hasLeftChild()) {
            nodosIzq += this.contarNodos(nodoNum.getLeftChild());
        }
        if (nodoNum.hasRightChild()) {
            nodosIzq += this.contarNodos(nodoNum.getRightChild());
        }
        if ((nodoNum.hasLeftChild()) && (!nodoNum.hasRightChild())) {
            return nodosIzq + 1;
        } else if ((!nodoNum.hasLeftChild()) && (nodoNum.hasRightChild())) {
            return nodosIzq + 1;
        } else {
            return nodosIzq + 0;
        }
    }

    public static void main(String[] args) {
        //Crea arbol de ejemplo de la practica
        BinaryTree<Integer> raiz = new BinaryTree<>(2);

        BinaryTree<Integer> n7 = new BinaryTree<>(7);
        BinaryTree<Integer> nMenos5 = new BinaryTree<>(-5);

        raiz.addLeftChild(n7);
        raiz.addRightChild(nMenos5);

        BinaryTree<Integer> n23 = new BinaryTree<>(23);
        BinaryTree<Integer> n6 = new BinaryTree<>(6);
        BinaryTree<Integer> n19 = new BinaryTree<>(19);

        n7.addLeftChild(n23);
        n7.addRightChild(n6);
        nMenos5.addLeftChild(n19);

        BinaryTree<Integer> nMenos3 = new BinaryTree<>(-3);
        BinaryTree<Integer> n55 = new BinaryTree<>(55);
        BinaryTree<Integer> n11 = new BinaryTree<>(11);
        BinaryTree<Integer> n4 = new BinaryTree<>(4);

        n23.addLeftChild(nMenos3);
        n6.addLeftChild(n55);
        n6.addRightChild(n11);
        n19.addRightChild(n4);

        BinaryTree<Integer> n18 = new BinaryTree<>(18);

        n4.addLeftChild(n18);
        ParcialArboles p = new ParcialArboles(raiz);
        System.out.println(p.isLeftTree(7));
        System.out.println(p.isLeftTree(2));
        System.out.println(p.isLeftTree(-5));
        System.out.println(p.isLeftTree(19));
        System.out.println(p.isLeftTree(-3));

    }
}
