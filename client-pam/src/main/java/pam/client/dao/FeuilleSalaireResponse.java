package pam.client.dao;

import pam.client.entities.FeuilleSalaire;

public class FeuilleSalaireResponse extends AbstractResponse {

  // la feuille de salaire
  private FeuilleSalaire feuilleSalaire;

  // getters et setters

  public FeuilleSalaire getFeuilleSalaire() {
    return feuilleSalaire;
  }

  public void setFeuilleSalaire(FeuilleSalaire feuilleSalaire) {
    this.feuilleSalaire = feuilleSalaire;
  }
}
