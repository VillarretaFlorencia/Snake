package Bloque;

import Posicion.Posicion;

public abstract class  Bloque {

protected Posicion posicion;
protected BloqueGrafico bloqueGrafico;
protected Consumible consumible;


public abstract void ocupar();
public abstract void desocupar();
public abstract Posicion getBloque();
public abstract void setBloque();
public void setBloque(Posicion bloque);
public  void accept (Visitor visitor);
	
}


}
