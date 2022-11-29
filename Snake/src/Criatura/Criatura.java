package Criatura;

import java.util.Iterator;

import Posicion.*;


public class Criatura {
	protected int orientacion;
	private int enReserva;
	protected PositionList<Transitable> miCuerpo;
	protected Estado miEstado;
	protected Visitor miVisitor;
	
	public Criatura (int orientacion, Estado estado, PositionList<Posicion> posiciones) {
		this.orientacion = orientacion;
		enReserva = 0;
		miCuerpo = new DoubleLinkedList <Transitable> ();
		miEstado = estado;
		Iterator <Posicion>  it = posiciones.iterator();
		while (it.hasNext()) {
			Posicion p = it.next();
			miCuerpo.addLast(new Transitable (p.getX(), p.getY()));
		}
	}
}
