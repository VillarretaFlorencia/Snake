package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PanelInicial extends JPanel {
	public PanelInicial() {
		setLayout(null);
		
		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(PanelInicial.class.getResource("/Recursos/PantallaInicio.jpg")));
		Fondo.setBounds(0, -15, 633, 632);
		add(Fondo);
		
		JButton btnStart = new JButton("");
		btnStart.setBounds(96, 340, 405, 33);
		add(btnStart);
	}
}
