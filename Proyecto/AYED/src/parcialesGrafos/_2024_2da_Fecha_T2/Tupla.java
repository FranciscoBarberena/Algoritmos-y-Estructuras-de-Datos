/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesGrafos._2024_2da_Fecha_T2;

/**
 *
 * @author Fran
 */
public class Tupla {
    private int amigos;
    private boolean popular;

    public Tupla(int amigos, boolean popular) {
        this.amigos = amigos;
        this.popular = popular;
    }

    public void incrementar() {
        this.amigos++;
    }

    public int getAmigos() {
        return this.amigos;
    }

    public void setAmigos(int amigos) {
        this.amigos = amigos;
    }

    public boolean isPopular() {
        return this.popular;
    }

    public void setPopular(boolean popular) {
        this.popular = popular;
    }
}
