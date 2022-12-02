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
	protected static LevelReader levelReader = LevelReader.getLevelReader();
	  
	public static Juego getJuego() {
		return juego;
	}
	
	public void iniciarJuego(int numNivel, String nombre) {
		//inicializo la ventana, nivel y jugador
		miNivel = new Nivel(numNivel);
		miJugador = new Jugador(nombre,0);
		
		//inicializo los hilos
		HiloCronometro hCronometro = new HiloCronometro();
		hiloCronometro = new Thread(hCronometro);
		hiloCronometro.start();

		hCriatura = new HiloCriatura();
		hiloCriatura = new Thread(hCriatura);
		hiloCriatura.start();
		
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
		Transitable cola = levelReader.getPosibleCriatura();
		Transitable cuerpo = (Transitable) getAdyacente(direccion, cola);
		Transitable cabeza = (Transitable) getAdyacente(direccion, cuerpo);
		miCriatura = new Criatura(direccion, cabeza, cuerpo, cola, bloqueGrafico.getCuerpo());
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
		if ((direccionActual == 1 || direccionActual == 3) && (direccion == 2 || direccionActual == 4))
			miCriatura.setDireccion(direccion);
		if ((direccionActual == 2 || direccionActual == 4) && (direccion == 1 || direccionActual == 3))
			miCriatura.setDireccion(direccion);
	}
	
	public void terminarJuego() {
		miPanelJuego.terminarJuego();
		hiloCronometro.stop();
		hiloCriatura.stop();
	}
	
	public void pasarDeNivel() {
		hiloCronometro.stop();
		hiloCriatura.stop();
		int numNivel = miNivel.getNivel();
		
		if (numNivel < 5) {
			miNivel = new Nivel(numNivel + 1);
			creacionCriatura();
			hCriatura.setCriatura(miCriatura);
		}
		else{
			miPanelJuego.ganarJuego();
			this.terminarJuego();
		}
	}
	
	public Jugador getJugador() {
		return miJugador;
	}
}
