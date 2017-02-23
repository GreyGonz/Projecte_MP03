/*
MP03 Projecte
Gerard Rey González 1r ASIX
*/

import java.util.Scanner;

public class projecte {

    //Nombre màxim de casselles per a l'array
    private static final int MAX_BOSSES=2;
    //Array on guardarem la informació dels pilots
    private static Boss[] array=new Boss[MAX_BOSSES];

    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);
        Scanner text = new Scanner(System.in);
        int i, init, opcioInt=0, auxInt=0;
        String auxStr=null;
        char opcioYN=' ', auxChr=' ';
        char[] atacs = {'m', 'a', 'c'};
        double auxDbl=0;

        // Declarem totes les caselles del array a false (canviarem a true quan estigue plena)
        for (int q = 0; q < array.length(); q++ ) {
          array[q] = new Boss();
          array[q].setOmplit(false);
        }

        // // Búsqueda de caselles buides
        // int i;
        // for ( i = 0; i < array.length() && array[i].isOmplit(); i++);
        //   if (i != array.length()); // casella buida
        //   else System.out.println("No caben més pilots"); //totes les caselles estan plenes


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
            init = entry.nextInt();

            switch(init) {
                case 0: System.exit(0);
                case 1: // Línies que ens permetran introduïr les dades d'un nou Boss

                    // Búsqueda de caselles buides
                    // int i;
                    for ( i = 0; i < array.length() && array[i].isOmplit(); i++);

                    if (i < array.length()) {
                        System.out.println("###Afegir un Boss###");
                        System.out.println("Introdueix el nom complet: ");
                        array[i].setNom(text.skip("[\r\n]*").nextLine());
                        do {
                            System.out.println("Joc de la primera aparició (valor numèric): ");
                            array[i].setAparicio(entry.skip("[\r\n]*").nextInt());
                        } while (aparicio < 1 || aparicio > 3);
                        System.out.println("Zona on es troba: ");
                        array[i].setZona(text.skip("[\r\n]*").nextLine());
                        do { // Demana les dades
                            System.out.println("Tipus d'atacs (\"m\", \"a\" o \"c\"): ");
                            System.out.println("Prem h per a mes ajuda");
                            array[i].setAtac(text.skip("[\r\n]*").next().charAt(0)); // si les dades no són vàlides es repetirà el bucle fins que siguin correctes
                            if (atacs[0] == getAtac() || atacs[1] == getAtac() || atacs[2] == getAtac()) { // si les dades són valides valid = true i es surt del bucle
                                break;
                            } else if (atac == 'h') { // si premem 'h' es mostrarà l'ajuda
                                System.out.println("#AJUDA#");
                                System.out.println("m = magia \na = armes a distància \nc = cos a cos");
                                System.out.println("#######");
                            } else {
                                System.out.println("El valor introduït no és vàlid. \n");
                            }
                        } while(true);
                        System.out.println("Tamany (en metres): ");
                        array[i].setTamany(entry.skip("[\r\n]*").nextDouble());
                        System.out.println("Animes: ");
                        array[i].setAnimes(entry.skip("[\r\n]*").nextInt());
                        System.out.println("Descripció: ");
                        array[i].setDesc(text.skip("[\r\n]*").nextLine());
                        array[i].setOmplit(true);
                        break;
                    } else {
                        //En cas d'haver dades introduïdes anteriorment s'executaran les següents línies
                        System.out.println("Les dades ja han estat introduïdes, si en vols posar més l'hauràs d'esborrar primer.");
                        System.out.println("Vols esborrar les dades per introduïr de noves? (s/n)");
                        opcioYN = entry.next().charAt(0);
                        if (opcioYN == 's') array[i].setOmplit(false);
                    }
                case 2:

                    for ( i = 0; i < array.length && array[i].isOmplit(); i++);

                    System.out.println("###Esborrar Boss###");
                    if (i < array.length()) {
                        System.out.println("No existeixen dades per a esborrar");
                        System.out.println("###################\n");
                    } else {
                        System.out.println("S'esborraran les següents dades: \n");
                        System.out.println("Nom complet: " + getNom());
                        System.out.println("Entrega de la primera aparició: " + getAparicio());
                        System.out.println("Zona on es troba: " + getZona());
                        System.out.println("Tipus d'atacs: " + getAtac());
                        System.out.println("Tamany: " + getTamany());
                        System.out.println("Animes: " + getAnimes());
                        System.out.println("Descripció: " + getDesc() + "\n");
                        System.out.println("Estas segur d'esborrar les dades? (s/n)");
                        opcioYN = entry.next().charAt(0);
                        if (opcioYN == 's') {
                            array[i].isOmplit(false);
                            System.out.println("Dades esborrades correctament");
                            System.out.println("###################\n");
                        } else {
                            // array[i].isOmplit(true);
                            System.out.println("No s'han esborrat les dades");
                            System.out.println("###################\n");
                        }
                    }
                    break;
                case 3:

                    for ( i = 0; i < array.length() && array[i].isOmplit(); i++);

                    System.out.println("###Modificar Boss###");
                    if(i < array.length()) {
                        System.out.println("No hi ha cap boss introduït");
                        System.out.println("####################\n");
                    } else {
                        do {
                            System.out.println("Tria el camp que vols modificar: \n");
                            System.out.println("0. Tornar al menú");
                            System.out.println("1. Nom complet: " + getNom());
                            System.out.println("2. Entrega de la primera aparició: " + getAparicio());
                            System.out.println("3. Zona on es troba: " + getZona());
                            System.out.println("4. Tipus d'atacs: " + getAtac());
                            System.out.println("5. Tamany: " + getTamany());
                            System.out.println("6. Animes: " + getAnimes());
                            System.out.println("7. Descripció: " + getDesc() + "\n");
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
                                        array[i].setNom(entry.skip("[\r\n]*").nextLine());
                                        break;
                                    case 2:
                                        do {
                                            System.out.println("Joc de la primera aparició (valor numèric): ");
                                            array[i].setAparicio(entry.skip("[\r\n]*").nextInt());
                                        } while (getAparicio() < 1 || getAparicio() > 3);
                                        break;
                                    case 3:
                                        array[i].setZona(entry.skip("[\r\n]*").nextLine());
                                        break;
                                    case 4:
                                        do { // Demana les dades
                                            System.out.println("Tipus d'atacs (\"m\", \"a\" o \"c\"): ");
                                            System.out.println("Prem h per a mes ajuda");
                                            array[i].setAtac(text.skip("[\r\n]*").next().charAt(0)); // si les dades no són vàlides es repetirà el bucle fins que siguin correctes
                                            if (atacs[0] == getAtac() || atacs[1] == getAtac() || atacs[2] == getAtac()) { // si les dades són valides valid = true i es surt del bucle
                                                break;
                                            } else if (getAtac() == 'h') { // si premem 'h' es mostrarà l'ajuda
                                                System.out.println("#AJUDA#");
                                                System.out.println("m = magia \na = armes a distància \nc = cos a cos");
                                                System.out.println("#######");
                                            } else {
                                                System.out.println("El valor introduït no és vàlid. \n");
                                            }
                                        } while(true);
                                        break;
                                    case 5:
                                        array[i].setTamany(entry.skip("[\r\n]*").nextDouble());
                                        break;
                                    case 6:
                                        getAnimes() = entry.nextInt();
                                        break;
                                    case 7:
                                        getDesc() = entry.skip("[\r\n]*").nextLine();
                                        break;
                                }
                                System.out.println("Vols modificar un altre valor? (s/n)");
                                opcioYN = entry.next().charAt(0);
                                if (opcioYN == 'n') break; // else { valid = false; }
                                System.out.println("####################\n");
                            }
                        } while(true);
                    }
                    break;
                case 4:

                    // for ( i = 0; i < array.length() && array[i].isOmplit(); i++);

                    System.out.println("###Llistat de Bosses###");
                    if(!valid){ // --> if (array[i].isOmplit(false)) {}
                        System.out.println("No hi ha dades introduïdes");
                        System.out.println("#######################\n");
                    } else {
                        System.out.println("\nNom complet: " + getNom());
                        System.out.println("Entrega de la primera aparició: " + getAparicio());
                        System.out.println("Zona on es troba: " + getZona());
                        System.out.println("Tipus d'atacs: " + getAtac());
                        System.out.println("Tamany: " + getTamany());
                        System.out.println("Animes: " + getAnimes());
                        System.out.println("Descripció: " + getDesc());
                        System.out.println("#######################\n");
                    }
                    break;
                case 5:
                    System.out.println("Dark Souls és una saga de videojocs[...]");
                    break;
                default: System.out.println("Entrada no vàlida. Introdueix una opció del 0 al 4");
                    break;
            }

        }while(true);
    }

}
