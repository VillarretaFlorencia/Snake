package Bloque;

import Posicion.Posicion;

public class Transitable extends Bloque {
	
	protected boolean ocupado;
	protected String imagen;
	
public Transitable (int x , int y,String imagen) {
	posicion =new Posicion (x ,y);
	ocupado=false;
	this.imagen=imagen;
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
public boolean getOcupado() {
	return ocupado;
}


