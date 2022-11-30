package Nivel;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyStore.Entry;
import java.util.LinkedList;
import java.util.Scanner;
import Entrada.*;

import Bloque.Bloque;

public class LevelReader {

  private LinkedList<Entrada<Integer, Integer>> comida = new LinkedList<>(); //coleccion de ubicacion de comida  [no usado hasta tener clase comida]
  private LinkedList<Entrada<Integer, Integer>> muro = new LinkedList<>(); //por ahora no usado mas delante lo usaremos
  private char[][] map = new char[20][20];
  private String path;
  private File DirPlanos = null;
  private File DirImagenes = null;

  public LevelReader(int lvl) {
    //buscamos el archivo
    File directorio = new File(System.getProperty("user.dir"));
    String[] arr = directorio.list();
    File dirSnake = null;
    File dirSrc = null;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].contains("Snake")) {
        dirSnake = new File(arr[i]);
      }
    }
    System.out.println(dirSnake.getAbsolutePath());
    File[] arr2 = dirSnake.listFiles();
    for (int i = 0; i < arr2.length; i++) {
      System.out.println(arr2[i].getAbsolutePath());
      if (arr2[i].getAbsolutePath().contains("src")) {
        System.out.println(
          "Entra al if de src      " + arr2[i].getAbsolutePath()
        );
        dirSrc = new File(arr2[i].getAbsolutePath());
      }
    }

    System.out.println("Crea dir planos y imagenes");
    System.out.println(dirSrc.getAbsolutePath());
    System.out.println(dirSrc.list().length);
    System.out.println("REvisamo dentro de SRC");
    arr2 = dirSrc.listFiles();
    for (int i = 0; i < arr2.length; i++) {
      System.out.println(arr2[i].getAbsolutePath());
      if (arr2[i].getAbsolutePath().contains("Planos")) {
        DirPlanos = new File(arr2[i].getAbsolutePath());
      }

      if (arr2[i].getAbsolutePath().contains("Imagenes")) {
        DirImagenes = new File(arr2[i].getAbsolutePath());
      }
    }

    File[] planos = DirPlanos.listFiles();
    String url = planos[lvl - 1].getAbsolutePath(); //busca el archivo dentro del pc
    System.out.println("Este es nuestro plano: " + url);
    path = url;

    File file = new File(url); // abrimos el archivo dentro de java
    try {
      //prepara el archivo
      Scanner scan = new Scanner(file);

      int ancho = Integer.parseInt(scan.nextLine()); // Esto es X
      int alto = Integer.parseInt(scan.nextLine()); // Esto es Y
      int cantMuros = Integer.parseInt(scan.nextLine());
      map = new char[ancho][alto];

      //comienza a leer el archivo
      int y = map[0].length - 1;
      while (scan.hasNextLine()) {
        //como construimos de arriba a abajo empezamos por la fila de mas arriba del texto
        String linea = scan.nextLine();

        //leemos cada linea de izquierda a dercha
        for (int x = 0; x < linea.length(); x++) {
          map[x][y] = linea.charAt(x);
          if (map[x][y] == 'o') {
            comida.add(new Entrada<Integer, Integer>(x, y));
          }
          if (map[x][y] == 'x') {
            muro.add(new Entrada<Integer, Integer>(x, y));
          }
          //System.out.println("Posicion: (" + x + "," + y + ") | char: " + map[x][y]);
        }
        //cuando termina cambiamos a la linea de abajo
        y--;
      }

      System.out.println("=================NIVEL CARGADO=================");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Bloque[][] buildNivel(Nivel nivel, int stage) {
    stage--;
    File file; // abrimos el archivo dentro de java
    File[] arrLvl = DirPlanos.listFiles();
    file = arrLvl[stage];
    System.out.println("$$$$$$$$$$$ NIVEL A CREAR +"+(stage-1)+": "+arrLvl[stage]);
    File[] arr = DirImagenes.listFiles();
    String urlCelda = "";
    String urlAlimento = "";
    String urlPowerup = "";
    String urlPared = "";

    for (int i = 0; i < arr.length; i++) {
      if (arr[i].getAbsolutePath().contains("bgcell")) {
        urlCelda = arr[i].getAbsolutePath();
      }

      if (arr[i].getAbsolutePath().contains("foodcell")) {
        urlAlimento = arr[i].getAbsolutePath();
      }

      if (arr[i].getAbsolutePath().contains("pucell")) {
        urlPowerup = arr[i].getAbsolutePath();
      }

      if (arr[i].getAbsolutePath().contains("wallcell")) {
        urlPared = arr[i].getAbsolutePath();
      }
    }
    try {
        //prepara el archivo
        Scanner scan = new Scanner(file);

        int ancho = Integer.parseInt(scan.nextLine()); // Esto es X
        int alto = Integer.parseInt(scan.nextLine()); // Esto es Y
        int cantMuros = Integer.parseInt(scan.nextLine());
        map = new char[ancho][alto];

        //comienza a leer el archivo
        int y = map[0].length - 1;
        while (scan.hasNextLine()) {
          //como construimos de arriba a abajo empezamos por la fila de mas arriba del texto
          String linea = scan.nextLine();

          //leemos cada linea de izquierda a dercha
          for (int x = 0; x < linea.length(); x++) {
            map[x][y] = linea.charAt(x);
            if (map[x][y] == 'o') {
              comida.add(new Entrada<Integer, Integer>(x, y));
            }
            if (map[x][y] == 'x') {
              muro.add(new Entrada<Integer, Integer>(x, y));
            }
            //System.out.println("Posicion: (" + x + "," + y + ") | char: " + map[x][y]);
          }
          //cuando termina cambiamos a la linea de abajo
          y--;
        }

        System.out.println("=================NIVEL CARGADO=================");
      } catch (Exception e) {
        e.printStackTrace();
    }

    return nivel.getNivel();
  }

  public File getDirImagenes() {
    return DirImagenes;
  }

  public File getDirPlanos() {
    return DirPlanos;
  }

  public void display() {
    for (int i = 0; i < map.length; i++) {
      // Loop through all elements of current row
      for (int j = map[i].length - 1; j >= 0; j--) {
        //System.out.println("Posicion: ("+i +","+j);
        System.out.print(map[i][j]);
      }

      System.out.println();
    }
    System.out.println("Mapa de: " + map.length + "x" + map[0].length);
    System.out.println("Cant de comida: " + comida.size());
    System.out.println("Cant de muros: " + muro.size());
    System.out.println("comida (1,18): " + map[1][18]); //deberia ser 'o'
    System.out.println("(0,19): " + map[0][19]); //deberia ser 'a'
    System.out.println("(19,19): " + map[19][19]); //deberia ser 'b'
    System.out.println("(0,0): " + map[0][0]); //deberia ser 'c'
    System.out.println("(19,0): " + map[19][0]); //deberia ser 'd'
  }

  public static void main(String[] args) {
    LevelReader minivel;
    minivel = new LevelReader(3);
    minivel.display();
  }
}
