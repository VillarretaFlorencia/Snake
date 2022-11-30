package Bloque;

public class BloqueGrafico  {
	
	private static BloqueGrafico bloqueGrafico = new BloqueGrafico();
	
	private static final  String powerupAmarillo= "./Recursos/powerupAmarillo.png";
	private static final  String powerupNegro= "./Recursos/powerupNegro.png";
	private static final  String powerUpBlanco= "./Recursos/powerupBlanco.png";
	private static final  String alimentoRojo ="./Recursos/alimentoRojo.png";
	private static final  String alimentoVerde= "./Recursos/alimentoVerde.png";
	private static final  String alimentoNaranja="./Recursos/alimentoNaranja.png";
	private static final String alimentoMorado = "./Recursos/alimentoMorado.png"; 
	private static final String alimentoRosa ="./Recursos/alimentoRosa.png";
	private static final String imagenCuerpo="./Recursos/cuerpoSnake.png";
	private static final String imagenCabeza= "./Recursos/cabezaSnake.png";
	private static final String imagenSuelo= "./Recursos/suelo.png";
	
	
	
public static String getPowerupamarillo() {
		return powerupAmarillo;
	}
	public static String getPowerupnegro() {
		return powerupNegro;
	}
	public static String getPowerupblanco() {
		return powerUpBlanco;
	}
	public static String getAlimentorojo() {
		return alimentoRojo;
	}
	public static String getAlimentoverde() {
		return alimentoVerde;
	}
	public static String getAlimentonaranja() {
		return alimentoNaranja;
	}
	public static String getAlimentomorado() {
		return alimentoMorado;
	}
	public static String getAlimentorosa() {
		return alimentoRosa;
	}
	public static String getImagencuerpo() {
		return imagenCuerpo;
	}
	public static String getImagencabeza() {
		return imagenCabeza;
	}
	public static String getImagensuelo() {
		return imagenSuelo;
	}
public BloqueGrafico () {
	
}
public BloqueGrafico getBloqueGrafico () {
	return bloqueGrafico;
}
public void  setBloqueGrafico (BloqueGrafico bloqueGrafico) {
	
	this.bloqueGrafico=bloqueGrafico;
}

}
