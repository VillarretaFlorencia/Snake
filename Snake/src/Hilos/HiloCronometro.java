package Hilos;

public class HiloCronometro implements Runnable{
	//Atributos de instancia
	public int segundos;
	//protected GUI ventana;
	
	public HiloCronometro () {
		segundos = 0;
	}
	
	public void run () {
		while(true) {
			try {
				Thread.sleep(1000);
				segundos++;
			}catch (InterruptedException e) {
				e.getMessage();
			}
		}
	}
}
