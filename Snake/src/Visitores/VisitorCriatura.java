package Visitores;

import Bloque.Pared;
import Bloque.Transitable;
import Criatura.Criatura;
import Juego.Juego;
import comestibles.Alimento;

public class VisitorCriatura {
	private Criatura criatura;
	
	public VisitorCriatura (Criatura c) {
		criatura = c;
	}
	
	public void visitar(Pared pared) {
		criatura.morir();
		Juego.terminarJuego();
	}

	public void visitar(Transitable transitable) {
		
	}
	
	public void visitar (Alimento alimento) {
		
	}

}
