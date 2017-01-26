

package projecte;

public class boss {
  private String nom=null;
  private String zona=null;
  private String desc=null;
  private Int aparicio=0;
  private Int animes=0;
  private double tamany=0;
  private char atac=' ';
  private boolean omplit=false;

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

  public Int getAparicio() {
    return aparicio;
  }

  public void setAparicio(String aparicio) {
    this.aparicio = aparicio;
  }

  public Int getAnimes() {
    return animes;
  }

  public void setAanimes(String animes) {
    this.animes = animes;
  }

  public double getTamany() {
    return tamany;
  }

  public void setTamany(String tamany) {
    this.tamany = tamany;
  }

  public Char getAtac() {
    return atac;
  }

  public void setAtac(String atac) {
    this.atac = atac;
  }


}
