/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesGrafos._Fecha_Desconocida_03;

/**
 *
 * @author Fran
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tp5.ejercicio01.*;

public class Parcial {

    public List<String> resolver(Graph<String> ciudades, String origen, String destino, List<String> pasandoPor) {
        Vertex<String> vInicial = ciudades.search(origen);
        List<String> camino = new ArrayList<>();
        
        if (vInicial != null) {
            Vertex<String> vFinal = ciudades.search(destino);
            if (vFinal != null) {
                boolean[] marca = new boolean[ciudades.getSize()];
                List<String> actual = new ArrayList<>();
                buscarCamino(vInicial, marca, pasandoPor, camino, actual, vFinal, ciudades);
            }
        }
        
        return camino;
    }

    private boolean buscarCamino(Vertex<String> vActual, boolean[] marca, List<String> pasandoPor, List<String> camino, List<String> actual, Vertex<String> vFinal, Graph<String> ciudades) {
        int pos = vActual.getPosition();
        marca[pos] = true;
        boolean encontre = false;
        
        String ciudad = vActual.getData();
        actual.add(ciudad);

        if (vActual == vFinal && actual.containsAll(pasandoPor)) {
            encontre = true;
            camino.addAll(actual);
        } else {
            List<Edge<String>> ady = ciudades.getEdges(vActual);
            Iterator<Edge<String>> it = ady.iterator();
            
            while (it.hasNext() && !encontre) {
                Vertex<String> sig = it.next().getTarget();
                int posSig = sig.getPosition();
                
                if (!marca[posSig]) {
                    encontre = buscarCamino(sig, marca, pasandoPor, camino, actual, vFinal, ciudades);
                }
            }
        }
        if (!encontre) {
            marca[pos] = false;
            actual.remove(actual.size() - 1);
        }
        
        return encontre;
    }
}
