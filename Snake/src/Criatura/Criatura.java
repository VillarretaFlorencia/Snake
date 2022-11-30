package Criatura;

import java.util.Iterator;
import java.util.LinkedList;

import Bloque.Bloque;
import Bloque.Transitable;
import Estados.Estado;
import Juego.Juego;
import Posicion.*;
import Visitores.Visitor;
import Visitores.VisitorCriatura;


public class Criatura {
	//protected int miDireccion;
	protected int enReserva;
	protected Transitable cabeza;
	protected Transitable cola;
	protected BloqueGrafico graficoCuerpo;
	protected LinkedList <Transitable> miCuerpo;
	protected Estado miEstado;
	protected Visitor miVisitor;
	
	static final int IZQUIERDA = -1;
	static final int DERECHA = 1;
	static final int ARRIBA = 2;
	static final int ABAJO = -2;
	
	public Criatura (LinkedList <Posicion> posiciones, BloqueGrafico bg) {
		enReserva = 0;
		graficoCuerpo = bg;
		miCuerpo = new LinkedList <Transitable> ();
		Iterator <Posicion>  it = posiciones.iterator();
		while (it.hasNext()) {
			Posicion p = it.next();
			Transitable parte = new Transitable (p.getX(),p.getY(), graficoCuerpo);
			parte.ocupar();
			miCuerpo.addLast(parte);
		}
		cabeza = miCuerpo.getFirst(); 
		cola = miCuerpo.getLast(); 
		//miEstado = new EstadoNormal(this);
		//miVisitor = new VisitorCriatura(this);
	}
	
	public void setEstado(Estado estado) {miEstado = estado;}
	public void setVisitor() {miVisitor = new VisitorCriatura(this);}
	
	public Transitable getCabeza() {
		return cabeza;
	}

	public Transitable getCola() {
		return cola;
	}

	public LinkedList<Transitable> getMiCuerpo() {
		return miCuerpo;
	}

	public Estado getMiEstado() {
		return miEstado;
	}

	public Visitor getMiVisitor() {
		return miVisitor;
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
		miVisitor.visit(adyacente);
		if (enReserva > 0) {
			enReserva --;
			Transitable nuevaCola = new Transitable (cola.getPosicion().getX(), cola.getPosicion().getY(), cola.getBloqueGrafico());
			nuevaCola.ocupar();
			miCuerpo.addLast(nuevaCola);
		}
		else {
			cola.desocupar();
			miCuerpo.remove(cola);
		}
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
	
	
	public void comer (int crecer) {
		 enReserva += crecer;
	}
	
	public void morir () {
		for (Transitable parte: miCuerpo) {
			parte.desocupar();
		}
		miCuerpo.clear();
	}
}
