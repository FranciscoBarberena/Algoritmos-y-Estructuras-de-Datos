/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ejercicio03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tp5.ejercicio01.Edge;
import tp5.ejercicio01.Graph;
import tp5.ejercicio01.Vertex;

/**
 *
 * @author Fran
 */
public class Mapa {

    private Graph<String> mapaCiudades;

    public List<String> devolverCamino(String ciudad1, String ciudad2) {
        Vertex<String> verticeInicial = mapaCiudades.search(ciudad1);
        List<String> camino = new ArrayList();
        if (verticeInicial != null) {
            boolean[] marca = new boolean[mapaCiudades.getSize()];
            dfsDevolverCamino(verticeInicial, ciudad2, marca, camino);
        }
        return camino;
    }

    private boolean dfsDevolverCamino(Vertex<String> verticeInicial, String destino, boolean[] marca, List<String> camino) {
        marca[verticeInicial.getPosition()] = true;
        boolean encontre = false;
        String dato = verticeInicial.getData();
        camino.add(dato);
        if (dato.equals(destino)) {
            encontre = true;
        } else {
            List<Edge<String>> aristas = new ArrayList(mapaCiudades.getEdges(verticeInicial));
            Iterator<Edge<String>> it = aristas.iterator();
            while (it.hasNext() && !encontre) {
                Edge<String> e = it.next();
                int j = e.getTarget().getPosition();
                Vertex<String> target = e.getTarget();
                if (!marca[j]) {
                    encontre = dfsDevolverCamino(target, destino, marca, camino);
                    if (!encontre) {
                        camino.remove(camino.size() - 1);
                    }
                }
            }
        }
        return encontre;
    }

    public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades) {
        Vertex<String> verticeInicial = mapaCiudades.search(ciudad1);
        List<String> camino = new ArrayList();
        if (verticeInicial != null && !ciudades.contains(ciudad1)) {
            boolean[] marca = new boolean[mapaCiudades.getSize()];
            dfsDevolverCaminoExceptuando(verticeInicial, ciudad2, marca, camino, ciudades);
        }
        return camino;
    }

    private boolean dfsDevolverCaminoExceptuando(Vertex<String> verticeInicial, String destino, boolean[] marca, List<String> camino, List<String> ciudades) {
        marca[verticeInicial.getPosition()] = true;
        boolean encontre = false;
        String dato = verticeInicial.getData();
        camino.add(dato);
        if (dato.equals(destino)) {
            encontre = true;
        } else {
            List<Edge<String>> aristas = mapaCiudades.getEdges(verticeInicial);
            Iterator<Edge<String>> it = aristas.iterator();
            while (it.hasNext() && !encontre) {
                Edge<String> e = it.next();
                int j = e.getTarget().getPosition();
                Vertex<String> target = e.getTarget();
                if (!marca[j] && (!ciudades.contains(target.getData()))) {
                    encontre = dfsDevolverCaminoExceptuando(target, destino, marca, camino, ciudades);
                }
            }
        }
        if (!encontre) {
            camino.remove(camino.size() - 1);
        }
        return encontre;
    }

    public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
        Vertex<String> verticeInicial = mapaCiudades.search(ciudad1);
        ResultadoCamino minimo = new ResultadoCamino();
        if (verticeInicial != null) {
            List<String> listaActual = new ArrayList<>();
            boolean[] marca = new boolean[mapaCiudades.getSize()];
            marca[verticeInicial.getPosition()] = true;
            listaActual.add(verticeInicial.getData());

            if (ciudad1.equals(ciudad2)) {
                minimo.setCosto(0);
                minimo.setCamino(new ArrayList<>(listaActual));
            } else {
                dfsDevolverCaminoMasCorto(verticeInicial, ciudad2, marca, minimo, listaActual, 0);
            }
        }
        return minimo.getCamino();
    }

    private void dfsDevolverCaminoMasCorto(Vertex<String> verticeInicial, String ciudad2, boolean[] marca, ResultadoCamino minimo, List<String> listaActual, int costoActual) {

        List<Edge<String>> ady = mapaCiudades.getEdges(verticeInicial);
        for (Edge<String> e : ady) {
            int j = e.getTarget().getPosition();
            if (!marca[j]) {
                int p = e.getWeight();
                if (p + costoActual < minimo.getCosto()) {
                    Vertex<String> vDestino = e.getTarget();
                    marca[j] = true;
                    listaActual.add(vDestino.getData());
                    if (vDestino.getData().equals(ciudad2)) {
                        minimo.setCosto(costoActual + p);
                        minimo.setCamino(new ArrayList<>(listaActual));

                    } else {
                        dfsDevolverCaminoMasCorto(vDestino, ciudad2, marca, minimo, listaActual, costoActual + p);
                    }
                    listaActual.remove(listaActual.size() - 1);
                    marca[j] = false;
                }
            }
        }
    }

    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        Vertex<String> verticeInicial = mapaCiudades.search(ciudad1);
        List<String> caminoSinNafta = new ArrayList<>();
        if (verticeInicial != null) {
            boolean[] marca = new boolean[mapaCiudades.getSize()];
            dfsCaminoSinCargarCombustible(verticeInicial, marca, ciudad2, tanqueAuto, caminoSinNafta, new ArrayList<>());
        }
        return caminoSinNafta;
    }

    private boolean dfsCaminoSinCargarCombustible(Vertex<String> verticeInicial, boolean[] marca, String destino, int tanqueAuto, List<String> caminoSinNafta, List<String> caminoActual) {
        int i = verticeInicial.getPosition();
        String data = verticeInicial.getData();
        marca[i] = true;
        boolean encontre = false;
        caminoActual.add(data);
        if (data.equals(destino)) {
            caminoSinNafta.addAll(caminoActual);
            encontre = true;
        } else {
            List<Edge<String>> aristas = mapaCiudades.getEdges(verticeInicial);
            Iterator<Edge<String>> it = aristas.iterator();
            while (it.hasNext() && !encontre) {
                Edge<String> aristaActual = it.next();
                int naftaNecesaria = aristaActual.getWeight();
                Vertex<String> siguiente = aristaActual.getTarget();
                int posSiguiente = siguiente.getPosition();
                if (naftaNecesaria <= tanqueAuto && !marca[posSiguiente]) {
                    encontre = dfsCaminoSinCargarCombustible(siguiente, marca, destino, tanqueAuto - naftaNecesaria, caminoSinNafta, caminoActual);
                }
            }
        }
        marca[i] = false;
        caminoActual.remove(caminoActual.size() - 1);
        return encontre;
    }

    public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        Vertex<String> verticeInicial = mapaCiudades.search(ciudad1);
        Vertex<String> verticeFinal = mapaCiudades.search(ciudad2);
        ResultadoCamino minimo = new ResultadoCamino();
        if (verticeInicial != null && verticeFinal != null){
            boolean[] marca = new boolean[mapaCiudades.getSize()];
            dfsCaminoConMenorCargaDeCombustible(verticeInicial,marca, ciudad2,tanqueAuto,tanqueAuto,0,minimo,new ArrayList<>());
        }
        return minimo.getCamino();
    }

    private void dfsCaminoConMenorCargaDeCombustible(Vertex<String> verticeInicial, boolean[] marca, String destino, int naftaRestante, int capacidadAuto, int cargasActuales, ResultadoCamino minimo, List<String> caminoActual) {
        String data = verticeInicial.getData();
        int pos = verticeInicial.getPosition();
        caminoActual.add(data);
        marca[pos] = true;
        if (data.equals(destino) && cargasActuales < minimo.getCosto()){
            minimo.setCamino(new ArrayList<>(caminoActual));
            minimo.setCosto(cargasActuales);
        } else{
            List<Edge<String>> aristas = mapaCiudades.getEdges(verticeInicial);
            for (Edge<String>a : aristas){
                Vertex<String> siguiente = a.getTarget();
                int costoAlSiguiente = a.getWeight();
                int posSiguiente = siguiente.getPosition();
                if (!marca[posSiguiente] && cargasActuales<minimo.getCosto())
                    if (costoAlSiguiente > naftaRestante && costoAlSiguiente <= capacidadAuto && cargasActuales<minimo.getCosto()-1)
                        dfsCaminoConMenorCargaDeCombustible(siguiente,marca,destino,capacidadAuto- costoAlSiguiente,capacidadAuto,cargasActuales + 1,minimo, caminoActual);
                    else if (costoAlSiguiente <= naftaRestante)
                        dfsCaminoConMenorCargaDeCombustible(siguiente,marca,destino,naftaRestante - costoAlSiguiente,capacidadAuto,cargasActuales,minimo, caminoActual);
            }
        }
        marca[pos] = false;
        caminoActual.remove(caminoActual.size()-1);
    }
}
