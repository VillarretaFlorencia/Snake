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

public class PanelJuego extends JPanel implements KeyListener{
		
	private JLabel[][] label = new JLabel[20][20];
	
	private JPanel infoPane;
	private JLabel lbNivel;
	private JLabel lbPuntaje;
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
		//nivel.setPanelJuego (this);
		
		/*
		infoPane = new JPanel(new BorderLayout());
		infoPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			
		lbNivel = new JLabel("Nivel : " + n);
		infoPane.add(lbNivel, BorderLayout.WEST); 

		lbCronometro = new JLabel("Tiempo: ");
		infoPane.add(lbCronometro, BorderLayout.CENTER);
		
		lbPuntaje = new JLabel("Puntaje: 0");
		infoPane.add(lbPuntaje, BorderLayout.EAST); 
		
		this.add(infoPane, BorderLayout.NORTH);
		*/
		//System.out.println(" +++++++++++ " + hiloCriatura.isAlive());
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
	

	@Override
	public void keyTyped(KeyEvent e) {
		switch(e.getKeyChar()){
			case 'w': juego.cambiarDireccion(1); break;
			case 'd': juego.cambiarDireccion(2); break;
			case 's': juego.cambiarDireccion(3); break;
			case 'a': juego.cambiarDireccion(4); break;
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
