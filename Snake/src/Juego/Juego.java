package Juego;

import Hilos.HiloCriatura;
import Hilos.HiloCronometro;
import Logica.Alimento;
import Logica.EntidadGrafica;
import Logica.Posicion;

import java.util.LinkedList;

import Bloque.*;


public class Juego {

	protected boolean terminarJuego;
	private static Juego nivel = new Juego();

	private Juego() {
		terminarJuego = false;
	}

	public void iniciarJuego(int numNivel) {
		HiloCronometro hiloCronometro = new HiloCronometro();
		hiloCronometro = new Thread();
		hiloCronometro.start();

		HiloCriatura hiloCriatura = new HiloCriatura();
		hiloCriatura = new Thread();
		hiloCriatura.start();
		
		LinkedList<Bloque> lista = new LinkedList<Bloque>();
		/*aca iria la posicion de los bloques de la criatura
	    lista.addLast(new Posicion(12, 10));
	    lista.addLast(new Posicion(11, 10));
	    lista.addLast(new Posicion(10, 10));
	    */
		
		for(int i = 0;  i< 5; i++) {
	    	Posicion p = generatePosicionValida();
		      arrComidas[i] = new Alimento(p.getX(), p.getY(), stage, (int)(Math.random()*100+1), new EntidadGrafica(urlAlimento));
		      //la linea de aca abajo es para ver las posiciones de la comida en panel del nivel
		      //nivel[p.getX()][p.getY()] = new Alimento(p.getX(), p.getY(), 1, 100, new EntidadGrafica(urlAlimento));
		}
	}
}
