package Visitores;

import Bloque.Pared;
import Bloque.Transitable;
import Comestibles.Alimento;
import Comestibles.PowerUp;

public abstract class Visitor {
	
	public abstract void visitar(Pared pared);
	
	public abstract void visitar(Transitable transitable);
	
	public abstract void visitar (Alimento alimento);
	
	public abstract void visitar (PowerUp powerUp);
}


