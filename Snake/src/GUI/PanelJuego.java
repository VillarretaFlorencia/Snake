package GUI;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Juego.Juego;

public class PanelJuego extends JPanel {
		
	private JLabel[][] label = new JLabel[20][20];

	Juego juego = Juego.getJuego();
	
	public PanelJuego() {
		setLayout(new GridLayout(20,20));
		for(int x = 0; x < 20; x++) {
			for(int y = 0; y < 20; y++) {
				label[x][y] = new JLabel();
				this.add(label[x][y]);
				label[x][y].setVisible(true);
			}
		}
	}
	
	public void iniciar(int n, String name) {
		juego.iniciarJuego(n, name);
	}

	public void actualizarLabel (int x, int y, String imagen) {
		label[x][y].setIcon(new ImageIcon(PanelJuego.class.getResource(imagen)));
		label[x][y].repaint();
	}
}
