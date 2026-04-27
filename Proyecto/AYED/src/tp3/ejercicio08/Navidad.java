/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejercicio08;

import java.util.List;
import tp3.GeneralTree;

/**
 *
 * @author Fran
 */
public class Navidad {
    private GeneralTree<Integer> arbol;

    public Navidad(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public String esAbetoNavidenio(){
        String cumple = recorrerArbol(arbol);
        return cumple;
    }

    private String recorrerArbol(GeneralTree<Integer> tree) {
        if (tree.isLeaf()){
            return "Leaf";
        } 
        List<GeneralTree<Integer>> children = tree.getChildren();
        
        int cantHojas = 0;
        for (GeneralTree<Integer> child : children){
            String cumple = recorrerArbol(child);
            if (cumple.equals("No")){
                return cumple;
            }
            if (cumple.equals("Leaf"))
                cantHojas += 1;
        }
        if (cantHojas>=3){
            return "Yes";
        } else return "No";
        
    }
}
