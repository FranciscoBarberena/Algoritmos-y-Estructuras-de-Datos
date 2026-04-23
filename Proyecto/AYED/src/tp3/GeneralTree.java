package tp3;

import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio8.Queue;

public class GeneralTree<T> {

    private T data;
    private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

    public GeneralTree() {

    }

    public GeneralTree(T data) {
        this.data = data;
    }

    public GeneralTree(T data, List<GeneralTree<T>> children) {
        this(data);
        this.children = children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<GeneralTree<T>> getChildren() {
        return this.children;
    }

    public void setChildren(List<GeneralTree<T>> children) {
        if (children != null) {
            this.children = children;
        }
    }

    public void addChild(GeneralTree<T> child) {
        this.getChildren().add(child);
    }

    public boolean isLeaf() {
        return !this.hasChildren();
    }

    public boolean hasChildren() {
        return !this.children.isEmpty();
    }

    public boolean isEmpty() {
        return this.data == null && !this.hasChildren();
    }

    public void removeChild(GeneralTree<T> child) {
        if (this.hasChildren()) {
            children.remove(child);
        }
    }

    public int altura() {
        int altura = 0;
        if (!this.isEmpty()) {
            altura = calcularAltura();
        }
        return altura;
    }

    private int calcularAltura() {
        int max = -1;
        List<GeneralTree<T>> children = this.getChildren();
        for (GeneralTree<T> child : children) {
            int altura = child.calcularAltura();
            if (altura > max) {
                max = altura;
            }
        }
        return 1 + max;
    }

    public int nivel(T dato) {
        int nivelInicial = -1;
        if (!this.isEmpty()) {
            nivelInicial = this.calcularNivel(dato, 0);
        }
        return nivelInicial;
    }

    private int calcularNivel(T dato, int nivelActual) {
        if (this.getData().equals(dato)) {
            return nivelActual;
        }
        List<GeneralTree<T>> children = this.getChildren();
        for (GeneralTree<T> child : children) {
            int nivelEncontrado = child.calcularNivel(dato, nivelActual + 1);
            if (nivelEncontrado != -1) {
                return nivelEncontrado;
            }
        }
        return -1;

    }

    public int ancho() {
        int maxAncho = 0;
        if (!this.isEmpty()) {
            Queue<GeneralTree<T>> cola = new Queue<>();
            cola.enqueue(this);
            while (!cola.isEmpty()) {
                int tamano = cola.size();
                if (tamano > maxAncho) {
                    maxAncho = tamano;
                }
                for (int i = 0; i < tamano; i++) {
                    GeneralTree<T> hijoActual = cola.dequeue();
                    List<GeneralTree<T>> children = hijoActual.getChildren();
                    for (GeneralTree<T> child : children) {
                        cola.enqueue(child);
                    }
                }
            }
        }
        return maxAncho;
    }

    public boolean esAncestro(T a, T b) {
        boolean encontre = false;
        if (this.getData().equals(a)){
            return !this.search(b).isEmpty();
        }
        int i = 0;
        List<GeneralTree<T>> children = this.getChildren();
        while((!encontre) && (i<children.size())){
            encontre = children.get(i).esAncestro(a,b);
            i++;
        }
        return encontre;

    }

    private GeneralTree<T> search(T a) {
        if (this.getData().equals(a)) {
            return this;
        }
        List<GeneralTree<T>> children = this.getChildren();
        for (GeneralTree<T> child : children) {
            GeneralTree<T> foundTree = child.search(a);
            if (!foundTree.isEmpty()) {
                return foundTree;
            }
        }
        return new GeneralTree<>();
    }

}
