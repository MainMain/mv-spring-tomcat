package pam.client.dao;

import pam.client.entities.Employe;
import pam.client.entities.FeuilleSalaire;

import java.util.List;

public interface IDao {
  // liste des employés
  public List<Employe> getEmployes();

  // feuille de salaire
  public FeuilleSalaire getFeuilleSalaire(String ss, double ht, int jt);

  // timeout
  public void setTimeout(int millis);

  // URL service REST
  public void setUrlServiceRest(String urlServiceRest);
}