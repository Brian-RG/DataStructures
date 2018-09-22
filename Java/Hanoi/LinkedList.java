
public class LinkedList<T>{
	
	private int size;
	private Node<T> inicio,
			fin;
	
	
	public LinkedList() {
		this.size=0;
		this.inicio=this.fin=null;
	}
	
	
	public LinkedList(T[] arreglo) {
		for(int i=0; i<arreglo.length; i++) {
			this.insertarFin(arreglo[i]);
		}
	}
	
	
	public T inicio() {
		try {
			return this.inicio.getDato();
		}
		catch(NullPointerException e) {
			throw new ListaVaciaException();
		}
	}
	
	
	public T fin() {
		try {
			return this.fin.getDato();
		}
		catch(NullPointerException e) {
			throw new ListaVaciaException();
		}
	}
	
	
	public int getSize() {
		return this.size;
	}
	
	
	public boolean estaVacia() {
		return this.size==0;
	}
	
	
	public void insertarInicio(T dato) {
			Node <T> nuevoInicio= new Node<T>(dato,this.inicio);
			this.inicio=nuevoInicio;
			if(size==0) {
				this.fin=nuevoInicio;
			}
			this.size++;
	}
	
	
	public void insertarFin(T dato) {
		
		if(size==0) {
			this.insertarInicio(dato);
		}
		else {
			Node <T> nuevoFinal= new Node<T>(dato);
			this.fin.setNext(nuevoFinal);
			this.fin=nuevoFinal;
			this.size++;
		}
	}

	
	public void insertarEn(int pos,T dato) throws IndexOutOfBoundsException{
		//Tarea
		//Considerar el throw de IndexOutOfBounds exception, si pos <0 or > size
		if(pos<0 || pos>size) {
			throw new IndexOutOfBoundsException();
		}
		else if(pos==0) {
			this.insertarInicio(dato);
		}
		else if(pos==size) {
			this.insertarFin(dato);
		}
		Node tmp=this.inicio;
		for(int i=0;i<pos-1;i++) {
				tmp=tmp.getNext();
		}
		Node nuevo= new Node(dato,tmp.getNext());
		tmp.setNext(nuevo);
		this.size++;
	}
	
	
	public T borrarInicio() throws ListaVaciaException{
		try {
			T tmp=this.inicio.getDato();
			this.inicio=inicio.getNext();
			size--;
			if(size==0) {
				this.fin=null;
			}
			return tmp;
		}			
		catch(NullPointerException e) {
			throw new ListaVaciaException();
		}
	}
	
	
	public T borrarFin() {
		try {
			T tmp= this.fin.getDato();
			if(this.size==1) {
				this.borrarInicio();
			}
			else {
				this.borrarEn(size-1);
			}
			return tmp;
		}
		catch(NullPointerException e){
			throw new ListaVaciaException("No se puede borrar el fin de una lista vacía ");
		}
	}
	
	
	public T borrarEn(int pos) {
		if(pos<0 || pos>=size) {
			throw new IndexOutOfBoundsException();
		}
		else if(pos==0) {
			this.borrarInicio();
			this.size--;
			return this.inicio.getDato();
		}
		else {
			Node<T> tmp=this.inicio;
			for(int i=0;i<pos-1;i++) {
				tmp=tmp.getNext();
			}
			if(pos==size-1) {
				tmp.setNext(null);
				this.fin=tmp;
				this.size--;
				return this.fin.getDato();
			}
			else {
				T d=tmp.getNext().getDato();
				tmp.setNext(tmp.getNext().getNext());
				this.size--;
				return d;
			}
		}
	}
	
	
	public void setAt(int pos,T dato) {
		Node tmp=this.inicio;
		if(pos<0 || pos>size) {
			throw new IndexOutOfBoundsException();
		}
		for(int j=0;j<pos;j++) {
			tmp=tmp.getNext();
		}
		tmp.setDato(dato);
	}
	
	
	@Override
	public String toString() {
		String r="";
		Node tmp = inicio;
		for(int i=0; i<size; i++) {
			r+=tmp.toString() +"\n";
			tmp=tmp.getNext();
		}
		return r;
	}

	
	public static void main(String[] args) {
		LinkedList<String> lista= new LinkedList<String>();
		lista.insertarFin("Aranza");
		lista.insertarFin("Aldo");
		lista.insertarFin("Esau");
		lista.insertarFin("Brian");
		lista.insertarFin("Holis");
		System.out.println(lista);
		System.out.println("-------------------------------------------------------------");
		lista.insertarEn(4, "DON QUIRININ");
		System.out.println(lista);
		System.out.println("-------------------------------------------------------------");
		lista.borrarEn(2);
		System.out.println(lista);
		System.out.println("-------------------------------------------------------------");
		lista.borrarFin();
		System.out.println(lista);
		System.out.println("-------------------------------------------------------------");
		lista.borrarEn(0);
		System.out.println(lista);
		System.out.println("-------------------------------------------------------------");
		System.out.println(lista.inicio());
		System.out.println(lista.fin());
		System.out.println(lista.getSize());
		System.out.println(lista.estaVacia());
		
		System.out.println("------------------------------------------------------------------");
		System.out.println(lista);
		for(int k=0;k<lista.getSize();k++) {
			lista.setAt(k, "null");
		}
		System.out.println(lista);
	}

}



class Node<T>{
	private Node <T> next;
	private T dato;

	
	public Node(T dato) {
		this(dato,null);
	}
	
	
	public Node(T dato, Node<T> next) {
		this.next=next;
		this.dato=dato;
	}
	
	
	public Node<T> getNext(){
		return this.next;
	}
	
	
	public void setNext(Node<T> next) {
		this.next=next;
	}
	
	
	public T getDato() {
		return this.dato;
	}
	
	
	public void setDato(T dato) {
		this.dato=dato;
	}

	
	@Override
	public String toString() {
		return dato.toString();
	}
	
}