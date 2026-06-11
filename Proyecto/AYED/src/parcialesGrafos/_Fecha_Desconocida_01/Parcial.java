/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesGrafos._Fecha_Desconocida_01;

/**
 *
 * @author Fran
 */

import tp5.ejercicio01.*;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parcial {

    public List<Ciudad> resolver(Graph<Ciudad> ciudades, String origen, String destino) {
        Vertex<Ciudad> vInicial = ciudades.search(new Ciudad(origen, 0));
        Vertex<Ciudad> vFinal = ciudades.search(new Ciudad(destino, 0));
        List<Ciudad> caminoEncontrado = new ArrayList<>();
        
        if (vInicial != null && vFinal != null && vInicial.getData().getFase() != 1 && vFinal.getData().getFase() != 1) {
            boolean[] marca = new boolean[ciudades.getSize()];
            buscarCamino(ciudades, vInicial, destino, marca, caminoEncontrado, new ArrayList<>());
        }
        
        return caminoEncontrado;
    }

    private boolean buscarCamino(Graph<Ciudad> ciudades, Vertex<Ciudad> vInicial, String destino, 
                                 boolean[] marca, List<Ciudad> caminoEnc, List<Ciudad> actual) {
        
        int pos = vInicial.getPosition();
        boolean encontre = false;
        
        actual.add(vInicial.getData());
        String data = vInicial.getData().getNombre();
        marca[pos] = true;
        
        if (data.equals(destino)) {
            caminoEnc.addAll(actual);
            encontre = true;
        } else {
            List<Edge<Ciudad>> ady = ciudades.getEdges(vInicial);
            Iterator<Edge<Ciudad>> it = ady.iterator();
            while (it.hasNext() && !encontre) {
                Edge<Ciudad> sig = it.next();
                Vertex<Ciudad> vSig = sig.getTarget();
                int posSig = vSig.getPosition();
                
                if (!marca[posSig] && vSig.getData().getFase() != 1) {
                    encontre = buscarCamino(ciudades, vSig, destino, marca, caminoEnc, actual);
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
