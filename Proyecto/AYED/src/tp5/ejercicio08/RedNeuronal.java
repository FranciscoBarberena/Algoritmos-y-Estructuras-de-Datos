/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ejercicio08;

import java.util.List;
import tp1.ejercicio8.Queue;
import tp5.ejercicio01.*;

/**
 *
 * @author Fran
 */
public class RedNeuronal {

    public int neuronasActivadas(Graph<String> grafo, String inicio, int impulso) {
        int cantidadDeNeuronasActivadas = 0;
        Vertex<String> verticeInicial = grafo.search(inicio);
        if (verticeInicial != null) {
            boolean[] marca = new boolean[grafo.getSize()];
            cantidadDeNeuronasActivadas = recorrerRed(grafo, verticeInicial, marca, impulso);
        }
        return cantidadDeNeuronasActivadas;
    }

    private int recorrerRed(Graph<String> grafo, Vertex<String> verticeInicial, boolean[] marca, int impulso) {
        int cantidadDeNeuronas = 1;
        Queue<Vertex<String>> cola = new Queue();
        cola.enqueue(verticeInicial);
        marca[verticeInicial.getPosition()] = true;
        while (!cola.isEmpty()) {
            int tamano = cola.size();
            impulso = (impulso * 9) / 10;
            for (int i = 0; i < tamano; i++) {
                Vertex<String> v = cola.dequeue();
                List<Edge<String>> aristas = grafo.getEdges(v);
                for (Edge<String> a : aristas) {
                    int peso = a.getWeight();
                    Vertex<String> vDestino = a.getTarget();
                    int posDestino = vDestino.getPosition();
                    if (peso >= impulso && !marca[posDestino]) {
                        cola.enqueue(vDestino);
                        marca[posDestino] = true;
                        cantidadDeNeuronas += 1;
                    }
                }
            }
        }
        return cantidadDeNeuronas;
    }
}
