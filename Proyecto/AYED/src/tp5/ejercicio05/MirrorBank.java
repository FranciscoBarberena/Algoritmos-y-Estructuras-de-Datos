/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ejercicio05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tp1.ejercicio8.Queue;
import tp5.ejercicio01.*;

/**
 *
 * @author Fran
 */
public class MirrorBank {

    public List<Persona> encontrarListaJubilados(Graph<Persona> grafo, Persona empleadoInicial, int gradoDeSeparacion) {
        int tamano = grafo.getSize();
        boolean[] marca = new boolean[tamano];
        List<Persona> listaJubilados = new ArrayList<>();
        Vertex<Persona> verticeDePartida = grafo.search(empleadoInicial);
        if (verticeDePartida != null)
             bfsEncontrarListaJubilados(grafo, verticeDePartida, marca, gradoDeSeparacion, listaJubilados);
        return listaJubilados;

    }

    private void bfsEncontrarListaJubilados(Graph<Persona> grafo, Vertex<Persona> verticeDePartida, boolean[] marca, int gradoDeSeparacion, List<Persona> listaJubilados) {
        Queue<Vertex<Persona>> q = new Queue<>();
        q.enqueue(verticeDePartida);
        int pos = verticeDePartida.getPosition();
        marca[pos] = true;
        boolean termine = false;
        int separacionActual = 0;
        while (!termine && !q.isEmpty() && separacionActual < gradoDeSeparacion) {
            int cantidadDeNodos = q.size();
            for (int i = 0; i < cantidadDeNodos; i++) {
                Vertex<Persona> w = q.dequeue();
                List<Edge<Persona>> adyacentes = grafo.getEdges(w);
                if (listaJubilados.size() < 40) {
                    Persona dato = w.getData();
                    if (dato.isJubilado()) {
                        listaJubilados.add(dato);
                    }
                    if (separacionActual < gradoDeSeparacion - 1) {
                        for (Edge<Persona> e : adyacentes) {
                            int j = e.getTarget().getPosition();
                            if (!marca[j]) {
                                marca[j] = true;
                                q.enqueue(e.getTarget());
                            }
                        }
                    }
                } else {
                    termine = true;
                }
            }
            separacionActual += 1;
        }
    }
}
