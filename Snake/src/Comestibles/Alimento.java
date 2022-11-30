package Comestibles;

import Bloque.BloqueGrafico;
import Posicion.Posicion;

public class Alimento extends Consumible {
	protected int puntaje;
	protected int tamanio;
	protected String imagen;
	
	public Alimento (int puntaje , int tamanio , String imagen) {
		this.puntaje=puntaje;
		this.tamanio=tamanio;
		this.imagen=imagen;
		
	}

	@Override
	public int getPuntaje() {
		
		return puntaje;
	}

	@Override
	public int getTamanio() {
		
		return tamanio;
	}

	@Override
	public void aceptar(Visitor visitor) {
		visitor.visitar(this);
	}

	public String getImagen() {
		
		return imagen;
	}



}
