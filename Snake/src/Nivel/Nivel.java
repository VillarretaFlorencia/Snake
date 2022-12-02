package Nivel;


import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.Popup;

import Bloque.Bloque;
import Bloque.BloqueGrafico;
import Bloque.Transitable;
import Grilla.Grilla;
import Juego.Juego;
import Posicion.Posicion;
import Comestibles.Alimento;
import Comestibles.Consumible;
import Comestibles.PowerUp;

public class Nivel {

	protected Grilla grilla;
	protected int numNivel;
	protected LinkedList<Consumible> consumibles;
	protected LevelReader levelReader;
	protected static BloqueGrafico bloqueGrafico = BloqueGrafico.getBloqueGrafico();
	protected static Juego juego = Juego.getJuego();
	
	
	public Nivel(int numNivel) {
		
		this.numNivel = numNivel;
		levelReader = new LevelReader();
	    //generamos el nivel
	    grilla = new Grilla (levelReader.generarGrilla(numNivel));
	    
	    
	    //generamos los consumibles
	    Alimento alimentoRojo = new Alimento(25, 2, bloqueGrafico.getAlimentoRojo());
	    Alimento alimentoVerde = new Alimento(50, 3, bloqueGrafico.getAlimentoVerde());
	    Alimento alimentoNaranja = new Alimento(75, 4, bloqueGrafico.getAlimentoNaranja());
	    Alimento alimentoMorado = new Alimento(100, 5, bloqueGrafico.getAlimentoMorado());
	    Alimento alimentoRosa = new Alimento(25, 6, bloqueGrafico.getAlimentoRosa());
	    PowerUp powerUpAmarillo = new PowerUp(50, 1, bloqueGrafico.getPowerUpAmarillo(), bloqueGrafico.getCuerpoAmarillo());
	    PowerUp powerUpNegro = new PowerUp(75, 2, bloqueGrafico.getPowerUpNegro(), bloqueGrafico.getCuerpoNegro());
	    PowerUp powerUpBlanco = new PowerUp(100, 3, bloqueGrafico.getPowerUpBlanco(), bloqueGrafico.getCuerpoBlanco());
	    
	    //generamos la lista de consumibles
	    consumibles = new LinkedList<>();
	    consumibles.addFirst(alimentoRojo);
	    consumibles.addFirst(alimentoVerde);
	    consumibles.addFirst(alimentoNaranja);
	    consumibles.addFirst(alimentoMorado);
	    consumibles.addFirst(alimentoRosa);
	    consumibles.addFirst(powerUpAmarillo);
	    consumibles.addFirst(powerUpNegro);
	    consumibles.addFirst(powerUpBlanco);
	   
	    //obtenemos la lista con los consumibles al azar
	    Collections.shuffle(consumibles);
	    
	    System.out.println("NUEVO NIVEL " + consumibles.size());
	}
	
	public int getNumNivel() {return numNivel;}
	
	public void generarConsumibles() {
		//ubica un cosumible en una posicion valida de la grilla y lo remueve de la lista de consumibles
		System.out.println("ENTRE A CONSUMIBLES " + consumibles.size());
		if (!consumibles.isEmpty()) {		
			Transitable transitable = levelReader.getPosibleConsumible();
			Consumible consumible = consumibles.getFirst();
			transitable.setConsumible(consumible);
			consumibles.remove(consumible);
			System.out.println("ENTRE A CONSUMIBLES elimine " + consumibles.size());
			consumible = null;
			juego.actualizarComestible(transitable); //pasar posicion e imagem
		} else {
			juego.pasarDeNivel();
		}
	}
	
	public Transitable getPosibleCriatura() {
		return levelReader.getPosibleCriatura();
	}
	
	public Grilla getGrilla() {
		return grilla;
	}

	public void limpiarNivel() {
		grilla.vaciar();
		consumibles = null;
	}
	
	//estos ya no los usamos los deje por las dudas
	/*
	public Transitable obtenerTransitable() {
		boolean estaOcupado = true;
		Transitable posibleTransitable = null;
		Iterator<Transitable> it = listaTransitables.iterator();
		
		while(it.hasNext() && estaOcupado) {
			posibleTransitable = it.next();
			estaOcupado = posibleTransitable.getOcupado();
		}	
		return posibleTransitable;
	}
	
	//PREGUNTAR FEDE y reever si queda aca o va en juego
	public boolean estaTransitable(Bloque bloque) {
		boolean encontre = false;
		Iterator<Transitable> it = listaTransitables.iterator();
		
		while(it.hasNext() && !encontre) {
			encontre = (bloque == it.next());
		}
		return encontre;
	}
	*/
}

