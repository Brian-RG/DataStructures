//import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderHanoi extends JPanel{
	
	Hanoi hanoi;
	
	public SliderHanoi(Hanoi hanoi) {
		this.hanoi = hanoi;
		
		this.setBackground(Color.WHITE);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		JLabel labelVel = new JLabel("Velocidad");
		
		JSlider slider = new JSlider(JSlider.VERTICAL,1,10,5);
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				hanoi.setVelocidad(slider.getValue());
				//me esta dando una excepción en la línea 23 de este código, del rango 
			}
		});
		add(labelVel);
		add(slider);
	}
	
}
