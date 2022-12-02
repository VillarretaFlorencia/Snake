package Bloque;

import Comestibles.Consumible;
import Juego.Juego;
import Posicion.Posicion;
import Visitores.Visitor;

public class Transitable extends Bloque {
	
	protected boolean ocupado;
	protected String imagen;
	protected Consumible consumible;
	
	BloqueGrafico bloqueGrafico = BloqueGrafico.getBloqueGrafico();
	Juego juego = Juego.getJuego();
		
	public Transitable (int x , int y,String imagen) {
		posicion = new Posicion (x ,y);
		ocupado = false;
		this.imagen = imagen;
	}

	public void setConsumible (Consumible consumible) {
		this.consumible = consumible;
	}
	
	public Consumible getConsumible () {
		return consumible;
	}
	
	public void setImagen (String imagen) {
		this.imagen = imagen;
	}
	
	public String getImagen () {
		return imagen;
	}
	
	public boolean getOcupado() {
		return ocupado;
	}
	
	public void ocupar(String imagen) {
		ocupado = true;
		this.imagen = imagen;
	}

	public void desocupar() {
		ocupado = false;
		imagen = bloqueGrafico.getSuelo();
	}
	
	public void aceptar (Visitor visitor) {
		if(consumible != null)
			if (consumible.getConsumido()) {
				consumible = null;
			}
			else{
				consumible.aceptar(visitor);
			}
		visitor.visitar(this);
	}
}

