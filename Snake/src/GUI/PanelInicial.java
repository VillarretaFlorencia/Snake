package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelInicial extends JPanel{
	private JTextField ingresarNombre;
	private JButton btnStart;
	public PanelInicial() {
		setLayout(null);
		
		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(PanelInicial.class.getResource("/Recursos/PantallaInicio.jpg")));
		Fondo.setBounds(0, -15, 633, 632);
		add(Fondo);
		
		btnStart = new JButton("");
		btnStart.setBounds(96, 340, 405, 33);
		add(btnStart);
		btnStart.setEnabled(false);
		
		ingresarNombre = new JTextField();
		ingresarNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(ingresarNombre.getText().length()>0) {
					btnStart.setEnabled(true);
				}else {
					btnStart.setEnabled(false);
				}
			}
		});

		ingresarNombre.setBounds(108, 309, 382, 20);
		add(ingresarNombre);
		ingresarNombre.setColumns(10);
		
		
		
		
	}
	
	public JButton getStartBtn(){
		return btnStart;
	}
	
	public JTextField getNombre() {
		return ingresarNombre;
	}
}
