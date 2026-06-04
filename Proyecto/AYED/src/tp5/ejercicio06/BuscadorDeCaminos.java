/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ejercicio06;

import java.util.ArrayList;
import java.util.List;
import tp5.ejercicio01.*;

/**
 *
 * @author Fran
 */
public class BuscadorDeCaminos {

    private Graph<String> bosque;
    private final String puntoDePartida = "Casa Caperucita";
    private final String puntoDestino = "Casa Abuelita";

    public BuscadorDeCaminos(Graph<String> bosque) {
        this.bosque = bosque;
    }

    public List<List<String>> recorridosMasSeguro() {
        Vertex<String> verticeInicial = bosque.search(puntoDePartida);
        Vertex<String> verticeDestino = bosque.search(puntoDestino);
        List<List<String>> todosLosRecorridos = new ArrayList<>();
        if (verticeInicial != null && verticeDestino != null){
            boolean [] marca = new boolean [bosque.getSize()];
            buscarRecorridos(bosque,verticeInicial,marca,todosLosRecorridos,new ArrayList<String>());
        }
        return todosLosRecorridos;
    }

    private void buscarRecorridos(Graph<String> bosque, Vertex<String> verticeInicial, boolean[] marca, List<List<String>> todosLosRecorridos, 
            List<String> recorridoActual) {
        String data = verticeInicial.getData();
        int pos = verticeInicial.getPosition();
        marca[pos] = true;
        recorridoActual.add(data);
        if (data.equals(puntoDestino)){
            todosLosRecorridos.add(new ArrayList<>(recorridoActual));
        } else {
            List<Edge<String>> aristas = bosque.getEdges(verticeInicial);
            for (Edge<String> a : aristas){
                int frutasEnSendero = a.getWeight();
                Vertex<String> destino = a.getTarget();
                int posSiguiente = destino.getPosition();
                if (frutasEnSendero < 5 && !marca[posSiguiente]){
                    buscarRecorridos(bosque,destino, marca, todosLosRecorridos, recorridoActual);
                }
            }
        }
        recorridoActual.remove(recorridoActual.size() - 1);
        marca[pos] = false;
    }
}
