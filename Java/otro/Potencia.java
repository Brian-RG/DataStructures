//Autor: BRIAN REYES GÁLVEZ A01633401	
//Clase Potencia
//Martes 16 de Enero 2018
//No comments

import javax.swing.JOptionPane;

public class Potencia {
	public static double potencia(int base, int exponente) {
		if(exponente==1) {
			return base;
		}
		else {
			if(exponente >0) {
			return base* potencia(base,exponente-1);
			}
			else {
				return 1/ potencia(base,Math.abs(exponente));
			}
		}
	}
	
	public static void main(String[] args) {
		while(true) {
			try {
			int base=Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce la base: "));
			int exponente=Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce el exponente: "));
			JOptionPane.showMessageDialog(null, potencia(base,exponente));
			int respuesta=JOptionPane.showConfirmDialog(null, "¿Deseas ingresar otros numeros?");
			if(respuesta>0) {
				break;
			}
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error con el dato ingresado.");
			}
		}
	}
	
	
}
