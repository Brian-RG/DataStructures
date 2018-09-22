//A01633401 Brian Reyes
//CLASE EJEMPLOPILAS
//Miércoles 14 de Febrero
//No comment

//ACUMULADOR PARA LA OPERACIÓN DESDE EL QUEUE, MATH/MULT SE GUARDA EN UN ACUMULADOR 
public class EjemploPilas {
	public static StackLE<Integer> clonarPila(StackLE<Integer> pila){	
		StackLE<Integer> s= new StackLE<Integer>();
		StackLE<Integer> c= new StackLE<Integer>();
			while(!pila.isEmpty()) {
				c.push(pila.pop());
			}
			while(!c.isEmpty()) {
				s.push(c.top());
				pila.push(c.pop());
			}
		return s;
	}
	
	public static void borrarValor(StackLE<Integer> pila,int valor) {
		StackLE<Integer> v= new StackLE<Integer>();
		while(!pila.isEmpty()) {
			if(pila.top().intValue()==valor) {
				pila.pop();
			}
			else {
				v.push(pila.pop());
			}
		}
		
		while(!v.isEmpty()) {
			pila.push(v.pop());
		}
	}
	
	/*public static int pruebaExpresión(String ex) {
		convierteinfija(ex.replace(" ", ""));
		return 1;
	}
	
	private static void convierteinfija(String ex) {
		String d="";
		int n;
		QueueLE<String> valores= new QueueLE<String>();
		StackLE<String> operadores= new StackLE<String>();
		for(int i=0;i<ex.length();i++) {
			char c=ex.charAt(i);
			if(  (ex.charAt(i)>=48)  &&  (ex.charAt(i)<58) ) {
				d+=c;	
			}
			else if(d.isEmpty()) {
				d+=c;
			}
			else {
				valores.enqueue(d);
				d="";
				d+=c;
				insertaoperador(operadores,d,valores);
				operadores.push(d);
				d="";			
			}
		}
		if(!d.isEmpty()) { valores.enqueue(d);}
		System.out.println("VALORES:");
		System.out.println(valores);
		System.out.println("--------------------");
		System.out.println("OPERADORES:");
		System.out.println(operadores);
		
		while(!operadores.isEmpty()) {
			valores.enqueue(operadores.pop());
		}
		
	}
	
	public static boolean insertaoperador(StackLE<String> operador, String d,QueueLE<String> valores) {
		if(operador.isEmpty()) {
			operador.push(d);
			return true;
		}
		else {
			String dato=operador.top();
			if(dato.equals("+")|| dato.equals("-")) {
				operador.push(d);
				return true;
			}
			else if(dato.equals("*") || dato.equals("/") ) {
				if(d.equals("+") || d.equals("-")) {
					valores.enqueue(operador.pop());
				}
			}
		
		}
	
	}
	
	
	private static void conviertePostfija(StackLE<String> operadores, QueueLE<String> valores) {
		
	}*/
	
	public static void main(String [] args) {
		//pruebaExpresión("212+232+201*30-44*-5");
		/*StackLE<Integer> pilita = new StackLE<Integer>();
		pilita.push(1);
		pilita.push(2);
		pilita.push(3);
		pilita.push(4);
		pilita.push(2);
		pilita.push(5);
		StackLE<Integer> copita=clonarPila(pilita);
		System.out.println(copita);
		System.out.println("----------------------");
		System.out.println(pilita);
		borrarValor(pilita, 7);
		System.out.println("----------------BORRANDO----------------");
		System.out.println(pilita);*/
	}
}
