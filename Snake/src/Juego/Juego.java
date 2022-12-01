package Juego;

import Nivel.LevelReader;
import Nivel.Nivel;
import Posicion.Posicion;

import java.util.LinkedList;

import Bloque.*;
import Criatura.Criatura;
import GUI.Ventana;
import Grilla.Grilla;
import Hilos.HiloCriatura;
import Hilos.HiloCronometro;


public class Juego {

	static final int ARRIBA = 1;
	static final int DERECHA = 2;
	static final int ABAJO = 3;
	static final int IZQUIERDA = 4;
	
	protected Nivel miNivel;
	protected Ventana miVentana;
	protected Grilla grilla;
	protected Jugador miJugador;
	protected Criatura miCriatura;
	Thread hiloCronometro;
	Thread hiloCriatura;
	
	protected BloqueGrafico bloqueGrafico = BloqueGrafico.getBloqueGrafico();
	private static Juego juego = new Juego();
	protected static LevelReader reader = LevelReader.getLevelReader();
	  
	public static Juego getJuego() {
		return juego;
	}

	public void iniciarJuego(int numNivel, String nombre) {
		//inicializo la ventana, nivel y jugador
		miVentana = new Ventana();
		miNivel = new Nivel(numNivel);
		miJugador = new Jugador(nombre,0);
		
		//inicializo los hilos
		HiloCronometro hCronometro = new HiloCronometro();
		hiloCronometro = new Thread(hCronometro);
		hiloCronometro.start();

		HiloCriatura hCriatura = new HiloCriatura();
		hiloCriatura = new Thread(hCriatura);
		hiloCriatura.start();
		
		//creo a la snake en una ubicacion random
		creacionCriatura();
	}
	public void colocarConsumible() {
		miNivel.generarConsumibles();
	}
	
	public void aumentarPuntaje(int puntaje) {
		miJugador.aumentarPuntaje(puntaje);
	}
	/*
	private void creacionCriatura(){
		LinkedList<Transitable> criatura = new LinkedList<Transitable>();
		boolean encontrePosiciones = false;
		int direccion = null;
		
		while(!encontrePosiciones) {
			Transitable cabeza = miNivel.obtenerTransitable();
			direccion = (int) ((Math.random()*4) + 1);
			if (miNivel.estaTransitable(getAdyacente(direccion,cabeza))) {
				Transitable cuerpo = (Transitable) getAdyacente(direccion,cabeza);
				if (miNivel.estaTransitable(getAdyacente(direccion,cuerpo))) {
					Transitable cola = (Transitable) getAdyacente(direccion,cuerpo);
					encontrePosiciones = true;
					criatura.addLast(cabeza);
					criatura.addLast(cuerpo);
					criatura.addLast(cola);
				}
			}
		}
		miCriatura = new Criatura(direccion, criatura, bloqueGrafico.getCabeza(), bloqueGrafico.getCuerpo());
	}
	*/
	private void creacionCriatura() {
		LinkedList<Transitable> criatura = new LinkedList<Transitable>();
		LinkedList<Posicion> listaPosiciones = new LinkedList<Posicion>();
		int direccion = (int) ((Math.random()*4) + 1);;
		int indicePosicion = (int) ((Math.random()*4) + 1);
		
		//creo posiciones validas y lista que las contiene
		Posicion p1 = new Posicion(7,10);
		Posicion p2 = new Posicion(13,10);
		Posicion p3 = new Posicion(16,10);
		Posicion p4 = new Posicion(3,10);
		listaPosiciones.addLast(p1);
		listaPosiciones.addLast(p2);
		listaPosiciones.addLast(p3);
		listaPosiciones.addLast(p4);
		Posicion posicionCabeza = listaPosiciones.get(indicePosicion);
		

		Transitable cabeza = (Transitable) grilla.getBloque(posicionCabeza.getX();posicionCabeza.getY())
		Transitable cuerpo = (Transitable) getAdyacente(direccion,cabeza);
		Transitable cola = (Transitable) getAdyacente(direccion,cuerpo);
		criatura.addLast(cabeza);
		criatura.addLast(cuerpo);
		criatura.addLast(cola);
		miCriatura = new Criatura(direccion, criatura, bloqueGrafico.getCabeza(), bloqueGrafico.getCuerpo());
	}
	
	public Bloque getAdyacente(int direccion, Bloque bloqueActual) {
		Bloque bloqueAdyacente = null;
		if (direccion == ARRIBA) {
			bloqueAdyacente = grilla.getBloque(bloqueActual.getPosicion().getX(), bloqueActual.getPosicion().getY() -1);
		}
		if (direccion == DERECHA) {
			bloqueAdyacente = grilla.getBloque(bloqueActual.getPosicion().getX() -1, bloqueActual.getPosicion().getY());
		}
		if (direccion == ABAJO) {
			bloqueAdyacente = grilla.getBloque(bloqueActual.getPosicion().getX(), bloqueActual.getPosicion().getY() +1);
		}
		if (direccion == IZQUIERDA) {
			bloqueAdyacente = grilla.getBloque(bloqueActual.getPosicion().getX() +1, bloqueActual.getPosicion().getY());
		}
		return bloqueAdyacente;
	}
	
	public void cambiar (String imagen, Bloque bloque) {
		bloque.setImagen(imagen);
		panelJuego.actualizrLabel(bloque);
		
	}
}
