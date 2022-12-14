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
		juego.terminarJuego();
	}

	public void visitar(Transitable adyacente) {
		if (adyacente.getOcupado()) {
			criatura.morir();
			juego.terminarJuego();
		}
		else {
			adyacente.ocupar(criatura.getEstado().getImagen());
			criatura.cambiarCabeza(adyacente);
			juego.actualizarGrilla (adyacente);
			
			if (criatura.getReserva() > 0) {
				criatura.modificarReserva(-1);
			}
			else {
				Transitable cola = criatura.getCola();
				cola.desocupar();
				criatura.eliminarCola();
				juego.actualizarGrilla (cola);
			}
		}
	}
	
	public void visitar (Alimento alimento) {
		alimento.consumir();
		criatura.modificarReserva (alimento.getTamanio());
		juego.aumentarPuntaje(alimento.getPuntaje());
		juego.colocarConsumible();		
	}
	
	public void visitar (PowerUp powerUp) {
		powerUp.consumir();
		criatura.modificarReserva (powerUp.getTamanio());
		criatura.getEstado().cambiarAspecto (powerUp.getAspecto());
		juego.aumentarPuntaje(powerUp.getPuntaje());
		juego.colocarConsumible();
	}


}
