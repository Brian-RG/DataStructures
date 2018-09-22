//Autor: BRIAN REYES GÁLVEZ A01633401	
//Clase Quicksort
//28 de Enero 2018
//Traté de hacer que eligiera el pivote de manera aleatoria, para ver si podría evitar una complejidad similar a la del bubblesort
import java.util.Random;
public class QuickSort {
	public static void quicksort(int[] datos) { //Primer método llamado
		quick(datos,0,datos.length);
	}
	
	public static void quick(int[] datos, int inf, int sup) {
		if(inf<sup) { //validar para que no me quiera generar un random de 0 a 0.
		int chosen= chooser(inf,sup); // Generador del pivote
		swap(datos,inf,chosen); //pone el pivote en la primera posición de la porción a ordenar.
		quicksort(datos,inf,sup); // Llama al método recursivo
		}
	}
	
	public static void quicksort(int[] datos, int pivote, int limit) {
		if(pivote<limit) {
			int q=sort(datos, pivote, limit);//Este lo ordena
			quick(datos,pivote,q); //Llamar la mitad izq para ser ordenada
			quick(datos,q+1,limit); //Llama mitad derecha
		}
		
	}
	
	public static int sort(int[]datos,int pivote,int limite) { // El chido
		int i=pivote+1;
		for(int j=pivote+1;j<limite;j++) {
			if(datos[j]<datos[pivote]) {
				swap(datos,j,i);
				i++;
			}
		}
		swap(datos,pivote,i-1);
		return i-1;
	}
	
	public static void swap(int[]datos, int x, int y) {
		int tmp=datos[x]; //Variable temporal
		datos[x]=datos[y];
		datos[y]=tmp;
	}
	
	private static int chooser(int inf, int sup) {
		Random ran= new Random();
		int l=sup-inf;
		int a = ran.nextInt(l)+inf; //Esto lo hago para generar valores entre 2 datos, con la formula nextInt(max-min)+max
		int b = ran.nextInt(l)+inf;
		int c = ran.nextInt(l)+inf;
		
		//Lo que devuelve 
		if((a<=b && b<=c)||(c<=b && b<=a)) {
			return b;
		}
		else if((b<=a && a<=c)||(c<=a && a<=b)) {
			return a;
		}
		else {
			return c;
		}
		//TODO LO DE ARRIBA ES PARA DEVOLVER EL VALOR EN POSICIÓN MEDIA ENTRE LOS 3 RANDOMS
	}
	public static void main(String[] Args) {
		/*int[] datos= {5,1,9,3,6,10,12,29,13,15,18,23,32,42,41,38};
		quicksort(datos);
		for(int l: datos) {
			System.out.println(l);
		}*/
	}
}
