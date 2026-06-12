/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesGrafos._2024_2da_Fecha_T1;

/**
 *
 * @author Fran
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tp5.ejercicio01.*;
import tp1.ejercicio8.Queue;
public class Parcial {

    public List<Usuario> invitacionMasterClass(Graph<String> red, String usuario, int distancia, int limite) {
        List<Usuario> invitados = new ArrayList<>();
        Vertex<String> vInicial = red.search(usuario);
        
        if (distancia > 0 && limite > 0 && vInicial != null) {
            boolean[] marca = new boolean[red.getSize()];
            bfsInvitados(red, vInicial, invitados, distancia, limite, marca);
        }
        
        return invitados;
    }

    private void bfsInvitados(Graph<String> red, Vertex<String> vInicial, List<Usuario> lista, int distanciaMax, int limite, boolean[] marca) {
        int distanciaActual = 0;
        int cantInvitados = 0;
        Queue<Vertex<String>> cola = new Queue<>();
        
        cola.enqueue(vInicial);
        marca[vInicial.getPosition()] = true;

        while (!cola.isEmpty() && cantInvitados < limite && distanciaActual < distanciaMax) {
            int tamaño = cola.size();
            int i = 0;
            
            while (i < tamaño && cantInvitados < limite) {
                Vertex<String> vActual = cola.dequeue();
                i++;
                
                List<Edge<String>> ady = red.getEdges(vActual);
                Iterator<Edge<String>> it = ady.iterator();
                
                while (it.hasNext() && cantInvitados < limite) {
                    Vertex<String> sig = it.next().getTarget();
                    
                    if (!marca[sig.getPosition()]) {
                        marca[sig.getPosition()] = true;
                        cantInvitados++;
                        cola.enqueue(sig);
                        
                        Usuario u = new Usuario(sig.getData(), distanciaActual + 1);
                        lista.add(u);
                    }
                }
            }
            distanciaActual++;
        }
    }
}
