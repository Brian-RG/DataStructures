//Autor: BRIAN REYES GÁLVEZ A01633401	
//Clase Ordenamientos
//24 de Enero 2018
//No comments
public class Ordenamientos {
	private static void bubbleSort(int[] datos) {
		for(int i=0; i<datos.length-2;i++) {
			for(int j=0;j<datos.length-1;j++) {
				if(datos[j]>datos[j+1]) {
					swap(datos,j,j+1);
				}
			}
		}
		
	}
	
	private static void swap(int[] valores, int i, int j) {
		int tmp=valores[j];
		valores[j]=valores[i];
		valores[i]=tmp;
	}
	
	
	public static <E extends Comparable <E>> E[] BubbleGenerico(E[] valores) {
		int flags=0;
		for(int l=0; l<valores.length-1;l++) {
			if(valores[l].compareTo(valores[l+1])>0) {
				flags+=1;
				swapE(valores, l, l+1);
			}
		}
		if(flags==0) {
			return valores;
		}
		else {
			return BubbleGenerico(valores);
		}
	}
	
	public static <E extends Comparable <E>> void swapE(E[] valores, int i, int j) {
		E tmp= valores[i];
		valores[i]=valores[j];
		valores[j]=tmp;
	}
	
	public static void main(String[] args) {
		Integer[] x= {4,1,5,2,6};
	}
}


