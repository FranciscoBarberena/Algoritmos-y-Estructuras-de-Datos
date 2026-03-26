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
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estudiante [] arregloEstudiantes = new Estudiante[3];
        Profesor [] arregloProfesores = new Profesor [2];
        //No entiendo el problema con ejecutar paso a paso
        for (int i = 0;i<3;i++){
            arregloEstudiantes[i] = new Estudiante(i+1,"Calle 452","Estudiante","Generico","alumno@gmail.com");
            System.out.println(arregloEstudiantes[i].tusDatos());
        }
        for (int i = 0;i<2;i++){
            arregloProfesores[i] = new Profesor(i+1,"Calle 547","Profesor","Generico","profe@gmail.com");
            System.out.println(arregloProfesores[i].tusDatos());
        }
        
    }
    
}
