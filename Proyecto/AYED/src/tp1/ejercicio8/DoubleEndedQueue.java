/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.ejercicio8;

/**
 *
 * @author Alejandra
 * @param <T>
 */
public class DoubleEndedQueue<T> extends Queue<T> {

    public void enqueueFirst(T data) {
        this.data.add(0, data);
    }

    public static void main(String[] args) {
        DoubleEndedQueue<Integer> q = new DoubleEndedQueue<>();
        System.out.println("----- AGREGANDO AL PRINCIPIO -----");
        for (int i = 0; i < 4; i++) {
            q.enqueueFirst(i);
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
