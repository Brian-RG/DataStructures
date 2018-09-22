//Autor: BRIAN REYES GÁLVEZ A01633401	
//Clase BinarySearch
//24 de Enero 2018
//No comments
public class BinarySearch {
	public static int BinarySearch(int valor, int[] valores) {
		int min =0,
			max =valores.length-1,
			avg;
		
		while(min<=max){
			avg=(min+max)/2;
			if(valores[avg]==valor) {
				return avg;
			}
			else {
				if(valor>valores[avg]) {
					min=avg+1;
				}
				else {
					max=avg-1;
				}
			}
		}
		
		return -1;
	}
	
	public static <E extends Comparable <E>> int binarySearch(E valor, E[] valores){
		int min=0,
			max=valores.length-1,
			avg;
		
		while(min<=max) {
			avg=(min+max)/2;
			if(valores[avg].compareTo(valor)==0) {
				return avg;
			}
			else {
				if(valor.compareTo(valores[avg])>0) {
					min=avg+1;
				}
				
				else {
					max=avg-1;
				}
				
			}
		}
		return -1;
	}
	
	public static <T extends Comparable <T>> int RecursiveBinary(T valor, T[] valores) {//manda a llamar al recursivo
		int min=0;
		int max=valores.length-1;
		return binarysearchRec(valor, valores,min, max);
	}
	
	
	private static <T extends Comparable <T>> int binarysearchRec(T valor, T[]valores, int min, int max) {//este hace todo
		if(min>max) {
			return -1;
		}
		
		else {
			int avg= (min+max)/2;
			if(valores[avg].compareTo(valor) == 0) {
				return avg;
			}
			
			else {
				if(valor.compareTo(valores[avg]) >0) {
					min=avg+1;
					return binarysearchRec(valor,valores,min,max);
				}
				else {
					max=avg-1;
					return binarysearchRec(valor,valores,min,max);
				}
				
			}
			
		}
	} 
	
	
	
	
	
	public static void main(String[] args) {
		Integer[] arr= {2,5,8,10,20,21,23,25,27,29,123,234,345,456,567,678,789,890};
		Integer g= new Integer(25);
		System.out.println(RecursiveBinary(27,arr));
	}
}


