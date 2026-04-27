/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejercicio07;

import java.util.ArrayList;
import java.util.List;
import tp3.GeneralTree;

/**
 *
 * @author Fran
 */
public class Caminos {

    GeneralTree<Integer> arbol;

    public List<Integer> caminoAHojaMasLejana() {
        List<Integer> listaMaxima = new ArrayList();
        if ((arbol != null) && (!arbol.isEmpty())) {
            //listaMaxima = this.encontrarCamino(arbol); resolucion con post orden
            List<Integer> listaActual = new ArrayList();
            this.encontrarCaminoBacktracking(arbol,listaMaxima,listaActual,0,Integer.MIN_VALUE);
        }
        return listaMaxima;
    }
        
    private List<Integer> encontrarCamino(GeneralTree<Integer> tree) {
        if (tree.isLeaf()){
            List<Integer> lista = new ArrayList();
            lista.add(tree.getData());
            return lista;
        }
        List<GeneralTree<Integer>> children = tree.getChildren();
        List<Integer> caminoMaximo= new ArrayList();
        for (GeneralTree<Integer> child : children) {
            List<Integer> caminoEncontrado = this.encontrarCamino(child);
            if (caminoEncontrado.size()>caminoMaximo.size()){
                caminoMaximo = caminoEncontrado;
            }
        }       
        caminoMaximo.add(0,tree.getData());
        return caminoMaximo;
    }

    private int encontrarCaminoBacktracking(GeneralTree<Integer> arbol, List<Integer> listaMaxima, List<Integer> listaActual, int longitudActual, int longitudMaxima) {
        listaActual.add(arbol.getData());
        longitudActual++;
        if (arbol.isLeaf()){
            if (longitudActual>longitudMaxima){
                longitudMaxima = longitudActual;
                listaMaxima.clear();
                listaMaxima.addAll(listaActual);
            }
        } else{
            List<GeneralTree<Integer>> children = arbol.getChildren();
            for (GeneralTree<Integer> child: children){
                longitudMaxima = this.encontrarCaminoBacktracking(child, listaMaxima, listaActual, longitudActual, longitudMaxima);
            }
        }
        listaActual.remove(listaActual.size()-1);
        return longitudMaxima;
    }
}
