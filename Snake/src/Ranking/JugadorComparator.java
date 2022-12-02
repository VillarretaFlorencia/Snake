package Ranking;

import java.util.Comparator;

import Juego.Jugador;

public class JugadorComparator implements Comparator<Jugador> {

	public int compare(Jugador o1, Jugador o2) {
        return Integer.compare(o1.getPuntaje(), o2.getPuntaje());
    }
}
