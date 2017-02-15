/*
MP03 Projecte
Gerard Rey González 1r ASIX
*/

package projecte;

import java.util.Scanner;

public class projecte1 {

  // Nombre màxim de caselles per a l'array
  private static final int MAX_BOSSES=2;
  //Array on guardarem la informació dels Bosses
  private static Boss[] array = new Boss[MAX_BOSSES];

  private static int opcio, casella, aparicio;

  private static char yn;

  private static char[] atacs = {'m','a','c','h'};

  public static void main(String[] args) {



  }

  public static void inicialitzar() {
    for (int q = 0; q < array.length(); q++ ) {
      array[q] = new Boss();
      array[q].setOmplit(false);
    }
  }

  public static void printMenu() {
    Scanner e = new Scanner(System.in);

    //Dibuixa el menú per pantalla
    System.out.println("####Dark Souls Bosses####");
    System.out.println("0. Sortir ");
    System.out.println("1. Afegir Boss");
    System.out.println("2. Esborrar Boss");
    System.out.println("3. Modificar Boss");
    System.out.println("4. Llistar Boss");
    System.out.println("5. Ajuda");
    System.out.println("#########################");
    System.out.println("Elegeix una opció [0-4]: ");
    opcio = e.nextInt();

  }

  public static void triaOpcio() {

    switch (opcio) {
      case 0: System.exit(0);
      case 1: newBoss();
    }

  }

  private static void newBoss() {
    Scanner entry = new Scanner(System.in);
    Scanner text = new Scanner(System.in);

    if (casellaDisponible()) {
        System.out.println("###Afegir un Boss###");
        System.out.println("Introdueix el nom complet: ");
        array[casella].setNom(text.skip("[\r\n]*").nextLine());
        do {
            System.out.println("Joc de la primera aparició (valor numèric): ");
            array[casella].setAparicio(entry.skip("[\r\n]*").nextInt());
        } while (aparicio < 1 || aparicio > 3);
        System.out.println("Zona on es troba: ");
        array[casella].setZona(text.skip("[\r\n]*").nextLine());
        do { // Demana les dades
            System.out.println("Tipus d'atacs (\"m\", \"a\" o \"c\"): ");
            System.out.println("Prem h per a mes ajuda");
            array[casella].setAtac(text.skip("[\r\n]*").next().charAt(0)); // si les dades no són vàlides es repetirà el bucle fins que siguin correctes
            if (atacs[0] == getAtac() || atacs[1] == getAtac() || atacs[2] == getAtac()) {
                break;
            } else if (atacs[3] == 'h') { // si premem 'h' es mostrarà l'ajuda
                System.out.println("#AJUDA#");
                System.out.println("m = magia \na = armes a distància \nc = cos a cos");
                System.out.println("#######");
            } else {
                System.out.println("El valor introduït no és vàlid. \n");
            }
        } while(true);
        System.out.println("Tamany (en metres): ");
        array[casella].setTamany(entry.skip("[\r\n]*").nextDouble());
        System.out.println("Animes: ");
        array[casella].setAnimes(entry.skip("[\r\n]*").nextInt());
        System.out.println("Descripció: ");
        array[casella].setDesc(text.skip("[\r\n]*").nextLine());
        array[casella].setOmplit(true);
    } else {
        //En cas d'haver dades introduïdes anteriorment s'executaran les següents línies
        System.out.println("Les dades ja han estat introduïdes, si en vols posar més l'hauràs d'esborrar primer.");
        System.out.println("Vols esborrar les dades per introduïr de noves? (s/n)");
        yn = entry.next().charAt(0);
        if (yn == 's') array[casella].setOmplit(false);
    }
  }

  public static boolean casellaDisponible() {
    int i;
    for( i = 0; i < array.length() && array[i].isOmplit(); i++);
    casella = i;
    return (i<array.length()?true:false);
  }

}
