/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;

import java.util.Scanner;

/**
 *
 * @author gerard
 */
public class Projecte {

    /**
     * @param args the command line arguments
     */

    //Nombre màxim de casselles per a l'array
    private static final int MAX_BOSSES=2;
    //Array on guardarem la informació dels pilots
    private static Boss[] array=new Boss[MAX_BOSSES];

    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);
        Scanner text = new Scanner(System.in);
        int init, aparicio=0, animes=0, opcioInt=0, auxInt=0;
        String nom = null, zona=null, descripcio=null, auxStr=null;
        char atac=' ', opcioYN=' ', auxChr=' ';
        char[] atacs = {'m', 'a', 'c'};
        boolean valid = false;
        double tamany=0, auxDbl=0;


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
                    if(!valid) {
                        System.out.println("###Afegir un Boss###");
                        System.out.println("Introdueix el nom complet: ");
                        nom = text.nextLine();
                        do {
                            System.out.println("Joc de la primera aparició (valor numèric): ");
                            aparicio = entry.nextInt();
                        } while (aparicio < 1 || aparicio > 3);
                        System.out.println("Zona on es troba: ");
                        zona = text.nextLine();
                        do { // Demana les dades
                            System.out.println("Tipus d'atacs (\"m\", \"a\" o \"c\"): ");
                            System.out.println("Prem h per a mes ajuda");
                            atac = text.next().charAt(0); // si les dades no són vàlides es repetirà el bucle fins que siguin correctes
                            if (atacs[0] == atac || atacs[1] == atac || atacs[2] == atac) { // si les dades són valides valid = true i es surt del bucle
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
                        tamany = entry.nextDouble();
                        System.out.println("Animes: ");
                        animes = entry.nextInt();
                        System.out.println("Descripció: ");
                        descripcio = text.nextLine();
                        valid = true;
                        break;
                    } else {
                        //En cas d'haver dades introduïdes anteriorment s'executaran les següents línies
                        System.out.println("Les dades ja han estat introduïdes, si en vols posar més l'hauràs d'esborrar primer.");
                        System.out.println("Vols esborrar les dades per introduïr de noves? (s/n)");
                        opcioYN = entry.next().charAt(0);
                        if (opcioYN == 's') valid = false; // else { valid = true; }
                    }
                case 2:
                    System.out.println("###Esborrar Boss###");
                    if (!valid) {
                        System.out.println("No existeixen dades per a esborrar");
                        System.out.println("###################\n");
                    } else {
                        System.out.println("S'esborraran les següents dades: \n");
                        System.out.println("Nom complet: " + nom);
                        System.out.println("Entrega de la primera aparició: " + aparicio);
                        System.out.println("Zona on es troba: " + zona);
                        System.out.println("Tipus d'atacs: " + atac);
                        System.out.println("Tamany: " + tamany);
                        System.out.println("Animes: " + animes);
                        System.out.println("Descripció: " + descripcio + "\n");
                        System.out.println("Estas segur d'esborrar les dades? (s/n)");
                        opcioYN = entry.next().charAt(0);
                        if (opcioYN == 's') {
                            valid = false;
                            System.out.println("Dades esborrades correctament");
                            System.out.println("###################\n");
                        } else {
                            //valid = true;
                            System.out.println("No s'han esborrat les dades");
                            System.out.println("###################\n");
                        }
                    }
                    break;
                case 3:
                    System.out.println("###Modificar Boss###");
                    if(!valid) {
                        System.out.println("No hi ha cap boss introduït");
                        System.out.println("####################\n");
                    } else {
                        do {
                            System.out.println("Tria el camp que vols modificar: \n");
                            System.out.println("0. Tornar al menú");
                            System.out.println("1. Nom complet: " + nom);
                            System.out.println("2. Entrega de la primera aparició: " + aparicio);
                            System.out.println("3. Zona on es troba: " + zona);
                            System.out.println("4. Tipus d'atacs: " + atac);
                            System.out.println("5. Tamany: " + tamany);
                            System.out.println("6. Animes: " + animes);
                            System.out.println("7. Descripció: " + descripcio + "\n");
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
                                        nom = entry.skip("[\r\n]*").nextLine();
                                        break;
                                    case 2:
                                        do {
                                            System.out.println("Joc de la primera aparició (valor numèric): ");
                                            aparicio = entry.nextInt();
                                        } while (aparicio < 1 || aparicio > 3);
                                        break;
                                    case 3:
                                        zona = entry.skip("[\r\n]*").nextLine();
                                        break;
                                    case 4:
                                        do { // Demana les dades
                                            System.out.println("Tipus d'atacs (\"m\", \"a\" o \"c\"): ");
                                            System.out.println("Prem h per a mes ajuda");
                                            atac = text.next().charAt(0); // si les dades no són vàlides es repetirà el bucle fins que siguin correctes
                                            if (atacs[0] == atac || atacs[1] == atac || atacs[2] == atac) { // si les dades són valides valid = true i es surt del bucle
                                                break;
                                            } else if (atac == 'h') { // si premem 'h' es mostrarà l'ajuda
                                                System.out.println("#AJUDA#");
                                                System.out.println("m = magia \na = armes a distància \nc = cos a cos");
                                                System.out.println("#######");
                                            } else {
                                                System.out.println("El valor introduït no és vàlid. \n");
                                            }
                                        } while(true);
                                        break;
                                    case 5:
                                        tamany = entry.nextDouble();
                                        break;
                                    case 6:
                                        animes = entry.nextInt();
                                        break;
                                    case 7:
                                        descripcio = entry.skip("[\r\n]*").nextLine();
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
                    System.out.println("###Llistat de Bosses###");
                    if(!valid){
                        System.out.println("No hi ha dades introduïdes");
                        System.out.println("#######################\n");
                    } else {
                        System.out.println("\nNom complet: " + nom);
                        System.out.println("Entrega de la primera aparició: " + aparicio);
                        System.out.println("Zona on es troba: " + zona);
                        System.out.println("Tipus d'atacs: " + atac);
                        System.out.println("Tamany: " + tamany);
                        System.out.println("Animes: " + animes);
                        System.out.println("Descripció: " + descripcio);
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
