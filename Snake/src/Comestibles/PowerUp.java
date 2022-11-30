package Comestibles;

import Visitores.Visitor;

public class PowerUp extends Consumible {
	
	protected String aspecto;
	
	public PowerUp (int puntaje , int tamanio , String imagen,String aspecto) {
		this.puntaje = puntaje;
		this.tamanio = tamanio;
		this.imagen = imagen;
		this.aspecto = aspecto;
	}

	public String getAspecto() {
		return aspecto;
	}
	
	public void aceptar(Visitor visitor) {
		visitor.visitar(this);
	}


}
