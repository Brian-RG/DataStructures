import java.util.NoSuchElementException;


public class TablaHash<K,V> {

	private ListaEnlazada<NodoHT<K,V>>[] tabla;
	private int size;
	
	public TablaHash() {
		this(13);
	}
	
	public TablaHash(int size) {
		this.tabla=(ListaEnlazada<NodoHT<K,V>>[]) (new ListaEnlazada[size]);
		for(int i=0;i<this.tabla.length;i++) {
			this.tabla[i]=new ListaEnlazada<>();
		}
		/*for(ListaEnlazada l: tabla) {
			l=new ListaEnlazada<>();
		}*/
		this.size=0;
	}
	
	public void put(K llave, V valor) {
		int pos=llave.hashCode()%this.tabla.length;
		this.tabla[pos].insertarFin(new NodoHT(llave,valor));
		this.size++;
	}
	
	public V get(K llave) {
		int pos=llave.hashCode()%this.tabla.length;
		ListaEnlazada<NodoHT<K,V>> l =this.tabla[pos];
		NodoHT<K,V> current;
		for(int i=0;i<l.getSize();i++) {
			current=l.getAt(i);
			if(llave.equals(current.getllave())) {
				return current.getvalor();
			}
		}
		return null; 
	}

	public V delete(K llave) throws NoSuchElementException {
		if(this.size>=0) {
			int pos=Math.abs(llave.hashCode())%this.tabla.length;
			ListaEnlazada<NodoHT<K,V>> l=this.tabla[pos];
			NodoHT<K,V> current;
			for(int i=0;i<l.getSize();i++) {
				current=l.getAt(i);
				if(llave.equals(current.getllave())) {
					this.size--;
					return l.borrarEn(i).getvalor();
				}
			}
		}
			throw new NoSuchElementException("No se encontró la llave");
	}
	
	public void clear() {
		TablaHash<K,V> tmp = new TablaHash<K,V>(13);
		this.tabla=tmp.tabla;
		this.size=0;
		System.gc();
	}
	
	publ1ic boolean containsKey(K llave) {
		try {
			this.get(llave);
			return true;
		}
		catch(NoSuchElementException e) {
			return false;
		}
	}
	
}
class NodoHT<E,V>{
	private E llave;
	private V valor;
	
	public NodoHT(E llave, V valor) {
		this.llave=llave;
		this.valor=valor;
	}
	
	public E getllave() {
		return this.llave;
	}
	
	public void setLlave(E llave) {
		this.llave=llave;
	}
	
	public V getvalor() {
		return this.valor;
	}
	
	public void setvalor() {
		this.valor=valor;
	}
}
