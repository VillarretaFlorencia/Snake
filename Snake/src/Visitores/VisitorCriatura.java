package Visitores;

<<<<<<< HEAD
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
=======
public class VisitorCriatura {
>>>>>>> d071e7633255eadd23496bdc3121025c089a2d0b

}
