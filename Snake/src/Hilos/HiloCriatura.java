package Hilos;

import Criatura.Criatura;

public class HiloCriatura implements Runnable{
	Criatura criatura;
	
	public HiloCriatura(){
	}
	
	public void run () {
		while(true) {
			try {
				Thread.sleep(200);
				criatura.mover();
			}catch (InterruptedException e) {
				e.getMessage();
			}
		}
	}
	
	public void setCriatura (Criatura c) {criatura = c;}
}
