

package projecte;

public class boss {
  private String nom=null;
  private String zona=null;
  private String desc=null;
  private int aparicio=0;
  private int animes=0;
  private double tamany=0;
  private char atac=' ';
  private boolean omplit=false;

  public void Boss() {

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

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getZona() {
    return zona;
  }

  public void setZona(String zona) {
    this.zona = zona;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public int getAparicio() {
    return aparicio;
  }

  public void setAparicio(int aparicio) {
    this.aparicio = aparicio;
  }

  public int getAnimes() {
    return animes;
  }

  public void setAanimes(int animes) {
    this.animes = animes;
  }

  public double getTamany() {
    return tamany;
  }

  public void setTamany(int tamany) {
    this.tamany = tamany;
  }

  public char getAtac() {
    return atac;
  }

  public void setAtac(char atac) {
    this.atac = atac;
  }


}
