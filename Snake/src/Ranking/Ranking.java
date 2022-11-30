package Ranking;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import Juego.Jugador;
public class Ranking {
	static private final String ruta = "/Ranking/ranking.txt";
	File txt;
	private LinkedList<Jugador> jugadores;
	
	public Ranking() {
		File directorio = new File(System.getProperty("user.dir"));
	    System.out.println(directorio.getAbsolutePath() + "dddddd");
	    String[] arr = directorio.list();
	    File dirRecursos = null;
	    File dirtxt = null;
	    for (int i = 0; i < arr.length; i++) {
	      if (arr[i].contains("src")) {
	        //System.out.println(arr[i]);
	        dirRecursos = new File(arr[i]);
	      }
	    }

	    File[] arr2 = dirRecursos.listFiles();
	    for (int i = 0; i < arr2.length; i++) {
	      //System.out.println(arr2[i].getAbsolutePath());
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
	    //sacado de:
	  //https://www.digitalocean.com/community/tutorials/java-read-text-file
	    try {
			FileInputStream fis = new FileInputStream(txt); //auxiliar
			InputStreamReader  isr = new InputStreamReader(fis); //auxliar
			BufferedReader lector = new BufferedReader(isr);
			
			String linea;
			//leemos lineas
			while((linea = lector.readLine()) != null) {//obtenemos la primera linea
				//procesamos la linea
				System.out.println(linea);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}
	
	public String getRuta() {
		return txt.getAbsolutePath();
	}
	
	public static void main(String[] args) {
		Ranking r = new Ranking();
		System.out.println(r.getRuta());
	}
}

