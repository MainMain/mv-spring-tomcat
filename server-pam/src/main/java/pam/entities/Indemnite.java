
package pam.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "INDEMNITES")
public class Indemnite extends AbstractEntity implements Serializable {

  private int indice;
  private double baseHeure;
  private double entretienJour;
  private double repasJour;
  private double indemnitesCP;

  public Indemnite() {
  }

  public Indemnite(int indice, double baseHeure, double entretienJour, double repasJour, double indemnitesCP) {
    setIndice(indice);
    setBaseHeure(baseHeure);
    setEntretienJour(entretienJour);
    setRepasJour(repasJour);
    setIndemnitesCP(indemnitesCP);
  }

  @Override
  public String toString() {
    return "jpa.Indemnite[id=" + getId()
      + ",version=" + getVersion()
      + ",indice=" + getIndice()
      + ",base heure=" + getBaseHeure()
      + ",entretien jour" + getEntretienJour()
      + ",repas jour=" + getRepasJour()
      + ",indemnités CP=" + getIndemnitesCP()
      + "]";
  }

  public int getIndice() {
    return indice;
  }

  public void setIndice(int indice) {
    this.indice = indice;
  }

  public double getBaseHeure() {
    return baseHeure;
  }

  public void setBaseHeure(double baseHeure) {
    this.baseHeure = baseHeure;
  }

  public double getEntretienJour() {
    return entretienJour;
  }

  public void setEntretienJour(double entretienJour) {
    this.entretienJour = entretienJour;
  }

  public double getRepasJour() {
    return repasJour;
  }

  public void setRepasJour(double repasJour) {
    this.repasJour = repasJour;
  }

  public double getIndemnitesCP() {
    return indemnitesCP;
  }

  public void setIndemnitesCP(double indemnitesCP) {
    this.indemnitesCP = indemnitesCP;
  }
}
