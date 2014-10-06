
package pam.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "INDEMNITES")
public class Indemnite extends AbstractEntity implements Serializable {

  private int indice;
  private double base_Heure;
  private double entretien_Jour;
  private double repas_Jour;
  private double indemnites_CP;

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
    return base_Heure;
  }

  public void setBaseHeure(double baseHeure) {
    this.base_Heure = baseHeure;
  }

  public double getEntretienJour() {
    return entretien_Jour;
  }

  public void setEntretienJour(double entretienJour) {
    this.entretien_Jour = entretienJour;
  }

  public double getRepasJour() {
    return repas_Jour;
  }

  public void setRepasJour(double repasJour) {
    this.repas_Jour = repasJour;
  }

  public double getIndemnitesCP() {
    return indemnites_CP;
  }

  public void setIndemnitesCP(double indemnitesCP) {
    this.indemnites_CP = indemnitesCP;
  }
}
