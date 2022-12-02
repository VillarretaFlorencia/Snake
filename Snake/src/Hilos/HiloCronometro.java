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
				juego.modificarTiempo(segundos);
				Thread.sleep(1000);
				segundos++;
			}catch (InterruptedException e) {
				e.getMessage();
			}
		}
	}
}
