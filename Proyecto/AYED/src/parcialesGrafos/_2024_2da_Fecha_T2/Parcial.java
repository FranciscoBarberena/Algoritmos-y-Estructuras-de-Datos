/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesGrafos._2024_2da_Fecha_T2;

/**
 *
 * @author Fran
 */
import java.util.List;
import tp5.ejercicio01.*;
import tp1.ejercicio8.Queue;

public class Parcial {

    public Tupla nivelPopularidad(Graph<String> red, String usuario, int distancia, int umbral) {
        boolean[] marca = new boolean[red.getSize()];
        Tupla tup = new Tupla(0, false);
        Vertex<String> vInicial = red.search(usuario);
        
        if (vInicial != null) {
            Queue<Vertex<String>> q = new Queue<>();
            q.enqueue(vInicial);
            marca[vInicial.getPosition()] = true;
            int distanciaActual = 0;
            
            while (!q.isEmpty() && distanciaActual <= distancia) {
                int tamano = q.size();
                
                for (int i = 0; i < tamano; i++) {
                    if (distanciaActual == distancia) {
                        tup.incrementar();
                    } else {
                        Vertex<String> vActual = q.dequeue();
                        List<Edge<String>> ady = red.getEdges(vActual);
                        
                        for (Edge<String> a : ady) {
                            Vertex<String> vSig = a.getTarget();
                            int posSig = vSig.getPosition();
                            
                            if (!marca[posSig]) {
                                marca[posSig] = true;
                                q.enqueue(vSig);
                            }
                        }
                    }
                }
                distanciaActual += 1;
            }
            tup.setPopular(tup.getAmigos() >= umbral);
            return tup;
            
        } else {
            return null;
        }
    }
}
