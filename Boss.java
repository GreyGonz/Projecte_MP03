

package projecte;

import java.util.Scanner;

public class Boss implements java.io.Serializable {
  private static final long serialVersionUID = 42L;
  private String nom=null;
  private String zona=null;
  private String desc=null;
  private int aparicio=0;
  private int animes=0;
  private double tamany=0;
  private char atac=' ';
  private boolean omplit=false;

  private String valorStr;
  private int valorInt;
  private double valorDbl;
  private Scanner e = new Scanner(System.in);



  public Boss() {

  }

  // Retorna el metode cada vegada que es crida l'objecte
  @Override // necessari per a sobreescriure el metode toString()
  public String toString() {
     return "Nom complet: " + nom +
              "\nEntrega de la primera aparició: " + aparicio +
              "\nZona on es troba: " + zona +
              "\nTipus d'atacs: " + atac +
              "\nTamany: " + tamany +
              "\nAnimes: " + animes +
              "\nDescripció: " + desc + "\n";
  }


  public void comprovaValor(int prova) {
    do {
      try {
        switch(prova) {
          case 1: this.valorStr = e.skip("[\r\n]*").nextLine(); break;
          case 2: this.valorInt = e.skip("[\r\n]*").nextInt(); break;
          case 3: this.valorDbl = e.skip("[\r\n]*").nextDouble(); break;
        }
        break;
      } catch (java.util.InputMismatchException x) {
        System.err.println("VALOR INVÀLID\nTorna a introduïr el valor: ");
        e.next();
      }
    } while (true);

  }

  public boolean isOmplit() {
    return omplit;
  }

  public void setOmplit(boolean omplit) {
    this.omplit = omplit;
  }

  public String getNom() {
    return nom;
  }

  public void setNom() {
    comprovaValor(1);
    this.nom = valorStr;

  }

  public String getZona() {
    return zona;
  }

  public void setZona() {
    comprovaValor(1);
    this.zona = valorStr;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc() {
    comprovaValor(1);
    this.desc = valorStr;
  }

  public int getAparicio() {
    return aparicio;
  }

  public void setAparicio() {
    do {
      comprovaValor(2);
      this.aparicio = valorInt;
      if (aparicio >= 1 && aparicio <= 3) break;
      else System.err.println("VALOR INVÀLID\nNomés s'accepten valors dins el rang 1-3: ");
    } while(true);

  }

  public int getAnimes() {
    return animes;
  }

  public void setAnimes() {
    comprovaValor(2);
    this.animes = valorInt;
  }

  public double getTamany() {
    return tamany;
  }

  public void setTamany() {
    comprovaValor(3);
    this.tamany = valorDbl;
  }

  public char getAtac() {
    return atac;
  }

  public void setAtac(char atac) {
    this.atac = atac;
  }

  // public void setAtac() {
  //   do {
  //     try {
  //       this.atac = e.skip("[\r\n]*").next().charAt(0);
  //       break;
  //     } catch (java.util.InputMismatchException x) {
  //       System.err.println("VALOR NO VÀLID");
  //       e.next();
  //     }
  //   } while(true);
  // }


}
