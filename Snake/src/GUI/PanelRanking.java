package GUI;

import javax.swing.JPanel;
import java.awt.Color;

import Juego.Jugador;
import Ranking.Ranking;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class PanelRanking extends JPanel {
	Ranking rank;
	JLabel[] tabla;
	
	public PanelRanking() {
		setBackground(Color.BLACK);
		setLayout(null);
		
		JLabel tituloRanking = new JLabel("");
		tituloRanking.setIcon(new ImageIcon(PanelRanking.class.getResource("/Recursos/tituloRanking.png")));
		tituloRanking.setBounds(136, 11, 312, 74);
		add(tituloRanking);
		tabla = new JLabel[5];
		rank = new Ranking();
		
		LinkedList<Jugador> jugadores = rank.getListaJugadores();
		int i = 0;
		for(Jugador j : jugadores) {
			tabla[i] = new JLabel();
			tabla[i].setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			tabla[i].setForeground(Color.GREEN);
			tabla[i].setText((i+1)+". "+ j.getNombre()+" - "+j.getPuntaje()+" Puntos");
			i++;
		}
		
		tabla[0].setBounds(140, 120, 350, 50);
		tabla[1].setBounds(140, 150, 350, 50);
		tabla[2].setBounds(140, 180, 350, 50);
		tabla[3].setBounds(140, 210, 350, 50);
		tabla[4].setBounds(140, 240, 350, 50);
		
		add(tabla[0]);
		add(tabla[1]);
		add(tabla[2]);
		add(tabla[3]);
		add(tabla[4]);
	}
	
	public void finJuego(Jugador j) {
		rank.sobreescribir(j);
	}
}
