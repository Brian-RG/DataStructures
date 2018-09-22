
public class Fibonacci {
	public static long fibonacci(int n) {
		if(n==1|| n==2) {
			return 1;
		}
		else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
		
	}
	
	public long fibonacciTabla(int n) {
		long[] valores= new long[n+1];
		valores[0]=valores[1]=1;
		return fibonacciTabla(n,valores);		
	}

	private long fibonacciTabla(int n, long[] valores) {
		
		if (valores[n] ==0){
			valores[n]=fibonacciTabla(n-2,valores) + fibonacciTabla(n-1,valores);
			return valores[n];
		}
		else {
			return valores[n];
		}
	}
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		System.out.println(f.fibonacciTabla(10));
	}
}
