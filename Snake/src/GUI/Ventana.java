package GUI;

import java.awt.CardLayout;

import javax.swing.JFrame;

import Juego.Juego;

public class Ventana extends JFrame {
	//identificadores
	static final String START = "menu de inicio";
	static final String JUEGO = "Panel del juego";
	static final String RANKING = "Panel del ranking";
	
	//Paneles <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	PanelInicial panelInicial = new PanelInicial();
	PanelJuego panelJuego = new PanelJuego();
	PanelRanking panelRanking = new PanelRanking();
	
	Juego juego = Juego.getJuego();
	
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 600, 600);
	    getContentPane().setLayout(new CardLayout(0, 0));
	    this.setResizable(false);
	    panelRanking.setVisible(true);
	    //añadimos los paneles al frame
	    getContentPane().add(panelInicial, START);
	    getContentPane().add(panelJuego,JUEGO);
	    getContentPane().add(panelRanking,RANKING);
	}
	
	public static void main(String[] args) {
		Ventana ven = new Ventana();
		ven.setVisible(true);
	}
}
