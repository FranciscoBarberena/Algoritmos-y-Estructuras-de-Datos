/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesGrafos._Fecha_Desconocida_04;

/**
 *
 * @author Fran
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tp5.ejercicio01.*;
public class Parcial {

    private final Ciudad INICIO = new Ciudad("Casa del Intendente", false);
    private final Ciudad DESTINO = new Ciudad("Municipalidad", false);

    public List<String> resolver(Graph<Ciudad> ciudades) {
        List<String> caminoSeguro = new ArrayList<>();
        
        Vertex<Ciudad> vInicial = ciudades.search(INICIO);
        if (vInicial != null) {
            Vertex<Ciudad> vFinal = ciudades.search(DESTINO);
            if (vFinal != null) {
                boolean[] marca = new boolean[ciudades.getSize()];
                List<String> actual = new ArrayList<>();
                buscarCamino(ciudades, vInicial, vFinal, marca, actual, caminoSeguro);
            }
        }
        return caminoSeguro;
    }

    private boolean buscarCamino(Graph<Ciudad> grafo, Vertex<Ciudad> vActual, Vertex<Ciudad> vFinal, boolean[] marca, List<String> actual, List<String> caminoSeguro) {
        boolean encontre = false;
        int pos = vActual.getPosition();
        marca[pos] = true;
        
        actual.add(vActual.getData().getNombre());

        if (vActual == vFinal) {
            encontre = true;
            caminoSeguro.addAll(actual);
        } else {
            List<Edge<Ciudad>> ady = grafo.getEdges(vActual);
            Iterator<Edge<Ciudad>> it = ady.iterator();
            while (it.hasNext() && !encontre) {
                Edge<Ciudad> sig = it.next();
              
                int w = sig.getWeight(); 
                Vertex<Ciudad> vSig = sig.getTarget();
                int posSig = vSig.getPosition();
                if (!marca[posSig] && w == 0 && !vSig.getData().isControlled()) {
                    encontre = buscarCamino(grafo, vSig, vFinal, marca, actual, caminoSeguro);
                }
            }
        }
        if (!encontre) {
            actual.remove(actual.size() - 1);
            marca[pos] = false;
        }
        return encontre;
    }
}
