package dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pam.client.config.Config;
import pam.client.dao.IDao;
import pam.client.entities.Employe;
import pam.client.entities.PamException;

@SpringApplicationConfiguration(classes = Config.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class JUnitDao {

  @Autowired
  private IDao dao;

  @Before()
  public void init() {
    dao.setTimeout(1000);
    dao.setUrlServiceRest("http://localhost:8080");
  }

  @Test
  public void test1() {
    Assert.assertEquals(72.4, dao.getFeuilleSalaire("260124402111742", 30, 5).getElementsSalaire().getSalaireNet(), 1e-6);
    Assert.assertEquals(368.77, dao.getFeuilleSalaire("254104940426058", 150, 20).getElementsSalaire().getSalaireNet(), 1e-6);
    boolean erreur = false;
    try {
      dao.getFeuilleSalaire("xx", 150, 20);
    } catch (PamException ex) {
      erreur = true;
    }
    Assert.assertTrue(erreur);
  }

  @Test
  public void test2() {
    System.out.println("Liste des employés");
    for (Employe employe : dao.getEmployes()) {
      System.out.println(employe);
    }
  }
}
