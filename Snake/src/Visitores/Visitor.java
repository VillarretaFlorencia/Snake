package Visitores;

import Bloque.Bloque;
import Criatura.Criatura;

public abstract class Visitor {
	  public abstract void visitCriatura(Criatura criatura);

	  public abstract void visitBloque(Bloque bloque);
	}


