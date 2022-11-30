package Bloque;

import Posicion.Posicion;


public class Pared  extends Bloque{

	public Pared (int x , int y, String imagen) {
		posicion = new Posicion (x , y);
		this.imagen = imagen;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
}