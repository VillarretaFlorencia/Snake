package Nivel;


import java.util.Collections;
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
	protected static LevelReader reader = LevelReader.getLevelReader();
	protected static BloqueGrafico bloqueGrafico = BloqueGrafico.getBloqueGrafico();
	protected static Juego juego = Juego.getJuego();
	
	
	public Nivel(int numNivel) {
		this.numNivel = numNivel;
	
	    //generamos el nivel
	    grilla = new Grilla(reader.generarGrilla(this,numNivel));
	    consumibles = new LinkedList<>();
	    
	    Alimento alimentoRojo = new Alimento(25, 2, bloqueGrafico.getAlimentoRojo());
	    Alimento alimentoVerde = new Alimento(50, 3, bloqueGrafico.getAlimentoVerde());
	    Alimento alimentoNaranja = new Alimento(75, 4, bloqueGrafico.getAlimentoNaranja());
	    Alimento alimentoMorado = new Alimento(100, 5, bloqueGrafico.getAlimentoMorado());
	    Alimento alimentoRosa = new Alimento(25, 6, bloqueGrafico.getAlimentoRosa());
	    PowerUp powerUpAmarillo = new PowerUp(50, 1, bloqueGrafico.getPowerUpAmarillo(), bloqueGrafico.getCuerpoAmarillo());
	    PowerUp powerUpNegro = new PowerUp(75, 2, bloqueGrafico.getPowerUpNegro(), bloqueGrafico.getCuerpoNegro());
	    PowerUp powerUpBlanco = new PowerUp(100, 3, bloqueGrafico.getPowerUpBlanco(), bloqueGrafico.getCuerpoBlanco());
	    
	    consumibles.addLast(alimentoRojo);
	    consumibles.addFirst(alimentoVerde);
	    consumibles.addFirst(alimentoNaranja);
	    consumibles.addFirst(alimentoMorado);
	    consumibles.addFirst(alimentoRosa);
	    consumibles.addFirst(powerUpAmarillo);
	    consumibles.addFirst(powerUpNegro);
	    consumibles.addFirst(powerUpBlanco);
	   
	    Collections.shuffle(consumibles);
	}
	
	public void ponerConsumibles() {
		Posicion posicion;
		LinkedList<Posicion> listaPosiciones;
		listaPosiciones = reader.posicionesTransitables();
		Collections.shuffle(listaPosiciones);
		
		posicion = listaPosiciones.getFirst();
		Transitable bloque;
		bloque = (Transitable) grilla.getBloque(posicion.getX(),posicion.getY());
		
		while(bloque.getOcupado()) {
			posicion = listaPosiciones.getFirst();
			bloque = (Transitable) grilla.getBloque(posicion.getX(),posicion.getY());
		}
		Consumible consumible = consumibles.getFirst();
		bloque.setConsumible(consumible);
		consumibles.remove(consumible);
		
		juego.actualizar(bloque.getPosicion().getX(), bloque.getPosicion().getY(), consumible.getImagen()); //pasar posicion e imagem
	}
}

