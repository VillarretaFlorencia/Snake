package GUI;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Juego.Juego;

public class Ventana extends JFrame {
	//identificadores
	
	static final String START = "menu de inicio";
	static final String JUEGO = "Panel del juego";
	static final String RANKING = "Panel del ranking";
	
	//Paneles <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	PanelInicial panelInicial = new PanelInicial();
	PanelJuegoConRank panelJuego = new PanelJuegoConRank();
	PanelRanking panelRanking = new PanelRanking();
	
	
	InputMap im = panelJuego.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
    ActionMap am = panelJuego.getActionMap();
    
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
	    juego.setPanelJuego(panelJuego);
	    panelInicial.getStartBtn().addActionListener(
	            new ActionListener() { //tomamos el boton del start
	                public void actionPerformed(ActionEvent e) { //al momento de presionar el boton
	                  CardLayout c1 = (CardLayout) (getContentPane().getLayout()); //se cambia toma el panel
	                  panelJuego.getPanelJuego().iniciar(1, panelInicial.getNombre().getText());
	                  c1.show(getContentPane(), JUEGO); // y lo cambiamos en el contentPane
	                }
	              }
	            );
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "RightArrow");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "LeftArrow");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "UpArrow");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "DownArrow");

	    am.put("RightArrow", new ArrowAction("RightArrow"));
	    am.put("LeftArrow", new ArrowAction("LeftArrow"));
	    am.put("UpArrow", new ArrowAction("UpArrow"));
	    am.put("DownArrow", new ArrowAction("DownArrow"));
	}
	
	public void terminarJuego() {
		CardLayout c1 = (CardLayout) (getContentPane().getLayout());
		panelRanking.finJuego(juego.getJugador());
		c1.show(getContentPane(), RANKING);
	}
	
	public static void main(String[] args) {
		Ventana ven = new Ventana();
		ven.setVisible(true);
	}
	
	
	//https://stackoverflow.com/questions/15422488/java-keybindings
	public class ArrowAction extends AbstractAction {

	    private String cmd;
	    Juego juego = Juego.getJuego();
	    public ArrowAction(String cmd) {
	        this.cmd = cmd;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {//aqui adentro van los mover
	        if (cmd.equalsIgnoreCase("LeftArrow")) {
	        	System.out.println("OOOOO");
	            juego.cambiarDireccion(4);
	        } else if (cmd.equalsIgnoreCase("RightArrow")) {
	        	System.out.println("OOOOO");
	        	juego.cambiarDireccion(2);
	        } else if (cmd.equalsIgnoreCase("UpArrow")) {
	        	System.out.println("OOOOO");
	        	juego.cambiarDireccion(1);
	        } else if (cmd.equalsIgnoreCase("DownArrow")) {
	        	System.out.println("OOOOO");
	            juego.cambiarDireccion(3);
	        }
	    }
	}
}


