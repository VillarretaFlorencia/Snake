package Bloque;

import Posicion.Posicion;

public class Transitable extends Bloque {
	
	protected boolean ocupado;
	
public Transitable (int x , int y,BloqueGrafico bloqueGrafico) {
	posicion =new Posicion (x ,y);
	bloqueGrafico.getImagensuelo();
	ocupado=false;
}


public void ocupar() {
	ocupado=true;
	
}

public void desocupar() {
	ocupado=false;
	bloqueGrafico.getImagensuelo();
	
}

public Posicion getPosicion() {

	return posicion;
}

}
