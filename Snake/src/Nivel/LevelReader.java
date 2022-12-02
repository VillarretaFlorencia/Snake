package Nivel;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;
import Bloque.*;

public class LevelReader {

  private File DirPlanos = null;
  private File DirImagenes = null;
  private Bloque [][] grilla;
  private LinkedList <Transitable> posiblesComestibles;
  private LinkedList <Transitable> posiblesCriatura;
  
  BloqueGrafico bloqueGrafico = BloqueGrafico.getBloqueGrafico();
  
  public LevelReader() {
	  grilla = null;
	  posiblesComestibles = new LinkedList<Transitable>();
	  posiblesCriatura = new LinkedList<Transitable>();
  }
  
  public Bloque[][] generarGrilla(int numNivel) {
	
    File directorio = new File(System.getProperty("user.dir"));
    //System.out.println(directorio.getAbsolutePath() + "dddddd");
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
      //System.out.println(arr2[i].getAbsolutePath());
      if (arr2[i].getAbsolutePath().contains("Planos")) {
        dirtxt = new File(arr2[i].getAbsolutePath());
      }
    }

    File[] arr3 = dirtxt.listFiles();
    for (int i = 0; i < arr3.length; i++) {
      if (arr3[i].getAbsolutePath().contains(numNivel + ".txt")) {
        dirtxt = new File(arr3[i].getAbsolutePath());
      }
    }

    String ruta = "";

    ruta = dirtxt.getAbsolutePath();

    File file = new File(ruta); // abrimos el archivo dentro de java
    try {
      //prepara el archivo
      Scanner scan = new Scanner(file);

      //comienza a leer el archivo
      int i = 0;
      while (scan.hasNextLine()) {
        //empezamos por la fila de mas arriba del texto
        String linea = scan.nextLine();
        //System.out.println(linea);
        //leemos cada linea de izquierda a dercha
        for (int j = 0; j < linea.length(); j++) {
        	if (linea.charAt(j) == 'x') {
        		grilla[i][j] = new Pared (i, j, bloqueGrafico.getPared());
        	}
        	if (linea.charAt(j) == '#') {
        		crearSuelo (i, j);
        	}
        	if (linea.charAt(j) == '$') {
        		posiblesCriatura.add(crearSuelo (i, j));
        	}
        	if (linea.charAt(j) == '@') {
        		posiblesComestibles.add(crearSuelo (i, j));
        	}
        }
        i++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
	return grilla;
  }
  
  private Transitable crearSuelo (int i, int j) {
	  Transitable suelo =  new Transitable (i, j, bloqueGrafico.getSuelo());
	  grilla[i][j] = suelo;
	  return suelo;
  }
 
  public File getDirImagenes() {
    return DirImagenes;
  }

  public File getDirPlanos() {
    return DirPlanos;
  }

  public void display() {}

  public static void main(String[] args) {
	  LevelReader minivel;
	  minivel = new LevelReader();
	  minivel.display();
  }
  
  public Transitable getPosibleConsumible() {
	  int indice = (int) ((Math.random() * posiblesComestibles.size()));
	  return posiblesComestibles.get(indice);
  }
  
  public Transitable getPosibleCriatura() {
	  int indice = (int) ((Math.random() * posiblesCriatura.size()));
	  return posiblesCriatura.get(indice);
  }
}
