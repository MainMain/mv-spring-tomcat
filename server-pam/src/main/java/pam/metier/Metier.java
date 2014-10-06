package pam.metier;

import org.springframework.stereotype.Service;
import pam.entities.Employe;
import pam.entities.FeuilleSalaire;

import java.util.List;

@Service("métier")
public class Metier implements IMetier {
  @Override
  public List<Employe> getEmployes() {
    return null;
  }

  @Override
  public FeuilleSalaire getFeuilleSalaire(String ss, double ht, int jt) {
    return null;
  }
}
