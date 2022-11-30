package Bloque;

import Posicion.Posicion;

public class Transitable extends Bloque {
	
	protected boolean ocupado;
	
public Transitable (int x , int y) {
	posicion =new Posicion (x ,y);
	ocupado=false;
}


public void ocupar() {
	ocupado=true;
	
}

public void desocupar() {
	ocupado=false;
	
}

}
