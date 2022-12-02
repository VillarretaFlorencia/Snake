package GUI;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class PanelJuegoConRank extends JLayeredPane {
	private PanelJuego panelJuego;

	private JLabel lbPuntaje;
	private JLabel lbCronometro;
	public PanelJuegoConRank() {
		this.setBounds(0, 0, 600, 600);
		panelJuego = new PanelJuego();
		add(panelJuego, Integer.valueOf(1));
		panelJuego.setBounds(-3, 0, 590, 560);
		panelJuego.setVisible(true);
		
		lbCronometro = new JLabel("Tiempo: ");
		lbCronometro.setForeground(Color.WHITE);
		lbCronometro.setLocation(20, 0);
		lbCronometro.setSize(111, 15);
		add(lbCronometro, Integer.valueOf(2));
		
		lbPuntaje = new JLabel("Puntaje: 0");
		lbPuntaje.setForeground(Color.WHITE);
		lbPuntaje.setLocation(305, 0);
		lbPuntaje.setSize(80, 15);
		add(lbPuntaje, Integer.valueOf(2)); 
		
		setLayout(null);
		
	}
	
	public PanelJuego getPanelJuego() {
		return panelJuego;
	}
}
