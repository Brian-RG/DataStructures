
public class QueueLE<T> {
	private LinkedList<T> lista;
	
	public QueueLE() {
		this.lista= new LinkedList<T>();
	}
	
	public boolean isempty() {
		return this.lista.estaVacia();
	}
	
	public int size() {
		return this.lista.getSize();
	}
	
	public void enqueue(T dato) {
		this.lista.insertarFin(dato);
	}
	
	public T dequeue() {
		return this.lista.borrarInicio();
	}
	
	public T next() {
		return this.lista.inicio();
	}
	
	public void flush() {
		this.lista=new LinkedList<>();
		System.gc();
	}
	
	public String toString() {
		return this.lista.toString();
	}
}
