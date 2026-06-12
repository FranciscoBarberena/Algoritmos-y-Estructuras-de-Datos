/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesGrafos._Fecha_Desconocida_05;

/**
 *
 * @author Fran
 */
public class Ciudad {
    private String nombre;
    private boolean flooded;

    public Ciudad(String nombre, boolean flooded) {
        this.nombre = nombre;
        this.flooded = flooded;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isFlooded() {
        return this.flooded;
    }

    public void setFlooded(boolean flooded) {
        this.flooded = flooded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Ciudad c = (Ciudad) o;
        return this.getNombre().equals(c.getNombre());
    }
}
