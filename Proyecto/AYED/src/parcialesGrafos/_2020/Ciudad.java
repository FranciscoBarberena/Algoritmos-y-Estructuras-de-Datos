/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesGrafos._2020;

/**
 *
 * @author Fran
 */
public class Ciudad {
    private String nombre;
    private int transito;

    public Ciudad(String nombre, int transito) {
        this.nombre = nombre;
        this.transito = transito;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTransito() {
        return this.transito;
    }

    public void setTransito(int transito) {
        this.transito = transito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        
        Ciudad c = (Ciudad) o;
        return c.getNombre().equals(this.getNombre());
    }
}
