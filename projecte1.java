/*
MP03 Projecte
Gerard Rey González 1r ASIX
*/

package projecte;

import java.util.Scanner;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class projecte1 {

  // Nombre màxim de caselles per a l'array
  private static final int MAX_BOSSES=2;
  //Array on guardarem la informació dels Bosses
  private static Boss[] array = new Boss[MAX_BOSSES];

  private static int opcio, opt, casella, aparicio;

  private static char yn;

  private static char[] atacs = {'m','a','c','h'};

  public static void main(String[] args) {

    inicialitzar();
    do {
      printMenu();
      triaOpcio();
    } while (opcio!=0);

  }

  public static void inicialitzar() {
    for (int q = 0; q < array.length; q++ ) {
      array[q] = new Boss();
      array[q].setOmplit(false);
    }

    File f = new File("projecte/boss.dat");

    if(f.exists()) {

      ObjectInputStream dades = null;

      try {
        dades = new ObjectInputStream(new FileInputStream(f));

        int i=0;
        while(true) {
          Boss b = (Boss) dades.readObject();
          array[i] = b;
          System.out.println(b);
          i++;
        }

      } catch (ClassNotFoundException | IOException ex) {

        System.err.println("Error en obrir el fitxer" + ex);
      } finally {
        try {
          dades.close();
        } catch (IOException ex) {
          System.out.println("Error en tancar el fitxer");
        }
      }
    }
  }

  public static void sortirPrograma() {
    File f = new File("projecte/boss.dat");

    ObjectOutputStream dades = null;
    try {
      dades = new ObjectOutputStream(new FileOutputStream(f));

      int i=0;
      while (true) {
        dades.writeObject(array[i]);
        i++;
      }

    } catch (IOException ex) {
      System.err.println("Error en obrir el fitxer");
    } finally {
      try {
        dades.close();
      } catch (IOException ex) {
        System.err.println("Error en tractar el fitxer");
      }
    }

    System.exit(0);
  }

  public static void printMenu() {
    Scanner e = new Scanner(System.in);

    do {

      System.out.println("####Dark Souls Bosses####");
      System.out.println("0. Sortir ");
      System.out.println("1. Afegir Boss");
      System.out.println("2. Esborrar Boss");
      System.out.println("3. Modificar Boss");
      System.out.println("4. Llistar Boss");
      System.out.println("5. Ajuda");
      System.out.println("#########################");
      System.out.println("Elegeix una opció [0-4]: ");

      try {
        opcio = e.nextInt();
        break;
      } catch (java.util.InputMismatchException x) {
        System.err.println("\nEL VALOR INTRODUÏT NO ÉS VÀLID!\n");
        e.next();
      }
    } while(true);
  }

  public static void triaOpcio() {

    switch (opcio) {
      case 0: sortirPrograma(); break;
      case 1: newBoss(); break;
      case 2: esborrarBoss(); break;
      case 3: modificarBoss(); break;
      case 4: llistarBoss(); break;
    }

  }

  public static boolean casellaDisponible() {
    int i;
    for( i = 0; i < array.length && array[i].isOmplit(); i++);
    casella = i;
    return (i<array.length?true:false);
  }

  private static boolean bossExist() {
    int i;
    for (i = 0; i < array.length && !array[i].isOmplit(); i++);
    casella = i;
    return (i<array.length?true:false);
  }

  private static void noValue() {
    System.out.println("\nNo es troba cap boss introduït");
    System.out.println("###################\n");
  }

  private static void triaBoss() {
    Scanner entry = new Scanner(System.in);

    llistarBoss();

    do {
      System.out.println("Quin boss desitges esborrar?[1-" + MAX_BOSSES + "]");
      casella = entry.nextInt();
    } while (casella < 0 && casella > MAX_BOSSES);

    casella--;
  }

  private static void mostrarBoss() {
    System.out.println(array[casella]);
  }

  private static void tipusAtacs() {
    Scanner entry = new Scanner(System.in);

    do { // Demana les dades
        System.out.println("Tipus d'atacs (\"m\", \"a\" o \"c\"): ");
        System.out.println("Prem h per a mes ajuda");
        array[casella].setAtac(entry.skip("[\r\n]*").next().charAt(0)); // si les dades no són vàlides es repetirà el bucle fins que siguin correctes
        if (atacs[0] == array[casella].getAtac() || atacs[1] == array[casella].getAtac() || atacs[2] == array[casella].getAtac()) {
            break;
        } else if (atacs[3] == 'h') { // si premem 'h' es mostrarà l'ajuda
            System.out.println("#AJUDA#");
            System.out.println("m = magia \na = armes a distància \nc = cos a cos");
            System.out.println("#######");
        } else {
            System.out.println("El valor introduït no és vàlid. \n");
        }
    } while(true);
  }

  private static void newBoss() {
    Scanner entry = new Scanner(System.in);

    if (casellaDisponible()) {
        System.out.println("\n###Afegir un Boss###");

        System.out.println("Introdueix el nom complet: ");
        array[casella].setNom();

        System.out.println("Joc de la primera aparició (valor numèric): ");
        array[casella].setAparicio();

        System.out.println("Zona on es troba: ");
        array[casella].setZona();

        tipusAtacs();

        System.out.println("Tamany (en metres): ");
        array[casella].setTamany();

        System.out.println("Animes: ");
        array[casella].setAnimes();

        System.out.println("Descripció: ");
        array[casella].setDesc();

        array[casella].setOmplit(true);
    } else {
        //En cas d'haver dades introduïdes anteriorment s'executaran les següents línies
        System.out.println("Les dades ja han estat introduïdes, si en vols posar més l'hauràs d'esborrar primer.");
        System.out.println("Vols esborrar les dades per introduïr de noves? (s/n)");
        yn = entry.next().charAt(0);
        if(yn == 's') {
          llistarBoss();
          System.out.println("Quin boss desitges eliminar per a introduïr dades noves?");
          opt = entry.nextInt();
          System.out.println("Estàs segur de que vols esborrar les dades del boss " + opt + "? (s/n)");
          yn = entry.next().charAt(0);
          if (yn == 's') array[opt-1].setOmplit(false);
        }
    }
  }

  private static void esborrarBoss() {
    Scanner entry = new Scanner(System.in);

    System.out.println("\n###Esborrar Boss###");

    if (bossExist()) {

      triaBoss();

      if (!array[casella].isOmplit()) {
        System.out.println("\nEl boss elegit no existeix o ja es troba esborrat. Perfavor elegeix un boss diferent: ");
        entry.next();
        esborrarBoss();
      }

      System.out.println("S'esborraran les següents dades: \n");

      mostrarBoss();

      System.out.println("Estas segur d'esborrar les dades? (s/n)");
      yn = entry.next().charAt(0);
      if (yn == 's') {
          array[casella].setOmplit(false);
          System.out.println("Dades esborrades correctament");
          System.out.println("###################\n");
      } else {
          System.out.println("No s'han esborrat les dades");
          System.out.println("###################\n");
      }
    } else noValue();

  }

  private static void modificarBoss() {
    Scanner entry = new Scanner(System.in);
    int opcioInt,bosSelec;

    System.out.println("###Modificar Boss###");

    if(!bossExist()) noValue();
    else {
        triaBoss();

        do {
            System.out.println("Tria el camp que vols modificar: \n");
            System.out.println("0. Tornar al menú");
            System.out.println("1. Nom complet: " + array[casella].getNom());
            System.out.println("2. Entrega de la primera aparició: " + array[casella].getAparicio());
            System.out.println("3. Zona on es troba: " + array[casella].getZona());
            System.out.println("4. Tipus d'atacs: " + array[casella].getAtac());
            System.out.println("5. Tamany: " + array[casella].getTamany());
            System.out.println("6. Animes: " + array[casella].getAnimes());
            System.out.println("7. Descripció: " + array[casella].getDesc() + "\n");
            System.out.println("Camp a modificar [0-7]: ");
            opcioInt = entry.nextInt();
            if (opcioInt == 0) {
                System.out.println("####################\n");
                break;
            } else if (opcioInt < 0 || opcioInt > 7){
                System.out.println("Valor invàlid");
            } else {
                System.out.println("Introdueix el nou valor: ");
                switch(opcioInt){
                    case 1:
                        array[casella].setNom();
                        break;
                    case 2:
                        array[casella].setAparicio();
                        break;
                    case 3:
                        array[casella].setZona();
                        break;
                    case 4:
                        tipusAtacs();
                        break;
                    case 5:
                        array[casella].setTamany();
                        break;
                    case 6:
                        array[casella].setAnimes();
                        break;
                    case 7:
                        array[casella].setDesc();
                        break;
                }
                System.out.println("Vols modificar un altre valor? (s/n)");
                yn = entry.next().charAt(0);
                if (yn == 'n') break;
                System.out.println("####################\n");
            }
        } while(true);
    }
  }

  private static void llistarBoss() {

    if(bossExist()) {
      for (casella = 0; casella < array.length; casella++) {
        if (array[casella].isOmplit()) {
          System.out.println("\nBoss num " + (casella+1));
          System.out.println("#########################");
          mostrarBoss();
        }
      }
    } else noValue();

  }



}
