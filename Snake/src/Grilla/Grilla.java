package Grilla;

import Bloque.Bloque;

public class Grilla {
	protected Bloque grilla[][];
	
	public Grilla(int x, int y) {
		grilla = new Bloque[x][y];
	}
	
	public Bloque getBloque(int x, int y) {
		return grilla[x][y];
	}
	
	public void ocuparBloque(int x, int y) {
		grilla[x][y].setOcupado(true);
	}
	public void desocuparBloque(int x, int y) {
		grilla[x][y].setOcupado(false);
	}
}
