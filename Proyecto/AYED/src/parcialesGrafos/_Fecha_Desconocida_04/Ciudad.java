/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesGrafos._Fecha_Desconocida_04;

/**
 *
 * @author Fran
 */
public class Ciudad {
    private String nombre;
    private boolean controlled;

    public Ciudad(String nombre, boolean mafia) {
        this.nombre = nombre;
        this.controlled = mafia;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isControlled() {
        return this.controlled;
    }

    public void setControlled(boolean controlled) {
        this.controlled = controlled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        
        Ciudad c = (Ciudad) o;
        return c.getNombre().equals(this.getNombre());
    }
}
