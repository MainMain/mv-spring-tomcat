package pam.metier;

import pam.entities.Cotisation;
import pam.entities.Employe;

import java.io.Serializable;

public class FeuilleSalaire implements Serializable {

  private static final long serialVersionUID = 1L;
  // champs privés
  private Employe employe;
  private Cotisation cotisation;
  private ElementsSalaire elementsSalaire;

  // constructeurs
  public FeuilleSalaire() {
  }

  public FeuilleSalaire(Employe employe, Cotisation cotisation, ElementsSalaire elementsSalaire) {
    setEmploye(employe);
    setCotisation(cotisation);
    setElementsSalaire(elementsSalaire);
  }

  // toString
  @Override
  public String toString() {
    return "[" + employe.toString2() + "," + cotisation + "," + elementsSalaire + "]";
  }

  // accesseurs
  public Cotisation getCotisation() {
    return cotisation;
  }

  public void setCotisation(Cotisation cotisation) {
    this.cotisation = cotisation;
  }

  public Employe getEmploye() {
    return employe;
  }

  public void setEmploye(Employe employe) {
    this.employe = employe;
  }

  public ElementsSalaire getElementsSalaire() {
    return elementsSalaire;
  }

  public void setElementsSalaire(ElementsSalaire elementsSalaire) {
    this.elementsSalaire = elementsSalaire;
  }
}
