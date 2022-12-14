package Juego;

import Nivel.LevelReader;
import Nivel.Nivel;
import Posicion.Posicion;

import java.util.LinkedList;

import Bloque.*;
import Criatura.Criatura;
import GUI.PanelJuego;
import GUI.PanelJuegoConRank;
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
	protected PanelJuegoConRank miPanelJuego;
	protected int miTiempo;
	protected HiloCriatura hCriatura;
	protected HiloCronometro hCronometro;
	protected Ventana miVentana;
	
	Thread hiloCronometro;
	Thread hiloCriatura;
	
	protected BloqueGrafico bloqueGrafico = BloqueGrafico.getBloqueGrafico();
	private static Juego juego = new Juego();
	  
	public static Juego getJuego() {
		return juego;
	}
	
	public Jugador getJugador() {
		return miJugador;
	}
	
	public void iniciarJuego(int numNivel, String nombre) {
		//inicializo la ventana, nivel y jugador
		
		miJugador = new Jugador(nombre,0);
		//inicializo los hilos
		hCronometro = new HiloCronometro();
		hiloCronometro = new Thread(hCronometro);
		hiloCronometro.start();
		
		hCriatura = new HiloCriatura();
		iniciar(numNivel);
		hiloCriatura = new Thread(hCriatura);
		hiloCriatura.start();
		
	}
	
	public void iniciar(int numNivel) {
		
		miNivel = new Nivel(numNivel);
		miPanelJuego.actualizarNivel(numNivel);
		grilla = miNivel.getGrilla();
		
		//creo a la snake en una ubicacion random
		creacionCriatura();
		hCriatura.setCriatura (miCriatura);
				
		colocarConsumible();	
	}

	private void creacionCriatura() {
		int direccion = (int) ((Math.random() * 4) + 1);
		Transitable cola = miNivel.getPosibleCriatura();
		Transitable cuerpo = (Transitable) getAdyacente(direccion, cola);
		Transitable cabeza = (Transitable) getAdyacente(direccion, cuerpo);
		miCriatura = new Criatura(direccion, cabeza, cuerpo, cola, bloqueGrafico.getCuerpo());
		actualizarGrilla (cola);
		actualizarGrilla (cuerpo);
		actualizarGrilla (cabeza);
	}
	
	public Bloque getAdyacente(int direccion, Bloque bloqueActual) {
		Bloque bloqueAdyacente = null;
		Posicion posicion = bloqueActual.getPosicion();
		int x = posicion.getX();
		int y = posicion.getY();
		if (direccion == ARRIBA) {
			bloqueAdyacente = grilla.getBloque(x - 1 , y); //fila, columna
		}
		if (direccion == DERECHA) {
			bloqueAdyacente = grilla.getBloque(x, y + 1);
		}
		if (direccion == ABAJO) {
			bloqueAdyacente = grilla.getBloque(x + 1, y);
		}
		if (direccion == IZQUIERDA) {
			bloqueAdyacente = grilla.getBloque(x, y - 1);
		}
		return bloqueAdyacente;
	}
	
	public void modificarTiempo(int tiempo) {
		miTiempo = tiempo;
		miPanelJuego.actualizarTiempo(tiempo);
	}
	
	public void colocarConsumible() {
		miNivel.generarConsumibles();
	}
	
	public void setPanelJuego(PanelJuegoConRank panelJuego) {
		miPanelJuego = panelJuego;
	}
	
	public void aumentarPuntaje(int puntaje) {
		miJugador.aumentarPuntaje(puntaje);
		miPanelJuego.actualizarPuntaje(miJugador.getPuntaje());
	}
	
	public void setVentana(Ventana ventana) {
		miVentana = ventana;
	}
	
	public void actualizarGrilla (Bloque bloque) {
		Posicion pos = bloque.getPosicion(); 
		miPanelJuego.getPanelJuego().actualizarLabel(pos.getX(), pos.getY(), bloque.getImagen());	
	}
	
	public void actualizarGrilla (Transitable bloque) {
		Posicion pos = bloque.getPosicion(); 
		miPanelJuego.getPanelJuego().actualizarLabel(pos.getX(), pos.getY(), bloque.getImagen());	

	}
	
	public void actualizarComestible (Transitable transitable) {
		Posicion pos = transitable.getPosicion(); 
		miPanelJuego.getPanelJuego().actualizarLabel(pos.getX(), pos.getY(), transitable.getConsumible().getImagen());	
	}
	
	public void cambiarDireccion(int direccion){
		int direccionActual = miCriatura.getDireccion();
		if (direccionActual == ARRIBA || direccionActual == ABAJO) {
				if(direccion == DERECHA || direccion == IZQUIERDA) {
					miCriatura.setDireccion(direccion);
				}
		}
		if (direccionActual == DERECHA || direccionActual == IZQUIERDA){
			if (direccion == ARRIBA || direccion == ABAJO) {
			miCriatura.setDireccion(direccion);
			}
		}	
	}
	public void pasarDeNivel(int numNivel) {
		miNivel.limpiarNivel();
		miNivel = null;
		miCriatura = null;
		iniciar(numNivel);
	}
	public void terminarJuego() {
		miVentana.terminarJuego();
		miNivel.limpiarNivel();
		miNivel = null;
		miCriatura = null;
		hiloCronometro.stop();
		hiloCriatura.stop();
		
	}
}
