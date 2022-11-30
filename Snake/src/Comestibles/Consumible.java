package Comestibles;

import Bloque.BloqueGrafico;
import Posicion.Posicion;
import Visitores.Visitor;

abstract public class Consumible {
	protected int puntaje;
	protected int tamanio;
	protected String imagen;


	
	public int getPuntaje() {
		return puntaje;
	}

	public int getTamanio() {
		return tamanio;
	}

	public abstract void aceptar(Visitor visitor);
		
	public String getImagen() {
		
		return imagen;
	}
	
}