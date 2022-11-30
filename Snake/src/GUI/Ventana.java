package GUI;

import java.awt.CardLayout;

import javax.swing.JFrame;

public class Ventana extends JFrame {
	//identificadores
	static final String START = "menu de inicio";
	static final String JUEGO = "Panel del juego";
	static final String RANKING = "Panel del ranking";
	
	//Paneles <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setLayout(new CardLayout(0, 0));
	}
}
