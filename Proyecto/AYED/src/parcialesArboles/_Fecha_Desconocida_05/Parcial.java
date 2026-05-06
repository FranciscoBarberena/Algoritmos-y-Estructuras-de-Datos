/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesArboles._Fecha_Desconocida_05;

import java.util.ArrayList;
import java.util.List;
import tp3.GeneralTree;

/**
 *
 * @author Fran
 */
public class Parcial {

    public List<List<Character>> caminosPares(GeneralTree<Character> arbol) {   
        if (arbol == null || arbol.isEmpty()) {
            return new ArrayList<>(); 
        }
        
        List<List<Character>> caminos = new ArrayList<>();
        List<Character> caminoActual = new ArrayList<>();
        encontrarCaminos(arbol, caminos, caminoActual);
        
        return caminos;
    }

    private void encontrarCaminos(GeneralTree<Character> arbol, List<List<Character>> caminos, List<Character> caminoActual) {
        caminoActual.add(arbol.getData());
        if (arbol.isLeaf()) {
            if (caminoActual.size() % 2 == 0) {
                caminos.add(new ArrayList<>(caminoActual));
            }
        } else {
            List<GeneralTree<Character>> children = arbol.getChildren();
            for (GeneralTree<Character> child : children) {
                encontrarCaminos(child, caminos, caminoActual); 
            }
        }
        
        caminoActual.remove(caminoActual.size() - 1);
    }
}
