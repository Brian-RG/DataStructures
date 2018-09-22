import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Cuadro extends JButton implements MouseListener{
	private int width=66;
	private int height=66;
	private int posX,posY;
	private int id;
	private boolean active=true;
	private ImageIcon img,over;
	private Tablero t;
	public Cuadro(ImageIcon imagen, int id,ImageIcon ovr, Tablero t) {
		super(imagen);
		this.setMargin(new Insets(0,0,0,0));
		this.id=id;
		this.img=imagen;
		this.over=ovr;
		this.t=t;
		this.addMouseListener(this);
		//this.setBounds(posX, posY, width, height);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Iterator<Cuadro> i =t.cuadros.iterator();
		System.out.println(arg0.getSource());
		/*while(i.hasNext()) {
			Cuadro f= i.next();
			f.removeMouseListener(f.getMouseListeners()[0]);
			//System.out.println("Holi");
		}*/
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(this.active) {	
			this.setIcon(this.over);
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if(this.active) {
			this.setIcon(this.img);
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setActive() {
		this.active=!this.active;
	}
	public void over() {
		
	}
	public void left() {
		
	}
	
}
