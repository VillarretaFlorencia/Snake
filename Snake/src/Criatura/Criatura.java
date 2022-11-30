package Criatura;

import java.util.Iterator;
import java.util.LinkedList;

import Bloque.Bloque;
import Bloque.Transitable;
import Estados.Estado;
import Posicion.*;
import Visitores.Visitor;


public class Criatura {
	protected int miDireccion;
	private int enReserva;
	protected Transitable cabeza;
	protected Transitable cola;
	protected LinkedList <Transitable> miCuerpo;
	protected Estado miEstado;
	protected Visitor miVisitor;
	
	static final int IZQUIERDA = -1;
	static final int DERECHA = 1;
	static final int ARRIBA = 2;
	static final int ABAJO = -2;
	
	public Criatura (int direccion, Estado estado, LinkedList <Posicion> posiciones) {
		miDireccion = direccion;
		enReserva = 0;
		miCuerpo = new LinkedList <Transitable> ();
		miEstado = estado;
		Iterator <Posicion>  it = posiciones.iterator();
		while (it.hasNext()) {
			Posicion p = it.next();
			Transitable parte = new Transitable (getX(),p.getY());
			parte.ocupar();
			miCuerpo.addLast(parte);
		}
		cabeza = miCuerpo.getFirst(); 
		cabeza = miCuerpo.getLast(); 
	}
	
	/*public void mover (int direccion){
		miDireccion = direccion;
		int xCabeza =  cabeza.getPosicion.getX();
		int yCabeza =  cabeza.getPosicion.getY();
		Bloque adyacente = null;
		//Posicion posColaActual = cola.getPosicion();
		Transitable nuevaCola = new Transitable (cola.getPosicion().getX(), cola.getPosicion().getY());
		if (miDireccion == IZQUIERDA) {
			adyacente = juego.getBloque(xCabeza - 1, yCabeza);
			desplazar('x', -1);
		}
		if (miDireccion == DERECHA) {
			adyacente = juego.getBloque(xCabeza + 1, yCabeza);
			desplazar('x', 1);
		}
		if (miDireccion == ARRIBA) {
			adyacente = juego.getBloque(xCabeza, yCabeza + 1);
			desplazar('y', 1);
		}
		if (miDireccion == ARRIBA) {
			adyacente = juego.getBloque(xCabeza, yCabeza - 1);
			desplazar('y', -1);
		}// esto creo que lo hace el jueo lo de darle directamente el adyacente, consultando la cabeza
		
		if (enReserva < 0) {
			enReserva --;
			miCuerpo.addLast(nuevaCola);
			nuevaCola.ocupar(); la cola ya estaba en oupada
		}
		else cola.desocupar();
		
		miVisitor.visit(adyacente);
	}*/
	
	public void mover (Bloque adyacente) {
		
		if (enReserva > 0) {
			enReserva --;
			Transitable nuevaCola = new Transitable (cola.getPosicion().getX(), cola.getPosicion().getY());
			miCuerpo.addLast(nuevaCola);
			nuevaCola.ocupar();
		}
		else cola.desocupar();
		miVisitor.visit(adyacente);
	}
	
	/*private void desplazar (char coordenada, int movimiento) {
		for (Transitable parte: miCuerpo) {
			Posicion posicion = parte.getPosicion();
			int x = posicion.getX();
			if (coordenada == 'x')
				posicion.setX(x + movimiento);
			if (coordenada == 'y')
				posicion.setY(posicion.getY() + movimiento);
			parte.ocupar();
		}
	}*/
	
	
}
