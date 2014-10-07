package pam.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pam.entities.Employe;
import pam.metier.FeuilleSalaire;
import pam.helpers.Static;
import pam.metier.IMetier;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ApplicationModel implements IMetier {

  // la couche [métier]
  @Autowired
  private IMetier métier;

  // liste des employés
  private List<Employe> employés = null;
  // liste des messages d'erreur
  private List<String> messages = null;

  @PostConstruct
  public void init() {
    // on récupère les employés
    try {
      employés = métier.getEmployes();
    } catch (Exception ex) {
      messages = Static.getErreursForException(ex);
    }
  }


  // getters et setters
  public List<String> getMessages() {
    return messages;
  }

  public void setMessages(List<String> messages) {
    this.messages = messages;
  }

  @Override
  public List<Employe> getEmployes() {
    return employés;
  }

  @Override
  public FeuilleSalaire getFeuilleSalaire(String ss, double ht, int jt) {
    return métier.getFeuilleSalaire(ss, ht, jt);
  }
}
