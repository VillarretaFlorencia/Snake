package Nivel;


import java.util.LinkedList;

import Grilla.Grilla;
import Comestibles.Consumible;

public class Nivel {

	protected Grilla grilla;
	protected int numNivel;
	protected LinkedList<Consumible> consumibles;
	protected LevelReader reader = LevelReader.getLevelReader();
	
	public Nivel(int numNivel) {
		this.numNivel = numNivel;
	
	    //generamos el nivel
	    grilla = new Grilla(reader.generarGrilla(this,numNivel));
	    consumibles = new LinkedList<>();
	    
	}
}

