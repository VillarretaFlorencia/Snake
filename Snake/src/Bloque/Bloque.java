package Bloque;

import Comestibles.Consumible;
import Posicion.Posicion;

public abstract class  Bloque {

protected Posicion posicion;
protected String imagen;
protected Consumible consumible;


public  abstract Posicion getPosicion();
	
public String getImagen () {
	return imagen;
}

public void setImagen (String imagen) {
	this.imagen=imagen;
}

public Consumible getConsumible () {
	return consumible;
}

public void setConsumible (Consumible consumible) {
	this.consumible=consumible;
}

public  void setBloque(Posicion pos) {
	this.posicion=posicion;
}

public  void aceptar (Visitor visitor) {
	 visitor.aceptar(this);
	
}
}


