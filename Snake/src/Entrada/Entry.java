package Entrada;

public interface Entry <K,V>{
	
	//Retorna la clave de la entrada K
	public K getKey();
	
	//Retorna el valor de la entrada
	public V getValue();
}
