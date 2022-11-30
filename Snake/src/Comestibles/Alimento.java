package Comestibles;

import Bloque.BloqueGrafico;
import Posicion.Posicion;

public class Alimento extends Consumible {
	protected int puntaje;
	protected int tamanio;
	protected BloqueGrafico bloqueGrafico;
	protected Posicion posicion;

	@Override
	public int getPuntaje() {
		
		return puntaje;
	}

	@Override
	public int getTamano() {
		
		return tamanio;
	}

	@Override
	public void aceptar(Visitor visitor) {
		visitor.visitar(this);
	}

	@Override
	public BloqueGrafico getBloqueGrafico() {
		
		return bloqueGrafico;
	}

	@Override
	public void setPosicion(int x, int y) {
		posicion.setX(x);
    	posicion.setY(y);
		
	}

	@Override
	public Posicion getPosicion() {
		return posicion;
	}
}
