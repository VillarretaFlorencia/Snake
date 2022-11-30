package GUI;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Nivel.*;

import java.awt.GridLayout;

public class PanelJuego extends JPanel {
	
	private JLabel[][] label = new JLabel[20][20];
	private Nivel nivel;
	
	public PanelJuego() {
		setLayout(new GridLayout(20,20));
		nivel = new Nivel();
		
	}

}
