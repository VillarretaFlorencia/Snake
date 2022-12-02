package Estados;

import Bloque.Bloque;
import Criatura.Criatura;
import Juego.Juego;

public class Estado {
	Criatura criatura;
	String aspecto;
	Juego juego = Juego.getJuego();
	
	public Estado (Criatura c) {
		criatura = c;
	}
	
	public void cambiarAspecto (String aspecto) {
		this.aspecto = aspecto;
		for (Bloque parte : criatura.getCuerpo()) {
			parte.setImagen(aspecto);
			juego.actualizarGrilla (parte);
		}
	}
	
	public String getImagen() {
		return aspecto;
	}
}
