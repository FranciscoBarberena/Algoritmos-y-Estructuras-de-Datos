/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesGrafos._2024_2da_Fecha_T1;

/**
 *
 * @author Fran
 */
public class Usuario {
    private String nombre;
    private int distancia;

    public Usuario(String nom, int dist) {
        this.nombre = nom;
        this.distancia = dist;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    
    
}
