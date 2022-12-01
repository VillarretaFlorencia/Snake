package Criatura;

import java.util.Iterator;
import java.util.LinkedList;

import Bloque.Bloque;
import Bloque.BloqueGrafico;
import Bloque.Transitable;
import Estados.Estado;
import Juego.Juego;
import Posicion.*;
import Visitores.Visitor;
import Visitores.VisitorCriatura;


public class Criatura {
	protected int miDireccion;
	protected int enReserva;
	//protected String imagenCuerpo;
	protected Transitable miCabeza;
	protected Transitable miCola;
	protected LinkedList <Transitable> miCuerpo;
	protected Estado miEstado;
	protected Visitor miVisitor;
	
	BloqueGrafico bloqueGrafico = BloqueGrafico.getBloqueGrafico();
	
	/*static final int IZQUIERDA = -1;
	static final int DERECHA = 1;
	static final int ARRIBA = 2;
	static final int ABAJO = -2;*/
	
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
		miCabeza = cola;
		miEstado = new Estado(this);
		miEstado.cambiarAspecto (imagen);
		miVisitor = new VisitorCriatura(this);
	}
	public void setDireccion (int direccion) {miDireccion = direccion;}
	
	public void setCola (Transitable c) {
		miCola = c;
		miCuerpo.addLast(miCola);
	}
	//public void setImagenCuerpo (String imagen) {imagenCuerpo = imagen;}
	
	//public void setEstado() {miEstado = new Estado (this);}
	
	//public void setVisitor() {miVisitor = new VisitorCriatura(this);}
	
	//public String getImagen () {return imagenCuerpo;}
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
		enReserva = reserva;
	}
	
	public void cambiarCabeza (Transitable c) {
		miCabeza = c;
		miCuerpo.addFirst(miCabeza);
	}
	
	public void eliminarCola() {
		miCuerpo.remove(miCuerpo.getLast());
		miCola = miCuerpo.getLast();
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
	
	public void mover () {
		Bloque adyacente = Juego.getAdyacente(miDireccion, miCabeza);
		adyacente.aceptar(miVisitor);
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
	
	
	public void morir () {
		for (Transitable parte: miCuerpo) {
			parte.desocupar();
		}
		miCuerpo.clear();
	}
}
