package GUI;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Bloque.Bloque;
import Nivel.*;
import Posicion.Posicion;

import java.awt.GridLayout;

public class PanelJuego extends JPanel {
	
	private JLabel[][] label = new JLabel[20][20];
	private Nivel nivel;
	
	public PanelJuego() {
		setLayout(new GridLayout(20,20));
		nivel = new Nivel();
		
	}
	
	public void actualizarLabel (Bloque bloque) {
		Posicion pos = bloque.getPosicion(); 
		//hacer icono 
		label[pos.getX()][pos.getY()].setImageIcon(bloque.getImagen());
		//label[pos.getX()][pos.getY()].repaint();
	}

}
