/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.ejercicio7;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Fran
 */
public class EjercicioSucesion {
    public List<Integer> calcularSucesion (int n) {
        List<Integer> L = new ArrayList<>();
        L = calcularSecuencia(L,n);
   
        return L;
    }
    public List<Integer> calcularSecuencia (List<Integer> L,int n){
        if ( n!=1){
            if (n % 2 == 0){
                calcularSecuencia(L,n/2);
        } else 
                calcularSecuencia(L,3*n+1);
        }
        L.add(n);
        return L;
    }
    
    public void invertirArrayList(ArrayList<Integer> lista){
        List<Integer> listaInvertida = new ArrayList<>();
        ArrayList<Integer> listaInvertidaArray = (ArrayList<Integer>) listaInvertida;
        for (int i = 0; i<lista.size();i++){
            listaInvertidaArray.add(lista.get(lista.size()-i-1));
        }
        for (int i = 0;i<lista.size();i++){ //Como hacer esto sin set???
            lista.set(i,listaInvertidaArray.get(i));
        }
    }
    
    public static void main(String[] args) {
        int n = 7;
        EjercicioSucesion e = new EjercicioSucesion();
        ArrayList<Integer> secuenciaInvertida = (ArrayList<Integer>) e.calcularSucesion(n);
        e.invertirArrayList(secuenciaInvertida);
        for (int i = 0; i<secuenciaInvertida.size();i++){
            System.out.println(secuenciaInvertida.get(i));
        }
        
        
    }
    
            
    
}
