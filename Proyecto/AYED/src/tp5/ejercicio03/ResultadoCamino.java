/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ejercicio03;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fran
 */
public class ResultadoCamino<T> {
    private List<T> camino = new ArrayList<>();
    private int costo = Integer.MAX_VALUE;

    public List<T> getCamino() {
        return camino;
    }

    public void setCamino(List<T> camino) {
        this.camino = camino;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
    
}
