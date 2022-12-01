package GUI;

import javax.swing.ImageIcon;
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
		//nivel = new Nivel(1);
		for(int x = 0; x < 20; x++) {
			for(int y = 0; y < 20; y++) {
				label[x][y] = new JLabel();
				//label[x][y].setText("("+x+" "+y+")");
				//label[x][y].setIcon(new ImageIcon(PanelJuego.class.getResource("/Recursos/suelo.png")));
				this.add(label[x][y]);
				label[x][y].setVisible(true);
				
			}
		}
	}
	
	public void actualizarLabel (int x, int y, String imagen) {
		//hacer icono 
		label[x][y].setIcon(new ImageIcon(PanelJuego.class.getResource(imagen)));
		//label[pos.getX()][pos.getY()].repaint();
	}

}
