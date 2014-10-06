package dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pam.config.DomainAndPersistenceConfig;
import pam.entities.Cotisation;
import pam.entities.Employe;
import pam.entities.Indemnite;
import pam.repositories.CotisationRepository;
import pam.repositories.EmployeRepository;
import pam.repositories.IndemniteRepository;

@SpringApplicationConfiguration(classes = DomainAndPersistenceConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class JUnitInitDB {

  // repositories
  @Autowired
  private EmployeRepository employeRepository;
  @Autowired
  private IndemniteRepository indemniteRepository;
  @Autowired
  private CotisationRepository cotisationRepository;

  @Before()
  public void clean() {
    log("clean------------------------");
    // on vide la base
    employeRepository.deleteAll();
    cotisationRepository.deleteAll();
    indemniteRepository.deleteAll();
  }

  // logs
  private static void log(String message) {
    System.out.println("----------- " + message);
  }

  // tests
  @Test
  public void test01() {
    log("test01---------------------");
    // on la remplit
    Indemnite indemnite1 = indemniteRepository.save(new Indemnite(1, 1.93, 2, 3, 12));
    Indemnite indemnite2 = indemniteRepository.save(new Indemnite(2, 2.1, 2.1, 3.1, 15));
    Employe employe2 = employeRepository.save(new Employe("254104940426058", "Jouveinal", "Marie", "5 rue des oiseaux", "St Corentin", "49203",
      indemnite2));
    Employe employe1 = employeRepository.save(new Employe("260124402111742", "Laverti", "Justine", "La br�lerie", "St Marcel", "49014", indemnite1));
    Cotisation cotisation1 = cotisationRepository.save(new Cotisation(3.49, 6.15, 9.39, 7.88));
    // on l'affiche
    System.out.println("Employés ----------------------");
    for (Employe employe : employeRepository.findAll()) {
      System.out.println(employe);
    }
    System.out.println("Indemnités ----------------------");
    for (Indemnite indemnite : indemniteRepository.findAll()) {
      System.out.println(indemnite);
    }
    System.out.println("Cotisations ----------------------");
    for (Cotisation cotisation : cotisationRepository.findAll()) {
      System.out.println(cotisation);
    }
  }
}
