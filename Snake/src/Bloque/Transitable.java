package Bloque;

import Comestibles.Consumible;
import Posicion.Posicion;
import Visitores.Visitor;

public class Transitable extends Bloque {
	
		protected boolean ocupado;
		protected String imagen;
		protected Consumible consumible;
		
		BloqueGrafico bloqueGrafico = BloqueGrafico.getBloqueGrafico();
		
	public Transitable (int x , int y,String imagen) {
		posicion =new Posicion (x ,y);
		ocupado=false;
		this.imagen=imagen;
	}
	
	
	public void ocupar(String imagen) {
		ocupado = true;
		this.imagen = imagen;
	}
	
	public void desocupar() {
		ocupado = false;
		imagen = bloqueGrafico.getSuelo();
		
	}
	public boolean getOcupado() {
		return ocupado;
	}
	public String getImagen () {
		return imagen;
	}
	public void setImagen (String imagen) {
		this.imagen = imagen;
	}
	
	
	public Consumible getConsumible () {
		return consumible;
	}
	
	public void setConsumible (Consumible consumible) {
		this.consumible = consumible;
	}
	public Posicion getPosicion() {
	
		return posicion;
	}
	public void aceptar (Visitor visitor) {
		if(consumible != null)
			consumible.aceptar(visitor);
		visitor.visitar(this);
	}
}

