/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialesArboles._Fecha_Desconocida_04;

/**
 *
 * @author Fran
 */
public class Personaje {
    private String nombre;
    
    public boolean esDragon() {
        return nombre.equals("Dragón"); 
    }
    
    public boolean esPrincesa() {
        return nombre.equals("Princesa"); 
    }
}
