/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejercicio6;

import java.util.List;
import tp3.GeneralTree;

/**
 *
 * @author Fran
 */
public class RedDeAguaPotable {
    private GeneralTree<Character> arbol;
    
    public RedDeAguaPotable(GeneralTree<Character> arbol) {
        this.arbol = arbol;
    }
    public double minimoCaudal(double caudal){
        if (this.arbol != null){
            return flujoCaudal(caudal,arbol);
        }
        return -1;
    }

    private double flujoCaudal(double caudal, GeneralTree<Character> arbol) {
        if (arbol.isLeaf()){
            return caudal;
        }
        List<GeneralTree<Character>> children = arbol.getChildren();
        double minimo = Double.MAX_VALUE;
        for (GeneralTree<Character> child: children){
            double caudalEncontrado = flujoCaudal(caudal/children.size(),child);
            if (caudalEncontrado<minimo){
                minimo = caudalEncontrado;
            }
        }
        return minimo;
    }

    
}
