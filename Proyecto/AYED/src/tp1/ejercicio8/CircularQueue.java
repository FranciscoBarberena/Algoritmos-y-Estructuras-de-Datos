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
public class CircularQueue<T> extends Queue<T>{
    public T shift(){
        T rotator = this.dequeue();
        this.enqueue(rotator);
        return rotator;
    }
    public static void main(String[] args) {
        CircularQueue<Integer> q = new CircularQueue<>();
        System.out.println("----- AGREGANDO -----");
        for (int i = 0; i < 4; i++) {
            q.enqueue(i);
            System.out.println(q.toString());
        }
        int tamaño = q.size();
        System.out.println("\n----- Borrando circularmente -----");
        for (int i = 0; i < tamaño+1; i++) {
            System.out.println(q.toString());
            q.shift();

        }
    }
}
