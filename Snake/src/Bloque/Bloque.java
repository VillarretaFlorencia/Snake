package Bloque;

import Posicion.Posicion;

public abstract class  Bloque {

protected Posicion posicion;
protected BloqueGrafico bloqueGrafico;
protected Consumible consumible;


public  abstract Posicion getPosicion();
	
public BloqueGrafico getBloqueGrafico () {
	return bloqueGrafico;
}

public void setBloqueGrafico (BloqueGrafico bloqueGrafico ) {
	this.bloqueGrafico=bloqueGrafico;
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


