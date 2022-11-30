package Ranking;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

import Juego.Jugador;
public class Ranking {
	static private final String ruta = "/Ranking/ranking.txt";
	File txt;
	private LinkedList<Jugador> jugadores = new LinkedList<>();
	
	public Ranking() {
		//buscamos el archivo
		File directorio = new File(System.getProperty("user.dir"));
	    String[] arr = directorio.list();
	    File dirRecursos = null;
	    File dirtxt = null;
	    for (int i = 0; i < arr.length; i++) {
	      if (arr[i].contains("src")) {
	        dirRecursos = new File(arr[i]);
	      }
	    }

	    File[] arr2 = dirRecursos.listFiles();
	    for (int i = 0; i < arr2.length; i++) {
	      if (arr2[i].getAbsolutePath().contains("Ranking")) {
	        dirtxt = new File(arr2[i].getAbsolutePath());
	      }
	    }

	    File[] arr3 = dirtxt.listFiles();
	    for (int i = 0; i < arr3.length; i++) {
	      if (arr3[i].getAbsolutePath().contains(".txt")) {
	        dirtxt = new File(arr3[i].getAbsolutePath());
	      }
	    }

	    String ruta = "";

	    ruta = dirtxt.getAbsolutePath();

	    txt = new File(ruta); // abrimos el archivo dentro de java
		LinkedList<Jugador> auxList = new LinkedList<>();
	    //lectura de archivo sacado de:
	    //https://www.digitalocean.com/community/tutorials/java-read-text-file
	    try {
			FileInputStream fis = new FileInputStream(txt); //auxiliar
			InputStreamReader  isr = new InputStreamReader(fis); //auxliar
			BufferedReader lector = new BufferedReader(isr);
			
			String linea;

			//leemos lineas
			while((linea = lector.readLine()) != null) {//obtenemos la primera linea
				//procesamos la linea
				Jugador jugador = new Jugador("",0);
				
				//leemos el nombre
				String nombre = "";
				int posicion = 0;
				for(int i = posicion; i < linea.length() && (linea.charAt(i) != ';'); i++) {
					//System.out.println(linea.charAt(i));
					nombre = nombre + linea.charAt(i);
					posicion = i;
				}
				posicion++;
				posicion++;//saltamos el ;
				//System.out.println(linea.charAt(posicion));
				//leemos el puntaje
				String puntajeAux = "";
				for(int i = posicion; i < linea.length() && (linea.charAt(i) != ';'); i++) {
					//System.out.println(linea.charAt(i));
					puntajeAux = puntajeAux + linea.charAt(i);
				}
				
				//System.out.println(nombre);
				int puntaje = Integer.valueOf(puntajeAux);
				
				jugador.setNombre(nombre);
				jugador.setPuntaje(puntaje);
				auxList.add(jugador);
				
				jugadores.add(jugador);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    jugadores = organizar();
	}
	
	/**
	 * Devuelve la rura del archivo de texto del ranking
	 * @return
	 */
	public String getRuta() {
		return txt.getAbsolutePath();
	}
	
	/**
	 * Organiza la lista de jugadores
	 * @return lista ordenada de jugadores
	 */
	public LinkedList<Jugador> organizar() {
		LinkedList<Jugador> auxList = (LinkedList<Jugador>) jugadores.clone();
		JugadorComparator comparador = new JugadorComparator();
	    auxList.sort(comparador);
	    int tamano = jugadores.size();
		for(Jugador j : auxList) {
			jugadores.addFirst(j);
		}
		
		for(int i = 0; i < tamano ; i++) {
			jugadores.removeLast();
		}
		return jugadores;
	}
	
	/**
	 * Sobreescribe el txt del ranking
	 * @param jugador nuevo
	 */
	public void sobreescribir(Jugador jugador) {
		jugadores.add(jugador);
		organizar();
		jugadores.removeLast();
		String escribir ="";
		try {
			FileWriter escritor = new FileWriter(txt.getAbsolutePath());
			for(Jugador j : jugadores) {
				escribir = escribir+ j.getNombre()+";"+j.getPuntaje()+";\n";
			}
			escritor.write(escribir);
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//sacado de: https://www.codespeedy.com/how-to-overwrite-a-file-in-java/
	}
	
	public String toString() {
		String escribir ="";
		int i = 1;
			for(Jugador j : jugadores) {
				escribir = escribir+i+". "+ j.getNombre()+" - Puntaje: "+j.getPuntaje()+" \n";
				i++;
			}
		return escribir;
	}
	
	public LinkedList<Jugador> getListaJugadores(){
		return jugadores;
	}
	
	public static void main(String[] args) {
		Ranking r = new Ranking();
		Jugador jug = new Jugador("Stanke",21);
		r.sobreescribir(jug);
		System.out.println("-------------------------------");
		System.out.println(r.toString());
		
	}
	
}

