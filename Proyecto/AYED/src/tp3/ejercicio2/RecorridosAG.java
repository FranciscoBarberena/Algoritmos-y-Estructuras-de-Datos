/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejercicio2;

import java.util.ArrayList;
import java.util.List;
import tp1.ejercicio8.Queue;
import tp3.GeneralTree;

/**
 *
 * @author Fran
 */
public class RecorridosAG {

    public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a,
            Integer n) {
        List<Integer> lista = new ArrayList();
        if ((a != null) && (!a.isEmpty())) {
            this.recorrerArbolPreOrden(a, n, lista);
        }
        return lista;

    }

    private void recorrerArbolPreOrden(GeneralTree<Integer> a, Integer n, List<Integer> lista) {
        if ((a.getData() % 2 != 0) && (a.getData() > n)) {
            lista.add(a.getData());
        }
        List<GeneralTree<Integer>> children = a.getChildren();
        children.forEach((child) -> {
            this.recorrerArbolPreOrden(child, n, lista);
        });
    }

    public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a,
            Integer n) {
        List<Integer> lista = new ArrayList();
        if ((a != null) && (!a.isEmpty())) {
            this.recorrerArbolInOrden(a, n, lista);
        }
        return lista;
    }

    private void recorrerArbolInOrden(GeneralTree<Integer> a, Integer n, List<Integer> lista) {
        List<GeneralTree<Integer>> children = a.getChildren();
        if (!children.isEmpty()) {
            this.recorrerArbolInOrden(children.get(0), n, lista);
        }
        if ((a.getData() % 2 != 0) && (a.getData() > n)) {
            lista.add(a.getData());
        }
        for (int i = 1; i<=children.size();i++) {
            this.recorrerArbolInOrden(children.get(i), n, lista);
        }
    }

    public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a,
            Integer n) {
        List<Integer> lista = new ArrayList();
        if ((a != null) && (!a.isEmpty())) {
            this.recorrerArbolPostOrden(a, n, lista);
        }
        return lista;
    }

    private void recorrerArbolPostOrden(GeneralTree<Integer> a, Integer n, List<Integer> lista) {   
        List<GeneralTree<Integer>> children = a.getChildren();
        for (GeneralTree<Integer> child : children) {
            this.recorrerArbolPostOrden(child, n, lista);
        }
        if ((a.getData() % 2 != 0) && (a.getData() > n)) {
            lista.add(a.getData());
        }
    }
    
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,
Integer n){
        List<Integer> lista = new ArrayList();
        if ((a != null) && (!a.isEmpty())) {
            this.recorrerArbolPorNiveles(a, n, lista);
        }
        return lista;
    }

    private void recorrerArbolPorNiveles(GeneralTree<Integer> a, Integer n, List<Integer> lista) {
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(a);
        while(!cola.isEmpty()){
            int tamano = cola.size();
            for (int i = 0;i<tamano;i++){   
                GeneralTree<Integer> hijoActual = cola.dequeue();
                if ((hijoActual.getData() % 2 != 0) && (hijoActual.getData() >n)){
                    lista.add(hijoActual.getData());
                }
                List <GeneralTree<Integer>> children = hijoActual.getChildren();
                for (GeneralTree<Integer> child: children){
                    cola.enqueue(child);
                }
            }
        }
    }
}
