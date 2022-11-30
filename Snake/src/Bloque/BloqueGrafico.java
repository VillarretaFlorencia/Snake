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
	
	
	
public static String getPowerupamarillo() {
		return powerUpAmarillo;
	}
public static String getPowerupnegro() {
		return powerUpNegro;
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
		return cuerpoInicial;
	}
public static String getCuerpoAmarillo() {
	return cuerpoAmarillo;
}
public static String getCuerpoNegro() {
	return cuerpoNegro;
}
public static String getCuerpoBlanco() {
	return cuerpoBlanco;
}
public static String getImagencabeza() {
		return cabeza;
	}
public static String getImagensuelo() {
		return suelo;
	}
public static String getImagenPared() {
	return pared;
}

public static BloqueGrafico getBloqueGrafico () {
	return bloqueGrafico;
}

}
