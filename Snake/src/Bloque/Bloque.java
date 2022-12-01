package Bloque;

import Comestibles.Consumible;
import Posicion.Posicion;
import Visitores.Visitor;

public abstract class  Bloque {

	protected Posicion posicion;
	protected String imagen;
	protected Consumible consumible;
	
	
	public  abstract Posicion getPosicion();
		
	public String getImagen () {
		return imagen;
	}
	
	public void setImagen (String imagen) {
		this.imagen = imagen;
	}
	
	public  void setPosicion(Posicion pos) {
		this.posicion = posicion;
	}
	
	public abstract void aceptar (Visitor visitor);
}


