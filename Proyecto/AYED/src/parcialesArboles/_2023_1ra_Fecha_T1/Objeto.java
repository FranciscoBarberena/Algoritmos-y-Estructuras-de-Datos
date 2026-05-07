/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesArboles._2023_1ra_Fecha_T1;

import java.util.ArrayList;
import java.util.List;
import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author Fran
 */
public class Objeto {
    private List<BinaryTree<Integer>> lista;
    private int cantPares;

    public Objeto() {
        this.lista = new ArrayList<>();
        this.cantPares = 0;
    }

    public void sumarPar() {
        this.cantPares++;
    }

    public void agregar(BinaryTree<Integer> tree) {
        this.lista.add(tree);
    }
}
