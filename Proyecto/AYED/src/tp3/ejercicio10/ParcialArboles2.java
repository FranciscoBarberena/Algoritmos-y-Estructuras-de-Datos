/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejercicio10;

import java.util.ArrayList;
import java.util.List;
import tp3.GeneralTree;

/**
 *
 * @author Fran
 */
public class ParcialArboles2 {

    public static List<Integer> resolver(GeneralTree<Integer> arbol) {
        List<Integer> lista = new ArrayList();
        if ((arbol != null) && (!arbol.isEmpty())) {
            lista = crearCamino(arbol, 0);
            lista.remove(0);
        }
        return lista;
    }

    private static List<Integer> crearCamino(GeneralTree<Integer> arbol, int nivelActual) {
        if (arbol.isLeaf()) {
            List<Integer> lista = new ArrayList();
            lista.add(arbol.getData()*nivelActual);
            if (arbol.getData() == 1) {
                lista.add(arbol.getData());
            }
            return lista;
        }
        List<GeneralTree<Integer>> children = arbol.getChildren();

        List<Integer> listaMaxima = new ArrayList();
        listaMaxima.add(-1);
        for (GeneralTree<Integer> child : children) {
            List<Integer> listaEncontrada = crearCamino(child, nivelActual+1);
            if ((listaEncontrada.get(0) > listaMaxima.get(0))) {
                listaMaxima = listaEncontrada;
            }
        }
        listaMaxima.set(0,listaMaxima.get(0)+arbol.getData()*nivelActual);
        if (arbol.getData() == 1) {
            listaMaxima.add(arbol.getData());
            
        }
        
        return listaMaxima;
    }

}
