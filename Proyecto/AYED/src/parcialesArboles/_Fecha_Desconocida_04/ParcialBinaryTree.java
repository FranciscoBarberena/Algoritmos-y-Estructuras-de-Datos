    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesArboles._Fecha_Desconocida_04;

/**
 *
 * @author Fran
 * @param <T>
 */
public class ParcialBinaryTree<T> {
    
    // Variables de instancia propias de la clase BinaryTree (en papel creo que no haría falta escribirlas)
    
    private T data;
    private ParcialBinaryTree<T> leftChild;
    private ParcialBinaryTree<T> rightChild;
    
    // Resolución en papel
    
    public Personaje princesaAccesible() {
        Personaje dato = (Personaje) this.getData(); 
        if (dato == null || dato.esDragon()) {
            return null;
        }
        if (dato.esPrincesa()) {
            return dato;
        }
        Personaje personajeEncontrado = null;
        if (this.hasLeftChild()) {
            personajeEncontrado = this.getLeftChild().princesaAccesible();
        }
        if (personajeEncontrado == null && this.hasRightChild()) {
            personajeEncontrado = this.getRightChild().princesaAccesible();
        }
        return personajeEncontrado;
    }
    
    // Métodos propios de la clase BinaryTree (en papel creo que no haría falta escribirlos)

    public ParcialBinaryTree() {
        super();
    }

    public ParcialBinaryTree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public ParcialBinaryTree<T> getLeftChild() {
        return leftChild;
    }
    public ParcialBinaryTree<T> getRightChild() {
        return this.rightChild;
    }

    public void addLeftChild(ParcialBinaryTree<T> child) {
        this.leftChild = child;
    }

    public void addRightChild(ParcialBinaryTree<T> child) {
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
}
