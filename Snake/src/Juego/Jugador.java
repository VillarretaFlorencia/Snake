package Juego;

import Nivel.Nivel;

public class Jugador implements Comparable<Jugador>{
    private int puntaje;
    private String nombre;

    public Jugador(String n, int p) {
    	nombre = n;
    	puntaje = p;
    }
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    public void aumentarPuntaje(int puntaje) {
        this.puntaje += puntaje; 
        System.out.println("puntaje: "+puntaje);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public int getPuntaje() {
        return puntaje;
    }
    
    public void copy(Jugador jugador) {
    	this.nombre = jugador.getNombre();
    	this.puntaje = jugador.getPuntaje();
    }
	@Override
	public int compareTo(Jugador o) {
		Integer compara = o.getPuntaje();
		compara.compareTo(puntaje);
		return compara;
	}

}