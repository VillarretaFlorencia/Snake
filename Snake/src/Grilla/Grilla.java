package Grilla;

import Bloque.Bloque;
import Nivel.LevelReader;

public class Grilla {
	protected Bloque [][] grilla;
	
	public Grilla(Bloque [][] grilla) {
		this.grilla = grilla;
	}
	
	public Bloque getBloque(int x, int y) {
		return grilla[x][y];
	}
	//ver si se usa
	public void modificar(int x, int y, Bloque bloque) {
		grilla[x][y] = bloque;
	}
	
	public int getColumnas() {return grilla.length;}
	
	public int getFilas() {return grilla[0].length;}
}