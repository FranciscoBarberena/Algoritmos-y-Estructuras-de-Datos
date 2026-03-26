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
public abstract class Persona {
    private String nombre;
    private String apellido;
    private String email;
    
    public String tusDatos(){
        String aux="";
        aux+= "Nombre: " + this.getNombre()+"\nApellido: "+ this.getApellido()+"\nEmail: "+this.getEmail();
     return aux;
    }

    
    // Constructor
    public Persona(String nombre, String apellido, String email) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEmail(email);
    }
    
    
    //Getters y setters
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
