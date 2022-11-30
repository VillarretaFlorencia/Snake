package Bloque;

import Posicion.Posicion;

public class Transitable extends Bloque {
	
	protected boolean ocupado;
	
public Transitable (int x , int y) {
	posicion =new Posicion (x ,y);
	ocupado=false;
}

@Override
public void ocupar() {
	ocupado=true;
	
}

@Override
public void desocupar() {
	ocupado=false;
	
}

@Override
public Posicion getBloque() {
	
	return posicion;
}

@Override
public void setBloque(Posicion posicion) {
	this.posicion=posicion;
	
}
}
