import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Hanoi extends JPanel implements Runnable {
	private Thread hilo;
	private int discos;
	private int velocidad=5;
	private int movimientos = 0;
	private ArrayList<Color> colores= new ArrayList<Color>();
	private StackLE<Disco> torreA=new StackLE<Disco>();
	private StackLE<Disco> torreB=new StackLE<Disco>();
	private StackLE<Disco> torreC=new StackLE<Disco>();
	
	
	public Hanoi() {
		generacolores();
		this.setBackground(Color.WHITE);
		this.discos=3;
        hilo= new Thread(this);
        hilo.setPriority(Thread.MAX_PRIORITY);
        hilo.start();
		creaTorreInicial(discos);		
	}
	
	public void creaTorreInicial(int discos){
		for(int i=0;i<discos;i++) {
			torreA.push(new Disco(this.colores.get(i),i));
		}
	}
	
	private void generacolores() {
		colores.add(Color.BLUE);
		colores.add(Color.RED);
		colores.add(Color.YELLOW);
		colores.add(Color.BLUE);
		colores.add(Color.GREEN);
		colores.add(Color.RED);
		colores.add(Color.BLUE);
		colores.add(Color.RED);
		colores.add(Color.YELLOW);
		colores.add(Color.BLUE);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect( ( ((this.getWidth()/3-5)-1)/2), 50, 5, (this.getHeight()-60));
		g.drawRect( (this.getWidth()/2 ), 50, 5, (this.getHeight()-60));
		int ancho= ((this.getWidth()/3)*2+11) + (this.getWidth()/3-20);
		int pinicial= (this.getWidth()/3)*2 +11;
		g.drawRect(  pinicial+(ancho-pinicial)/2, 50, 5, (this.getHeight()-60));
	//	g.drawRect(  pinicial+ ((this.getWidth()/3-5)-1)/2, 50, 5, (this.getHeight()-60));
		
	//	g.drawLine(this.getWidth()/2, 50, this.getWidth()/2, this.getHeight()-15);
	//	g.drawRect(intX, intY, Ancho, ALTo);e
		int piAX=1,
		piBX=(this.getWidth()/3)+6,
		piCX=(this.getWidth()/3)*2+11,
		PY=this.getHeight()-10,
		anchoA=this.getWidth()/3-5,
		anchoB=this.getWidth()/3-5,
		anchoC=this.getWidth()/3-20;
		g.drawRect(piAX, PY, this.getWidth()/3-5, 9);
		g.drawRect(piBX, PY, (this.getWidth()/3)-5, 9);
		g.drawRect(piCX, PY, this.getWidth()/3-20, 9);
		
		StackLE<Disco> pila1 =copiaPila(torreA);
		StackLE<Disco> pila2=copiaPila(torreB);
		StackLE<Disco> pila3=copiaPila(torreC);
		PintaPila(g, pila1,piAX,anchoA,PY);
		PintaPila(g, pila2,piBX,anchoB,PY);
		PintaPila(g, pila3,piCX,anchoC,PY);

	}
	
	public static StackLE<Disco> copiaPila(StackLE<Disco> torre){
		//No copia la pila directamente, la copia de manera inversa.
		StackLE<Disco> copia= new StackLE<Disco>();
		StackLE<Disco> c= new StackLE<Disco>();
			while(!torre.isEmpty()) {
				copia.push(torre.top());
				c.push(torre.pop());
			}
			while(!c.isEmpty()) {
				torre.push(c.pop());
			}
		return copia;
	}
	
	public void PintaPila(Graphics g, StackLE<Disco> torre,int pInicial, int ancho, int PY) {
		if(!torre.isEmpty()) {
			torre.pop().pintaDisco(g,pInicial,ancho,PY);
			PintaPila(g,torre,pInicial,ancho, PY);
		}
	}
	

	
	public void setDiscos(int discos) {
		this.discos=discos;
		this.reinicia();
	}
	
	public int getDiscos() {
		return this.discos;
	}
	
	public int getMovimientos() {
		return this.movimientos;
	}
	
	public void setVelocidad(int vel) {
		this.velocidad=vel;
	}
	
	public StackLE<Disco> getTorreA(){
		return this.torreA;
	}
	public StackLE<Disco> getTorreB(){
		return this.torreB;
	}
	public StackLE<Disco> getTorreC(){
		return this.torreC;
	}
	
	public void espera() {
		long startTime = System.currentTimeMillis();
		for (int count = 0; ;count++) {
		long now = System.currentTimeMillis();
		if(now - startTime >= 1000 / this.velocidad) break;
		// Do nothing
		}
	}
	
	
	public void reinicia() {
		torreA.flush();
		torreB.flush();
		torreC.flush();
		creaTorreInicial(this.discos);
		this.repaint();
	}
	
	public void run() {
		try {   
					paintImmediately(0, 0, getWidth(), getHeight());
					this.repaint();
				Thread.sleep(1000 / this.velocidad);
        }
        catch(InterruptedException e){
            System.out.println("No se puede detener");
        }
	}
	
	
	public void resuelve(int nivel, StackLE<Disco> torreI, StackLE<Disco> torreDest, StackLE<Disco> torreAux) {
			if(nivel == 1) {
				torreDest.push(torreI.pop());
				this.movimientos++;
			} else if(nivel>1){

				resuelve(nivel-1, torreI, torreAux, torreDest);
				resuelve(1, torreI, torreDest, torreAux);
				resuelve(nivel-1, torreAux, torreDest, torreI);
			}
			//espera();
			/*long startTime = System.currentTimeMillis();
			for (int count = 0; ;count++) {
			long now = System.currentTimeMillis();
			if(now - startTime >= 1000 / this.velocidad) break;
			// Do nothing
			}*/
			//paintImmediately(0, 0, getWidth(), getHeight());
			run();
	}
	
	public static void main(String[] args) {
		JFrame ventana = new JFrame("Torres de Hanoi - Brian Reyes - Rafael Elu");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Hanoi hanoi = new Hanoi();
		ventana.add(new PanelControlHanoi(hanoi), BorderLayout.NORTH);
		ventana.add(new SliderHanoi(hanoi), BorderLayout.WEST);
		ventana.add(hanoi);
		ventana.setSize(800, 300);
		ventana.setLocation(280,200);
		ventana.setMinimumSize(new Dimension(414,255));
		ventana.setVisible(true);
	}
	
}
