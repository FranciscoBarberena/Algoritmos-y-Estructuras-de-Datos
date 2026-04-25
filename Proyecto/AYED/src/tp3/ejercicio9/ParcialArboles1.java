/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejercicio9;

import java.util.List;
import tp3.GeneralTree;

/**
 *
 * @author Fran
 */
public class ParcialArboles1 {

    public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
        boolean seleccion = false;
        if ((arbol != null) && (!arbol.isEmpty())) {
            seleccion = recorrerArbol(arbol);
        }
        return seleccion;
    }

    private static boolean recorrerArbol(GeneralTree<Integer> arbol) {
        
        if (arbol.isLeaf()){
            return true;
        }
        List<GeneralTree<Integer>> children = arbol.getChildren();
        int min = Integer.MAX_VALUE;
        
        for (GeneralTree<Integer> child : children) {
            boolean cumple = recorrerArbol(child);
            if (!cumple) {
                return cumple;
            } 
            if (child.getData() < min) {
                min = child.getData();
            }
        }
        return min == arbol.getData();
    }
}
