package Grilla;

import Bloque.Bloque;
import Nivel.LevelReader;

public class Grilla {
	protected Bloque grilla[][];
	private LevelReader reader = new LevelReader(2);
	
	public Grilla(int x, int y) {
		grilla = new Bloque[x][y];
		grilla = reader.buildNivel(this,numNivel);
	}
	
	public Bloque getBloque(int x, int y) {
		return grilla[x][y];
	}
	
	public void ocuparBloque(int x, int y) {
		grilla[x][y].ocupar();
	}
	public void desocuparBloque(int x, int y) {
		grilla[x][y].desocupar();
	}
	public void modificar(int x, int y, Bloque bloque) {
		grilla[x][y] = bloque;
	}
}