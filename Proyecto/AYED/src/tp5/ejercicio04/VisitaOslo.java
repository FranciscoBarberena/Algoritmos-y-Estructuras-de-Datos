/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ejercicio04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tp5.ejercicio01.*;

/**
 *
 * @author Fran
 */
public class VisitaOslo {

    private final String puntoDePartida = "Ayuntamiento";

    public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos) {
        Vertex<String> verticeInicial = lugares.search(puntoDePartida);
        Vertex<String> verticeFinal = lugares.search(destino);
        List<String> caminoFinal = new ArrayList<>();
        if (verticeInicial != null && verticeFinal != null && !lugaresRestringidos.contains(puntoDePartida)) {
            boolean[] marca = new boolean[lugares.getSize()];
            buscarCaminoCondicion(verticeInicial, marca, lugares, destino, maxTiempo, lugaresRestringidos, new ArrayList<String>(),caminoFinal);
        }
        return caminoFinal;
    }

    private boolean buscarCaminoCondicion(Vertex<String> verticeInicial, boolean[] marca, Graph<String> lugares, String destino, 
            int tiempoRestante, List<String> lugaresRestringidos, List<String> caminoEncontrado,List<String> caminoFinal) {
        boolean encontre = false;
        int pos = verticeInicial.getPosition();
        String data = verticeInicial.getData();
        caminoEncontrado.add(data);
        marca[pos] = true;
        if (data.equals(destino)) {
            encontre = true;
            caminoFinal.addAll(caminoEncontrado);
        } else {
            List<Edge<String>> edges = lugares.getEdges(verticeInicial);
            Iterator<Edge<String>> it = edges.iterator();
            while (it.hasNext() && !encontre) {
                Edge<String> caminoAlSiguiente = it.next();
                int tiempoNecesario = caminoAlSiguiente.getWeight();
                Vertex<String> siguiente = caminoAlSiguiente.getTarget();
                int posSiguiente = siguiente.getPosition();
                if (!marca[posSiguiente] && tiempoRestante - tiempoNecesario > 0 && !lugaresRestringidos.contains(siguiente.getData())) {
                    encontre = buscarCaminoCondicion(siguiente,marca,lugares,destino,tiempoRestante-tiempoNecesario,lugaresRestringidos,caminoEncontrado,caminoFinal);
                }
            }
        }
        if (!encontre){
            caminoEncontrado.remove(caminoEncontrado.size() - 1);
            marca[pos] = false;
        }
        
        return encontre;
    }
}
