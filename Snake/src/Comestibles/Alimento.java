package Comestibles;

import Bloque.BloqueGrafico;
import Posicion.Posicion;
import Visitores.Visitor;

public class Alimento extends Consumible {
	
	
	public Alimento (int puntaje , int tamanio , String imagen) {
		this.puntaje = puntaje;
		this.tamanio = tamanio;
		consumido = false;
		this.imagen = imagen;
		
	}

	public void aceptar(Visitor visitor) {
		visitor.visitar(this);
	}

}
