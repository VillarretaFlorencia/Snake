package Juego;

import Nivel.LevelReader;
import Nivel.Nivel;
import Posicion.Posicion;

import java.util.LinkedList;

import Bloque.*;
import Criatura.Criatura;
import GUI.PanelJuego;
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
	protected Grilla grilla;
	protected Jugador miJugador;
	protected Criatura miCriatura;
	protected PanelJuego miPanelJuego;
	protected int miTiempo;
	protected HiloCriatura hCriatura;
	protected Ventana miVentana;
	
	Thread hiloCronometro;
	Thread hiloCriatura;
	
	protected BloqueGrafico bloqueGrafico = BloqueGrafico.getBloqueGrafico();
	private static Juego juego = new Juego();
	  
	public static Juego getJuego() {
		return juego;
	}
	
	public void iniciarJuego(int numNivel, String nombre) {
		//inicializo la ventana, nivel y jugador
		miNivel = new Nivel(numNivel);
		miJugador = new Jugador(nombre,0);
		
		//inicializo los hilos
		/*HiloCronometro hCronometro = new HiloCronometro();
		hiloCronometro = new Thread(hCronometro);
		hiloCronometro.start();

		hCriatura = new HiloCriatura();
		hiloCriatura = new Thread(hCriatura);
		hiloCriatura.start();
		*/
		
		//creo a la snake en una ubicacion random
		creacionCriatura();
	}
	
	public void modificarTiempo(int tiempo) {
		miTiempo = tiempo;
		miPanelJuego.actualizarTiempo(tiempo);
	}
	
	public void colocarConsumible() {
		miNivel.generarConsumibles();
	}
	
	public void setPanelJuego(PanelJuego panelJuego) {
		miPanelJuego = panelJuego;
	}
	
	public void aumentarPuntaje(int puntaje) {
		miJugador.aumentarPuntaje(puntaje);
		miPanelJuego.actualizarPuntaje(puntaje);
	}
	
	public void setVentana(Ventana ventana) {
		miVentana = ventana;
	}

	private void creacionCriatura() {
		int direccion = (int) ((Math.random() * 4) + 1);
		Transitable cola = miNivel.getPosibleCriatura();
		Transitable cuerpo = (Transitable) getAdyacente(direccion, cola);
		Transitable cabeza = (Transitable) getAdyacente(direccion, cuerpo);
		miCriatura = new Criatura(direccion, cabeza, cuerpo, cola, bloqueGrafico.getCuerpo());
	}
	
	public Bloque getAdyacente(int direccion, Bloque bloqueActual) {
		Bloque bloqueAdyacente = null;
		Posicion posicion = bloqueActual.getPosicion();
		int x = posicion.getX();
		int y = posicion.getY();
		if (direccion == ARRIBA) {
			bloqueAdyacente = grilla.getBloque(x, y - 1);
		}
		if (direccion == DERECHA) {
			bloqueAdyacente = grilla.getBloque(x - 1, y);
		}
		if (direccion == ABAJO) {
			bloqueAdyacente = grilla.getBloque(x, y + 1);
		}
		if (direccion == IZQUIERDA) {
			bloqueAdyacente = grilla.getBloque(x + 1, y);
		}
		return bloqueAdyacente;
	}
	
	public void actualizarGrilla (Bloque bloque) {
		Posicion pos = bloque.getPosicion(); 
		miPanelJuego.actualizarLabel(pos.getX(), pos.getY(), bloque.getImagen());	
	}
	
	public void actualizarComestible (Transitable transitable) {
		Posicion pos = transitable.getPosicion(); 
		miPanelJuego.actualizarLabel(pos.getX(), pos.getY(), transitable.getConsumible().getImagen());	
	}
	
	public void cambiarDireccion(int direccion){
		int direccionActual = miCriatura.getDireccion();
		if ((direccionActual == ARRIBA || direccionActual == ABAJO) && (direccion == DERECHA || direccionActual == IZQUIERDA))
			miCriatura.setDireccion(direccion);
		if ((direccionActual == DERECHA || direccionActual == IZQUIERDA) && (direccion == ARRIBA || direccionActual == ABAJO))
			miCriatura.setDireccion(direccion);
	}
	
	public void terminarJuego() {
		hiloCronometro.stop();
		hiloCriatura.stop();
		miVentana.terminarJuego();
	}
	
	public void pasarDeNivel() {
		int numNivel = miNivel.getNumNivel();
		if (numNivel < 5) {
			miNivel = new Nivel(numNivel + 1);
			creacionCriatura();
			hCriatura.setCriatura(miCriatura);
		}
		else{
			this.terminarJuego();
		}
	}
	
	public Jugador getJugador() {
		return miJugador;
	}
}
