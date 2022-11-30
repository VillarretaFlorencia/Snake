package Bloque;

public class BloqueGrafico  {
	
	private static BloqueGrafico bloqueGrafico = new BloqueGrafico();
	
	private static final  String powerupAmarillo= "/recursos/FlagZombie.gif";
	public String powerupNegro= "/recursos/FlagZombie.gif";
	public String powerUpBlanco;
	public String alimentoRojo;
	public String alimentoVerde;
	public String alimentoNaranja;
	public String alimentoMorado;
	public String alimentoRosa;
	public String imagenCuerpo;
	public String imagenCabeza;
	
	
	
public BloqueGrafico () {
	
}
public BloqueGrafico getBloqueGrafico () {
	return bloqueGrafico;
}
public void  setBloqueGrafico (BloqueGrafico bloqueGrafico) {
	
	this.bloqueGrafico=bloqueGrafico;
}

}
