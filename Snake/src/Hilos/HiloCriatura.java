package Hilos;

import Criatura.Criatura;

public class HiloCriatura  implements Runnable {
	Criatura criatura;
	
	public HiloCriatura(){
	}
	
	public void run () {
		try {
			//Thread.sleep(1000);
			
			while(true) {				
				Thread.sleep(250);
				criatura.mover();
			}
		}catch (InterruptedException e) {
			e.getMessage();
		}
		
		
	}
	
	public void setCriatura (Criatura c) {criatura = c;}
}
