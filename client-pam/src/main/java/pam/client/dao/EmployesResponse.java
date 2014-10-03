package pam.client.dao;


import pam.client.entities.Employe;

import java.util.List;

/**
 * Created by ST on 15/09/2014.
 */
public class EmployesResponse extends AbstractResponse {

  // la liste des employés
  private List<Employe> employés;

  // getters et setters

  public List<Employe> getEmployés() {
    return employés;
  }

  public void setEmployés(List<Employe> employés) {
    this.employés = employés;
  }
}
