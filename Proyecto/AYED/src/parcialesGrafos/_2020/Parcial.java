/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesGrafos._2020;

import java.util.List;
import tp5.ejercicio01.*;

/**
 *
 * @author Fran
 */
public class Parcial {

    public int resolver(Graph<Ciudad> ciudades, String origen, String destino, int maxControles) {
        int maxTiempo = 0;
        Ciudad aux = new Ciudad(origen, 0);
        Ciudad aux2 = new Ciudad(destino, 0);
        
        Vertex<Ciudad> vInicial = ciudades.search(aux);
        Vertex<Ciudad> vFinal = ciudades.search(aux2);
        
        if (vInicial != null && vFinal != null) {
            boolean[] marca = new boolean[ciudades.getSize()];
            maxTiempo = buscarMaxTiempo(ciudades, vInicial, vFinal, maxControles, marca);
        }
        
        return maxTiempo;
    }
    
    private int buscarMaxTiempo(Graph<Ciudad> ciudades, Vertex<Ciudad> vActual, Vertex<Ciudad> vFinal, int maxControles, boolean[] marca) {
        int ret;
        int pos = vActual.getPosition();
        marca[pos] = true;
        if (vActual == vFinal) {
            ret = vActual.getData().getTransito();
        } else {
            int maxTiempo = 0;
            List<Edge<Ciudad>> ady = ciudades.getEdges(vActual);
            for (Edge<Ciudad> a : ady) {
                Vertex<Ciudad> vSig = a.getTarget();
                int controles = a.getWeight();
                if (!marca[vSig.getPosition()] && controles <= maxControles) {
                    int tiempoHijo = buscarMaxTiempo(ciudades, vSig, vFinal, maxControles, marca);
                    if (tiempoHijo != 0) {
                        int tiempoCamino = tiempoHijo + vActual.getData().getTransito();
                        if (tiempoCamino > maxTiempo) {
                            maxTiempo = tiempoCamino;
                        }
                    }
                }
            }
            ret = maxTiempo;
        }
        marca[pos] = false;
        return ret;
    }
}

