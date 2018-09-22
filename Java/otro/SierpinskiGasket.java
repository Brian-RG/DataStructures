import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SierpinskiGasket extends JFrame{
	private int level;
	
	public SierpinskiGasket() {
		super("Fractal SierpinskiGasket");
		this.setSize(640,480);
		this.level=Integer.parseInt(JOptionPane.showInputDialog("Escribe el nivel de profundidad a calcular"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Point a= new Point(20,380);
		Point b=new Point(620,380);
		Point c= new Point(320,50);
		
		this.pintaTriangulos(g, this.level, a, b, c);
	}
	
	private Point puntomedio(Point a, Point b) {
		return new Point((a.x+b.x)/2 , (a.y+b.y)/2);
	}
	
	private void pintaTriangulos(Graphics g, int l, Point a, Point b, Point c) {
		if(l==0) {
			pintalineas(g, a, b);
			pintalineas(g,b,c);
			pintalineas(g,c,a);
		}
		else {
			Point ab2=this.puntomedio(a, b),
				  bc2=this.puntomedio(b, c),
				  ca2=this.puntomedio(c, a);
			this.pintaTriangulos(g, l-1, a, ab2, ca2);
			this.pintaTriangulos(g, l-1, ab2, b, bc2);
			this.pintaTriangulos(g, l-1, ca2, bc2, c);
		}
	}
	
	private void pintalineas(Graphics g, Point a, Point b) {
		g.drawLine(a.x, a.y, b.x, b.y);
	}
	
	
	
	public static void main(String[] args) {
		SierpinskiGasket fractal= new SierpinskiGasket();
	}
}
