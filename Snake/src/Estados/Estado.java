package Estados;

import java.util.LinkedList;

import Bloque.Bloque;
import Bloque.Transitable;
import Criatura.Criatura;

public class Estado {
	Criatura criatura;

	public Estado (Criatura c) {
		criatura = c;
	}
	
	public void cambiarAspecto (String aspecto) {
		//criatura.setImagenCuerpo (aspecto); //?
		Bloque cabeza = criatura.getCabeza();
		LinkedList<Transitable> cuerpo = criatura.getCuerpo();
		for (Bloque parte : cuerpo) {
			if (parte != cabeza) {
				parte.setImagen(aspecto);
			}
		}
		
	}
}
