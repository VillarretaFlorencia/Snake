package Comestibles;

import Bloque.BloqueGrafico;
import Posicion.Posicion;

abstract public class Consumible {

	public abstract int getPuntaje();
    public abstract int getTamanio();
    public abstract void accept (Visitor visitor);
    public abstract BloqueGrafico getBloqueGrafico();
    public abstract void  setPosicion (int x, int y);
    public abstract Posicion getPosicion();
	public abstract String getImagen();
		
   }