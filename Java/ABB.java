public class ABB <E extends Comparable <E>> {
	private int size;
	private NodoABB<E> raiz;
	
	public ABB() {
		this.size=0;
		this.raiz=null;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void insertar(E valor) {
		NodoABB<E> nuevo = new NodoABB<E>(valor);
		if(this.raiz==null) {
			this.raiz=nuevo;
		}
		else {
			insertarrecursivo(nuevo,raiz);
		}
		size++;
	}
	
	public E buscar(E valor) {
		if(this.raiz==null) {
			return null;
		}
		else {
			NodoABB<E> current = this.raiz;
			while(current!=null) {
				if(valor.compareTo(current.getValor())<0) {
					current=current.getIzq();
				}
				else if(valor.compareTo(current.getValor())>0) {
					current=current.getDer();
				}
				else {
					return valor;
				}
			}
			return null;
		}
	}
	
	public E borrar(E valor){
		if(this.raiz==null) {
			return null;
		}
		else {
			NodoABB<E> current = this.raiz;
			NodoABB<E> parent = current;
			while(current!=null) {
				if(valor.compareTo(current.getValor())<0) {
					current=current.getIzq();
				}
				else if(valor.compareTo(current.getValor())>0) {
					current=current.getDer();
				}
				else {
					return valor;
				}
			}
			return null;
		}
	}
	
	public void insertarrecursivo(NodoABB<E> nuevo,NodoABB<E> comparar) {
		if(nuevo.getValor().compareTo(comparar.getValor()) <0) {
			if(comparar.getIzq()==null) {
				comparar.setIzq(nuevo);
			}
			else {
			insertarrecursivo(nuevo,comparar.getIzq());
			}
		}
		else {
			if(comparar.getDer()==null) {
				comparar.setDer(nuevo);
			}
			else {
			insertarrecursivo(nuevo,comparar.getDer());
			}
		}		
	}
	
	public String toString(){
		String result="",r="", res="";
		r=generaString(r,this.raiz);
		System.out.println(r);
		res=imprimeInorden(res,this.raiz);
		System.out.println(res);
		result=imprimePostOrden(result,this.raiz);
		return result;
	}
	
	public String generaString(String r,NodoABB<E> nodo) {
		if(nodo!= null) {
			//Tipo: "¿Cómo le hiciste?" -"No sé, yo apreté todos los botones"
			r+=/*"\n Nodo: "+*/nodo+",";
			//r+="\n Izquierda de " + nodo + ": ";
			r=generaString(r,nodo.getIzq());
	//		r+=/*"\nDerecha de " */+ nodo + " ";
			r=generaString(r,nodo.getDer());
		}
		else {
		//	r+="\n null \n";
		}
		
		return r;
	}
	
	private String imprimeInorden(String r, NodoABB<E> nodo) {
		if(nodo!=null) {
			r=imprimeInorden(r,nodo.getIzq());
			r+=nodo +",";
			r=imprimeInorden(r,nodo.getDer());
		}
		return r;
	}
	
	private String imprimePostOrden(String r, NodoABB<E> nodo) {
		if(nodo!=null) {
			r=imprimePostOrden(r,nodo.getIzq());
			r=imprimePostOrden(r,nodo.getDer());
			r+=nodo +",";
		}
		return r;
	}
	
	public String Stringnivel(QueueLE<NodoABB<E>> nodos, String r, NodoABB<E> nodo) {
		nodos.enqueue(nodo);
		while(!nodos.isempty()) {
			
		}
		return r;
	}
	
	public void Stringnivel() {
		QueueLE<NodoABB<E>> nodos= new QueueLE<NodoABB<E>>();
		nodos.enqueue(this.raiz);
		String r="";
		while(!nodos.isempty()) {
			if(nodos.next().getIzq()!=null) {
				nodos.enqueue(nodos.next().getIzq());
			}
			if(nodos.next().getDer()!=null) {
				nodos.enqueue(nodos.next().getDer());
			}
			r+=nodos.dequeue();
		}
		
	}
	
	private NodoABB<E> predecesor(NodoABB<E> nodo){
		NodoABB<E> current = nodo.getIzq();
		while(current.getDer()!=null) {
			current=current.getDer();
		}
		return current;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ABB<Integer> arbol= new ABB<Integer>();
		arbol.insertar(21);
		arbol.insertar(13);
		arbol.insertar(33);
		arbol.insertar(10);
		arbol.insertar(18);
		arbol.insertar(25);
		arbol.insertar(40);
		arbol.insertar(29);
		arbol.insertar(27);
		arbol.insertar(30);
		System.out.println(arbol);
		/*System.out.println("Buscando: \n ----------------------------------------------");
		System.out.println(arbol.buscar(3));
		System.out.println(arbol.buscar(6));
		System.out.println(arbol.buscar(5));
		System.out.println(arbol.buscar(10));
		System.out.println(arbol.buscar(1));
		*/
		
	}

}


class NodoABB<E>{
	private E valor;
	private NodoABB<E> izq, 
					der;
	
	public NodoABB(E valor) {
		this(valor,null,null);
	}
	
	public NodoABB(E valor, NodoABB<E> izq, NodoABB<E> der) {
		this.valor=valor;
		this.izq=izq;
		this.der=der;
	}
	
	public E getValor() {
		return valor;
	}

	public NodoABB<E> getIzq() {
		return izq;
	}

	public void setIzq(NodoABB<E> izq) {
		this.izq = izq;
	}

	public NodoABB<E> getDer() {
		return der;
	}

	public void setDer(NodoABB<E> der) {
		this.der = der;
	}

	public void setValor(E valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return " " + valor;
	}
}
