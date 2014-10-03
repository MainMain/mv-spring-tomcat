package pam.restapi;

import pam.entities.Employe;

import java.util.List;

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
