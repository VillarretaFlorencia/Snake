package Hilos;

import Juego.Juego;

public class HiloCronometro implements Runnable{
	//Atributos de instancia
	public int segundos;
	Juego juego = Juego.getJuego();
	
	public HiloCronometro () {
		segundos = 0;
	}
	
	public void run () {
		while(true) {
			try {
				Thread.sleep(1000);
				//juego.modificarTiempo(segundos);
				segundos++;
			}catch (InterruptedException e) {
				e.getMessage();
			}
		}
	}
}
