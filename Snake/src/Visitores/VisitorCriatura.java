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

	public void visitar(Transitable transitable) {
		if (transitable.getOcupado()) {
			criatura.morir();
			Juego.terminarJuego();
		}
		else {
//			// cambiar a mensajes de criatura 
			if (criatura.getReserva() > 0) {
				enReserva --;
				Transitable nuevaCola = new Transitable (cola.getPosicion().getX(), cola.getPosicion().getY(), imagenCuerpo);
				nuevaCola.ocupar();
				miCuerpo.addLast(nuevaCola);
			}
			else {
				cola.desocupar();
				miCuerpo.remove(cola);
			}
			cabeza = adyacente;
			Transitable cabezaAnterior = miCuerpo.getFirst();
			cabezaAnterior.setImagen(miEstado.getImagen());
			miCuerpo.addFirst(adyacente);
		}
	}
	
	public void visitar (Alimento alimento) {
		criatura.comer(alimento.getTamanio());
		juego.aumentarPunaje(alimento.getPuntaje());
		juego.colocarConsumible();
	}
	
	public void visitar (PowerUp powerUp) {
		criatura.comer(powerUp.getTamanio());
		criatura.getEstado().cambiarAspecto (powerUp.getAspecto());
		juego.aumentarPunaje(powerUp.getPuntaje());
		juego.colocarConsumible();
	}


}
