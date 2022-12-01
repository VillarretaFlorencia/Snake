package Bloque;

import Posicion.Posicion;
import Visitores.Visitor;


public class Pared  extends Bloque{

	public Pared (int x , int y, String imagen) {
		posicion = new Posicion (x , y);
		this.imagen = imagen;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	public void aceptar (Visitor visitor) {
		visitor.visitar(this);
	}
}