import java.util.Stack;

public class Main {
	
	static Stack<Integer> torreA = new Stack();
	static Stack<Integer> torreB = new Stack();
	static Stack<Integer> torreC = new Stack();
	
	public static void main(String[] args) {
		
		// La pieza chica tiene como valor, el número 1
		// La pieza mediana tiene como valor, el número 2
		// La pieza grande tiene como valor, el número 3
		
		torreA.push(3);
		torreA.push(2);
		torreA.push(1);
		
		System.out.println("Inicio del juego: ");
		System.out.println("Torre A: " + torreA.toString());
		System.out.println("Torre B: " + torreB.toString());
		System.out.println("Torre C: " + torreC.toString());
		System.out.println("------------------------------");
		
		resolverHanoi(3, torreA, torreB, torreC);
		
		System.out.println("------------------------------");
		System.out.println("Juego terminado: ");
		System.out.println("Torre A: " + torreA.toString());
		System.out.println("Torre B: " + torreB.toString());
		System.out.println("Torre C: " + torreC.toString());
		
	}
	
	public static void resolverHanoi(int piezas, Stack torreA, Stack torreB, Stack torreC) {
		if(piezas == 1) {
			System.out.println("Torre A: " + torreA.toString());
			System.out.println("Torre B: " + torreB.toString());
			System.out.println("Torre C: " + torreC.toString() + "\n");
			torreC.push(torreA.pop());
		} else {
			resolverHanoi(piezas-1, torreA, torreC, torreB);
			resolverHanoi(1, torreA, torreB, torreC);
			resolverHanoi(piezas-1, torreB, torreA, torreC);
		}
	}
	
}