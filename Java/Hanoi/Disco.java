import java.awt.Color;
import java.awt.Graphics;

public class Disco {
	
	Color color;
	int tamaño;
	
	public Disco(Color color, int tamaño) {
		this.color = color;
		this.tamaño=tamaño;
	}
	
	public String toString() {
		return Integer.toString(this.tamaño);
	}
	
	public void pintaDisco(Graphics g,int pInicial, int ancho, int altura) {
		g.setColor(this.color);
		g.fillRoundRect(pInicial + (this.tamaño*(ancho/20)), altura - ((tamaño+1)*(altura/15)), ancho -( tamaño * (ancho/20)*2), (altura/15), 20, 110);
	}
}
