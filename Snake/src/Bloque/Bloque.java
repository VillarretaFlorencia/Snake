package Bloque;

import Comestibles.Consumible;
import Posicion.Posicion;
import Visitores.Visitor;

public abstract class  Bloque {

	protected Posicion posicion;
	protected String imagen;
	protected Consumible consumible;
	

	public void setImagen (String imagen) {
		this.imagen = imagen;
	}

	public  void setPosicion(Posicion pos) {
		this.posicion = pos;
	}
	
	public String getImagen () {
		return imagen;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	public abstract void aceptar (Visitor visitor);
}


