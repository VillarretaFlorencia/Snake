package Hilos;

import Criatura.Criatura;

public class HiloCriatura {
	Criatura criatura;
	
	public HiloCriatura(){
		
	}
	
	
	public void run () {
		while(true) {
			try {
				Thread.sleep(1000);
				criatura.mover();
			}catch (InterruptedException e) {
				e.getMessage();
			}
		}
	}
	
	public void setCriatura (Criatura c) {criatura = c;}
}
