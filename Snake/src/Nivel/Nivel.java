package Nivel;

import java.util.LinkedList;

import Grilla.Grilla;
import comestibles.Consumible;

public class Nivel {

	protected Grilla grilla = new Grilla(20,20);
	protected int numNivel;
	protected LinkedList<Consumible> consumibles;
	
	public Nivel(int numNivel) {
		this.numNivel = numNivel;
	
    //generamos el nivel
    grilla = reader.buildNivel(this,numNivel);
    consumibles = new LinkedList<>();
    
	}
}

