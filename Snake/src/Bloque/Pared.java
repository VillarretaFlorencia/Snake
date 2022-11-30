package Bloque;

import Posicion.Posicion;


public class Pared  extends Bloque{

public Pared (int x , int y,BloqueGrafico bloqueGrafico) {
	posicion = new Posicion (x , y);
	bloqueGrafico.getImagenPared();
}

public Posicion getPosicion() {
	return posicion;
}
}