/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.ejercicio8;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Alejandra
 * @param <T>
 */
public class Queue<T> extends Sequence {

    protected List<T> data;

    public Queue() {
        this.data = new LinkedList<>();
    }

    public void enqueue(T dato) {
        data.add(dato);
    }

    public T dequeue() {
        T elem = this.head();
        data.remove(elem);
        return elem;
    }

    public T head() {
        return data.get(0);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public String toString() {
        String aux = "Cabeza de cola ";
        for (int i = 0; i < this.size(); i++) {
            aux += data.get(i) + " - ";
        }
        aux += "Fin de la cola";
        return aux;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        System.out.println("----- AGREGANDO -----");
        for (int i = 0; i < 4; i++) {
            q.enqueue(i);
            System.out.println(q.toString());
        }
        int tamaño = q.size();
        System.out.println("\n----- Borrando -----");
        for (int i = 0; i < tamaño; i++) {
            System.out.println(q.toString());
            q.dequeue();

        }
    }

}
