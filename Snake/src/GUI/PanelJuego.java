package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bloque.Bloque;
import Juego.Juego;
import Nivel.*;
import Posicion.Posicion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PanelJuego extends JPanel {
		
	private JLabel[][] label = new JLabel[20][20];
	
	
	private JLabel lbCronometro;
	

	Juego juego = Juego.getJuego();
	
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
	
	public void iniciar(int n, String name) {
		juego.iniciarJuego(n, name);
	}
	
	public void actualizarLabel (int x, int y, String imagen) {
		//hacer icono 
		label[x][y].setIcon(new ImageIcon(PanelJuego.class.getResource(imagen)));
		label[x][y].repaint();
	}
	
	public void actualizarTiempo (int tiempo) {
		lbCronometro.setText("Tiempo: " + tiempo);
	}
	
	public void actualizarPuntaje (int puntaje) {
		lbCronometro.setText("Puntaje: " + puntaje);
	}
	

	
	
}
