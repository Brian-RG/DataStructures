import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelControlHanoi extends JPanel{
	
	Hanoi hanoi;
	private int flag=0;
	
	public PanelControlHanoi(Hanoi hanoi) {
		this.hanoi = hanoi;
		
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		
		JLabel labelDiscos = new JLabel("Discos: "),
				labelMovimientos = new JLabel("Movimientos: " + hanoi.getMovimientos()),
				labelMaximo = new JLabel("Movimientos: "+ 2*(hanoi.getDiscos()) +"") ;
		//Calcular el máximo de movimientos (2 ** (discos) -1);
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(3,1,10,1));
		JButton bComenzar = new JButton("Comenzar"),
				bReset = new JButton("Resetear");
		
		((JSpinner.DefaultEditor)spinner.getEditor()).getTextField().setEditable(false);
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				hanoi.setDiscos((Integer)spinner.getValue());
				bComenzar.setText("Comenzar");
				flag = 0;
			}
			
		});
		
		bComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag==0) {
					flag=1;
					hanoi.resuelve(hanoi.getDiscos(),hanoi.getTorreA(),hanoi.getTorreC(),hanoi.getTorreB());
					bComenzar.setText("Parar");
				}
				else if(flag == 1){
					flag=2;
					bComenzar.setText("Resumir");
				}
			}	
		});
		
		bReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hanoi.reinicia();
				bComenzar.setText("Comenzar");
				flag=0;
			}
		});
		
		this.add(labelDiscos);
		this.add(spinner);
		this.add(labelMovimientos);
		this.add(bComenzar);
		this.add(bReset);
	}
	
}
