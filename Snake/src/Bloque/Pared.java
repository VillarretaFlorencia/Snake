package Bloque;

import Posicion.Posicion;
import Visitor.Visitor;

public class Pared  extends Bloque{

protected Posicion pos;

public Pared (int x , int y) {
	pos= new Posicion (x, y);
}
public  void accept (Visitor visitorSnake) {
	visitorSnake.visit(this);}
}
}