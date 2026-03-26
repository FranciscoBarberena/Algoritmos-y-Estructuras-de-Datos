package tp1.ejercicio5;

public class ArregloParametros {

	
	public static void main(String[] args) {
		Integer [] arreglo = new Integer[3];
		
		for (int i =1;i<4;i++) {
			arreglo[i-1] = i;
		}
		System.out.println("Calculo por return: "+Calcular.calcularReturn(arreglo));
		Datos d = new Datos();
		Calcular.calcularParametro(arreglo, d);
		System.out.println("Calculo por parametro: "+d);
		Calcular.calcularSinNada(arreglo);
		System.out.println("Calculo sin nada: Maximo "+DatosGlobal.getMax()+
				" Minimo: "+DatosGlobal.getMin()+" Promedio: "+DatosGlobal.getProm());
		
	}
	
	
		
		
	}
	
	
	


