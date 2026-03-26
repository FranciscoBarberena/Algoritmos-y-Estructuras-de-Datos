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
public class Profesor extends Persona{
    private int catedra;
    private String facultad;

    public String tusDatos(){
        String aux = super.tusDatos();
        aux+= "\nCátedra: "+this.getCatedra()+"\nFacultad: "+this.getFacultad();
        return aux;
    } 

    
    //Constructor
    public Profesor(int catedra, String facultad, String nombre, String apellido, String email) {
        super(nombre, apellido, email);
        this.setCatedra(catedra);
        this.setFacultad(facultad);
    }

    //Getters y setters
    public int getCatedra() {
        return catedra;
    }

    public void setCatedra(int catedra) {
        this.catedra = catedra;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    
    
}
