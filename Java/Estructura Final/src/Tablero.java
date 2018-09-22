import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Tablero extends JPanel implements MouseListener{
	ArrayList<Cuadro> cuadros= new ArrayList<Cuadro>();
	private Cuadro casilla[][]= new Cuadro[8][8]; 
	public ImageIcon[] pre=new ImageIcon[2];
	public ImageIcon[] over=new ImageIcon[2];
	caballo c;
	Cuadro d;
	public Tablero() {
		super();
		pre[0]=new ImageIcon("C:\\Users\\brian\\Desktop\\Cuadro.png");
		pre[1]=new ImageIcon("C:\\Users\\brian\\Desktop\\oscuro.png");
		over[0]=new ImageIcon("C:\\Users\\brian\\Desktop\\over.png");
		over[1]=new ImageIcon("C:\\Users\\brian\\Desktop\\overn.png");
		this.setPreferredSize(new Dimension(600,600));
		this.setLayout(new GridLayout(8,8));
		this.setBorder(BorderFactory.createEmptyBorder(36, 36, 36,36));
		this.addMouseListener(this);
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				this.add(d=new Cuadro(pre[(((j%2)+i)%2)],(8*i+j),over[(((j%2)+i)%2)] ,this) );
				casilla[i][j]=d;
			}
		}
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getSource());
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
