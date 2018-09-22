import javax.swing.JFrame;


public class Knights extends JFrame{
	public Tablero t= new Tablero();
	public Knights() {
		super();
		//this.setSize(960,800);
		this.setVisible(true);
		this.setResizable(false);
		//this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(t);
		this.pack();
	}
	
	public static void main(String[] args) {
		Knights k = new Knights();
	}

}
