package Visitores;


import Bloque.Bloque;
import Bloque.Pared;
import Bloque.Transitable;
import Criatura.Criatura;
import Juego.Juego;
import Comestibles.*;

public class VisitorCriatura extends Visitor{
	private Criatura criatura;
	private Juego juego = Juego.getJuego();
	
	public VisitorCriatura (Criatura c) {
		criatura = c;
	}
	
	public void visitar(Pared pared) {
		criatura.morir();
		Juego.terminarJuego();
	}

	public void visitar(Transitable adyacente) {
		if (adyacente.getOcupado()) {
			criatura.morir();
			Juego.terminarJuego();
		}
		else {
			adyacente.ocupar(criatura.getEstado().getImagen());
			criatura.cambiarCabeza(adyacente);
			juego.actualizarGrilla (adyacente);
			if (criatura.getReserva() > 0) {
				criatura.modificarReserva(-1);
			}
			else {
				criatura.getCola().desocupar();
				criatura.eliminarCola();
			}
		}
	}
	
	public void visitar (Alimento alimento) {
		criatura.modificarReserva (alimento.getTamanio());
		juego.aumentarPunaje(alimento.getPuntaje());
		juego.colocarConsumible();
	}
	
	public void visitar (PowerUp powerUp) {
		criatura.modificarReserva (powerUp.getTamanio());
		criatura.getEstado().cambiarAspecto (powerUp.getAspecto());
		juego.aumentarPunaje(powerUp.getPuntaje());
		juego.colocarConsumible();
	}


}
