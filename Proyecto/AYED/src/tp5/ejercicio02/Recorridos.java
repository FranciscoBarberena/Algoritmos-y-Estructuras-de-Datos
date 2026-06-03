/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ejercicio02;

import java.util.ArrayList;
import java.util.List;
import tp1.ejercicio8.Queue;
import tp5.ejercicio01.Edge;
import tp5.ejercicio01.Graph;
import tp5.ejercicio01.Vertex;

/**
 *
 * @author Fran
 */
public class Recorridos<T> {

    public List<T> dfs(Graph<T> grafo) {
        List<T> lista = new ArrayList<>();
        boolean[] marca = new boolean[grafo.getSize()]; //Marca todos como no visitados
        for (int i = 0; i < grafo.getSize(); i++) { //Para todos los no visitados, llama el dfs auxiliar (necesito probar todos por si el grafo no es conexo)
            if (!marca[i]) {
                dfs(i, grafo, marca, lista);
            }
        }
        return lista;
    }

    private void dfs(int i, Graph<T> grafo, boolean[] marca, List<T> lista) {
        marca[i] = true; //Marco como visitado el inicio
        Vertex<T> v = grafo.getVertex(i);
        lista.add(v.getData());
        List<Edge<T>> adyacentes = grafo.getEdges(v);
        for (Edge<T> e : adyacentes) { //Recorro todos los adyacentes
            int j = e.getTarget().getPosition();
            if (!marca[j]) {
                dfs(j, grafo, marca, lista); //Para los adyacentes no visitados, llamo dfs. 
            }
        } //Resultado de este algoritmo: Todos los vertices alcanzables desde el nodo inicial van a haber sido visitados.
    }

    public List<T> bfs(Graph<T> grafo) {
        boolean[] marca = new boolean[grafo.getSize()];
        List<T> lista = new ArrayList<>();
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!marca[i]) {
                this.bfs(i, grafo, marca,lista);
            }
        }
        return lista;
    }

    private void bfs(int i, Graph<T> grafo, boolean[] marca, List<T> lista) {
        Queue<Vertex<T>> q = new Queue<>();
        q.enqueue(grafo.getVertex(i));
        marca[i] = true; //Todos los vertices que encolo, los marco como visitados
        while (!q.isEmpty()) {
            Vertex<T> w = q.dequeue(); 
            lista.add(w.getData()); //Proceso que saco de la cola
            List<Edge<T>> adyacentes = grafo.getEdges(w);
            for (Edge<T> e : adyacentes) { //Encolo todos los adyacentes y los marco como visitados
                int j = e.getTarget().getPosition();
                if (!marca[j]) {
                    marca[j] = true;
                    q.enqueue(e.getTarget());
                }
            }
        }
    }

}
