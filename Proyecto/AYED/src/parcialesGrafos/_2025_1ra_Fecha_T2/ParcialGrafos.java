/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesGrafos._2025_1ra_Fecha_T2;

/**
 *
 * @author Fran
 */
import java.util.ArrayList;
import java.util.List;
import tp5.ejercicio01.*;
public class ParcialGrafos {

    public List<String> rutaOptimaDistribucion(Graph<String> reino, String castillo, String aldea, int maxPociones) {
        List<String> mejorCamino = new ArrayList<>();
        Vertex<String> vInicial = reino.search(castillo);
        
        if (vInicial != null) {
            Vertex<String> vFinal = reino.search(aldea);
            if (vFinal != null && maxPociones >= 0) {
                boolean[] marca = new boolean[reino.getSize()];
                List<String> actual = new ArrayList<>();
                buscarCamino(reino, vInicial, vFinal, marca, actual, mejorCamino, maxPociones);
            }
        }
        
        return mejorCamino;
    }

    private void buscarCamino(Graph<String> reino, Vertex<String> vActual, Vertex<String> vFinal, boolean[] marca, List<String> actual, List<String> mejorCamino, int pocionesRestantes) {
        int pos = vActual.getPosition();
        marca[pos] = true;
        actual.add(vActual.getData());

        if (vActual == vFinal) {
            if (actual.size() > mejorCamino.size()) {
                mejorCamino.clear();
                mejorCamino.addAll(actual);
            }
        } else {
            List<Edge<String>> ady = reino.getEdges(vActual);
            for (Edge<String> a : ady) {
                Vertex<String> vSig = a.getTarget();
                int costo = a.getWeight();
                int posSig = vSig.getPosition();
                
                if (!marca[posSig] && pocionesRestantes >= costo) {
                    buscarCamino(reino, vSig, vFinal, marca, actual, mejorCamino, pocionesRestantes - costo);
                }
            }
        }
        marca[pos] = false;
        actual.remove(actual.size() - 1);
    }
}
