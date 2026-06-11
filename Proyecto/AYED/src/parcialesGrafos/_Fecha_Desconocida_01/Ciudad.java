/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesGrafos._Fecha_Desconocida_01;

/**
 *
 * @author Fran
 */
public class Ciudad {

    private String nombre;
    private int fase;

    public Ciudad(String nombre, int fase) {
        this.nombre = nombre;
        this.fase = fase;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFase() {
        return this.fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;
        
        Ciudad c = (Ciudad) o;
        return c.getNombre().equals(this.getNombre());
    }
}

