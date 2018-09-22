import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ReglaRecursiva extends JPanel{
	private int nivel;
	
	public ReglaRecursiva() {
		super();
		this.nivel=1;
		this.setPreferredSize(new Dimension(1000,300));
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		this.setBackground(Color.WHITE);
		int x1=100;
 		int x2=((int)this.getWidth() -100);
 		int y=200;
 		int altura=10;
		g.drawLine(x1, y,x2, y);
		this.pintaregla(x1,x2,200,altura,this.getNivel(),g);
	}
	
	public void pintaregla(int x1, int x2, int y, int altura, int nivel, Graphics g) {
		int pm=(x1+x2)/2;
		int a=y-altura*nivel;
		if(nivel>0) {
			this.pintalinea(pm,y,a,g);
			this.pintaregla(x1, pm, y, altura, nivel-1, g);
			this.pintaregla(pm,x2,y,altura,nivel-1,g);
		}
	}
	
	public void pintalinea(int pm, int y1 , int y2, Graphics g) {
		g.drawLine(pm, 200, pm, y2);
	}
	
	
	public void setNivel(int n){
		this.nivel=n;
		this.repaint();
	}
	
	public int getNivel() {
		return this.nivel;
	}
	
	public static void main(String[] args) {
		JFrame ventana=new JFrame("Regla recursiva-Brian Reyes - A01633401 Gpo [2]");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ReglaRecursiva obj=new ReglaRecursiva();
		ventana.add(obj);
		ventana.add(new PanelControl(obj),BorderLayout.WEST);
		ventana.pack();
		ventana.setVisible(true);
	}
}

class PanelControl extends JPanel{
	JSlider js;
	public PanelControl(ReglaRecursiva obj) {
		super();
		this.setPreferredSize(new Dimension(200,300));
		this.js= new JSlider(JSlider.VERTICAL,1,11,1);
		this.js.setMinorTickSpacing(1);
		this.js.setMajorTickSpacing(11);
		this.js.setPaintTicks(true);
		this.js.setPaintLabels(true);
		this.js.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				obj.setNivel(js.getValue());
				System.out.println(js.getValue());
			}
		});
		this.add(js);
	}
	
	
}