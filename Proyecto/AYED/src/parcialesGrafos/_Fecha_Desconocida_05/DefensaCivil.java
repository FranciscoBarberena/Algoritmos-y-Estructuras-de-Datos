/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesGrafos._Fecha_Desconocida_05;

/**
 *
 * @author Fran
 */
import java.util.List;
import tp5.ejercicio01.*;
public class DefensaCivil {

    public int calcularGastoMinimo(Graph<Ciudad> mapa, String origen, String destino) {
        int minGasto = -1;
        Vertex<Ciudad> vInicial = mapa.search(new Ciudad(origen, false));
        if (vInicial != null) {
            Vertex<Ciudad> vFinal = mapa.search(new Ciudad(destino, false));
            if (vFinal != null) {
                boolean[] marca = new boolean[mapa.getSize()];
                minGasto = buscarGasto(mapa, vInicial, vFinal, marca);
            }
        }
        return minGasto;
    }

    private int buscarGasto(Graph<Ciudad> mapa, Vertex<Ciudad> vActual, Vertex<Ciudad> vFinal, boolean[] marca) {
        int ret;
        int pos = vActual.getPosition();
        marca[pos] = true;
        if (vActual == vFinal) {
            ret = 0;
        } else {
            int gastoActual = 0;
            int gastoMinimo = Integer.MAX_VALUE;
            ret = -1;
            List<Edge<Ciudad>> ady = mapa.getEdges(vActual);
            for (Edge<Ciudad> a : ady) {
                Vertex<Ciudad> vSig = a.getTarget();
                int costo = a.getWeight();
                int posSig = vSig.getPosition();
                if (!marca[posSig] && !vSig.getData().isFlooded()) {
                    gastoActual = buscarGasto(mapa, vSig, vFinal, marca);
                    if (gastoActual != -1 && gastoActual + costo < gastoMinimo) {
                        gastoMinimo = gastoActual + costo;
                    }
                }
            }
            if (gastoMinimo != Integer.MAX_VALUE) {
                ret = gastoMinimo;
            }
        }
        marca[pos] = false;
        return ret;
    }
}
