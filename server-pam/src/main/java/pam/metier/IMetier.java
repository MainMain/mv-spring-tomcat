package pam.metier;

import pam.entities.Employe;
import pam.entities.FeuilleSalaire;

import java.util.List;

public interface IMetier {

  // liste des employés
  public List<Employe> getEmployes();
  // feuille de salaire
  public FeuilleSalaire getFeuilleSalaire(String ss, double ht, int jt);

}