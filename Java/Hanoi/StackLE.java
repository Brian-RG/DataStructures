 

public class StackLE<T> {
	private LinkedList<T> lista;
	
	public StackLE() {
		this.lista=new LinkedList<T>();
	}
	
	public boolean isEmpty() {
		return this.lista.estaVacia();
	}
	
	public int size() {
		return this.lista.getSize();
	}
	
	public void push(T dato) {
		this.lista.insertarInicio(dato);
	}
	
	public T pop() {
		return this.lista.borrarInicio();
	}
	
	public T top() {
		return this.lista.inicio();
	}
	
	public void flush() {
		this.lista=new LinkedList<>();
		System.gc();
	}
	
	public String toString() {
		return this.lista.toString();
	}
	
	public static void main(String[] args) {
		StackLE<String> pila1= new StackLE<String>();
		String[] nombres= {"Juan","Alberto","Ricardo","Esau","Aranza"};
		for(String i: nombres) {
			pila1.push(i);
		}
		
		while(!pila1.isEmpty()) {
			System.out.println(pila1.pop());
		}
		
	}

}
