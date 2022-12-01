package Bloque;

public class BloqueGrafico  {
	
	private static BloqueGrafico bloqueGrafico = new BloqueGrafico();
	
	private static final  String powerUpAmarillo= "./Recursos/powerupAmarillo.png";
	private static final  String powerUpNegro= "./Recursos/powerupNegro.png";
	private static final  String powerUpBlanco= "./Recursos/powerupBlanco.png";
	private static final  String alimentoRojo ="./Recursos/alimentoRojo.png";
	private static final  String alimentoVerde= "./Recursos/alimentoVerde.png";
	private static final  String alimentoNaranja="./Recursos/alimentoNaranja.png";
	private static final String alimentoMorado = "./Recursos/alimentoMorado.png"; 
	private static final String alimentoRosa ="./Recursos/alimentoRosa.png";
	private static final String cuerpoInicial="./Recursos/cuerpoSnake.png";
	private static final String cuerpoAmarillo="./Recursos/cuerpoSnake.png";
	private static final String cuerpoNegro="./Recursos/cuerpoSnake.png";
	private static final String cuerpoBlanco="./Recursos/cuerpoSnake.png";
	private static final String cabeza= "./Recursos/cabezaSnake.png";
	private static final String suelo= "./Recursos/suelo.png";
	private static final String pared= "./Recursos/imagenPared.png";
	
	public BloqueGrafico () {
		
	}
		
	public String getPowerUpAmarillo() {
		return powerUpAmarillo;
	}
	
	public String getPowerUpNegro() {
		return powerUpNegro;
	}
	
	public String getPowerUpBlanco() {
		return powerUpBlanco;
	}
	
	public String getAlimentoRojo() {
		return alimentoRojo;
	}
	
	public String getAlimentoVerde() {
		return alimentoVerde;
	}
	
	public String getAlimentoNaranja() {
		return alimentoNaranja;
	}
	
	public String getAlimentoMorado() {
		return alimentoMorado;
	}
	
	public String getAlimentoRosa() {
		return alimentoRosa;
	}
	
	public String getCuerpo() {
		return cuerpoInicial;
	}
	
	public String getCuerpoAmarillo() {
		return cuerpoAmarillo;
	}
	
	public String getCuerpoNegro() {
		return cuerpoNegro;
	}
	
	public String getCuerpoBlanco() {
		return cuerpoBlanco;
	}
	
	public String getCabeza() {
		return cabeza;
	}
	
	public String getSuelo() {
		return suelo;
	}
	
	public String getPared() {
		return pared;
	}
	
	public static BloqueGrafico getBloqueGrafico () {
		return bloqueGrafico;
	}
}
