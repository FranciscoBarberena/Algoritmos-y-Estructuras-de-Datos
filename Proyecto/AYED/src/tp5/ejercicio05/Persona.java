/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ejercicio05;

import java.util.Objects;

/**
 *
 * @author Fran
 */
public class Persona {
    private boolean jubilado;
    private String nombre;
    private String direccion;

    public boolean isJubilado() {
        return jubilado;
    }

    public void setJubilado(boolean jubilado) {
        this.jubilado = jubilado;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Persona otraPersona = (Persona) obj;
        
        return Objects.equals(this.nombre, otraPersona.nombre) &&
               Objects.equals(this.direccion, otraPersona.direccion);
    }
}
