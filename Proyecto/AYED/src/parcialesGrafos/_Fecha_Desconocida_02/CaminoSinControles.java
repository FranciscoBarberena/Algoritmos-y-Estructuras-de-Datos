/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesGrafos._Fecha_Desconocida_02;

/**
 *
 * @author Fran
 */
import java.util.ArrayList;
import java.util.List;
import tp5.ejercicio01.*;
public class CaminoSinControles {
    
    private Graph<String> mapa;

    public List<List<String>> devolverCaminos(String origen, String destino) {
        Vertex<String> vInicial = this.mapa.search(origen);
        boolean[] marca = new boolean[mapa.getSize()];
        List<List<String>> caminos = new ArrayList<>();
        
        buscarCamino(vInicial, caminos, destino, new ArrayList<>(), marca);
        
        return caminos;
    }

    private void buscarCamino(Vertex<String> vActual, List<List<String>> caminos, String destino, List<String> caminoActual, boolean[] marca) {
        int pos = vActual.getPosition();
        marca[pos] = true;
        String ciudadActual = vActual.getData();
        caminoActual.add(ciudadActual);

        if (ciudadActual.equals(destino)) {
            caminos.add(new ArrayList<>(caminoActual));
        } else {
            List<Edge<String>> ady = mapa.getEdges(vActual);

            for (Edge<String> a : ady) {
                int controles = a.getWeight();
                Vertex<String> vSig = a.getTarget();
                if (controles == 0 && !marca[vSig.getPosition()]) {
                    buscarCamino(vSig, caminos, destino, caminoActual, marca);
                }
            }
        }
        
        marca[pos] = false;
        caminoActual.remove(caminoActual.size() - 1);
    }
}
