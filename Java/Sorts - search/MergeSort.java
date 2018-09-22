//Autor: BRIAN REYES GÁLVEZ A01633401	
//Clase Quicksort
//28 de Enero 2018
//Sin comentarios

public class MergeSort {
	
	/*public static <E> void mergesort(E[] datos) {
		int min=0;
		int max=datos.length-1;
		Mergesort(datos,min,max);
	}
	
	private static<E> void Mergesort(E[] datos, int min, int max) {
		if(min<max) {
			int med=(min+max)/2;
			Mergesort(datos,min,med);
			Mergesort(datos,med+1,max);
		}
	}*/
	
	public static void mergesort(int[] datos) {
		Mergesort(datos,0,datos.length-1);
	}
	
	private static void Mergesort(int[] datos, int min, int max) {
		if(min<max) {
			int med=(min+max)/2;
			Mergesort(datos,min,med);
			Mergesort(datos,med+1,max);
			mezcla(datos,min,max);
		}
	}
	
	private static void mezcla(int[] datos, int min, int max) {
			int[] tmp= new int[max-min+1];
			int mid=(max+min)/2;
			int j=min;
			int k=mid+1;
			for(int i=0; i<tmp.length;i++) {
				if(j>mid) {
					tmp[i]=datos[k];
					k++;
				}
				else if(k>max) {
					tmp[i]=datos[j];
					j++;
				}
				
				else {
					if(datos[j]<datos[k]) {
						tmp[i]=datos[j];
						j++;
					}
					else {
						tmp[i]=datos[k];
						k++;
					}
				}
			}
			
			System.arraycopy(tmp, 0, datos, min, tmp.length);
	}
	
	
	public static void main(String[] args) {
		int[] arr= {0,2,10,8,3,6,4};
		mergesort(arr);
		for(int l:arr) {
			System.out.println(l);
		}
	}
}
