package Comestibles;

import Bloque.BloqueGrafico;
import Posicion.Posicion;
import Visitores.Visitor;

abstract public class Consumible {
	protected int puntaje;
	protected int tamanio;
	protected boolean consumido;
	protected String imagen;
	
	public int getPuntaje() {
		return puntaje;
	}

	public int getTamanio() {
		return tamanio;
	}
	
	public boolean getConsumido() {return consumido;}
	
	public String getImagen() {
		return imagen;
	}
	
	public void consumir() {consumido = true;}
	
	public abstract void aceptar(Visitor visitor);
}