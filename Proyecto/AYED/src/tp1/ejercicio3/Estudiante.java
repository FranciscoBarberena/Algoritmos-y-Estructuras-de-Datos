/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.ejercicio3;

/**
 *
 * @author Fran
 */
public class Estudiante extends Persona{
    private int comision;
    private String direccion;
    
    
  
    
    public String tusDatos(){
        String aux=super.tusDatos();
        aux+= "\nComisión: "+this.getComision()+"\nDirección: "+this.getDireccion()+"\n";
        return aux;
    } 

  
    

    //Constructor

    public Estudiante(int comision, String direccion, String nombre, String apellido, String email) {
        super(nombre, apellido, email);
        this.setComision(comision);
        this.setDireccion(direccion);
    }

    //Getters y setters
    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
