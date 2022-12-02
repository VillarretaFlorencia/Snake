package Criatura;

import java.util.LinkedList;

import Bloque.Bloque;
import Bloque.BloqueGrafico;
import Bloque.Transitable;
import Estados.Estado;
import Juego.Juego;
import Visitores.Visitor;
import Visitores.VisitorCriatura;


public class Criatura {
	protected int miDireccion;
	protected int enReserva;
	protected Transitable miCabeza;
	protected Transitable miCola;
	protected LinkedList <Transitable> miCuerpo;
	protected Estado miEstado;
	protected Visitor miVisitor;
	
	BloqueGrafico bloqueGrafico = BloqueGrafico.getBloqueGrafico();
	Juego juego = Juego.getJuego();
	
	public Criatura (int direccion, Transitable cabeza, Transitable cuerpo, Transitable cola,  String imagen) {
		miDireccion = direccion;
		enReserva = 0;
		miCuerpo = new LinkedList <Transitable> ();
		cabeza.ocupar(imagen);
		cuerpo.ocupar(imagen);
		cola.ocupar(imagen);
		miCuerpo.addLast(cabeza);
		miCuerpo.addLast(cuerpo);
		miCuerpo.addLast(cola);		
		miCabeza = cabeza;
		miCola = cola;
		miEstado = new Estado(this);
		miEstado.cambiarAspecto (imagen);
		miVisitor = new VisitorCriatura(this);
	}
	
	public void setDireccion (int direccion) {miDireccion = direccion;}
	
	public void setCola (Transitable c) {
		miCola = c;
		miCuerpo.addLast(miCola);
	}
	
	public int getDireccion () {return miDireccion;}
	
	public int getReserva () {return enReserva;}
	
	public Transitable getCabeza() {
		return miCabeza;
	}

	public Transitable getCola() {
		return miCola;
	}

	public LinkedList<Transitable> getCuerpo() {
		return miCuerpo;
	}

	public Estado getEstado() {
		return miEstado;
	}

	public Visitor getVisitor() {
		return miVisitor;
	}

	public void modificarReserva (int reserva) {
		enReserva += reserva;
	}
	
	public void cambiarCabeza (Transitable c) {
		miCabeza = c;
		miCuerpo.addFirst(miCabeza);
	}
	
	public void eliminarCola() {
		miCuerpo.remove(miCuerpo.getLast());
		miCola = miCuerpo.getLast();
	}
		
	public void mover () {
		Bloque adyacente = juego.getAdyacente(miDireccion, miCabeza);
		adyacente.aceptar(miVisitor);
	}
		
	public void morir () {
		for (Transitable parte: miCuerpo) {
			parte.desocupar();
		}
		miCabeza = null;
		miCola = null;
		enReserva = 0;
		miCuerpo.clear();
	}
}
